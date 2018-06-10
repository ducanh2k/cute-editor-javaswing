package Guide;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author THAYCACAC
 */
public class Setting extends javax.swing.JFrame {

    /**
     * Creates new form Setting
     */
    MainFrame mainFrame;

    public Setting(java.awt.Frame parent, boolean modal) {
        initComponents();
        setFontName();
        customTextField();
        customComboBox();
        getCurrentFile(parent);
        setFontCurrent(parent);
        this.setTitle("Setting");
        this.mainFrame = (MainFrame) parent;
        this.setResizable(false);
        txtWorkspace.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBackground = new javax.swing.JPanel();
        jlbInformation = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlbWorkspace = new javax.swing.JLabel();
        txtWorkspace = new javax.swing.JTextField();
        jlbFont = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlbFontName = new javax.swing.JLabel();
        jlbFontStyle = new javax.swing.JLabel();
        jlbFontSize = new javax.swing.JLabel();
        cbbFontSize = new javax.swing.JComboBox<>();
        cbbFontName = new javax.swing.JComboBox<>();
        cbbFontStyle = new javax.swing.JComboBox<>();
        btnOke = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnBackground.setBackground(new java.awt.Color(254, 224, 226));

        jlbInformation.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlbInformation.setForeground(new java.awt.Color(102, 102, 102));
        jlbInformation.setText("Infomation");

        jlbWorkspace.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbWorkspace.setForeground(new java.awt.Color(102, 102, 102));
        jlbWorkspace.setText("Workspace");

        txtWorkspace.setText("None");

        jlbFont.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jlbFont.setForeground(new java.awt.Color(102, 102, 102));
        jlbFont.setText("Font");

        jlbFontName.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbFontName.setForeground(new java.awt.Color(102, 102, 102));
        jlbFontName.setText("Font Name");

        jlbFontStyle.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbFontStyle.setForeground(new java.awt.Color(102, 102, 102));
        jlbFontStyle.setText("Font Style");

        jlbFontSize.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jlbFontSize.setForeground(new java.awt.Color(102, 102, 102));
        jlbFontSize.setText("Font Size");

        cbbFontSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" }));

        cbbFontStyle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Bold", "Italic", "Bold & Italic" }));

        btnOke.setText("OK");
        btnOke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkeActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBackgroundLayout = new javax.swing.GroupLayout(jpnBackground);
        jpnBackground.setLayout(jpnBackgroundLayout);
        jpnBackgroundLayout.setHorizontalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                .addComponent(jlbWorkspace)
                                .addGap(18, 18, 18)
                                .addComponent(txtWorkspace, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbInformation)
                                .addComponent(jlbFont))
                            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                        .addComponent(jlbFontStyle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbFontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBackgroundLayout.createSequentialGroup()
                                        .addComponent(jlbFontName)
                                        .addGap(21, 21, 21)
                                        .addComponent(cbbFontName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBackgroundLayout.createSequentialGroup()
                                        .addComponent(jlbFontSize)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                                                .addComponent(btnOke)
                                                .addGap(56, 56, 56)
                                                .addComponent(btnCancel))
                                            .addComponent(cbbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(3, 3, 3)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jpnBackgroundLayout.setVerticalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbWorkspace)
                    .addComponent(txtWorkspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jlbFont)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFontName)
                    .addComponent(cbbFontName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFontStyle)
                    .addComponent(cbbFontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFontSize)
                    .addComponent(cbbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOke)
                    .addComponent(btnCancel))
                .addContainerGap(179, Short.MAX_VALUE))
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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkeActionPerformed
        if (mainFrame.getJtpTable().getTabCount() > 0) {
            JTextPane textPane = getCurrentTextPane(mainFrame.getJtpTable());
            String fontName = cbbFontName.getSelectedItem().toString();
            int fontSize = Integer.parseInt(cbbFontSize.getSelectedItem().toString());
            int fontStyle = cbbFontStyle.getSelectedIndex();
            textPane.setFont(new Font(fontName, fontStyle, fontSize));
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnOkeActionPerformed

    //get curent file
    private void getCurrentFile(java.awt.Frame parent) {

        this.mainFrame = (MainFrame) parent;
        if (mainFrame.getJtpTable().getTabCount() >= 0) {
            JTextPane textPane = getCurrentTextPane(mainFrame.getJtpTable());
            if (!mainFrame.hashMap.isEmpty()) {
                File file = mainFrame.hashMap.get(textPane);
                if (!file.exists()) {
                    txtWorkspace.setText(file.getPath());
                }
            }
        }
    }

    //set curent file
    private void setFontCurrent(java.awt.Frame parent) {

        this.mainFrame = (MainFrame) parent;
        if (mainFrame.getJtpTable().getTabCount() >= 0) {
            JTextPane textPane = getCurrentTextPane(mainFrame.getJtpTable());
            if (!mainFrame.hashMap.isEmpty()) {
                File file = mainFrame.hashMap.get(textPane);
                cbbFontName.setSelectedIndex(5);
            }
        }
    }

    //custom text field
    private void customTextField() {
        Font fieldFont = new Font("Roboto", Font.PLAIN, 14);
        txtWorkspace.setFont(fieldFont);
        txtWorkspace.setBackground(Color.WHITE);
        txtWorkspace.setForeground(Color.GRAY);
        txtWorkspace.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
    }

    //custom combo box
    private void customComboBox() {
        Font fieldFont = new Font("Lato", Font.PLAIN, 14);
        cbbFontName.setFont(fieldFont);
        cbbFontName.setBackground(Color.WHITE);
        cbbFontName.setForeground(new Color(100, 99, 99));
        cbbFontName.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        cbbFontStyle.setFont(fieldFont);
        cbbFontStyle.setBackground(Color.WHITE);
        cbbFontStyle.setForeground(new Color(100, 99, 99));
        cbbFontStyle.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        cbbFontSize.setFont(fieldFont);
        cbbFontSize.setBackground(Color.WHITE);
        cbbFontSize.setForeground(new Color(100, 99, 99));
        cbbFontSize.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        btnOke.setFont(fieldFont);
        btnOke.setBackground(Color.WHITE);
        btnOke.setForeground(new Color(62, 156, 0));
        btnOke.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        btnCancel.setFont(fieldFont);
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setForeground(new Color(177, 0, 17));
        btnCancel.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
    }

    //allow user set font name
    private void setFontName() {
        String fonts[]
                = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        cbbFontName.setModel(new DefaultComboBoxModel(fonts));
    }

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
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Setting dialog = new Setting(new javax.swing.JFrame(), true);
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

    @SuppressWarnings("serial")
    class CustomeBorder extends AbstractBorder {

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                int width, int height) {
            // TODO Auto-generated method stubs
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor(new Color(254, 224, 226));
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
        }
    }

    class FieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(txtWorkspace.getText());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOke;
    private javax.swing.JComboBox<String> cbbFontName;
    private javax.swing.JComboBox<String> cbbFontSize;
    private javax.swing.JComboBox<String> cbbFontStyle;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlbFont;
    private javax.swing.JLabel jlbFontName;
    private javax.swing.JLabel jlbFontSize;
    private javax.swing.JLabel jlbFontStyle;
    private javax.swing.JLabel jlbInformation;
    private javax.swing.JLabel jlbWorkspace;
    private javax.swing.JPanel jpnBackground;
    private javax.swing.JTextField txtWorkspace;
    // End of variables declaration//GEN-END:variables
}
