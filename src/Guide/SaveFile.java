package Guide;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 *
 * @author THAYCACAC
 */
public class SaveFile {

    //action save file
    public void saveFile(JTabbedPane jtpTable, HashMap<JTextPane, File> hashMap,
            MainFrame mainFrame) {
        if (jtpTable.getTabCount() > 0) {
            JTextPane textPane = mainFrame.getCurrentTextPane(jtpTable);
            //get file
            File file = hashMap.get(textPane);
            if (file != null) {
                String fileName = file.getPath();
                if (fileName.contains("\\") || fileName.contains("/")) {
                    try {
                        DataOutputStream dos
                                = new DataOutputStream(new FileOutputStream(file));
                        String line = textPane.getText();
                        dos.writeBytes(line);
                        dos.close();
                        //no change text
                        int currentFile = jtpTable.getSelectedIndex();
                        String titleFile = jtpTable.getTitleAt(currentFile);
                        if (titleFile.contains("!!!")) {
                            titleFile = titleFile.replace("!!!", "");
                            jtpTable.setTitleAt(currentFile, titleFile);
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                SaveAsFile saveAsFile = new SaveAsFile();
                saveAsFile.saveAsFile(jtpTable, hashMap, mainFrame);
            }
        }
    }
}
