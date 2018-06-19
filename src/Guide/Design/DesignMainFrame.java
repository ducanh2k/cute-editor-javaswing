package Guide.Design;

import Guide.Find;
import Guide.MainFrame;
import Guide.Replace;
import Guide.Setting;
import MyCustom.MyButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author THAYCACAC
 */
public class DesignMainFrame {

    MainFrame mainFrame;
    Replace replace;
    Find find;
    Setting settting;

    /*
    DESIGN
     */
    public DesignMainFrame(MainFrame mainFrame, Replace replace, Find find, Setting settting) {
        this.mainFrame = mainFrame;
        this.replace = replace;
        this.find = find;
        this.settting = settting;
    }

    public DesignMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
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

    private void buttonActionPerformed(JButton btn, String title) {
        btn.setText(title);
        Font font = new Font("Verdana", Font.BOLD, 12);
        btn.setForeground(new Color(114, 16, 6));
        btn.setFont(font);
    }

    private void buttonMoved(JButton btn, String title) {
        btn.setText(title);
        Font font = new Font("Verdana", Font.BOLD, 12);
        btn.setForeground(new Color(211, 36, 23));
        btn.setFont(font);
    }

    private void buttonExited(JButton btn) {
        btn.setText("");
    }

    public void designTask() {
        setMyButton(mainFrame.getBtnNew(), "src/Icon/new-file.png");
        setMyButton(mainFrame.getBtnOpen(), "src/Icon/open-file.png");
        setMyButton(mainFrame.getBtnSave(), "src/Icon/save.png");
        setMyButton(mainFrame.getBtnSaveAs(), "src/Icon/save-as.png");
        setMyButton(mainFrame.getBtnNormalize(), "src/Icon/normalize.png");
        setMyButton(mainFrame.getBtnZip(), "src/Icon/zip-file.png");
        setMyButton(mainFrame.getBtnSetting(), "src/Icon/setting.png");
        setMyButton(mainFrame.getBtnClose(), "src/Icon/close.png");
        mainFrame.getJpnTask().setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
        mainFrame.getJpnTask().setBackground(new Color(252, 200, 196));
    }

    public void designTaskTop() {
        setMyButtonTop(mainFrame.getBtnBold(), "src/Icon/bold.png");
        setMyButtonTop(mainFrame.getBtnItalic(), "src/Icon/italic.png");
        setMyButtonTop(mainFrame.getBtnUnderLine(), "src/Icon/underline.png");
        setMyButtonTop(mainFrame.getBtnFind(), "src/Icon/find.png");
        setMyButtonTop(mainFrame.getBtnReplace(), "src/Icon/replace.png");
        setMyButtonTop(mainFrame.getBtnCode(), "src/Icon/code.png");
        setMyButtonTop(mainFrame.getBtnUndoNavigator(), "src/Icon/undo.png");
        setMyButtonTop(mainFrame.getBtnRedoNavigator(), "src/Icon/redo.png");
        setMyButtonTop(mainFrame.getBtnH1(), "src/Icon/h1.png");
        setMyButtonTop(mainFrame.getBtnH3(), "src/Icon/h3.png");
        setMyButtonTop(mainFrame.getBtnH2(), "src/Icon/h2.png");
        setMyButtonTop(mainFrame.getSplite1(), "src/Icon/splite.png");
        setMyButtonTop(mainFrame.getSplite2(), "src/Icon/splite.png");
        setMyButtonTop(mainFrame.getSplite3(), "src/Icon/splite.png");
        setMyButtonTop(mainFrame.getSplite4(), "src/Icon/splite.png");
        mainFrame.getBtnRedo().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
    }

    public void designText() {
        mainFrame.getJtpTable().setBorder(null);
    }

