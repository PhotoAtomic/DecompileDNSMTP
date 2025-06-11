package org.apache.log4j.p010c;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import org.apache.log4j.helpers.C0059c;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.apache.log4j.c.a */
/* loaded from: input.jar:org/apache/log4j/c/a.class */
public final class C0047a extends Thread {

    /* renamed from: a */
    boolean f152a = false;

    /* renamed from: b */
    private final C0048b f153b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0047a(C0048b c0048b) {
        this.f153b = c0048b;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f152a) {
            try {
                Thread.sleep(this.f153b.f158d);
                C0059c.m83a(new StringBuffer().append("Attempting connection to ").append(this.f153b.f155a.getHostName()).toString());
                Socket socket = new Socket(this.f153b.f155a, this.f153b.f156b);
                synchronized (this) {
                    this.f153b.f157c = new ObjectOutputStream(socket.getOutputStream());
                    C0048b.m106a(this.f153b, (C0047a) null);
                    C0059c.m83a("Connection established. Exiting connector thread.");
                }
                return;
            } catch (IOException e) {
                C0059c.m83a(new StringBuffer().append("Could not connect to ").append(this.f153b.f155a.getHostName()).append(". Exception is ").append(e).toString());
            } catch (InterruptedException unused) {
                C0059c.m83a("Connector interrupted. Leaving loop.");
                return;
            } catch (ConnectException unused2) {
                C0059c.m83a(new StringBuffer().append("Remote host ").append(this.f153b.f155a.getHostName()).append(" refused connection.").toString());
            }
        }
    }
}
