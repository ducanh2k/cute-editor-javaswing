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
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author THAYCACAC
 */
public class MainFrame extends javax.swing.JFrame {

    int countFile = 0;
    HashMap<JTextPane, File> hashMap;

    //action cut, copy, paste
    Action copy = new DefaultEditorKit.CopyAction();
    Action paste = new DefaultEditorKit.PasteAction();
    Action cut = new DefaultEditorKit.CutAction();

    public MainFrame() {
        this.getContentPane().setBackground(new Color(254, 242, 241));
        initComponents();
        designTask();
        designText();
        designTaskTop();
        setSortcutKey();
        hashMap = new HashMap<>();

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
        jpnTaskTop.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
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
                .put(controlO, "Save File");
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
        jpnTaskTop = new javax.swing.JPanel();
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jpnTaskTop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnTaskTopLayout = new javax.swing.GroupLayout(jpnTaskTop);
        jpnTaskTop.setLayout(jpnTaskTopLayout);
        jpnTaskTopLayout.setHorizontalGroup(
            jpnTaskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jpnTaskTopLayout.setVerticalGroup(
            jpnTaskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jtpTable.setFont(new java.awt.Font("Lato", 0, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnTaskTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpTable)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnTaskTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }//GEN-LAST:event_btnSettingActionPerformed

    private void jpnTaskMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTaskMouseExited
        jpnTask.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
        jpnTask.setBackground(new Color(253, 216, 213));
    }//GEN-LAST:event_jpnTaskMouseExited

    private void jpnTaskMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnTaskMouseMoved
        jpnTask.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
        jpnTask.setBackground(new Color(252, 200, 196));
    }//GEN-LAST:event_jpnTaskMouseMoved

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNormalize;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton btnZip;
    private javax.swing.JPanel jpnTask;
    private javax.swing.JPanel jpnTaskTop;
    private javax.swing.JTabbedPane jtpTable;
    // End of variables declaration//GEN-END:variables
}
