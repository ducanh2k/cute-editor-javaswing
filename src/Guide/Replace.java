package Guide;

import Guide.Design.DesignFind;
import Guide.Design.DesignReplace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author THAYCACAC
 */
public class Replace extends javax.swing.JFrame {

    MainFrame mainFrame;

    public Replace(java.awt.Frame parent, boolean modal) {
        initComponents();
        mainFrame = (MainFrame) parent;
        this.setTitle("Replace");
        DesignReplace designReplace = new DesignReplace(this);
        designReplace.design();
        this.setResizable(false);
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
        btnReplace = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnReplaceAll = new javax.swing.JButton();
        jlbReplaceWith = new javax.swing.JLabel();
        txtReplaceWith = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnBackground.setBackground(new java.awt.Color(254, 224, 226));

        jlbFind.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlbFind.setForeground(new java.awt.Color(102, 102, 102));
        jlbFind.setText("Replace");

        jlbFindWhat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbFindWhat.setForeground(new java.awt.Color(102, 102, 102));
        jlbFindWhat.setText("Find What");

        btnReplace.setText("Replace");
        btnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplaceActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("Please click on document before replace!!!");

        btnReplaceAll.setText("Replace All");
        btnReplaceAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplaceAllActionPerformed(evt);
            }
        });

        jlbReplaceWith.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbReplaceWith.setForeground(new java.awt.Color(102, 102, 102));
        jlbReplaceWith.setText("Replace With");

        javax.swing.GroupLayout jpnBackgroundLayout = new javax.swing.GroupLayout(jpnBackground);
        jpnBackground.setLayout(jpnBackgroundLayout);
        jpnBackgroundLayout.setHorizontalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFind, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                    .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbFindWhat)
                                        .addComponent(jlbReplaceWith))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtReplaceWith, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                        .addComponent(txtFindWhat))))))
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1))
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnReplace)
                        .addGap(18, 18, 18)
                        .addComponent(btnReplaceAll)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)))
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbReplaceWith)
                    .addComponent(txtReplaceWith, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReplace)
                    .addComponent(btnReplaceAll)
                    .addComponent(btnCancel))
                .addContainerGap(72, Short.MAX_VALUE))
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

    private void btnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplaceActionPerformed
        JTextPane textPane = mainFrame.getCurrentTextPane(mainFrame.getJtpTable());
        if (textPane != null) {
            String text = textPane.getText();
            String target = txtFindWhat.getText();
            String replace = txtReplaceWith.getText();
            String changed;

            changed = text.replace(target, replace);

            if (!changed.equals(text)) {
                textPane.setText(changed);
            }
        }
    }//GEN-LAST:event_btnReplaceActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnReplaceAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplaceAllActionPerformed
        JTextPane textPane = mainFrame.getCurrentTextPane(mainFrame.getJtpTable());
        if (textPane != null) {
            String text = textPane.getText();
            String target = txtFindWhat.getText();
            String replace = txtReplaceWith.getText();
            String changed;

            changed = text.replaceAll(target, replace);

            if (!changed.equals(text)) {
                textPane.setText(changed);
            }
        }
    }//GEN-LAST:event_btnReplaceAllActionPerformed

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
            java.util.logging.Logger.getLogger(Replace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Replace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Replace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Replace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Replace dialog = new Replace(new javax.swing.JFrame(), true);
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

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnReplace() {
        return btnReplace;
    }

    public JButton getBtnReplaceAll() {
        return btnReplaceAll;
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

    public JLabel getJlbReplaceWith() {
        return jlbReplaceWith;
    }

    public JPanel getJpnBackground() {
        return jpnBackground;
    }

    public JTextField getTxtFindWhat() {
        return txtFindWhat;
    }

    public JTextField getTxtReplaceWith() {
        return txtReplaceWith;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReplace;
    private javax.swing.JButton btnReplaceAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbFind;
    private javax.swing.JLabel jlbFindWhat;
    private javax.swing.JLabel jlbReplaceWith;
    private javax.swing.JPanel jpnBackground;
    private javax.swing.JTextField txtFindWhat;
    private javax.swing.JTextField txtReplaceWith;
    // End of variables declaration//GEN-END:variables
}
