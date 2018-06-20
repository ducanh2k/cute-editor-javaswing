package Design;

import Guide.Replace;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author THAYCACAC
 */
public class DesignReplace {

    Replace replace;

    public DesignReplace(Replace replace) {
        this.replace = replace;
    }

    public void design() {
        Font fieldFont = new Font("Lato", Font.PLAIN, 14);
        replace.getTxtFindWhat().setFont(fieldFont);
        replace.getTxtFindWhat().setBackground(Color.WHITE);
        replace.getTxtFindWhat().setForeground(new Color(100, 99, 99));
        replace.getTxtFindWhat().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
        replace.getTxtReplaceWith().setFont(fieldFont);
        replace.getTxtReplaceWith().setBackground(Color.WHITE);
        replace.getTxtReplaceWith().setForeground(new Color(100, 99, 99));
        replace.getTxtReplaceWith().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        replace.getBtnReplace().setFont(fieldFont);
        replace.getBtnReplace().setBackground(Color.WHITE);
        replace.getBtnReplace().setForeground(new Color(62, 156, 0));
        replace.getBtnReplace().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        replace.getBtnReplaceAll().setFont(fieldFont);
        replace.getBtnReplaceAll().setBackground(Color.WHITE);
        replace.getBtnReplaceAll().setForeground(new Color(62, 156, 0));
        replace.getBtnReplaceAll().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        replace.getBtnCancel().setFont(fieldFont);
        replace.getBtnCancel().setBackground(Color.WHITE);
        replace.getBtnCancel().setForeground(new Color(177, 0, 17));
        replace.getBtnCancel().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
    }
}
