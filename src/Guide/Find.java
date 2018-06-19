package Guide;

import Guide.Design.DesignFind;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author THAYCACAC
 */
public class Find extends javax.swing.JFrame {

    MainFrame mainFrame;

    public Find(java.awt.Frame parent, boolean modal) {
        initComponents();
        mainFrame = (MainFrame) parent;
        this.setTitle("Find");
        DesignFind designFind = new DesignFind(this);
        designFind.design();
        this.setResizable(false);
        //click close don't close app
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnBackground = new javax.swing.JPanel();
        jlbFind = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlbFindWhat = new javax.swing.JLabel();
        txtFindWhat = new javax.swing.JTextField();
        jlbDirection = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnFindNext = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        rdbUp = new javax.swing.JRadioButton();
        rdbDown = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnBackground.setBackground(new java.awt.Color(254, 224, 226));

        jlbFind.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlbFind.setForeground(new java.awt.Color(102, 102, 102));
        jlbFind.setText("Find");

        jlbFindWhat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbFindWhat.setForeground(new java.awt.Color(102, 102, 102));
        jlbFindWhat.setText("Find What");

        jlbDirection.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlbDirection.setForeground(new java.awt.Color(102, 102, 102));
        jlbDirection.setText("Direction");

        btnFindNext.setText("Find Next");
        btnFindNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindNextActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        rdbUp.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(rdbUp);
        rdbUp.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        rdbUp.setForeground(new java.awt.Color(255, 255, 255));
        rdbUp.setText("            Up");

        rdbDown.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(rdbDown);
        rdbDown.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        rdbDown.setForeground(new java.awt.Color(255, 255, 255));
        rdbDown.setSelected(true);
        rdbDown.setText("         Down");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Please click on document before find!!!");

        javax.swing.GroupLayout jpnBackgroundLayout = new javax.swing.GroupLayout(jpnBackground);
        jpnBackground.setLayout(jpnBackgroundLayout);
        jpnBackgroundLayout.setHorizontalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addComponent(jlbFindWhat)
                        .addGap(18, 18, 18)
                        .addComponent(txtFindWhat, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlbFind)
                        .addComponent(jlbDirection)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnFindNext)
                                    .addComponent(rdbUp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdbDown, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel)))
                            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel1)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jpnBackgroundLayout.setVerticalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFindWhat)
                    .addComponent(txtFindWhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jlbDirection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbUp)
                    .addComponent(rdbDown))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFindNext)
                    .addComponent(btnCancel))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindNextActionPerformed
        JTextPane textPane = mainFrame.getCurrentTextPane(mainFrame.getJtpTable());
        if (textPane != null) {
            String find = txtFindWhat.getText();
            String text = "";
            int start;
            int index = -1;

            if (rdbDown.isSelected()) {
                try {
                    text = textPane.getDocument().getText(0, textPane.getDocument().getLength());
                } catch (BadLocationException ex) {
                    Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                }
                start = textPane.getSelectionEnd();
                index = text.indexOf(find, start);
            } else {
                start = textPane.getSelectionStart();
                try {
                    text = textPane.getDocument().getText(0, start);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
                index = text.lastIndexOf(find);
            }

            if (index != -1) {
                try {
                    int selectStart = index;
                    int selectEnd = index + find.length();
                    textPane.setSelectionStart(selectStart);
                    textPane.setSelectionEnd(selectEnd);
                  
                    Highlighter highlight = textPane.getHighlighter();
                    highlight.removeAllHighlights();
                    highlight.addHighlight(selectStart, selectEnd, DefaultHighlighter.DefaultPainter);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Cannot find \"" + find + "\"",
                        mainFrame.getTitle(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No text field found!!!",
                    mainFrame.getTitle(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFindNextActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Find dialog = new Find(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    class FieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(txtFindWhat.getText());
        }

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnFindNext() {
        return btnFindNext;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getJlbFind() {
        return jlbFind;
    }

    public JLabel getJlbFindWhat() {
        return jlbFindWhat;
    }

    public JPanel getJpnBackground() {
        return jpnBackground;
    }

    public JRadioButton getRdbDown() {
        return rdbDown;
    }

    public JRadioButton getRdbUp() {
        return rdbUp;
    }

    public JTextField getTxtFindWhat() {
        return txtFindWhat;
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFindNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlbDirection;
    private javax.swing.JLabel jlbFind;
    private javax.swing.JLabel jlbFindWhat;
    private javax.swing.JPanel jpnBackground;
    private javax.swing.JRadioButton rdbDown;
    private javax.swing.JRadioButton rdbUp;
    private javax.swing.JTextField txtFindWhat;
    // End of variables declaration//GEN-END:variables
}
