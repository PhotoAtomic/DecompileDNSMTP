package org.apache.log4j.lf5;

import java.awt.Color;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: input.jar:org/apache/log4j/lf5/LogLevel.class */
public class LogLevel implements Serializable {

    /* renamed from: a */
    private static LogLevel f256a = new LogLevel("FATAL", 0);

    /* renamed from: b */
    private static LogLevel f257b = new LogLevel("ERROR", 1);

    /* renamed from: c */
    private static LogLevel f258c = new LogLevel("WARN", 2);

    /* renamed from: d */
    private static LogLevel f259d = new LogLevel("INFO", 3);

    /* renamed from: e */
    private static LogLevel f260e = new LogLevel("DEBUG", 4);

    /* renamed from: f */
    private static LogLevel f261f = new LogLevel("SEVERE", 1);

    /* renamed from: g */
    private static LogLevel f262g = new LogLevel("WARNING", 2);

    /* renamed from: h */
    private static LogLevel f263h = new LogLevel("CONFIG", 4);

    /* renamed from: i */
    private static LogLevel f264i = new LogLevel("FINE", 5);

    /* renamed from: j */
    private static LogLevel f265j = new LogLevel("FINER", 6);

    /* renamed from: k */
    private static LogLevel f266k = new LogLevel("FINEST", 7);
    protected String _label;
    protected int _precedence;

    /* renamed from: l */
    private static LogLevel[] f267l;

    /* renamed from: m */
    private static Map f268m;

    /* renamed from: n */
    private static Map f269n;

    private LogLevel(String str, int i) {
        this._label = str;
        this._precedence = i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if ((obj instanceof LogLevel) && this._precedence == ((LogLevel) obj)._precedence) {
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
        new HashMap();
        LogLevel[] logLevelArr = {f256a, f257b, f258c, f259d, f260e};
        LogLevel[] logLevelArr2 = {f261f, f262g, f259d, f263h, f264i, f265j, f266k};
        f267l = new LogLevel[]{f256a, f257b, f258c, f259d, f260e, f261f, f262g, f263h, f264i, f265j, f266k};
        f268m = new HashMap();
        for (int i = 0; i < f267l.length; i++) {
            f268m.put(f267l[i]._label, f267l[i]);
        }
        f269n = new HashMap();
        for (int i2 = 0; i2 < f267l.length; i2++) {
            f269n.put(f267l[i2], Color.black);
        }
    }
}
