package Guide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 *
 * @author THAYCACAC
 */
public class ZipFile {

    JTabbedPane jtpTable;
    HashMap<JTextPane, File> hashMap;
    MainFrame mainFrame;

    public ZipFile(JTabbedPane jtpTable, HashMap<JTextPane, File> hashMap, MainFrame mainFrame) {
        this.jtpTable = jtpTable;
        this.hashMap = hashMap;
        this.mainFrame = mainFrame;
    }

    //action zip file
    public void zipFile() {

        JTextPane textPanel = mainFrame.getCurrentTextPane(jtpTable);
        int currentFile = jtpTable.getSelectedIndex();
        File file = hashMap.get(textPanel);
        String pathFile = file.getPath();
        String pathDirectory = file.getParentFile().getPath();
        try {
            String nameFile = file.getName();
            String zipFileName = nameFile.substring(0, nameFile.lastIndexOf(".")).concat(".zip");

            FileOutputStream fos = new FileOutputStream(pathDirectory + "/" + zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            zos.putNextEntry(new ZipEntry(file.getName()));

            byte[] bytes = Files.readAllBytes(Paths.get(pathFile));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
            JOptionPane.showMessageDialog(null, "Zip file " + file.getName() + " successfully!!!");
        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist", pathFile);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }
}
