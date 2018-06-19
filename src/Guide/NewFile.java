package Guide;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.text.View;

/**
 *
 * @author THAYCACAC
 */
public class NewFile {

    //create new textpane
    public JTextPane newTextPanel(String titleTab, JTabbedPane jtpTable) {
        jtpTable.setUI(new CustomTabbedPaneUI());
        JTextPane textPanel = new JTextPane();
        textPanel.setFont(new Font("Roboto", Font.PLAIN, 14));
        Icon iconWrite = new ImageIcon("src/icon/heart.png");
        JScrollPane scrollPane = new JScrollPane(textPanel);
        jtpTable.addTab(titleTab, iconWrite, scrollPane);
        int index = jtpTable.getTabCount() - 1;
        jtpTable.setSelectedIndex(index);
        textPanel.getDocument().addDocumentListener(new TextChange(jtpTable));
        textPanel.requestFocus();
        return textPanel;
    }

    //specifies the file to be edited
    private class TextChange implements DocumentListener {

        JTabbedPane jtpTable;

        public TextChange() {
        }

        public TextChange(JTabbedPane jtpTable) {
            this.jtpTable = jtpTable;
        }

        @Override
        public void insertUpdate(DocumentEvent de) {
            textChange();
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
        }

        private void textChange() {
            if (jtpTable.getTabCount() > 0) {
                int index = jtpTable.getSelectedIndex();
                String tableTitle = jtpTable.getTitleAt(index);
                if (!tableTitle.contains("!!! ")) {
                    tableTitle += "!!! ";
                    jtpTable.setTitleAt(index, tableTitle);
                }
            }
        }
    }

    public class CustomTabbedPaneUI extends BasicTabbedPaneUI {

        private Color selectColor;
        private Color deSelectColor;
        private int inclTab = 4;
        private int anchoFocoV = inclTab;
        private int anchoFocoH = 4;
        private int anchoCarpetas = 18;
        private Polygon shape;

//        @Override
//        public ComponentUI createUI(JComponent c) {
//            return new CustomTabbedPaneUI();
//        }
        @Override
        protected void installDefaults() {
            super.installDefaults();
            selectColor = new Color(250, 192, 192);
            deSelectColor = Color.PINK;
            tabAreaInsets.right = anchoCarpetas;
        }

        @Override
        protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
            if (runCount > 1) {
                int lines[] = new int[runCount];
                for (int i = 0; i < runCount; i++) {
                    lines[i] = rects[tabRuns[i]].y + (tabPlacement == TOP ? maxTabHeight : 0);
                }
                Arrays.sort(lines);
                if (tabPlacement == TOP) {
                    int fila = runCount;
                    for (int i = 0; i < lines.length - 1; i++, fila--) {
                        Polygon carp = new Polygon();
                        carp.addPoint(0, lines[i]);
                        carp.addPoint(tabPane.getWidth() - 2 * fila - 2, lines[i]);
                        carp.addPoint(tabPane.getWidth() - 2 * fila, lines[i] + 3);
                        if (i < lines.length - 2) {
                            carp.addPoint(tabPane.getWidth() - 2 * fila, lines[i + 1]);
                            carp.addPoint(0, lines[i + 1]);
                        } else {
                            carp.addPoint(tabPane.getWidth() - 2 * fila, lines[i] + rects[selectedIndex].height);
                            carp.addPoint(0, lines[i] + rects[selectedIndex].height);
                        }
                        carp.addPoint(0, lines[i]);
                        g.setColor(hazAlfa(fila));
                        g.fillPolygon(carp);
                        g.setColor(darkShadow.darker());
                        g.drawPolygon(carp);
                    }
                } else {
                    int fila = 0;
                    for (int i = 0; i < lines.length - 1; i++, fila++) {
                        Polygon carp = new Polygon();
                        carp.addPoint(0, lines[i]);
                        carp.addPoint(tabPane.getWidth() - 2 * fila - 1, lines[i]);
                        carp.addPoint(tabPane.getWidth() - 2 * fila - 1, lines[i + 1] - 3);
                        carp.addPoint(tabPane.getWidth() - 2 * fila - 3, lines[i + 1]);
                        carp.addPoint(0, lines[i + 1]);
                        carp.addPoint(0, lines[i]);
                        g.setColor(hazAlfa(fila + 2));
                        g.fillPolygon(carp);
                        g.setColor(darkShadow.darker());
                        g.drawPolygon(carp);
                    }
                }
            }
            super.paintTabArea(g, tabPlacement, selectedIndex);
        }

