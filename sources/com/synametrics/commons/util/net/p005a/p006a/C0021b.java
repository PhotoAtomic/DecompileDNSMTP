package com.synametrics.commons.util.net.p005a.p006a;

import com.synametrics.commons.util.C0015d;
import com.synametrics.commons.util.logging.LoggingFW;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
/* renamed from: com.synametrics.commons.util.net.a.a.b */
/* loaded from: input.jar:com/synametrics/commons/util/net/a/a/b.class */
public final class C0021b {

    /* renamed from: a */
    private ServerSocket f43a = null;

    /* renamed from: b */
    private boolean f44b;

    /* renamed from: c */
    private Thread f45c;

    /* renamed from: d */
    private int f46d;

    /* renamed from: e */
    private String f47e;

    /* renamed from: a */
    private boolean m180a(InterfaceC0023d interfaceC0023d) {
        try {
            InetAddress inetAddress = null;
            if (this.f47e != null && this.f47e.trim().length() > 0 && C0015d.m198a(this.f47e)) {
                try {
                    inetAddress = InetAddress.getByName(this.f47e);
                } catch (UnknownHostException e) {
                    LoggingFW.log(40000, this, "Failure resolving IP address for binding. " + e.getMessage());
                }
            }
            this.f43a = new ServerSocket(this.f46d, 10000, inetAddress);
            LoggingFW.log(20000, this, "SMTP server successfully started...");
            return true;
        } catch (IOException e2) {
            LoggingFW.log(40000, this, "Failure starting SMTP server. Make sure no other program is listening on port " + this.f46d);
            if (interfaceC0023d != null) {
                interfaceC0023d.mo150c("Failure starting SMTP server. Make sure no other program is listening on port " + this.f46d + "." + C0015d.f25a + "Message: " + e2.getMessage());
                return false;
            }
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m182a(int i, InterfaceC0023d interfaceC0023d) {
        this.f46d = i;
        this.f47e = null;
        if (m180a(interfaceC0023d)) {
            this.f45c = new Thread(new RunnableC0024e(this, interfaceC0023d));
            this.f45c.start();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m183a() {
        try {
            if (this.f43a == null) {
                return true;
            }
            this.f44b = true;
            this.f43a.close();
            if (this.f45c != null) {
                this.f45c.interrupt();
                return true;
            }
            return true;
        } catch (IOException unused) {
            LoggingFW.log(40000, this, "Error while stopping SMTP server");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m181a(C0021b c0021b, InterfaceC0023d interfaceC0023d) {
        String property;
        c0021b.f44b = false;
        try {
            if (System.getProperty("smtpserver.host.name", InetAddress.getLocalHost().getHostName()).indexOf(".") == -1) {
                String str = String.valueOf(property) + ".nohost.com";
            }
        } catch (UnknownHostException e) {
        }
        while (true) {
            if (c0021b.f44b) {
                break;
            } else if (Thread.interrupted()) {
                LoggingFW.log(20000, c0021b, "Thread inturrupted. Will terminate the SMTP SMTP server");
                break;
            } else {
                try {
                    new C0025f(c0021b.f43a.accept(), interfaceC0023d).m179a();
                } catch (IOException e2) {
                    if (!c0021b.f44b) {
                        LoggingFW.log(20000, c0021b, "Either accept failed or server was stopped: " + e2.getMessage());
                    }
                }
            }
        }
        LoggingFW.log(20000, c0021b, "SMTP Proxy server terminated");
    }
}
