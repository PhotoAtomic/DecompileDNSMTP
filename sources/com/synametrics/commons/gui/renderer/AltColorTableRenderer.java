package com.synametrics.commons.gui.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.HashSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/* loaded from: input.jar:com/synametrics/commons/gui/renderer/AltColorTableRenderer.class */
public class AltColorTableRenderer extends DefaultTableCellRenderer {
    protected Color evenColor;
    protected Color oddColor;
    protected Color selectionColor;
    protected boolean deleted;
    protected HashSet deletedRows = new HashSet();

    public AltColorTableRenderer(Color color, Color color2, Color color3) {
        this.evenColor = color;
        this.oddColor = color2;
        this.selectionColor = color3;
    }

    public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean z, boolean z2, int i, int i2) {
        Component tableCellRendererComponent = super.getTableCellRendererComponent(jTable, obj, z, z2, i, i2);
        this.deleted = this.deletedRows.contains(new Integer(i));
        if (z) {
            tableCellRendererComponent.setBackground(this.selectionColor);
        } else if (i % 2 == 0) {
            tableCellRendererComponent.setBackground(this.evenColor);
        } else {
            tableCellRendererComponent.setBackground(this.oddColor);
        }
        return tableCellRendererComponent;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.deleted) {
            String text = getText();
            if (text.length() > 0) {
                graphics.drawLine(getInsets().left, 8, Math.min(graphics.getFontMetrics().stringWidth(text), getBounds().width - getInsets().right), 8);
            }
        }
    }
}