        @Override
        protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            Graphics2D g2D = (Graphics2D) g;
            GradientPaint gradientShadow;
            int xp[] = null; // Para la forma
            int yp[] = null;
            switch (tabPlacement) {
                case LEFT:
                    xp = new int[]{x, x, x + w, x + w, x};
                    yp = new int[]{y, y + h - 3, y + h - 3, y, y};
                    gradientShadow = new GradientPaint(x, y, Color.PINK, x, y + h, Color.PINK);
                    break;
                case RIGHT:
                    xp = new int[]{x, x, x + w - 2, x + w - 2, x};
                    yp = new int[]{y, y + h - 3, y + h - 3, y, y};
                    gradientShadow = new GradientPaint(x, y, Color.PINK, x, y + h, Color.PINK);
                    break;
                case BOTTOM:
                    xp = new int[]{x, x, x + 3, x + w - inclTab - 6, x + w - inclTab - 2, x + w - inclTab, x + w - 3, x};
                    yp = new int[]{y, y + h - 3, y + h, y + h, y + h - 1, y + h - 3, y, y};
                    gradientShadow = new GradientPaint(x, y, Color.PINK, x, y + h, Color.PINK);
                    break;
                case TOP:
                default:
                    xp = new int[]{x, x, x + 3, x + w - inclTab - 6, x + w - inclTab - 2, x + w - inclTab, x + w - inclTab, x};
                    yp = new int[]{y + h, y + 3, y, y, y + 1, y + 3, y + h, y + h};
                    gradientShadow = new GradientPaint(0, 0,new Color(252, 214, 211), 0, y + h / 2, new Color(252, 214, 211));
                    break;
            }
            // ;
            shape = new Polygon(xp, yp, xp.length);
            if (isSelected) {
                g2D.setColor(selectColor);
                g2D.setPaint(gradientShadow);
            } else {
                if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                    g2D.setColor(deSelectColor);
                    GradientPaint gradientShadowTmp = new GradientPaint(0, 0, new Color(253, 229, 227), 0, y + h / 2, new Color(253, 229, 227));
                    g2D.setPaint(gradientShadowTmp);
                } else {
                    GradientPaint gradientShadowTmp = new GradientPaint(0, 0, Color.PINK, 0, y + 15 + h / 2, Color.PINK);
                    g2D.setPaint(gradientShadowTmp);
                }
            }
            //selectColor = new Color(255, 255, 200);
            //deSelectColor = new Color(240, 255, 210);
            g2D.fill(shape);
            if (runCount > 1) {
                g2D.setColor(hazAlfa(getRunForTab(tabPane.getTabCount(), tabIndex) - 1));
                g2D.fill(shape);
            }
            g2D.fill(shape);
        }

        @Override
        protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
            super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
            g.setFont(font);
            View v = getTextViewForTab(tabIndex);
            if (v != null) {
                // html
                v.paint(g, textRect);
            } else {
                // plain text
                int mnemIndex = tabPane.getDisplayedMnemonicIndexAt(tabIndex);
                if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                    g.setColor(tabPane.getForegroundAt(tabIndex));
                    BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex, textRect.x, textRect.y + metrics.getAscent());
                } else { // tab disabled
                    g.setColor(Color.BLACK);
                    BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex, textRect.x, textRect.y + metrics.getAscent());
                    g.setColor(tabPane.getBackgroundAt(tabIndex).darker());
                    BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex, textRect.x - 1, textRect.y + metrics.getAscent() - 1);
                }
            }
        }

        @Override
        protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
            return 20 + inclTab + super.calculateTabWidth(tabPlacement, tabIndex, metrics);
        }

        @Override
        protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
            if (tabPlacement == LEFT || tabPlacement == RIGHT) {
                return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
            } else {
                return anchoFocoH + super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
            }
        }

        @Override
        protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        }

        @Override
        protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
            if (tabPane.hasFocus() && isSelected) {
                g.setColor(UIManager.getColor("ScrollBar.thumbShadow"));
                g.drawPolygon(shape);
            }
        }

        protected Color hazAlfa(int fila) {
            int alfa = 0;
            if (fila >= 0) {
                alfa = 50 + (fila > 7 ? 70 : 10 * fila);
            }
            return new Color(0, 0, 0, alfa);
        }
    }
}
