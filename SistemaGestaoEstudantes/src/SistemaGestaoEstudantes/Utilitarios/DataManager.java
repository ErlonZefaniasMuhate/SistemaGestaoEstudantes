/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import SistemaGestaoEstudantes.Modelos.User;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Erlon Z. Muhate
 * @param <Usuario> represents the user of the system
 * @param <Entity> the type of entity, which can represent classrooms, departments, classes, assessments, disciplines, or other components of the system that are not users (they do not extend the User class) or activity logs
 */
public abstract class DataManager<Usuario extends User & Serializable, Entity extends Serializable> {

    private final String currentProjectPath;
    private final Path filesDirectoryPath;

    /**
     * Construtor da classe SystemUtils. 
     * Inicializa o caminho do diretório do projeto e o caminho do diretório de arquivos. 
     * Se o diretório de arquivos não existe, ele é criado. 
     * Caso ocorra algum erro ao criar o diretório, uma mensagem de erro é exibida e o programa é encerrado.
     */
    public DataManager() {
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
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Failed to create the directory", e);
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
    * Procura uma entidade pelo nome em um arquivo específico e retorna a primeira ocorrência encontrada.
    *
    * @param entityType o tipo da entidade (nome da classe) a ser procurada
    * @param entityName o nome da entidade a ser procurada
    * @return a entidade encontrada ou null se não for encontrada
    */
    public Entity findEntityByName(String entityType, String entityName) {
        
        try {
            var existingEntities = loadEntitiesFromFile(getFileName(entityName));
            for (Entity e : existingEntities) {
                try {
                    Class<?> classe = Class.forName(entityType);
                    if (classe.isInstance(e)) {
                        // Fazendo o casting do objeto para a classe desejada
                        Object objetoCasteado = classe.cast(e);

                        // Obtendo o método "getNome" na classe desejada
                        Method getNomeMethod = classe.getMethod("getNome");

                        // Invocando o método "getNome" no objeto casteado
                        String nome = (String) getNomeMethod.invoke(objetoCasteado);

                        if(nome.equals(entityName)){
                            return (Entity)objetoCasteado;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("Classe não encontrada: " + entityType);
                } catch (NoSuchMethodException ex) {
                    System.out.println("Método getNome não encontrado na classe: " + entityType);
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    System.out.println("Erro ao invocar o método getNome na classe: " + entityType);
                }
            }
        } catch (NoSuchFileException e) {
            e.getMessage();
        } catch (IOException e) {
            //handle the exception
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
        Path filePath = getDirectoryPath(getFileName(userType));

        try ( ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
            var existingUsers = loadUsersFromFile(getFileName(userType));
            if (!existingUsers.containsKey(u.getCodigoInstituicional())) {
                existingUsers.put(u.getCodigoInstituicional(), u);
                oos.writeObject(existingUsers);
                oos.flush();
            }
        } catch (IOException e) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Exception encountered: ", e);
        }
    }

    private Path getDirectoryPath(String fileName) {
        Path filePath = filesDirectoryPath.resolve(fileName);
        return filePath;
    }

    private String getFileName(String userType) {
        String fileName = userType + ".ser";
        return fileName;
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
        Path filePath = getDirectoryPath(fileName);

        try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {

            HashMap<Integer, Usuario> usersFromFile = (HashMap<Integer, Usuario>) ois.readObject();
            ois.close();
            return usersFromFile;

        } catch (NoSuchFileException | FileNotFoundException e) {
            throw e;
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, " Excepcao encontrada ", e);
        }
        return new HashMap<>();
    }
    
    /**
    * Salva uma entidade em um arquivo.
    *
    * @param entity     a entidade a ser salva
    * @param entityName o nome da entidade
    */
    public void saveEntityToFile(Entity entity, String entityName) {
        
        Path filePath = getDirectoryPath(getFileName(entityName));

        try ( ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
            var existingEntities = loadEntitiesFromFile(getFileName(entityName));
            existingEntities.add(entity);
            if (!existingEntities.contains(entity)) {
                oos.writeObject(existingEntities);
                oos.flush();
            }
        } catch (IOException e) {
            //handle the exception
        }
    }
    
    /**
    * Carrega uma lista de entidades a partir de um arquivo.
    *
    * @param fileName o nome do arquivo contendo as entidades
    * @return a lista de entidades carregadas
    * @throws NoSuchFileException     se o arquivo não existe
    * @throws FileNotFoundException se o arquivo não foi encontrado
    */
    public List<Entity> loadEntitiesFromFile(String fileName) throws NoSuchFileException, FileNotFoundException {

        Path filePath = getDirectoryPath(fileName);
        try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {
            List<Entity> entity = (List) ois.readObject();
            ois.close();
            return entity;
        } catch (NoSuchFileException | FileNotFoundException e) {
            throw e;
        } catch (IOException | ClassNotFoundException e) {
            //handle the exception
        }
        return null;
    }
    
    /**
    * Salva as informações de login em um arquivo de texto.
    *
    * @param userCode   o código institucional do usuário
    * @param password   a senha do usuário
    * @param userType   o tipo de usuário
    */
    public void saveLoginInfo(Integer userCode, String password, String userType) {
        Path filePath = getDirectoryPath("login.txt");
        try ( BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            writer.write(userCode + "||" + password);
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
        Path filePath = getDirectoryPath("login.txt");

        if (!Files.exists(filePath)) {
            throw new NoSuchFileException("Login data is not available");
        }

        try ( BufferedReader reader = Files.newBufferedReader(filePath)) {
            System.out.println("Enter your institutional code: ");
            String code = reader.readLine();
            while (!Validate.isInteger(code)) {
                System.out.println("Invalid code, please try again: ");
                code = reader.readLine();
            }

            System.out.println("Enter your password: ");
            String password = reader.readLine();
            while (!Validate.containsLettersOrDigits(password)) {
                System.out.println("Invalid password, please try again: ");
                password = reader.readLine();
            }

            boolean welcomeMessagePrinted = validateUserCredentials(code, password, reader);

            if (!welcomeMessagePrinted) {
                reader.close();
                throw new SecurityException("Access denied");
            } else {
                String userType = getFileName(getUserType(Integer.parseInt(code), password));
                return findUserByCode(Integer.parseInt(code), userType);
            }
        } catch (IOException e) {
            //handle the exception
        }
        return null;
    }
    
    /**
    * Valida as credenciais de um usuário.
    *
    * @param code     o código institucional do usuário
    * @param password a senha do usuário
    * @param reader   o BufferedReader para leitura dos dados de login
    * @return true se as credenciais forem válidas e uma mensagem de boas-vindas for exibida, caso contrário, false
    * @throws IOException se ocorrer um erro durante a leitura dos dados de login
    */
    private boolean validateUserCredentials(String code, String password, BufferedReader reader) throws IOException {
        String line;
        boolean welcomeMessagePrinted = false;

        try {
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "||");
                String codeCheck = tokenizer.nextToken();
                String passCheck = tokenizer.nextToken();
                if (code.equals(codeCheck) && password.equals(passCheck)) {
                    System.out.println("Welcome!");
                    welcomeMessagePrinted = true;
                    break;
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return welcomeMessagePrinted;
    }
    
    /**
    * Obtém o tipo de usuário com base no código institucional e senha fornecidos.
    *
    * @param codigoInstitucional o código institucional do usuário
    * @param password           a senha do usuário
    * @return o tipo de usuário correspondente ao código e senha fornecidos, ou null se não for encontrado
    */
    private String getUserType(int codigoInstitucional, String password) {
        Path filePath = getDirectoryPath("login.txt");
        try ( BufferedReader reader = new BufferedReader(Files.newBufferedReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|\\|"); // Dividir a linha usando o separador "||"
                int codigo = Integer.parseInt(parts[0]);
                String senha = parts[1];
                String tipoUsuario = parts[2];

                if (codigo == codigoInstitucional && senha.equals(password)) {
                    return tipoUsuario; // Encontrou o código e senha correspondentes, retorna o tipo de usuário
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Código e senha não encontrados
    }
}
