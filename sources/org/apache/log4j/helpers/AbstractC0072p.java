package org.apache.log4j.helpers;

import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.p */
/* loaded from: input.jar:org/apache/log4j/helpers/p.class */
public abstract class AbstractC0072p {

    /* renamed from: a */
    public AbstractC0072p f231a;

    /* renamed from: b */
    private int f232b;

    /* renamed from: c */
    private int f233c;

    /* renamed from: d */
    private boolean f234d;

    /* renamed from: e */
    private static String[] f235e = {" ", "  ", "    ", "        ", "                ", "                                "};

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0072p() {
        this.f232b = -1;
        this.f233c = Priority.OFF_INT;
        this.f234d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0072p(C0080x c0080x) {
        this.f232b = -1;
        this.f233c = Priority.OFF_INT;
        this.f234d = false;
        this.f232b = c0080x.f253a;
        this.f233c = c0080x.f254b;
        this.f234d = c0080x.f255c;
    }

    /* renamed from: a */
    protected abstract String mo28a(LoggingEvent loggingEvent);

    /* renamed from: a */
    public void mo52a(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        String mo28a = mo28a(loggingEvent);
        if (mo28a == null) {
            if (0 < this.f232b) {
                m53a(stringBuffer, this.f232b);
                return;
            }
            return;
        }
        int length = mo28a.length();
        if (length > this.f233c) {
            stringBuffer.append(mo28a.substring(length - this.f233c));
        } else if (length >= this.f232b) {
            stringBuffer.append(mo28a);
        } else if (this.f234d) {
            stringBuffer.append(mo28a);
            m53a(stringBuffer, this.f232b - length);
        } else {
            m53a(stringBuffer, this.f232b - length);
            stringBuffer.append(mo28a);
        }
    }

    /* renamed from: a */
    private static void m53a(StringBuffer stringBuffer, int i) {
        while (i >= 32) {
            stringBuffer.append(f235e[5]);
            i -= 32;
        }
        for (int i2 = 4; i2 >= 0; i2--) {
            if ((i & (1 << i2)) != 0) {
                stringBuffer.append(f235e[i2]);
            }
        }
    }
}
