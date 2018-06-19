
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;
 
/**
 * This Java program demonstrates how to compress a file in ZIP format.
 *
 * @author www.codejava.net
 */
public class ZipFile {
 
    private static void zipFile(String filePath) {
        try {
            File file = new File(filePath);
            String nameFile = file.getName();
            String zipFileName = nameFile.substring(0, nameFile.lastIndexOf(".")).concat(".zip");

            FileOutputStream fos = new FileOutputStream("D:\\"+zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
 
            zos.putNextEntry(new ZipEntry(file.getName()));
 
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
            
        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist", filePath);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }
 
    public static void main(String[] args) {
        zipFile("D:\\SHARP TEAM/Test.txt");
        
    }
}