/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import SistemaGestaoEstudantes.Modelos.Email;
import SistemaGestaoEstudantes.Modelos.User;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Erlon Z. Muhate
 * @param <Usuario> represents the user of the system
 */
public abstract class UserDataManager<Usuario extends User & Serializable> {

    private final String currentProjectPath;
    private final Path filesDirectoryPath;
    private static BufferedReader x = new BufferedReader (new InputStreamReader (System.in));
    private static final String SERIALIZATION_EXTENSION = ".ser";
    private static final String LOGIN_FILENAME = "Login.txt";
    private static String USER_TYPE;//value found on a sucessful login process, reduces need of creating method.
    private static int USER_CODE;//value found on a sucessful login process, reduces need of creating method.

    /**
     * Construtor da classe SystemUtils. 
     * Inicializa o caminho do diretório do projeto e o caminho do diretório de arquivos. 
     * Se o diretório de arquivos não existe, ele é criado. 
     * Caso ocorra algum erro ao criar o diretório, uma mensagem de erro é exibida e o programa é encerrado.
     */
    public UserDataManager() {
        // Obter o caminho do diretório atual do projeto
        currentProjectPath = System.getProperty("user.dir");

        // Definir o caminho para o diretório de arquivos
        filesDirectoryPath = Paths.get(currentProjectPath, ".files");

        // Verificar se o diretório de arquivos não existe
        if (!Files.exists(filesDirectoryPath)) {
            try {
                // Criar o diretório de arquivos
                Files.createDirectories(filesDirectoryPath);
            } catch (IOException e) {
                // Lidar com a exceção em caso de falha na criação do diretório
                Logger.getLogger(UserDataManager.class.getName()).log(Level.SEVERE, "Failed to create the directory", e);
            } finally {
                // Exibir uma mensagem de erro e encerrar o programa
                System.out.println("Please, re-run the program!");
                System.exit(1);
            }
        }
    }
    
    /**
     * @param userCode as the institutional user code
     * @param userType as the type of user to be found
     * @return User object
     * @throws NoSuchElementException if no element is found
     */
    public Usuario findUserByCode(int userCode, String userType) throws NoSuchElementException {
        try {
            var existingUsers = loadUsersFromFile(getFileName(userType));
            if (existingUsers.containsKey(userCode)) {
                return existingUsers.get(userCode);
            } else {
                throw new NoSuchElementException("A chave fornecida não corresponde a nenhum usuário");
            }
        } catch (NoSuchFileException | FileNotFoundException e) {
            System.out.println("Desculpe, as informações solicitadas ainda não estão disponíveis.");
            System.exit(0);
        }
        return null;
    }
    


    /**
     * Salva um usuário em um arquivo específico, de acordo com o tipo de usuário.
     *
     * @param u o usuário a ser salvo
     * @param userType o tipo de usuário
     */
    public void saveUserToFile(Usuario u, String userType) {
        Path filePath = getFilePath(getFileName(userType));

        try ( ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
            var existingUsers = loadUsersFromFile(getFileName(userType));
            if (!existingUsers.containsKey(u.getCodigoInstituicional())) {
                existingUsers.put(u.getCodigoInstituicional(), u);
                oos.writeObject(existingUsers);
                oos.flush();
            }
        } catch (IOException e) {
            Logger.getLogger(UserDataManager.class.getName()).log(Level.SEVERE, "Exception encountered: ", e);
        }
    }

    private Path getFilePath(String fileName) {
        return filesDirectoryPath.resolve(fileName);
    }
    //remove todas ocorrencias da extensao '.ser', concatena a extensao no final da (nome da class) String recebida e retorna-a
    private String getFileName(String userType) {
        return userType = (userType.contains(SERIALIZATION_EXTENSION))? (userType.replaceAll(SERIALIZATION_EXTENSION, "").trim() + SERIALIZATION_EXTENSION) : (userType + SERIALIZATION_EXTENSION);
    }

