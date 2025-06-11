package com.synametrics.commons.util.logging.perfmon;

import com.synametrics.commons.gui.table.CustomTable;
import java.util.ArrayList;
/* loaded from: input.jar:com/synametrics/commons/util/logging/perfmon/LogTable.class */
public class LogTable extends CustomTable {
    public LogTable() {
        super(new ArrayList(5));
        this.model.addColumn("Client");
        this.model.addColumn("Time (ms)");
        this.model.addColumn("Message");
        this.model.addColumn("Class name");
        this.model.addColumn("Thread name");
        this.model.addColumn("");
        getColumnModel().getColumn(5).setMaxWidth(0);
        getColumnModel().getColumn(5).setMinWidth(0);
        getColumnModel().getColumn(5).setWidth(0);
        m214a(new int[]{120, 75, 100, 100, 100}, false);
    }
}
