package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.C0059c;
/* loaded from: input.jar:org/apache/log4j/spi/LocationInfo.class */
public class LocationInfo implements Serializable {

    /* renamed from: a */
    private transient String f285a;

    /* renamed from: b */
    private transient String f286b;

    /* renamed from: c */
    private transient String f287c;

    /* renamed from: d */
    private transient String f288d;
    public String fullInfo;

    /* renamed from: e */
    private static StringWriter f289e = new StringWriter();

    /* renamed from: f */
    private static PrintWriter f290f = new PrintWriter(f289e);
    static final long serialVersionUID = -1325822038990805636L;

    /* renamed from: g */
    private static boolean f291g;

    public LocationInfo(Throwable th, String str) {
        String stringWriter;
        int indexOf;
        if (th == null) {
            return;
        }
        synchronized (f289e) {
            th.printStackTrace(f290f);
            stringWriter = f289e.toString();
            f289e.getBuffer().setLength(0);
        }
        int lastIndexOf = stringWriter.lastIndexOf(str);
        if (lastIndexOf == -1 || (indexOf = stringWriter.indexOf(Layout.LINE_SEP, lastIndexOf)) == -1) {
            return;
        }
        int i = indexOf + Layout.LINE_SEP_LEN;
        int indexOf2 = stringWriter.indexOf(Layout.LINE_SEP, i);
        if (indexOf2 == -1) {
            return;
        }
        if (!f291g) {
            int lastIndexOf2 = stringWriter.lastIndexOf("at ", indexOf2);
            if (lastIndexOf2 == -1) {
                return;
            }
            i = lastIndexOf2 + 3;
        }
        this.fullInfo = stringWriter.substring(i, indexOf2);
    }

    /* renamed from: a */
    public final String m22a() {
        if (this.fullInfo == null) {
            return "?";
        }
        if (this.f287c == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(40);
            if (lastIndexOf == -1) {
                this.f287c = "?";
            } else {
                int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
                int i = 0;
                if (f291g) {
                    i = this.fullInfo.lastIndexOf(32, lastIndexOf2) + 1;
                }
                if (lastIndexOf2 == -1) {
                    this.f287c = "?";
                } else {
                    this.f287c = this.fullInfo.substring(i, lastIndexOf2);
                }
            }
        }
        return this.f287c;
    }

    /* renamed from: b */
    public final String m21b() {
        if (this.fullInfo == null) {
            return "?";
        }
        if (this.f286b == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(58);
            if (lastIndexOf == -1) {
                this.f286b = "?";
            } else {
                this.f286b = this.fullInfo.substring(this.fullInfo.lastIndexOf(40, lastIndexOf - 1) + 1, lastIndexOf);
            }
        }
        return this.f286b;
    }

    /* renamed from: c */
    public final String m20c() {
        if (this.fullInfo == null) {
            return "?";
        }
        if (this.f285a == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(41);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(58, lastIndexOf - 1);
            if (lastIndexOf2 == -1) {
                this.f285a = "?";
            } else {
                this.f285a = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.f285a;
    }

    /* renamed from: d */
    public final String m19d() {
        if (this.fullInfo == null) {
            return "?";
        }
        if (this.f288d == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(40);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
            if (lastIndexOf2 == -1) {
                this.f288d = "?";
            } else {
                this.f288d = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.f288d;
    }

    static {
        f291g = false;
        try {
            Class.forName("com.ibm.uvm.tools.DebugSupport");
            f291g = true;
            C0059c.m83a("Detected IBM VisualAge environment.");
        } catch (Throwable unused) {
        }
    }
}
