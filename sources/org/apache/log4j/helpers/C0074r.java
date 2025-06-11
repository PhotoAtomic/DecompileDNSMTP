package org.apache.log4j.helpers;

import org.apache.log4j.AsyncAppender;
import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.r */
/* loaded from: input.jar:org/apache/log4j/helpers/r.class */
public final class C0074r {

    /* renamed from: b */
    private int f246b = 0;

    /* renamed from: c */
    private int f247c = 0;

    /* renamed from: d */
    private int f248d = 0;

    /* renamed from: e */
    private int f249e = AsyncAppender.DEFAULT_BUFFER_SIZE;

    /* renamed from: a */
    private LoggingEvent[] f245a = new LoggingEvent[AsyncAppender.DEFAULT_BUFFER_SIZE];

    public C0074r(int i) {
    }

    /* renamed from: a */
    public final LoggingEvent m45a() {
        if (this.f246b == 0) {
            return null;
        }
        LoggingEvent loggingEvent = this.f245a[this.f247c];
        this.f245a[this.f247c] = null;
        int i = this.f247c + 1;
        this.f247c = i;
        if (i == this.f249e) {
            this.f247c = 0;
        }
        this.f246b--;
        return loggingEvent;
    }

    /* renamed from: a */
    public final void m42a(LoggingEvent loggingEvent) {
        if (this.f246b != this.f249e) {
            this.f245a[this.f248d] = loggingEvent;
            int i = this.f248d + 1;
            this.f248d = i;
            if (i == this.f249e) {
                this.f248d = 0;
            }
            this.f246b++;
        }
    }

    /* renamed from: b */
    public final int m41b() {
        return this.f249e;
    }

    /* renamed from: c */
    public final boolean m40c() {
        return this.f246b == this.f249e;
    }

    /* renamed from: d */
    public final int m39d() {
        return this.f246b;
    }

    /* renamed from: a */
    private static int m43a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* renamed from: a */
    public final synchronized void m44a(int i) {
        if (i == this.f249e) {
            return;
        }
        LoggingEvent[] loggingEventArr = new LoggingEvent[i];
        int m43a = m43a(m43a(this.f249e - this.f247c, i), this.f246b);
        System.arraycopy(this.f245a, this.f247c, loggingEventArr, 0, m43a);
        int i2 = 0;
        if (m43a < this.f246b && m43a < i) {
            i2 = m43a(this.f246b - m43a, i - m43a);
            System.arraycopy(this.f245a, 0, loggingEventArr, m43a, i2);
        }
        this.f245a = loggingEventArr;
        this.f249e = i;
        this.f247c = 0;
        this.f246b = m43a + i2;
        this.f248d = this.f246b;
        if (this.f248d == this.f249e) {
            this.f248d = 0;
        }
    }

    /* renamed from: e */
    public final boolean m38e() {
        return this.f246b == 1;
    }

    /* renamed from: f */
    public final boolean m37f() {
        return this.f246b + 1 == this.f249e;
    }
}
