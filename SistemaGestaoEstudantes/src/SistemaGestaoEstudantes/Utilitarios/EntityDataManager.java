/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erlon Z. Muhate
 * @param <Entity>
 */
public abstract class EntityDataManager <Entity extends Serializable> {
    private final String currentProjectPath;
    private final Path filesDirectoryPath;
    private static final String SERIALIZATION_EXTENSION = ".ser";

    /**
     * Construtor da classe EntityDataManager. 
     * Inicializa o caminho do diretório do projeto e o caminho do diretório de arquivos. 
     * Se o diretório de arquivos não existe, ele é criado. 
     * Caso ocorra algum erro ao criar o diretório, uma mensagem de erro é exibida e o programa é encerrado.
     */
    public EntityDataManager() {
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
    * Salva uma entidade em um arquivo.
    *
    * @param entity     a entidade a ser salva
    * @param entityName o nome da entidade
    */
    public void saveEntityToFile(Entity entity, String entityName) {
        
        Path filePath = getFilePath(getFileName(entityName));

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

        Path filePath = getFilePath(fileName);
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
    private Path getFilePath(String fileName) {
        Path filePath = filesDirectoryPath.resolve(fileName);
        return filePath;
    }

    private static String getFileName(String entityName) {
        return entityName = (entityName.contains(SERIALIZATION_EXTENSION))? (entityName.replaceAll(SERIALIZATION_EXTENSION, "").trim() + SERIALIZATION_EXTENSION) : (entityName + SERIALIZATION_EXTENSION);
    }
}
