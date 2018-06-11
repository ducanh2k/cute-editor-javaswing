/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.*;
import javax.swing.*;

class Animation extends JFrame {

    JLabel lblText;

    Animation() {
        setTitle("Text Animation");
        setLayout(null);
        lblText = new JLabel("<html><p style='color: #ff00ff; font-size:20pt'>Happy New Year</p></html>");
        lblText.setSize(200, 50);
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(lblText);
        setVisible(true);
        doAnimation();
    }

    public void doAnimation() {
        int x = 1;
        int y = 5;
        boolean check = true;
        try {
            while (true) {
                lblText.setLocation(x, y);
                Thread.sleep(200);
                if(check){
                    y -= 10;
                }else{
                    y+=10;
                }
                check = !check;
            }

        } catch (InterruptedException ie) {
        }
    }

}

public class TextAnimation {

    public static void main(String args[]) {
        new Animation();

    }

}
