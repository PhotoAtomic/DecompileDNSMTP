package org.apache.log4j;

import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0074r;
import org.apache.log4j.helpers.C0076t;
import org.apache.log4j.spi.LoggingEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.b */
/* loaded from: input.jar:org/apache/log4j/b.class */
public final class C0042b extends Thread {

    /* renamed from: a */
    C0074r f142a;

    /* renamed from: c */
    private C0076t f143c;

    /* renamed from: b */
    boolean f144b = false;

    /* renamed from: d */
    private AsyncAppender f145d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0042b(C0074r c0074r, AsyncAppender asyncAppender) {
        this.f142a = c0074r;
        this.f145d = asyncAppender;
        this.f143c = asyncAppender.f87a;
        setDaemon(true);
        setPriority(1);
        setName(new StringBuffer().append("Dispatcher-").append(getName()).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        r0 = r3.f145d.f87a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        if (r3.f143c == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r0 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
        r3.f143c.m32a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
        monitor-exit(r0);
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        while (true) {
            synchronized (this.f142a) {
                if (this.f142a.m39d() == 0) {
                    if (this.f144b) {
                        break;
                    }
                    try {
                        this.f142a.wait();
                    } catch (InterruptedException e) {
                        C0059c.m80b("The dispathcer should not be interrupted.");
                    }
                    this.f143c.m31b();
                }
                LoggingEvent m45a = this.f142a.m45a();
                if (this.f142a.m37f()) {
                    this.f142a.notify();
                }
            }
            this.f143c.m31b();
        }
        this.f143c.m31b();
    }
}
