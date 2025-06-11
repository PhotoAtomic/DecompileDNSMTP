package org.apache.log4j.lf5.viewer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: input.jar:org/apache/log4j/lf5/viewer/LogTableColumn.class */
public class LogTableColumn implements Serializable {
    protected String _label;

    /* renamed from: a */
    private static LogTableColumn f274a = new LogTableColumn("Date");

    /* renamed from: b */
    private static LogTableColumn f275b = new LogTableColumn("Thread");

    /* renamed from: c */
    private static LogTableColumn f276c = new LogTableColumn("Message #");

    /* renamed from: d */
    private static LogTableColumn f277d = new LogTableColumn("Level");

    /* renamed from: e */
    private static LogTableColumn f278e = new LogTableColumn("NDC");

    /* renamed from: f */
    private static LogTableColumn f279f = new LogTableColumn("Category");

    /* renamed from: g */
    private static LogTableColumn f280g = new LogTableColumn("Message");

    /* renamed from: h */
    private static LogTableColumn f281h = new LogTableColumn("Location");

    /* renamed from: i */
    private static LogTableColumn f282i = new LogTableColumn("Thrown");

    /* renamed from: j */
    private static LogTableColumn[] f283j = {f274a, f275b, f276c, f277d, f278e, f279f, f280g, f281h, f282i};

    /* renamed from: k */
    private static Map f284k = new HashMap();

    private LogTableColumn(String str) {
        this._label = str;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if ((obj instanceof LogTableColumn) && this._label == ((LogTableColumn) obj)._label) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this._label.hashCode();
    }

    public String toString() {
        return this._label;
    }

    static {
        for (int i = 0; i < f283j.length; i++) {
            f284k.put(f283j[i]._label, f283j[i]);
        }
    }
}