    /*
    ANIMATION
     */
    public void animation() {
        mainFrame.getBtnBold().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnBold(), "src/Icon/bold.png");
            }
        });

        mainFrame.getBtnBold().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnBold(), "src/Icon/bold-mouse.png");
            }
        });

        mainFrame.getBtnItalic().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnItalic(), "src/Icon/italic.png");
            }

            public void mouseMove(MouseEvent me) {

            }
        });

        mainFrame.getBtnItalic().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnItalic(), "src/Icon/italic-mouse.png");
            }
        });

        mainFrame.getBtnUnderLine().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnUnderLine(), "src/Icon/underline.png");
            }
        });

        mainFrame.getBtnUnderLine().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnUnderLine(), "src/Icon/underline-mouse.png");
            }
        });

        mainFrame.getBtnFind().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnFind(), "src/Icon/find.png");
            }
        });

        mainFrame.getBtnFind().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnFind(), "src/Icon/find-mouse.png");
            }
        });

        mainFrame.getBtnReplace().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTop(mainFrame.getBtnReplace(), "src/Icon/replace.png");
            }
        });

        mainFrame.getBtnReplace().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnReplace(), "src/Icon/replace-mouse.png");
            }
        });

        mainFrame.getBtnCode().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnCode(), "src/Icon/code.png");
            }
        });

        mainFrame.getBtnCode().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnCode(), "src/Icon/code-mouse.png");
            }
        });

        mainFrame.getBtnUndoNavigator().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnUndoNavigator(), "src/Icon/undo.png");
            }
        });

        mainFrame.getBtnUndoNavigator().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnUndoNavigator(), "src/Icon/undo-mouse.png");
            }
        });

        mainFrame.getBtnRedoNavigator().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnRedoNavigator(), "src/Icon/redo.png");
            }
        });

        mainFrame.getBtnRedoNavigator().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnRedoNavigator(), "src/Icon/redo-mouse.png");
            }
        });

        mainFrame.getBtnH1().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnH1(), "src/Icon/h1.png");
            }
        });

        mainFrame.getBtnH1().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnH1(), "src/Icon/h1-mouse.png");
            }
        });

        mainFrame.getBtnH2().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnH2(), "src/Icon/h2.png");
            }
        });

        mainFrame.getBtnH2().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnH2(), "src/Icon/h2-mouse.png");
            }
        });

        mainFrame.getBtnH3().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnH3(), "src/Icon/h3.png");
            }
        });

        mainFrame.getBtnH3().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                setMyButtonTopMouse(mainFrame.getBtnH3(), "src/Icon/h3-mouse.png");
            }
        });

        mainFrame.getBtnNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnNew(), "New File ");
            }
        });

        mainFrame.getBtnNew().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnNew());
            }
        });

        mainFrame.getBtnNew().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnNew(), "New File ");
            }
        });

        mainFrame.getBtnOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnOpen(), "Open File ");
            }
        });

        mainFrame.getBtnOpen().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnOpen());
            }
        });

        mainFrame.getBtnOpen().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnOpen(), "Open File ");
            }
        });

        mainFrame.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnSave(), "Save File ");
            }
        });

        mainFrame.getBtnSave().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnSave());
            }
        });

        mainFrame.getBtnSave().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnSave(), "Save File ");
            }
        });

        mainFrame.getBtnSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnSaveAs(), "Save As File ");
            }
        });

        mainFrame.getBtnSaveAs().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnSaveAs());
            }
        });

        mainFrame.getBtnSaveAs().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnSaveAs(), "Save As File ");
            }
        });

        mainFrame.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnClose(), "Close File ");
            }
        });

        mainFrame.getBtnClose().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnClose());
            }
        });

        mainFrame.getBtnClose().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnClose(), "Close File ");
            }
        });

        mainFrame.getBtnNormalize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnNormalize(), "Normalize File ");
            }
        });

        mainFrame.getBtnNormalize().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnNormalize());
            }
        });

        mainFrame.getBtnNormalize().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnNormalize(), "Normalize File ");
            }
        });

        mainFrame.getBtnZip().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnZip(), "Zip File ");
            }
        });

        mainFrame.getBtnZip().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnZip());
            }
        });

        mainFrame.getBtnZip().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnZip(), "Zip File ");
            }
        });

        mainFrame.getBtnSetting().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buttonActionPerformed(mainFrame.getBtnSetting(), "Setting ");
            }
        });

        mainFrame.getBtnSetting().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                buttonExited(mainFrame.getBtnSetting());
            }
        });

        mainFrame.getBtnSetting().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                buttonMoved(mainFrame.getBtnSetting(), "Setting ");
            }
        });

        mainFrame.getJpnTask().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mainFrame.getJpnTask().setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
                mainFrame.getJpnTask().setBackground(new Color(253, 216, 213));
            }
        });

        mainFrame.getJpnTask().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                mainFrame.getJpnTask().setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.RED));
                mainFrame.getJpnTask().setBackground(new Color(252, 200, 196));
            }
        });

    }
}
