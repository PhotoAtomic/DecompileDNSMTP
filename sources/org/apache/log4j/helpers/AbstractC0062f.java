package org.apache.log4j.helpers;

import java.io.File;
/* renamed from: org.apache.log4j.helpers.f */
/* loaded from: input.jar:org/apache/log4j/helpers/f.class */
public abstract class AbstractC0062f extends Thread {

    /* renamed from: a */
    protected String f208a;

    /* renamed from: c */
    private File f210c;

    /* renamed from: b */
    private long f209b = 60000;

    /* renamed from: d */
    private long f211d = 0;

    /* renamed from: e */
    private boolean f212e = false;

    /* renamed from: f */
    private boolean f213f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0062f(String str) {
        this.f208a = str;
        this.f210c = new File(str);
        setDaemon(true);
        m74b();
    }

    /* renamed from: a */
    public final void m75a(long j) {
        this.f209b = j;
    }

    /* renamed from: a */
    protected abstract void mo76a();

    /* renamed from: b */
    private void m74b() {
        try {
            if (!this.f210c.exists()) {
                if (this.f212e) {
                    return;
                }
                C0059c.m83a(new StringBuffer().append("[").append(this.f208a).append("] does not exist.").toString());
                this.f212e = true;
                return;
            }
            long lastModified = this.f210c.lastModified();
            if (lastModified > this.f211d) {
                this.f211d = lastModified;
                mo76a();
                this.f212e = false;
            }
        } catch (SecurityException e) {
            C0059c.m78c(new StringBuffer().append("Was not allowed to read check file existance, file:[").append(this.f208a).append("].").toString());
            this.f213f = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f213f) {
            try {
                Thread.currentThread();
                Thread.sleep(this.f209b);
            } catch (InterruptedException unused) {
            }
            m74b();
        }
    }
}
