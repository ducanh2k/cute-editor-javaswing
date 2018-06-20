package Design;

import Guide.Find;
import MyCustom.MyBorderButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author THAYCACAC
 */
public class DesignFind {

    Find find;

    public DesignFind(Find find) {
        this.find = find;
    }

    public void design() {
        Font fieldFont = new Font("Lato", Font.PLAIN, 14);
        find.getTxtFindWhat().setFont(fieldFont);
        find.getTxtFindWhat().setBackground(Color.WHITE);
        find.getTxtFindWhat().setForeground(new Color(100, 99, 99));
        find.getTxtFindWhat().setBorder(BorderFactory.createCompoundBorder(
                new MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        find.getRdbDown().setBorder(BorderFactory.createCompoundBorder(
                new MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        find.getRdbUp().setBorder(BorderFactory.createCompoundBorder(
                new MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        find.getBtnFindNext().setFont(fieldFont);
        find.getBtnFindNext().setBackground(Color.WHITE);
        find.getBtnFindNext().setForeground(new Color(62, 156, 0));
        find.getBtnFindNext().setBorder(BorderFactory.createCompoundBorder(
                new MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        find.getBtnCancel().setFont(fieldFont);
        find.getBtnCancel().setBackground(Color.WHITE);
        find.getBtnCancel().setForeground(new Color(177, 0, 17));
        find.getBtnCancel().setBorder(BorderFactory.createCompoundBorder(
                new MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
    }
}
