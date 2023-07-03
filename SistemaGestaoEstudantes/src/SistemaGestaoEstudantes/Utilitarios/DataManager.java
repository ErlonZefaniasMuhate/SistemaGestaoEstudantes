/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import SistemaGestaoEstudantes.Modelos.Curso;
import SistemaGestaoEstudantes.Modelos.Departamento;
import SistemaGestaoEstudantes.Modelos.Email;
import SistemaGestaoEstudantes.Modelos.Turma;
import SistemaGestaoEstudantes.Modelos.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erlon Z. Muhate
 */
public class DataManager {

    private final String currentProjectPath;
    private final Path filesDirectoryPath;
    private static BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    private static final String SERIALIZATION_EXTENSION = ".ser";
    private static final String LOGIN_FILENAME = "Login.txt";
    private static String USER_TYPE;//value found on a sucessful login process, reduces need of creating method.
    private static Integer USER_CODE;

    public DataManager() {
        // Obter o caminho do diretório atual do projeto
        currentProjectPath = System.getProperty("user.dir");

        // Definir o caminho para o diretório de arquivos
        filesDirectoryPath = Paths.get(currentProjectPath, "database");

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
    private Path getFilePath(String fileName) {
        return filesDirectoryPath.resolve(fileName);
    }
    //remove todas ocorrencias da extensao '.ser', concatena a extensao no final da (nome da class) String recebida e retorna-a

    private String getFileName(String userType) {
        return userType = (userType.contains(SERIALIZATION_EXTENSION)) ? (userType.replaceAll(SERIALIZATION_EXTENSION, "").trim() + SERIALIZATION_EXTENSION) : (userType + SERIALIZATION_EXTENSION);
    }

    public  class UserManager<Usuario extends User & Serializable> {

        /**
         * Localiza um usuário pelo código institucional.
         *
         * @param userCode   O código institucional do usuário a ser pesquisado.
         * @param userType   O tipo de usuário para determinar o arquivo a ser carregado.
         * @return O objeto Usuario correspondente ao código institucional fornecido.
         * @throws NoSuchElementException Se o usuário não for encontrado.
         */
        public Usuario findUser(Integer userCode, String userType) throws NoSuchElementException {
            try {
                // Carrega os usuários existentes a partir do arquivo
                var existingUsers = loadUsersFromFile(getFileName(userType));
                TreeMap<Integer, Usuario> usuariosOrdenandosPorCodigo = new TreeMap<>();

                // Cria um TreeMap de usuarios ordenado por código institucional para facilitar a busca
                for (Usuario u : existingUsers) {
                    usuariosOrdenandosPorCodigo.put(u.getCodigoInstituicional(), u);
                }
                //converte o TreeMap em um ArrayList para busca e extraccao.
                List<Usuario> usuariosOnArray = new ArrayList<>(usuariosOrdenandosPorCodigo.values());

                int lowIndex = 0;
                int highIndex = usuariosOnArray.size() - 1;
                int middle = (lowIndex + highIndex) / 2;

                boolean found = false;
                while (lowIndex <= highIndex) {
                    var currentUserCode = usuariosOnArray.get(middle).getCodigoInstituicional();
                    if (currentUserCode.equals(userCode)) {
                        // O código institucional do usuário foi encontrado, definindo a flag 'found' como verdadeira e saindo do loop
                        found = true;
                        break;
                    } else if (currentUserCode.compareTo(userCode) > 0) {
                        // O código institucional do usuário atual é maior do que o código procurado,
                        // então atualizamos o índice para pesquisar a metade inferior do intervalo
                        highIndex = middle - 1;
                    } else {
                        // O código institucional do usuário atual é menor do que o código procurado,
                        // então atualizamos o índice para pesquisar a metade inferior do intervalo
                        lowIndex = middle - 1;
                    }
                    middle = (lowIndex + highIndex) / 2;
                }

                if (!found) {
                    // Lança uma exceção se o usuário não for encontrado
                    throw new NoSuchElementException("A chave fornecida não corresponde a nenhum usuário");
                }

                // Retorna o usuário encontrado
                return usuariosOnArray.get(middle);

            } catch (NoSuchFileException | FileNotFoundException e) {
                // Trata exceções de arquivo não encontrado
                System.out.println("Desculpe, as informações solicitadas ainda não estão disponíveis.");
                System.exit(0);
            }

            // Retorna nulo caso algo dê errado
            return null;
        }

        
        /**
         * Localiza um usuário pelo nome de usuário.
         *
         * @param userName O nome de usuário a ser pesquisado.
         * @param userType O tipo de usuário para determinar o arquivo a ser carregado.
         * @return O objeto Usuario correspondente ao nome de usuário fornecido.
         * @throws NoSuchElementException Se o usuário não for encontrado.
         */
        public Usuario findUser(String userName, String userType) throws NoSuchElementException {
            try {
                // Carrega os usuários existentes a partir do arquivo
                var usuariosOrdenadosPorNome = loadUsersFromFile(getFileName(userType));
                List<Usuario> usuariosOnArray = new ArrayList<>(usuariosOrdenadosPorNome);

                int lowIndex = 0;
                int highIndex = usuariosOnArray.size() - 1;
                int middle = (lowIndex + highIndex) / 2;

                boolean found = false;
                while (lowIndex <= highIndex) {
                    var currentUserName = usuariosOnArray.get(middle).getNome();
                    if (currentUserName.equals(userName)) {
                        // O nome do usuário foi encontrado, definindo a flag 'found' como verdadeira e saindo do loop
                        found = true;
                        break;
                    } else if (currentUserName.compareTo(userName) > 0) {
                        // O nome do usuário atual vem depois do nome procurado na ordem alfabética,
                        // então atualizamos os índices para pesquisar a metade superior do intervalo
                        highIndex = middle - 1;
                    } else {
                        // O nome do usuário atual vem antes do nome procurado na ordem alfabética,
                        // então atualizamos os índices para pesquisar a metade inferior do intervalo
                        lowIndex = middle + 1;
                    }
                    middle = (lowIndex + highIndex) / 2;
                }

                if (!found) {
                    // Lança uma exceção se o usuário não for encontrado
                    throw new NoSuchElementException("A chave fornecida não corresponde a nenhum usuário");
                }

                // Retorna o usuário encontrado
                return usuariosOnArray.get(middle);

            } catch (NoSuchFileException | FileNotFoundException e) {
                // Trata exceções de arquivo não encontrado
                System.out.println("Desculpe, as informações solicitadas ainda não estão disponíveis.");
                System.exit(0);
            }

            // Retorna nulo caso algo dê errado
            return null;
        }
        /**
         * Salva um usuário em um arquivo específico, de acordo com o tipo de
         * usuário.
         *
         * @param u o usuário a ser salvo
         * @param userType o tipo de usuário
         */
        public void saveToFile(Usuario u, String userType) {
            Path filePath = getFilePath(getFileName(userType));

            try ( ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
                var existingUsers = loadUsersFromFile(getFileName(userType));
                
                existingUsers.add(u);
                oos.writeObject(existingUsers);
                oos.flush();

            } catch (IOException e) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, "Exception encountered: ", e);
            }
        }
        /*        public void updateUser(Usuario userAtualizado){
        try {
        var usersExistentes = (TreeSet<Usuario>) loadUsersFromFile(User.class.getSimpleName());
        var userNaoAtualizado = findUser(userAtualizado.getNome());
        
        usersExistentes.removeIf(user -> user.equals(userNaoAtualizado));
        usersExistentes.add(userAtualizado);
        
        saveToFile((Entity) usersExistentes, User.class.getSimpleName());
        } catch (NoSuchFileException | FileNotFoundException e) {
        Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao atualizar o user.", e);
        }
        }*/

