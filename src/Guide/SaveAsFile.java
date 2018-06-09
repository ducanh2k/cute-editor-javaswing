package Guide;

import java.awt.FileDialog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;

/**
 *
 * @author THAYCACAC
 */
public class SaveAsFile {

    //action save as file
    public void saveAsFile(JTabbedPane jtpTable, HashMap<JTextPane, File> hashMap) {
        if (jtpTable.getTabCount() > 0) {
            FileDialog fd = new FileDialog(new JFrame(), "Save file", FileDialog.SAVE);
            fd.setVisible(true);
            if (fd.getFile() != null) {
                String path = fd.getDirectory() + fd.getFile() + ".txt";
                JTextPane textPanel = getCurrentTextPane(jtpTable);
                int currentFile = jtpTable.getSelectedIndex();
                try {
                    DataOutputStream dos
                            = new DataOutputStream(new FileOutputStream(path));
                    String line = textPanel.getText();
                    dos.writeBytes(line);
                    dos.close();
                    hashMap.put(textPanel, new File(path));
                    //example D:\\
                    String file = path.substring(path.lastIndexOf("\\") + 1);
                    jtpTable.setTitleAt(currentFile, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                textPanel.requestFocus();
            }
        }
    }
    //get current text pane
    public JTextPane getCurrentTextPane(JTabbedPane jtpTable) {
        JTextPane currentTextPane = null;
        int index = jtpTable.getSelectedIndex();
        if (index >= 0) {
            JScrollPane scrollPane = (JScrollPane) jtpTable.getSelectedComponent();
            JViewport viewport = scrollPane.getViewport();
            currentTextPane = (JTextPane) viewport.getView();
        }
        return currentTextPane;
    }

}
