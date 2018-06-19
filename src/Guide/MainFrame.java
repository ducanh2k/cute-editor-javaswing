package Guide;

import Guide.Design.DesignMainFrame;
import MyStack.ManagerStack;
import MyStack.MyStack;
import java.awt.Color;
import java.awt.event.ActionEvent;
import static java.awt.event.ActionEvent.ALT_MASK;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author THAYCACAC
 */
public class MainFrame extends javax.swing.JFrame {

    int countFile = 1;
    HashMap<JTextPane, File> hmFile;
    HashMap<Integer, ManagerStack> hmStack;

    //action cut, copy, paste
    Action copy = new DefaultEditorKit.CopyAction();
    Action paste = new DefaultEditorKit.PasteAction();
    Action cut = new DefaultEditorKit.CutAction();
    DesignMainFrame design = new DesignMainFrame(this);

    public MainFrame() {
        this.getContentPane().setBackground(new Color(254, 242, 241));
        this.setTitle("CUTE EDITOR");
        initComponents();
        design.designTask();
        design.designTaskTop();
        design.designText();
        design.animation();
        setSortcutKey();
        hmFile = new HashMap<>();
        hmStack = new HashMap<Integer, ManagerStack>();
    }

    private void setSortcutKey() {
        //new file
        Action newFile = new AbstractAction("New File") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MyStack<String> stackUndo = new MyStack<>();
                MyStack<String> stackRedo = new MyStack<>();
                NewFile newFile = new NewFile();
                JTextPane textpane = newFile.newTextPanel("Document " + countFile + " ", jtpTable);
                ManagerStack managerStack = new ManagerStack(stackUndo, stackRedo, textpane);
                managerStack.changeContent();
                hmStack.put(countFile, managerStack);
                countFile++;
            }
        };
        KeyStroke controlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);
        btnNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlN, "New File");
        btnNew.getActionMap().put("New File", newFile);
        btnNew.addActionListener(newFile);

        //open file
        Action openFile = new AbstractAction("Open File") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                OpenFile openFile = new OpenFile();
                openFile.openFile((MainFrame.this), jtpTable, hmFile);
            }
        };
        KeyStroke controlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
        btnOpen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlO, "Open File");
        btnOpen.getActionMap().put("Open File", openFile);
        btnOpen.addActionListener(openFile);

        //save file
        Action saveFile = new AbstractAction("Save File") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                SaveFile saveFile = new SaveFile();
                saveFile.saveFile(jtpTable, hmFile, MainFrame.this);
            }
        };
        KeyStroke controlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
        btnSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlS, "Save File");
        btnSave.getActionMap().put("Save File", saveFile);
        btnSave.addActionListener(saveFile);

        //save as file
        Action saveAsFile = new AbstractAction("Save As File") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                SaveAsFile saveAsFile = new SaveAsFile();
                saveAsFile.saveAsFile(jtpTable, hmFile, MainFrame.this);
            }
        };
        KeyStroke controlAltS = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ALT_MASK);
        btnSaveAs.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlAltS, "Save As File");
        btnSaveAs.getActionMap().put("Save As File", saveAsFile);
        btnSaveAs.addActionListener(saveAsFile);

        //close file
        Action closeFile = new AbstractAction("Close File") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CloseFile closeFile = new CloseFile();
                closeFile.closeAllFile(jtpTable, MainFrame.this, hmFile);
                countFile--;
            }
        };
        KeyStroke controlW = KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK);
        btnClose.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlW, "Close File");
        btnClose.getActionMap().put("Close File", closeFile);
        btnClose.addActionListener(closeFile);

        //Bold text
        Action boldText = new AbstractAction("Bold Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke controlB = KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK);
        btnBold.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlB, "Bold Text");
        btnBold.getActionMap().put("Bold Text", boldText);
        btnBold.addActionListener(boldText);

        //Italic text
        Action italicText = new AbstractAction("Italic Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke controlI = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK);
        btnItalic.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlI, "Italic Text");
        btnItalic.getActionMap().put("Italic Text", italicText);
        btnItalic.addActionListener(italicText);

        //Underline text
        Action underlineText = new AbstractAction("Underline Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke controlU = KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK);
        btnUnderLine.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlU, "Underline Text");
        btnUnderLine.getActionMap().put("Underline Text", underlineText);
        btnUnderLine.addActionListener(underlineText);

        //Header1 text
        Action h1Text = new AbstractAction("Header1 Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setFontSize(asNew, 24);
                StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
                StyleConstants.setFontFamily(asNew, "Lato Black");
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke control1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK);
        btnH1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Header1 Text");
        btnH1.getActionMap().put("Header1 Text", h1Text);
        btnH1.addActionListener(h1Text);

        //Header2 text
        Action h2Text = new AbstractAction("Header2 Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setFontSize(asNew, 21);
                StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
                StyleConstants.setFontFamily(asNew, "Lato Black");
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke control2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK);
        btnH2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Header2 Text");
        btnH2.getActionMap().put("Header2 Text", h2Text);
        btnH2.addActionListener(h2Text);

        //Header3 text
        Action h3Text = new AbstractAction("Header3 Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setFontSize(asNew, 18);
                StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
                StyleConstants.setFontFamily(asNew, "Lato Black");
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke control3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK);
        btnH3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Header3 Text");
        btnH3.getActionMap().put("Header3 Text", h3Text);
        btnH3.addActionListener(h3Text);

        //find
        Action find = new AbstractAction("Find Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Find find = new Find(MainFrame.this, false);
                find.setLocationRelativeTo(MainFrame.this);
                find.setVisible(true);
            }
        };
        KeyStroke controlF = KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK);
        btnFind.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Find Text");
        btnFind.getActionMap().put("Find Text", find);
        btnFind.addActionListener(find);

        //replace
        Action replace = new AbstractAction("Replace Text") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Replace replace = new Replace(MainFrame.this, false);
                replace.setLocationRelativeTo(MainFrame.this);
                replace.setVisible(true);
            }
        };
        KeyStroke controlH = KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK);
        btnReplace.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Replace Text");
        btnReplace.getActionMap().put("Replace Text", replace);
        btnReplace.addActionListener(replace);

        //undo
        Action undo = new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    //get manager stack of tab current
                    ManagerStack managerStach = hmStack.get(jtpTable.getSelectedIndex() + 1);
                    managerStach.undo();
                } catch (Exception e) {
                }
            }
        };
        KeyStroke controlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK);
        btnUndoNavigator.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Undo");
        btnUndoNavigator.getActionMap().put("Undo", undo);
        btnUndoNavigator.addActionListener(undo);

        //redo
        Action redo = new AbstractAction("Redo") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //get manager stack of tab current
                ManagerStack managerStach = hmStack.get(jtpTable.getSelectedIndex() + 1);
                managerStach.redo();
            }
        };
        KeyStroke controlY = KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK);
        btnRedoNavigator.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Redo");
        btnRedoNavigator.getActionMap().put("Redo", redo);
        btnRedoNavigator.addActionListener(redo);

        //code
        Action code = new AbstractAction("Code") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JTextPane textPane = getCurrentTextPane(jtpTable);
                String textSelected = textPane.getSelectedText();
                StyledDocument doc = (StyledDocument) textPane.getDocument();
                int selectionEnd = textPane.getSelectionEnd();
                int selectionStart = textPane.getSelectionStart();
                if (selectionStart == selectionEnd) {
                    return;
                }
                Element element = doc.getCharacterElement(selectionStart);
                AttributeSet as = element.getAttributes();
                MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
                StyleConstants.setFontSize(asNew, 14);
                StyleConstants.setFontFamily(asNew, "Roboto");
                StyleConstants.setBold(asNew, false);
                StyleConstants.setItalic(asNew, false);
                StyleConstants.setUnderline(asNew, false);
                doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
            }
        };
        KeyStroke controlG = KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK);
        btnCode.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(control1, "Redo");
        btnCode.getActionMap().put("Redo", code);
        btnCode.addActionListener(code);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnTask = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnNormalize = new javax.swing.JButton();
        btnZip = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();
        btnRedo = new javax.swing.JPanel();
        btnBold = new javax.swing.JButton();
        btnItalic = new javax.swing.JButton();
        btnUnderLine = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnReplace = new javax.swing.JButton();
        btnCode = new javax.swing.JButton();
        btnUndoNavigator = new javax.swing.JButton();
        btnRedoNavigator = new javax.swing.JButton();
        splite1 = new javax.swing.JButton();
        splite2 = new javax.swing.JButton();
        splite3 = new javax.swing.JButton();
        splite4 = new javax.swing.JButton();
        btnH1 = new javax.swing.JButton();
        btnH3 = new javax.swing.JButton();
        btnH2 = new javax.swing.JButton();
        jtpTable = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnNew.setToolTipText("");

        javax.swing.GroupLayout jpnTaskLayout = new javax.swing.GroupLayout(jpnTask);
        jpnTask.setLayout(jpnTaskLayout);
        jpnTaskLayout.setHorizontalGroup(
            jpnTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaskLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew)
                    .addComponent(btnOpen)
                    .addComponent(btnSave)
                    .addComponent(btnSaveAs)
                    .addComponent(btnClose)
                    .addComponent(btnNormalize)
                    .addComponent(btnZip)
                    .addComponent(btnSetting))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpnTaskLayout.setVerticalGroup(
            jpnTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addGap(18, 18, 18)
                .addComponent(btnOpen)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnSaveAs)
                .addGap(18, 18, 18)
                .addComponent(btnNormalize)
                .addGap(18, 18, 18)
                .addComponent(btnZip)
                .addGap(18, 18, 18)
                .addComponent(btnSetting)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        btnRedo.setBackground(new java.awt.Color(255, 255, 255));

        btnBold.setToolTipText("");

        btnItalic.setToolTipText("");

        btnUnderLine.setToolTipText("");

        btnFind.setToolTipText("");

        btnReplace.setToolTipText("");

        btnCode.setToolTipText("");

        btnUndoNavigator.setToolTipText("");

        btnRedoNavigator.setToolTipText("");

        splite1.setToolTipText("");

        splite2.setToolTipText("");

        splite3.setToolTipText("");

        splite4.setToolTipText("");

        btnH1.setToolTipText("");

        btnH3.setToolTipText("");

        btnH2.setToolTipText("");

        javax.swing.GroupLayout btnRedoLayout = new javax.swing.GroupLayout(btnRedo);
        btnRedo.setLayout(btnRedoLayout);
        btnRedoLayout.setHorizontalGroup(
            btnRedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRedoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBold)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnItalic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUnderLine)
                .addGap(18, 18, 18)
                .addComponent(splite4)
                .addGap(18, 18, 18)
                .addComponent(btnH1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnH2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnH3)
                .addGap(18, 18, 18)
                .addComponent(splite1)
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReplace)
                .addGap(18, 18, 18)
                .addComponent(splite2)
                .addGap(18, 18, 18)
                .addComponent(btnUndoNavigator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRedoNavigator)
                .addGap(18, 18, 18)
                .addComponent(splite3)
                .addGap(18, 18, 18)
                .addComponent(btnCode)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        btnRedoLayout.setVerticalGroup(
            btnRedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRedoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnRedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnH3)
                    .addGroup(btnRedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnH2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(splite4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(splite3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(splite2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(splite1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRedoNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUndoNavigator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnItalic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUnderLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpTable.setBackground(new java.awt.Color(255, 255, 255));
        jtpTable.setFont(new java.awt.Font("Lato", 0, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRedo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpTable)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRedo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpTable)
                .addContainerGap())
            .addComponent(jpnTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public JTabbedPane getJtpTable() {
        return jtpTable;
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

    public JButton getBtnBold() {
        return btnBold;
    }

    public JButton getBtnClose() {
        return btnClose;
    }

    public JButton getBtnCode() {
        return btnCode;
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    public JButton getBtnH1() {
        return btnH1;
    }

    public JButton getBtnH2() {
        return btnH2;
    }

    public JButton getBtnH3() {
        return btnH3;
    }

    public JButton getBtnItalic() {
        return btnItalic;
    }

    public JButton getBtnNew() {
        return btnNew;
    }

    public JButton getBtnNormalize() {
        return btnNormalize;
    }

    public JButton getBtnOpen() {
        return btnOpen;
    }

    public JPanel getBtnRedo() {
        return btnRedo;
    }

    public JButton getBtnRedoNavigator() {
        return btnRedoNavigator;
    }

    public JButton getBtnReplace() {
        return btnReplace;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnSaveAs() {
        return btnSaveAs;
    }

    public JButton getBtnSetting() {
        return btnSetting;
    }

    public JButton getBtnUnderLine() {
        return btnUnderLine;
    }

    public JButton getBtnUndoNavigator() {
        return btnUndoNavigator;
    }

    public JButton getBtnZip() {
        return btnZip;
    }

    public JPanel getJpnTask() {
        return jpnTask;
    }

    public JButton getSplite1() {
        return splite1;
    }

    public JButton getSplite2() {
        return splite2;
    }

    public JButton getSplite3() {
        return splite3;
    }

    public JButton getSplite4() {
        return splite4;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBold;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCode;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnH1;
    private javax.swing.JButton btnH2;
    private javax.swing.JButton btnH3;
    private javax.swing.JButton btnItalic;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNormalize;
    private javax.swing.JButton btnOpen;
    private javax.swing.JPanel btnRedo;
    private javax.swing.JButton btnRedoNavigator;
    private javax.swing.JButton btnReplace;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton btnUnderLine;
    private javax.swing.JButton btnUndoNavigator;
    private javax.swing.JButton btnZip;
    private javax.swing.JPanel jpnTask;
    private javax.swing.JTabbedPane jtpTable;
    private javax.swing.JButton splite1;
    private javax.swing.JButton splite2;
    private javax.swing.JButton splite3;
    private javax.swing.JButton splite4;
    // End of variables declaration//GEN-END:variables
}