        /**
         * Carrega os usuários de um arquivo de especificado.
         *
         * @param fileName o nome do arquivo a ser carregado
         * @return um HashMap contendo os usuários carregados do arquivo
         * @throws NoSuchFileException se o arquivo não for encontrado
         * @throws FileNotFoundException se o arquivo não for encontrado
         */
        private TreeSet<Usuario> loadUsersFromFile(String fileName) throws NoSuchFileException, FileNotFoundException {
            Path filePath = getFilePath(fileName);

            try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {

                TreeSet<Usuario> usersFromFile = (TreeSet<Usuario>) ois.readObject();
                ois.close();
                return usersFromFile;

            } catch (NoSuchFileException | FileNotFoundException e) {
                throw e;
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, " Excepcao encontrada ", e);
            }
            return new TreeSet<>();
        }

        /**
         * Salva as informações de login em um arquivo de texto.
         *
         * @param email o email institucional do usuário
         * @param userCode o código institucional do usuário
         * @param password a senha do usuário
         * @param userType o tipo de usuário
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
         * @throws SecurityException se as credenciais de login forem inválidas
         * @throws NoSuchFileException se os dados de login não estiverem
         * disponíveis
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
                    return findUser(USER_CODE, USER_TYPE);
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
         * Valida as credenciais do usuário, comparando o código ou e-mail e a
         * senha fornecidos com os registros armazenados em um BufferedReader de ficheiros.
         *
         * @param codeOrEmail o código ou e-mail do usuário
         * @param password a senha do usuário
         * @param reader o BufferedReader contendo os registros de usuário
         * @return true se as credenciais forem válidas, false caso contrário
         * @throws IOException se ocorrer um erro de leitura do BufferedReader
         */
        private boolean validateUserCredentials(String codeOrEmail, String password, BufferedReader reader) throws IOException {
            String line;
            boolean welcomeMessagePrinted = false;

            try {
                while ((line = reader.readLine()) != null) {
                    // Divide a linha em campos usando o delimitador "||"
                    StringTokenizer tokenizer = new StringTokenizer(line, "||");
                    String email = tokenizer.nextToken();
                    String code = tokenizer.nextToken();
                    String passCheck = tokenizer.nextToken();

                    // Verifica se o código ou e-mail e a senha correspondem aos registros
                    if ((codeOrEmail.equals(email) || codeOrEmail.equals(code)) && password.equals(passCheck)) {
                        System.out.println("Welcome!");
                        welcomeMessagePrinted = true;
                        USER_TYPE = tokenizer.nextToken();
                        USER_CODE = Integer.valueOf(code);
                        break;
                    }
                }
            } catch (IOException e) {
                throw e;
            }

            return welcomeMessagePrinted;
        }

    }

    public  class EntityManager<Entity extends Serializable> {

        /**
         * Procura um curso pelo nome em uma lista ordenada de cursos pelo nome.
         *
         * @param nomeDoCursoPretendido o nome do curso a ser procurado
         * @return o curso encontrado, se existir
         * @throws NoSuchElementException se o curso não for encontrado na lista
         */
        public Curso findCourse(String nomeDoCursoPretendido) throws NoSuchElementException {

            try {
                // Carrega as entidades do arquivo em um TreeSet ordenado por nome
                TreeSet<Curso> cursosOrdenadosPorNome = (TreeSet<Curso>) loadEntitiesFromFile(Curso.class.getSimpleName());

                // Converte o TreeSet em um ArrayList para permitir acesso aleatório
                List<Curso> cursosNoArray = new ArrayList<>(cursosOrdenadosPorNome);

                int highIndex = cursosNoArray.size() - 1;
                int lowIndex = 0;
                int middle = (highIndex + lowIndex) / 2;
                boolean found = false;

                while (lowIndex <= highIndex) {
                    
                    String nomeDoCursoAtual = cursosNoArray.get(middle).getNome();
                    if (nomeDoCursoAtual.equalsIgnoreCase(nomeDoCursoPretendido)) {
                        found = true;
                        break;
                    } else if (nomeDoCursoAtual.compareToIgnoreCase(nomeDoCursoPretendido) > 0) {
                        highIndex = middle - 1;
                    } else {
                        lowIndex = middle + 1;
                    }
                    middle = (highIndex + lowIndex) / 2;
                    
                }

                if (!found) {
                    throw new NoSuchElementException("Curso não encontrado");
                }

                return cursosNoArray.get(middle);
            } catch (NoSuchFileException | FileNotFoundException e) {
                // Trata exceções de arquivo não encontrado
            }

            return null;
        }
        public Departamento findDepartment(String nomeDoDepartamentoPretendido) throws NoSuchElementException {

            try {
                // Carrega as entidades do arquivo em um TreeSet ordenado por nome
                TreeSet<Departamento> departamentosOrdenadosPorNome = (TreeSet<Departamento>) loadEntitiesFromFile(Departamento.class.getSimpleName());

                // Converte o TreeSet em um ArrayList para permitir acesso aleatório
                List<Departamento> departamentosNoArray = new ArrayList<>(departamentosOrdenadosPorNome);

                int highIndex = departamentosNoArray.size() - 1;
                int lowIndex = 0;
                int middle = (highIndex + lowIndex) / 2;
                boolean found = false;

                while (lowIndex <= highIndex) {

                    String nomeDoDepartamentoAtual = departamentosNoArray.get(middle).getNome();
                    if (nomeDoDepartamentoAtual.equalsIgnoreCase(nomeDoDepartamentoPretendido)) {
                        found = true;
                        break;
                    } else if (nomeDoDepartamentoAtual.compareToIgnoreCase(nomeDoDepartamentoPretendido) > 0) {
                        highIndex = middle - 1;
                    } else {
                        lowIndex = middle + 1;
                    }
                    middle = (highIndex + lowIndex) / 2;

                }

                if (!found) {
                    throw new NoSuchElementException("Departamento não encontrado");
                }

                return departamentosNoArray.get(middle);
            } catch (NoSuchFileException | FileNotFoundException e) {
                // Trata exceções de arquivo não encontrado
            }

            return null;
        }
        public Turma findClass(String nomeDaTurmaPretendida) throws NoSuchElementException {

            try {
                // Carrega as entidades do arquivo em um TreeSet ordenado por nome
                TreeSet<Turma> turmasOrdenadosPorNome = (TreeSet<Turma>) loadEntitiesFromFile(Turma.class.getSimpleName());

                // Converte o TreeSet em um ArrayList para permitir acesso aleatório
                List<Turma> turmasNoArray = new ArrayList<>(turmasOrdenadosPorNome);

                int highIndex = turmasNoArray.size() - 1;
                int lowIndex = 0;
                int middle = (highIndex + lowIndex) / 2;
                boolean found = false;

                while (lowIndex <= highIndex) {

                    String nomeDoTurmaAtual = turmasNoArray.get(middle).getNome();
                    if (nomeDoTurmaAtual.equalsIgnoreCase(nomeDaTurmaPretendida)) {
                        found = true;
                        break;
                    } else if (nomeDoTurmaAtual.compareToIgnoreCase(nomeDaTurmaPretendida) > 0) {
                        highIndex = middle - 1;
                    } else {
                        lowIndex = middle + 1;
                    }
                    middle = (highIndex + lowIndex) / 2;

                }

                if (!found) {
                    throw new NoSuchElementException("Turma não encontrada");
                }

                return turmasNoArray.get(middle);
            } catch (NoSuchFileException | FileNotFoundException e) {
                // Trata exceções de arquivo não encontrado
            }

            return null;
        }

        /**
         * Salva uma entidade em um arquivo.
         *
         * @param entity a entidade a ser salva
         * @param entityName o nome da entidade
         */
        public void saveToFile(Entity entity, String entityName) {

            Path filePath = getFilePath(getFileName(entityName));

            try ( ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
                
                var existingEntities = loadEntitiesFromFile(getFileName(entityName));
                existingEntities.add(entity);

                oos.writeObject(existingEntities);
                oos.flush();
                
            } catch (IOException e) {
                //handle the exception
            }
        }
        public void saveToFile (TreeSet<Entity> entidadesAsalvar, String nomeDaClasse){
            Path filePath = getFilePath(getFileName(nomeDaClasse));
            
            try(ObjectOutputStream out = new ObjectOutputStream (Files.newOutputStream(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))){
                
                out.writeObject(entidadesAsalvar);
                out.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Carrega uma lista de entidades a partir de um arquivo.
         *
         * @param fileName o nome do arquivo contendo as entidades
         * @return a lista de entidades carregadas
         * @throws NoSuchFileException se o arquivo não existe
         * @throws FileNotFoundException se o arquivo não foi encontrado
         */
        public TreeSet<Entity> loadEntitiesFromFile(String fileName) throws NoSuchFileException, FileNotFoundException {

            Path filePath = getFilePath(fileName);
            try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {
                TreeSet<Entity> entity = (TreeSet) ois.readObject();
                ois.close();
                return entity;
            } catch (NoSuchFileException | FileNotFoundException e) {
                throw e;
            } catch (IOException | ClassNotFoundException e) {
                //handle the exception
            }
            return new TreeSet<>();
        }
        
        public void updateEntity(Curso cursoAtualizado) {
            try {
                var cursosExistentes = (TreeSet<Curso>)loadEntitiesFromFile(Curso.class.getSimpleName());
                var cursoNaoAtualizado = findCourse(cursoAtualizado.getNome());

                cursosExistentes.removeIf(curso -> curso.equals(cursoNaoAtualizado));
                cursosExistentes.add(cursoAtualizado);

                saveToFile((Entity) cursosExistentes, Curso.class.getSimpleName());
            } catch (NoSuchFileException | FileNotFoundException e) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao atualizar o curso.", e);
            }
        }
        public void updateEntity(Departamento departamentoAtualizado) {
            try {
                var departamentosExistentes = (TreeSet<Departamento>) loadEntitiesFromFile(Departamento.class.getSimpleName());
                var departamentoNaoAtualizado = findDepartment(departamentoAtualizado.getNome());

                departamentosExistentes.removeIf(departamento -> departamento.equals(departamentoNaoAtualizado));
                departamentosExistentes.add(departamentoAtualizado);

                saveToFile((Entity) departamentosExistentes, Departamento.class.getSimpleName());
            } catch (NoSuchFileException | FileNotFoundException e) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao atualizar o departamento.", e);
            }
        }
        public void updateEntity(Turma turmaAtualizado) {
            try {
                var turmasExistentes = (TreeSet<Turma>) loadEntitiesFromFile(Turma.class.getSimpleName());
                var turmaNaoAtualizado = findClass(turmaAtualizado.getNome());

                turmasExistentes.removeIf(turma -> turma.equals(turmaNaoAtualizado));
                turmasExistentes.add(turmaAtualizado);

                saveToFile((Entity) turmasExistentes, Turma.class.getSimpleName());
            } catch (NoSuchFileException | FileNotFoundException e) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ocorreu um erro ao atualizar o turma.", e);
            }
        }
    } 
}
