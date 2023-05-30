/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Erlon Z. Muhate
 * @param <Usuario> represents the user of the system
 */
public abstract class SystemUtils<Usuario extends User & Serializable> {

    private final String projectPath;
    private final Path directoryPath;

    public SystemUtils() {
        projectPath = System.getProperty("user.dir");
        directoryPath = Paths.get(projectPath, ".files");
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, "Failed to create the directory", e);
            } finally {
                System.out.println("Please, re-run the program!");
                System.exit(1);
            }
        }
    }

    /**
     * @param code as the institutional user code
     * @param fileName as the type of user to be found
     * @return User object
     * @throws NoSuchElementException if no element is found
     */
    public Usuario getUserByCode(int code, String fileName) throws NoSuchElementException {
        var usersFromFile = readFromFile(fileName);
        if (usersFromFile.containsKey(code)) {
            return usersFromFile.get(code);
        } else {
            throw new NoSuchElementException("A chave fornecida não corresponde a nenhum usuário");
        }
    }

    public Curso getCourseByName() {
        return null;
    }

    public void saveToFile(Usuario u, String fileName) {
        Path filePath = directoryPath.resolve(fileName);

        try ( ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
            var usersFromFile = readFromFile(fileName);
            if (!usersFromFile.containsKey(u.getCodigoInstituicional())) {
                usersFromFile.put(u.getCodigoInstituicional(), u);
                oos.writeObject(usersFromFile);
                oos.flush();
            }

        } catch (IOException e) {
            Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, "Exception encountered: ", e);
        }
    }

    private HashMap<Integer, Usuario> readFromFile(String fileName) {
        Path filePath = directoryPath.resolve(fileName);

        try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {

            HashMap<Integer, Usuario> usersFromFile = (HashMap<Integer, Usuario>) ois.readObject();
            ois.close();
            return usersFromFile;

        } catch (NoSuchFileException | FileNotFoundException e) {

            try {
                Files.createFile(filePath);
            } catch (IOException ex) {
                Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, "Excepcao encontrada: ", ex);
            }
            return new HashMap<>();

        } catch (EOFException e) {
            //reached end of file
        } catch (StreamCorruptedException e) {
            Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, " Ficheiro corrompido ", e);
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, " Excepcao encontrada ", e);
        }
        return new HashMap<>();
    }
    
    //implementar metodos para ler e salvar listas de entidades(turmas, departamentos, entre outros), dessas listas extrair objectos e retornar ao sistema
   /*public Curso findCourse(String fileName) {
        Path filePath = directoryPath.resolve(fileName);

        try ( ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {
            var coursesFound = (List) ois.readObject();
            ois.close();
            
        } catch (NoSuchFileException | FileNotFoundException e) {

            try {
                Files.createFile(filePath);
            } catch (IOException ex) {
                Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, "Excepcao encontrada: ", ex);
            }
            return null;

        } catch (EOFException e) {
            //reached end of file
        } catch (StreamCorruptedException e) {
            Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, " Ficheiro corrompido ", e);
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(SystemUtils.class.getName()).log(Level.SEVERE, " Excepcao encontrada ", e);
        }
        return null;
    }
    public void saveCourse(String fileName){
        Path filePath = directoryPath.resolve(fileName);
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath, StandardOpenOption.TRUNCATE_EXISTING))){
           var courses = findCourses
        }catch(IOException e){
            
        }
    }*/

}
