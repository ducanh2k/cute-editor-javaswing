package Test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author THAYCACAC
 */
public class Demo extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public Demo() {
        initComponents();
        setIconButtom();

    }

    private void setIconButtom() {
        btnNew.setContentAreaFilled(false);
        btnNew.setBorder(new RoundedBorder(2));
        btnNew.setForeground(new Color(220, 55, 43));
        Icon i = new ImageIcon("src/Icon/new-file.png");
        btnNew.setIcon(i);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNew.setBorderPainted(false);
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNew.setDefaultCapable(false);
        btnNew.setFocusPainted(false);
        btnNew.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnNew.setMaximumSize(new java.awt.Dimension(0, 0));
        btnNew.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(640, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(471, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    // End of variables declaration//GEN-END:variables
}
class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    public void setBackground(RoundedBorder roundedBorder) {
        roundedBorder.setBackground(Color.BLUE);
    }

    void setBackground(Color BLUE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}