    /**
     * Carrega os usuários de um arquivo de especificado.
     *
     * @param fileName o nome do arquivo a ser carregado
     * @return um HashMap contendo os usuários carregados do arquivo
     * @throws NoSuchFileException se o arquivo não for encontrado
     * @throws FileNotFoundException se o arquivo não for encontrado
     */
    private HashMap<Integer, Usuario> loadUsersFromFile(String fileName) throws NoSuchFileException, FileNotFoundException {
        Path filePath = getFilePath(fileName);

        try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {

            HashMap<Integer, Usuario> usersFromFile = (HashMap<Integer, Usuario>) ois.readObject();
            ois.close();
            return usersFromFile;

        } catch (NoSuchFileException | FileNotFoundException e) {
            throw e;
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(UserDataManager.class.getName()).log(Level.SEVERE, " Excepcao encontrada ", e);
        }
        return new HashMap<>();
    }
    

    
    /**
    * Salva as informações de login em um arquivo de texto.
    *
    * @param email      o email institucional do usuário
    * @param userCode   o código institucional do usuário
    * @param password   a senha do usuário
    * @param userType   o tipo de usuário
    */
    public void saveLoginInfo(Email email, Integer userCode, String password, String userType) {
        Path filePath = getFilePath(LOGIN_FILENAME);
        try ( BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            writer.write(email + "||" + userCode + "||" + password + "||" + userType);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Realiza o processo de login do usuário.
    *
    * @return o objeto User correspondente ao usuário logado
    * @throws SecurityException     se as credenciais de login forem inválidas
    * @throws NoSuchFileException   se os dados de login não estiverem disponíveis
    * @since 09/06/2023
    */
    public User login() throws SecurityException, NoSuchFileException {
        Path filePath = getFilePath(LOGIN_FILENAME);

        if (!Files.exists(filePath)) {
            throw new NoSuchFileException("Login data is not available");
        }

        try ( BufferedReader reader = Files.newBufferedReader(filePath)) {
            
            String codeOrEmail = readCodeOrEmail();
            String password = readPassword();

            boolean welcomeMessagePrinted = validateUserCredentials(codeOrEmail, password, reader);
            reader.close();

            if (!welcomeMessagePrinted) {
                throw new SecurityException("Access denied");
            } else {
                return findUserByCode(USER_CODE, USER_TYPE);
            }
        } catch (IOException e) {
            //handle the exception
        }
        return null;
    }

    private String readPassword() throws IOException {
        System.out.println("Enter your password: ");
        String password = x.readLine();
        while (!Validate.containsLettersOrDigits(password)) {
            System.out.println("Invalid password, please try again: ");
            password = x.readLine();
        }
        return password;
    }

    private String readCodeOrEmail() throws IOException {
        System.out.println("Enter your institutional code or email: ");
        String codeOrEmail = x.readLine();
        while (true) {
            if (codeOrEmail.matches("\\d+")) {
                return codeOrEmail;
            } else if (Validate.isEmail(codeOrEmail)) {
                return codeOrEmail;
            } else {
                System.out.println("Invalid input, please try again: ");
                codeOrEmail = x.readLine();
            }
        }
    }
    
    /**
    * Valida as credenciais de um usuário.
    *
    * @param codeOrEmail     o código institucional ou email do usuário
    * @param password a senha do usuário
    * @param reader   o BufferedReader para leitura dos dados de login
    * @return true se as credenciais forem válidas e uma mensagem de boas-vindas for exibida, caso contrário, false
    * @throws IOException se ocorrer um erro durante a leitura dos dados de login
    */
    private boolean validateUserCredentials(String codeOrEmail, String password, BufferedReader reader) throws IOException {
        String line;
        boolean welcomeMessagePrinted = false;

        try {
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "||");
                String email = tokenizer.nextToken();
                String code = tokenizer.nextToken();
                String passCheck = tokenizer.nextToken();
                if ((codeOrEmail.equals(email) || (codeOrEmail.equals(code))) && password.equals(passCheck)) {
                    System.out.println("Welcome!");
                    welcomeMessagePrinted = true;
                    USER_TYPE = tokenizer.nextToken();
                    USER_CODE = Integer.parseInt(code);
                    break;
                } 
            }
        } catch (IOException e) {
            throw e;
        }
        return welcomeMessagePrinted;
    }
}
