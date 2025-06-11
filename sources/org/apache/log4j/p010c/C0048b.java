package org.apache.log4j.p010c;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.c.b */
/* loaded from: input.jar:org/apache/log4j/c/b.class */
public class C0048b extends AppenderSkeleton {

    /* renamed from: e */
    private String f154e;

    /* renamed from: a */
    InetAddress f155a;

    /* renamed from: b */
    int f156b;

    /* renamed from: c */
    ObjectOutputStream f157c;

    /* renamed from: d */
    int f158d;

    /* renamed from: f */
    private boolean f159f;

    /* renamed from: g */
    private C0047a f160g;

    /* renamed from: h */
    private int f161h;

    public C0048b() {
        this.f156b = 4560;
        this.f158d = 30000;
        this.f159f = false;
        this.f161h = 0;
    }

    public C0048b(InetAddress inetAddress, int i) {
        this.f156b = 4560;
        this.f158d = 30000;
        this.f159f = false;
        this.f161h = 0;
        this.f155a = inetAddress;
        this.f154e = inetAddress.getHostName();
        this.f156b = i;
        m107a(inetAddress, i);
    }

    public C0048b(String str, int i) {
        this.f156b = 4560;
        this.f158d = 30000;
        this.f159f = false;
        this.f161h = 0;
        this.f156b = i;
        this.f155a = m108a(str);
        this.f154e = str;
        m107a(this.f155a, i);
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
        m107a(this.f155a, this.f156b);
    }

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        cleanUp();
    }

    public void cleanUp() {
        if (this.f157c != null) {
            try {
                this.f157c.close();
            } catch (IOException e) {
                C0059c.m79b("Could not close oos.", e);
            }
            this.f157c = null;
        }
        if (this.f160g != null) {
            this.f160g.f152a = true;
            this.f160g = null;
        }
    }

    /* renamed from: a */
    private void m107a(InetAddress inetAddress, int i) {
        if (this.f155a == null) {
            return;
        }
        try {
            cleanUp();
            this.f157c = new ObjectOutputStream(new Socket(inetAddress, i).getOutputStream());
        } catch (IOException e) {
            String stringBuffer = new StringBuffer().append("Could not connect to remote log4j server at [").append(inetAddress.getHostName()).append("].").toString();
            if (this.f158d > 0) {
                stringBuffer = new StringBuffer().append(stringBuffer).append(" We will try again later.").toString();
                m109a();
            }
            C0059c.m79b(stringBuffer, e);
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        if (loggingEvent == null) {
            return;
        }
        if (this.f155a == null) {
            this.errorHandler.mo5a(new StringBuffer().append("No remote host is set for SocketAppender named \"").append(this.name).append("\".").toString());
        } else if (this.f157c != null) {
            try {
                if (this.f159f) {
                    loggingEvent.m18a();
                }
                this.f157c.writeObject(loggingEvent);
                this.f157c.flush();
                int i = this.f161h + 1;
                this.f161h = i;
                if (i >= 1) {
                    this.f161h = 0;
                    this.f157c.reset();
                }
            } catch (IOException e) {
                this.f157c = null;
                C0059c.m78c(new StringBuffer().append("Detected problem with connection: ").append(e).toString());
                if (this.f158d > 0) {
                    m109a();
                }
            }
        }
    }

    /* renamed from: a */
    private void m109a() {
        if (this.f160g == null) {
            C0059c.m83a("Starting a new connector thread.");
            this.f160g = new C0047a(this);
            this.f160g.setDaemon(true);
            this.f160g.setPriority(1);
            this.f160g.start();
        }
    }

    /* renamed from: a */
    private static InetAddress m108a(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception e) {
            C0059c.m79b(new StringBuffer().append("Could not find address of [").append(str).append("].").toString(), e);
            return null;
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    public void setRemoteHost(String str) {
        this.f155a = m108a(str);
        this.f154e = str;
    }

    public String getRemoteHost() {
        return this.f154e;
    }

    public void setPort(int i) {
        this.f156b = i;
    }

    public int getPort() {
        return this.f156b;
    }

    public void setLocationInfo(boolean z) {
        this.f159f = z;
    }

    public boolean getLocationInfo() {
        return this.f159f;
    }

    public void setReconnectionDelay(int i) {
        this.f158d = i;
    }

    public int getReconnectionDelay() {
        return this.f158d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C0047a m106a(C0048b c0048b, C0047a c0047a) {
        c0048b.f160g = null;
        return null;
    }
}
