package Guide;

import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import MyCustom.MyTablePane;

/**
 *
 * @author THAYCACAC
 */
public class NewFile {

    //create new textpane
    public JTextPane newTextPanel(String titleTab, JTabbedPane jtpTable) {
        jtpTable.setUI(new MyTablePane());
        JTextPane textPanel = new JTextPane();
        textPanel.setFont(new Font("Lato", Font.PLAIN, 14));
        Icon iconWrite = new ImageIcon("src/icon/heart.png");
        JScrollPane scrollPane = new JScrollPane(textPanel);
        jtpTable.addTab(titleTab, iconWrite, scrollPane);
        int index = jtpTable.getTabCount() - 1;
        jtpTable.setSelectedIndex(index);
        textPanel.getDocument().addDocumentListener(new TextChange(jtpTable));
        textPanel.requestFocus();
        return textPanel;
    }

    //specifies the file to be edited
    private class TextChange implements DocumentListener {

        JTabbedPane jtpTable;

        public TextChange() {
        }

        public TextChange(JTabbedPane jtpTable) {
            this.jtpTable = jtpTable;
        }

        @Override
        public void insertUpdate(DocumentEvent de) {
            textChange();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
        }

        //if user edit appear in title tab !!!
        private void textChange() {
            if (jtpTable.getTabCount() > 0) {
                int index = jtpTable.getSelectedIndex();
                String tableTitle = jtpTable.getTitleAt(index);
                if (!tableTitle.contains("!!! ")) {
                    tableTitle += "!!! ";
                    jtpTable.setTitleAt(index, tableTitle);
                }
            }
        }
    }
}
