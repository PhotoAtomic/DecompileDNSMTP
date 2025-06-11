package org.apache.log4j;

import java.util.Enumeration;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0074r;
import org.apache.log4j.helpers.C0076t;
import org.apache.log4j.spi.InterfaceC0084b;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/AsyncAppender.class */
public class AsyncAppender extends AppenderSkeleton implements InterfaceC0084b {
    public static final int DEFAULT_BUFFER_SIZE = 128;

    /* renamed from: b */
    private C0074r f86b = new C0074r(DEFAULT_BUFFER_SIZE);

    /* renamed from: d */
    private boolean f89d = false;

    /* renamed from: e */
    private boolean f90e = false;

    /* renamed from: a */
    C0076t f87a = new C0076t();

    /* renamed from: c */
    private C0042b f88c = new C0042b(this.f86b, this);

    public AsyncAppender() {
        this.f88c.start();
    }

    @Override // org.apache.log4j.spi.InterfaceC0084b
    public void addAppender(Appender appender) {
        synchronized (this.f87a) {
            this.f87a.addAppender(appender);
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        loggingEvent.m12e();
        loggingEvent.m8i();
        loggingEvent.m11f();
        if (this.f89d) {
            loggingEvent.m18a();
        }
        synchronized (this.f86b) {
            while (this.f86b.m40c()) {
                try {
                    this.f86b.wait();
                } catch (InterruptedException e) {
                    if (this.f90e) {
                        C0059c.m78c("AsyncAppender interrupted again.");
                    } else {
                        this.f90e = true;
                        C0059c.m77c("AsyncAppender interrupted.", e);
                    }
                }
            }
            this.f86b.m42a(loggingEvent);
            if (this.f86b.m38e()) {
                this.f86b.notify();
            }
        }
    }

    @Override // org.apache.log4j.Appender
    public void close() {
        synchronized (this) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            C0042b c0042b = this.f88c;
            synchronized (c0042b.f142a) {
                c0042b.f144b = true;
                if (c0042b.f142a.m39d() == 0) {
                    c0042b.f142a.notify();
                }
            }
            try {
                this.f88c.join();
            } catch (InterruptedException e) {
                C0059c.m79b("Got an InterruptedException while waiting for the dispatcher to finish.", e);
            }
            this.f88c = null;
            this.f86b = null;
        }
    }

    public Enumeration getAllAppenders() {
        Enumeration m35a;
        synchronized (this.f87a) {
            m35a = this.f87a.m35a();
        }
        return m35a;
    }

    public Appender getAppender(String str) {
        Appender m34a;
        synchronized (this.f87a) {
            m34a = this.f87a.m34a(str);
        }
        return m34a;
    }

    public boolean getLocationInfo() {
        return this.f89d;
    }

    public boolean isAttached(Appender appender) {
        return this.f87a.m33a(appender);
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    public void removeAllAppenders() {
        synchronized (this.f87a) {
            this.f87a.m31b();
        }
    }

    public void removeAppender(Appender appender) {
        synchronized (this.f87a) {
            this.f87a.m29b(appender);
        }
    }

    public void removeAppender(String str) {
        synchronized (this.f87a) {
            this.f87a.m30b(str);
        }
    }

    public void setLocationInfo(boolean z) {
        this.f89d = z;
    }

    public void setBufferSize(int i) {
        this.f86b.m44a(i);
    }

    public int getBufferSize() {
        return this.f86b.m41b();
    }
}
