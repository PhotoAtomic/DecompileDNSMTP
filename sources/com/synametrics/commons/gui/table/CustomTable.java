package com.synametrics.commons.gui.table;

import com.synametrics.commons.gui.renderer.AltColorTableRenderer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/* loaded from: input.jar:com/synametrics/commons/gui/table/CustomTable.class */
public class CustomTable extends JTable {
    public final String downArrow = " ↓";
    public final String upArrow = " ↑";
    protected Color evenRowColor;
    protected Color oddRowColor;
    protected Color selectedRowColor;
    protected boolean autoRowAddition;
    protected AltColorTableRenderer myRenderer;
    protected Vector data;
    protected Vector columnNames;
    protected HashSet deletedRows;
    protected DefaultTableModel model;
    protected boolean useCustomRenderer;
    protected boolean boldHeader;
    protected InterfaceC0005a doubleClickListener;

    protected CustomTable() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomTable(ArrayList arrayList) {
        this.downArrow = " ↓";
        this.upArrow = " ↑";
        this.evenRowColor = new Color(221, 221, 255);
        this.oddRowColor = Color.WHITE;
        this.selectedRowColor = new Color(170, 170, 225);
        this.autoRowAddition = false;
        this.myRenderer = null;
        this.useCustomRenderer = true;
        this.boldHeader = false;
        this.doubleClickListener = null;
        m215a(arrayList);
    }

    public boolean isCellEditable(int i, int i2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m214a(int[] iArr, boolean z) {
        for (int i = 0; i < getColumnModel().getColumnCount() && i < iArr.length; i++) {
            getColumnModel().getColumn(i).setPreferredWidth(iArr[i]);
        }
    }

    public void editingStopped(ChangeEvent changeEvent) {
        int selectedRow;
        super.editingStopped(changeEvent);
        if (this.autoRowAddition && (selectedRow = getSelectedRow()) == getRowCount() - 1) {
            this.model.addRow(new String[getColumnCount()]);
            setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
        }
    }

    public TableCellRenderer getCellRenderer(int i, int i2) {
        if (this.useCustomRenderer) {
            if (this.myRenderer == null) {
                this.myRenderer = new AltColorTableRenderer(this.evenRowColor, Color.WHITE, this.selectedRowColor);
            }
            return this.myRenderer;
        }
        return super.getCellRenderer(i, i2);
    }

    /* renamed from: a */
    private void m215a(ArrayList arrayList) {
        this.data = new Vector();
        this.columnNames = new Vector();
        this.deletedRows = new HashSet(11);
        this.model = new DefaultTableModel(this.data, this.columnNames);
        setModel(this.model);
        if (arrayList == null) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            this.model.addColumn((String) arrayList.get(i));
        }
    }
}
