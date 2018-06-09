package Guide;

import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;

/**
 *
 * @author THAYCACAC
 */
public class CloseFile {

    //action close all file
    public int closeAllFile(JTabbedPane jtpTable, MainFrame mainFrame, HashMap<JTextPane, File> hashMap) {
        if (jtpTable.getTabCount() > 0) {
            int fileCurrent = jtpTable.getSelectedIndex();
            //check file save or not
            if (jtpTable.getTitleAt(fileCurrent).contains("*")) {
                String titleFile = jtpTable.getTitleAt(fileCurrent);
                int n = JOptionPane.showConfirmDialog(mainFrame, "Do you want to save "
                        + titleFile + " before close?", "Save or not", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (n == JOptionPane.YES_OPTION || n == JOptionPane.NO_OPTION) {
                    if (n == JOptionPane.YES_OPTION) {
                        SaveFile saveFile = new SaveFile();
                        saveFile.saveFile(jtpTable, hashMap);
                    }
                    //if this is the last one -> set the title again
                    if (jtpTable.getTabCount() == 1) {
                        mainFrame.setTitle("Cute Editor");
                    }
                    hashMap.remove(getCurrentTextPane(jtpTable));
                    jtpTable.remove(fileCurrent);
                } else if (n == JOptionPane.CANCEL_OPTION) {

                }
            } else {
                //if this is the last one -> set the title again
                if (jtpTable.getTabCount() == 1) {
                    mainFrame.setTitle("Cute Editor");
                }
                hashMap.remove(getCurrentTextPane(jtpTable));
                jtpTable.remove(fileCurrent);
            }
        }
        return 0;
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
