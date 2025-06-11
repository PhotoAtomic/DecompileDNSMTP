package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.spi.InterfaceC0084b;
import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.t */
/* loaded from: input.jar:org/apache/log4j/helpers/t.class */
public final class C0076t implements InterfaceC0084b {

    /* renamed from: a */
    private Vector f251a;

    @Override // org.apache.log4j.spi.InterfaceC0084b
    public final void addAppender(Appender appender) {
        if (appender == null) {
            return;
        }
        if (this.f251a == null) {
            this.f251a = new Vector(1);
        }
        if (this.f251a.contains(appender)) {
            return;
        }
        this.f251a.addElement(appender);
    }

    /* renamed from: a */
    public final int m32a(LoggingEvent loggingEvent) {
        int i = 0;
        if (this.f251a != null) {
            i = this.f251a.size();
            for (int i2 = 0; i2 < i; i2++) {
                ((Appender) this.f251a.elementAt(i2)).doAppend(loggingEvent);
            }
        }
        return i;
    }

    /* renamed from: a */
    public final Enumeration m35a() {
        if (this.f251a == null) {
            return null;
        }
        return this.f251a.elements();
    }

    /* renamed from: a */
    public final Appender m34a(String str) {
        if (this.f251a == null || str == null) {
            return null;
        }
        int size = this.f251a.size();
        for (int i = 0; i < size; i++) {
            Appender appender = (Appender) this.f251a.elementAt(i);
            if (str.equals(appender.getName())) {
                return appender;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final boolean m33a(Appender appender) {
        if (this.f251a == null || appender == null) {
            return false;
        }
        int size = this.f251a.size();
        for (int i = 0; i < size; i++) {
            if (((Appender) this.f251a.elementAt(i)) == appender) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m31b() {
        if (this.f251a != null) {
            int size = this.f251a.size();
            for (int i = 0; i < size; i++) {
                ((Appender) this.f251a.elementAt(i)).close();
            }
            this.f251a.removeAllElements();
            this.f251a = null;
        }
    }

    /* renamed from: b */
    public final void m29b(Appender appender) {
        if (appender == null || this.f251a == null) {
            return;
        }
        this.f251a.removeElement(appender);
    }

    /* renamed from: b */
    public final void m30b(String str) {
        if (str == null || this.f251a == null) {
            return;
        }
        int size = this.f251a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(((Appender) this.f251a.elementAt(i)).getName())) {
                this.f251a.removeElementAt(i);
                return;
            }
        }
    }
}
