package Guide;

import MyTask.MyButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import static java.awt.event.ActionEvent.ALT_MASK;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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

    int countFile = 0;
    HashMap<JTextPane, File> hashMap;
    Thread thread;

    //action cut, copy, paste
    Action copy = new DefaultEditorKit.CopyAction();
    Action paste = new DefaultEditorKit.PasteAction();
    Action cut = new DefaultEditorKit.CutAction();

    public MainFrame() {
        this.getContentPane().setBackground(new Color(254, 242, 241));
        this.setTitle("CUTE EDITOR");
        initComponents();
        designTask();
        designText();
        designTaskTop();
        setSortcutKey();
        hashMap = new HashMap<>();
//        check();
    }
    
    private void check(){
        JTextPane textPane = getCurrentTextPane(jtpTable);
        if(textPane != null){
            textPane.setSelectionStart(5);
        textPane.setSelectionEnd(10);
        textPane.setSelectionColor(Color.PINK);
        textPane.setSelectedTextColor(Color.BLUE);
        
        }
        
    }

    private void designTask() {
        setMyButton(btnNew, "src/Icon/new-file.png");
        setMyButton(btnOpen, "src/Icon/open-file.png");
        setMyButton(btnSave, "src/Icon/save.png");
        setMyButton(btnSaveAs, "src/Icon/save-as.png");
        setMyButton(btnNormalize, "src/Icon/normalize.png");
        setMyButton(btnZip, "src/Icon/zip-file.png");
        setMyButton(btnSetting, "src/Icon/setting.png");
        setMyButton(btnClose, "src/Icon/close.png");
        jpnTask.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
        jpnTask.setBackground(new Color(252, 200, 196));
    }

    private void designText() {
        jtpTable.setBorder(null);
    }

    private void designTaskTop() {
        setMyButtonTop(btnBold, "src/Icon/bold.png");
        setMyButtonTop(btnItalic, "src/Icon/italic.png");
        setMyButtonTop(btnUnderLine, "src/Icon/underline.png");
        setMyButtonTop(btnFind, "src/Icon/find.png");
        setMyButtonTop(btnReplace, "src/Icon/replace.png");
        setMyButtonTop(btnCode, "src/Icon/code.png");
        setMyButtonTop(btnUndoNavigator, "src/Icon/undo.png");
        setMyButtonTop(btnRedoNavigator, "src/Icon/redo.png");
        setMyButtonTop(btnH1, "src/Icon/h1.png");
        setMyButtonTop(btnH3, "src/Icon/h3.png");
        setMyButtonTop(btnH2, "src/Icon/h2.png");
        setMyButtonTop(splite1, "src/Icon/splite.png");
        setMyButtonTop(splite2, "src/Icon/splite.png");
        setMyButtonTop(splite3, "src/Icon/splite.png");
        setMyButtonTop(splite4, "src/Icon/splite.png");
        btnRedo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
    }

    private void setSortcutKey() {
        //new file
        Action newFile = new AbstractAction("New File") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                NewFile newFile = new NewFile();
                newFile.newTextPanel("Document " + ++countFile + " ", jtpTable);
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
                openFile.openFile((MainFrame.this), jtpTable, hashMap);
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
                saveFile.saveFile(jtpTable, hashMap);
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
                saveAsFile.saveAsFile(jtpTable, hashMap);
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
                closeFile.closeAllFile(jtpTable, MainFrame.this, hashMap);
                countFile--;
            }
        };
        KeyStroke controlW = KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK);
        btnClose.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(controlW, "Close File");
        btnClose.getActionMap().put("Close File", closeFile);
        btnClose.addActionListener(closeFile);
    }

    public void setMyButton(JButton button, String pathIcon) {
        button.setContentAreaFilled(false);
        button.setBorder(new MyButton(2));
        button.setForeground(new Color(220, 55, 43));
        Icon i = new ImageIcon(pathIcon);
        button.setIcon(i);
    }

    public void setMyButtonTop(JButton button, String pathIcon) {
        button.setContentAreaFilled(false);
        button.setBorder(new MyButton(0));
        button.setForeground(Color.WHITE);
        Icon i = new ImageIcon(pathIcon);
        button.setIcon(i);
    }

    public void setMyButtonTopMouse(JButton button, String pathIcon) {
        button.setContentAreaFilled(false);
        button.setBorder(new MyButton(0));
        button.setForeground(Color.WHITE);
        Icon i = new ImageIcon(pathIcon);
        button.setIcon(i);
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

        jpnTask.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpnTaskMouseMoved(evt);
            }
        });
        jpnTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnTaskMouseExited(evt);
            }
        });

        btnNew.setToolTipText("");
        btnNew.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNewMouseMoved(evt);
            }
        });
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewMouseExited(evt);
            }
        });
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnOpen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnOpenMouseMoved(evt);
            }
        });
        btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOpenMouseExited(evt);
            }
        });
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnSave.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveMouseMoved(evt);
            }
        });
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSaveAs.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSaveAsMouseMoved(evt);
            }
        });
        btnSaveAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveAsMouseExited(evt);
            }
        });
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });

        btnClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCloseMouseMoved(evt);
            }
        });
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnNormalize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNormalizeMouseMoved(evt);
            }
        });
        btnNormalize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNormalizeMouseExited(evt);
            }
        });
        btnNormalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNormalizeActionPerformed(evt);
            }
        });

        btnZip.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnZipMouseMoved(evt);
            }
        });
        btnZip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnZipMouseExited(evt);
            }
        });
        btnZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZipActionPerformed(evt);
            }
        });

        btnSetting.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSettingMouseMoved(evt);
            }
        });
        btnSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSettingMouseExited(evt);
            }
        });
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });

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
        btnBold.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBoldMouseMoved(evt);
            }
        });
        btnBold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBoldMouseExited(evt);
            }
        });
        btnBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoldActionPerformed(evt);
            }
        });

        btnItalic.setToolTipText("");
        btnItalic.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnItalicMouseMoved(evt);
            }
        });
        btnItalic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnItalicMouseExited(evt);
            }
        });
        btnItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItalicActionPerformed(evt);
            }
        });

        btnUnderLine.setToolTipText("");
        btnUnderLine.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUnderLineMouseMoved(evt);
            }
        });
        btnUnderLine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUnderLineMouseExited(evt);
            }
        });
        btnUnderLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnderLineActionPerformed(evt);
            }
        });

        btnFind.setToolTipText("");
        btnFind.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnFindMouseMoved(evt);
            }
        });
        btnFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFindMouseExited(evt);
            }
        });
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnReplace.setToolTipText("");
        btnReplace.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReplaceMouseMoved(evt);
            }
        });
        btnReplace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReplaceMouseExited(evt);
            }
        });
        btnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplaceActionPerformed(evt);
            }
        });

        btnCode.setToolTipText("");
        btnCode.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCodeMouseMoved(evt);
            }
        });
        btnCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCodeMouseExited(evt);
            }
        });
        btnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodeActionPerformed(evt);
            }
        });

        btnUndoNavigator.setToolTipText("");
        btnUndoNavigator.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnUndoNavigatorMouseMoved(evt);
            }
        });
        btnUndoNavigator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUndoNavigatorMouseExited(evt);
            }
        });
        btnUndoNavigator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoNavigatorActionPerformed(evt);
            }
        });

        btnRedoNavigator.setToolTipText("");
        btnRedoNavigator.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRedoNavigatorMouseMoved(evt);
            }
        });
        btnRedoNavigator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRedoNavigatorMouseExited(evt);
            }
        });
        btnRedoNavigator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedoNavigatorActionPerformed(evt);
            }
        });

        splite1.setToolTipText("");
        splite1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                splite1MouseMoved(evt);
            }
        });
        splite1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                splite1MouseExited(evt);
            }
        });
        splite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splite1ActionPerformed(evt);
            }
        });

        splite2.setToolTipText("");
        splite2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                splite2MouseMoved(evt);
            }
        });
        splite2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                splite2MouseExited(evt);
            }
        });
        splite2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splite2ActionPerformed(evt);
            }
        });

        splite3.setToolTipText("");
        splite3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                splite3MouseMoved(evt);
            }
        });
        splite3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                splite3MouseExited(evt);
            }
        });
        splite3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splite3ActionPerformed(evt);
            }
        });

        splite4.setToolTipText("");
        splite4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                splite4MouseMoved(evt);
            }
        });
        splite4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                splite4MouseExited(evt);
            }
        });
        splite4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splite4ActionPerformed(evt);
            }
        });

        btnH1.setToolTipText("");
        btnH1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnH1MouseMoved(evt);
            }
        });
        btnH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnH1MouseExited(evt);
            }
        });
        btnH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnH1ActionPerformed(evt);
            }
        });

        btnH3.setToolTipText("");
        btnH3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnH3MouseMoved(evt);
            }
        });
        btnH3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnH3MouseExited(evt);
            }
        });
        btnH3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnH3ActionPerformed(evt);
            }
        });

        btnH2.setToolTipText("");
        btnH2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnH2MouseMoved(evt);
            }
        });
        btnH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnH2MouseExited(evt);
            }
        });
        btnH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnH2ActionPerformed(evt);
            }
        });

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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        btnNew.setText("New File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnNew.setForeground(new Color(114, 16, 6));
        btnNew.setFont(font);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnNewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseMoved
        btnNew.setText("New File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnNew.setForeground(new Color(211, 36, 23));
        btnNew.setFont(font);
    }//GEN-LAST:event_btnNewMouseMoved

    private void btnNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseExited
        btnNew.setText("");
    }//GEN-LAST:event_btnNewMouseExited

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        btnOpen.setText("Open File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnOpen.setForeground(new Color(114, 16, 6));
        btnOpen.setFont(font);
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnOpenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseMoved
        btnOpen.setText("Open File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnOpen.setForeground(new Color(211, 36, 23));
        btnOpen.setFont(font);
    }//GEN-LAST:event_btnOpenMouseMoved

    private void btnOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseExited
        btnOpen.setText("");
    }//GEN-LAST:event_btnOpenMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        btnSave.setText("Save File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnSave.setForeground(new Color(114, 16, 6));
        btnSave.setFont(font);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseMoved
        btnSave.setText("Save File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnSave.setForeground(new Color(211, 36, 23));
        btnSave.setFont(font);
    }//GEN-LAST:event_btnSaveMouseMoved

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setText("");
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        btnSaveAs.setText("Save As File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnSaveAs.setForeground(new Color(114, 16, 6));
        btnSaveAs.setFont(font);
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void btnSaveAsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveAsMouseMoved
        btnSaveAs.setText("Save As File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnSaveAs.setForeground(new Color(211, 36, 23));
        btnSaveAs.setFont(font);
    }//GEN-LAST:event_btnSaveAsMouseMoved

    private void btnSaveAsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveAsMouseExited
        btnSaveAs.setText("");
    }//GEN-LAST:event_btnSaveAsMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        btnClose.setText("Exit  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnClose.setForeground(new Color(114, 16, 6));
        btnClose.setFont(font);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseMoved
        btnClose.setText("Exit  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnClose.setForeground(new Color(211, 36, 23));
        btnClose.setFont(font);
    }//GEN-LAST:event_btnCloseMouseMoved

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setText("");
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnNormalizeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNormalizeMouseMoved
        btnNormalize.setText("Normalize  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnNormalize.setForeground(new Color(211, 36, 23));
        btnNormalize.setFont(font);
    }//GEN-LAST:event_btnNormalizeMouseMoved

    private void btnNormalizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNormalizeMouseExited
        btnNormalize.setText("");
    }//GEN-LAST:event_btnNormalizeMouseExited

    private void btnNormalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNormalizeActionPerformed
        btnNormalize.setText("Normalize  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnNormalize.setForeground(new Color(114, 16, 6));
        btnNormalize.setFont(font);
        if (jtpTable.getTabCount() > 0) {
            JTextPane textPane = getCurrentTextPane(jtpTable);
            String content = textPane.getText();
            Normalize normalize = new Normalize(content);
            content = normalize.normalize();
            textPane.setText(content);
        }
    }//GEN-LAST:event_btnNormalizeActionPerformed

    private void btnZipMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZipMouseMoved
        btnZip.setText("Zip File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnZip.setForeground(new Color(211, 36, 23));
        btnZip.setFont(font);
    }//GEN-LAST:event_btnZipMouseMoved

    private void btnZipMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZipMouseExited
        btnZip.setText("");
    }//GEN-LAST:event_btnZipMouseExited

    private void btnZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZipActionPerformed
        btnZip.setText("Zip File  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnZip.setForeground(new Color(114, 16, 6));
        btnZip.setFont(font);
    }//GEN-LAST:event_btnZipActionPerformed

    private void btnSettingMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingMouseMoved
        btnSetting.setText("Setting  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnSetting.setForeground(new Color(211, 36, 23));
        btnSetting.setFont(font);
    }//GEN-LAST:event_btnSettingMouseMoved

    private void btnSettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingMouseExited
        btnSetting.setText("");
    }//GEN-LAST:event_btnSettingMouseExited

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        btnSetting.setText("Setting  ");
        Font font = new Font("Verdana", Font.BOLD, 12);
        btnSetting.setForeground(new Color(114, 16, 6));
        btnSetting.setFont(font);
        Setting setting = new Setting(this, false);
        setting.setLocationRelativeTo(this);
        setting.setVisible(true);
    }//GEN-LAST:event_btnSettingActionPerformed

    private void jpnTaskMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTaskMouseExited
        jpnTask.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
        jpnTask.setBackground(new Color(253, 216, 213));
    }//GEN-LAST:event_jpnTaskMouseExited

    private void jpnTaskMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTaskMouseMoved
        jpnTask.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
        jpnTask.setBackground(new Color(252, 200, 196));
    }//GEN-LAST:event_jpnTaskMouseMoved

    private void btnBoldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoldMouseMoved
        setMyButtonTopMouse(btnBold, "src/Icon/bold-mouse.png");
    }//GEN-LAST:event_btnBoldMouseMoved

    private void btnBoldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoldMouseExited
        setMyButtonTopMouse(btnBold, "src/Icon/bold.png");
    }//GEN-LAST:event_btnBoldMouseExited

    private void btnBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoldActionPerformed
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
        textPane.setSelectionStart(selectionStart);
        textPane.setSelectionEnd(selectionEnd);
        textPane.setSelectionColor(Color.PINK);
        textPane.setSelectedTextColor(Color.BLUE);
            

    }//GEN-LAST:event_btnBoldActionPerformed

    
    private void btnItalicMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnItalicMouseMoved
        setMyButtonTopMouse(btnItalic, "src/Icon/italic-mouse.png");
    }//GEN-LAST:event_btnItalicMouseMoved

    private void btnItalicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnItalicMouseExited
        setMyButtonTopMouse(btnItalic, "src/Icon/italic.png");
    }//GEN-LAST:event_btnItalicMouseExited

    private void btnItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItalicActionPerformed
        check();
    }//GEN-LAST:event_btnItalicActionPerformed

    private void btnUnderLineMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnderLineMouseMoved
        setMyButtonTopMouse(btnUnderLine, "src/Icon/underline-mouse.png");
    }//GEN-LAST:event_btnUnderLineMouseMoved

    private void btnUnderLineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnderLineMouseExited
        setMyButtonTopMouse(btnUnderLine, "src/Icon/underline.png");
    }//GEN-LAST:event_btnUnderLineMouseExited

    private void btnUnderLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnderLineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnderLineActionPerformed

    private void btnFindMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFindMouseMoved
        setMyButtonTopMouse(btnFind, "src/Icon/find-mouse.png");
    }//GEN-LAST:event_btnFindMouseMoved

    private void btnFindMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFindMouseExited
        setMyButtonTopMouse(btnFind, "src/Icon/find.png");
    }//GEN-LAST:event_btnFindMouseExited

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        Find find = new Find(this, false);
        find.setLocationRelativeTo(this);
        find.setVisible(true);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnReplaceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReplaceMouseMoved
        setMyButtonTopMouse(btnReplace, "src/Icon/replace-mouse.png");
    }//GEN-LAST:event_btnReplaceMouseMoved

    private void btnReplaceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReplaceMouseExited
        setMyButtonTop(btnReplace, "src/Icon/replace.png");
    }//GEN-LAST:event_btnReplaceMouseExited

    private void btnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplaceActionPerformed
        Replace replace = new Replace(this, false);
        replace.setLocationRelativeTo(this);
        replace.setVisible(true);
    }//GEN-LAST:event_btnReplaceActionPerformed

    private void btnCodeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCodeMouseMoved
        setMyButtonTopMouse(btnCode, "src/Icon/code-mouse.png");
    }//GEN-LAST:event_btnCodeMouseMoved

    private void btnCodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCodeMouseExited
        setMyButtonTopMouse(btnCode, "src/Icon/code.png");
    }//GEN-LAST:event_btnCodeMouseExited

    private void btnCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodeActionPerformed

    }//GEN-LAST:event_btnCodeActionPerformed

    private void btnUndoNavigatorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUndoNavigatorMouseMoved
        setMyButtonTopMouse(btnUndoNavigator, "src/Icon/undo-mouse.png");
    }//GEN-LAST:event_btnUndoNavigatorMouseMoved

    private void btnUndoNavigatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUndoNavigatorMouseExited
        setMyButtonTopMouse(btnUndoNavigator, "src/Icon/undo.png");
    }//GEN-LAST:event_btnUndoNavigatorMouseExited

    private void btnUndoNavigatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoNavigatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUndoNavigatorActionPerformed

    private void btnRedoNavigatorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRedoNavigatorMouseMoved
        setMyButtonTopMouse(btnRedoNavigator, "src/Icon/redo-mouse.png");
    }//GEN-LAST:event_btnRedoNavigatorMouseMoved

    private void btnRedoNavigatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRedoNavigatorMouseExited
        setMyButtonTopMouse(btnRedoNavigator, "src/Icon/redo.png");
    }//GEN-LAST:event_btnRedoNavigatorMouseExited

    private void btnRedoNavigatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedoNavigatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedoNavigatorActionPerformed

    private void splite1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_splite1MouseMoved

    private void splite1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_splite1MouseExited

    private void splite1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splite1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splite1ActionPerformed

    private void splite2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_splite2MouseMoved

    private void splite2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_splite2MouseExited

    private void splite2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splite2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splite2ActionPerformed

    private void splite3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite3MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_splite3MouseMoved

    private void splite3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_splite3MouseExited

    private void splite3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splite3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splite3ActionPerformed

    private void splite4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite4MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_splite4MouseMoved

    private void splite4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splite4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_splite4MouseExited

    private void splite4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splite4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_splite4ActionPerformed

    private void btnH1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnH1MouseMoved
        setMyButtonTopMouse(btnH1, "src/Icon/h1-mouse.png");
    }//GEN-LAST:event_btnH1MouseMoved

    private void btnH1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnH1MouseExited
        setMyButtonTopMouse(btnH1, "src/Icon/h1.png");
    }//GEN-LAST:event_btnH1MouseExited

    private void btnH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnH1ActionPerformed

    private void btnH3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnH3MouseMoved
        setMyButtonTopMouse(btnH3, "src/Icon/h3-mouse.png");
    }//GEN-LAST:event_btnH3MouseMoved

    private void btnH3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnH3MouseExited
        setMyButtonTopMouse(btnH3, "src/Icon/h3.png");
    }//GEN-LAST:event_btnH3MouseExited

    private void btnH3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnH3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnH3ActionPerformed

    private void btnH2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnH2MouseMoved
        setMyButtonTopMouse(btnH2, "src/Icon/h2-mouse.png");
    }//GEN-LAST:event_btnH2MouseMoved

    private void btnH2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnH2MouseExited
        setMyButtonTopMouse(btnH2, "src/Icon/h2.png");
    }//GEN-LAST:event_btnH2MouseExited

    private void btnH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnH2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnH2ActionPerformed

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
