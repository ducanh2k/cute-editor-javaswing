package Guide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.HashMap;

/**
 *
 * @author THAYCACAC
 */
public class OpenFile {

    String recentlyDirectory = "";

    public void openFile(MainFrame mainFrame, JTabbedPane jtpTable,
            HashMap<JTextPane, File> hashMap) {
        try {
            JFileChooser fc = new JFileChooser(recentlyDirectory);
            fc.setMultiSelectionEnabled(true);
            fc.setFileFilter(new FileNameExtensionFilter("Only Text", "txt",
                    "java", "html", "xml"));
            fc.showOpenDialog(mainFrame);

            //path directory of file
            File file = fc.getSelectedFile();
            String fileName = file.toString();
            String fileNameNormalize = fileName;
            if (fileName.contains("\\")) {
                fileNameNormalize = fileName.substring(fileName.lastIndexOf("\\") + 1);
            } else if (fileName.contains("/")) {
                fileNameNormalize = fileName.substring(fileName.lastIndexOf("/") + 1);
            }
            //create new tab text
            NewFile newFile = new NewFile();
            JTextPane textPane = newFile.newTextPanel(fileNameNormalize, jtpTable);
            hashMap.put(textPane, file);
//      print content to textpane
            StringBuffer stringBuffer = new StringBuffer();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line + "\n");
                }
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
            String content = stringBuffer.toString();
            textPane.setText(content);
            int index = jtpTable.getSelectedIndex();
            jtpTable.setTitleAt(index, fileNameNormalize);
        } catch (Exception e) {
        }
    }
}
