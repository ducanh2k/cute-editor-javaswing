package Design;

import Guide.Setting;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author THAYCACAC
 */
public class DesignSetting {

    Setting setting;

    public DesignSetting(Setting setting) {
        this.setting = setting;
    }

    public void design() {
        Font fieldFont = new Font("Lato", Font.PLAIN, 14);
        setting.getCbbFontName().setFont(fieldFont);
        setting.getCbbFontName().setBackground(Color.WHITE);
        setting.getCbbFontName().setForeground(new Color(100, 99, 99));
        setting.getCbbFontName().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        setting.getCbbFontStyle().setFont(fieldFont);
        setting.getCbbFontStyle().setBackground(Color.WHITE);
        setting.getCbbFontStyle().setForeground(new Color(100, 99, 99));
        setting.getCbbFontStyle().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        setting.getCbbFontSize().setFont(fieldFont);
        setting.getCbbFontSize().setBackground(Color.WHITE);
        setting.getCbbFontSize().setForeground(new Color(100, 99, 99));
        setting.getCbbFontSize().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        setting.getBtnOke().setFont(fieldFont);
        setting.getBtnOke().setBackground(Color.WHITE);
        setting.getBtnOke().setForeground(new Color(62, 156, 0));
        setting.getBtnOke().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        setting.getBtnCancel().setFont(fieldFont);
        setting.getBtnCancel().setBackground(Color.WHITE);
        setting.getBtnCancel().setForeground(new Color(177, 0, 17));
        setting.getBtnCancel().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));

        setting.getTxtWorkspace().setFont(fieldFont);
        setting.getTxtWorkspace().setBackground(Color.WHITE);
        setting.getTxtWorkspace().setForeground(Color.GRAY);
        setting.getTxtWorkspace().setBorder(BorderFactory.createCompoundBorder(
                new MyCustom.MyBorderButton(),
                new EmptyBorder(new Insets(15, 25, 15, 25))));
    }

}
