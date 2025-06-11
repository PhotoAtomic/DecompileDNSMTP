package org.apache.log4j.p010c;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.c.c */
/* loaded from: input.jar:org/apache/log4j/c/c.class */
public class RunnableC0049c implements Runnable {

    /* renamed from: a */
    private Hierarchy f162a;

    /* renamed from: b */
    private ObjectInputStream f163b;

    /* renamed from: c */
    private static Logger f164c;

    /* renamed from: d */
    private static Class f165d;

    public RunnableC0049c(Socket socket, Hierarchy hierarchy) {
        this.f162a = hierarchy;
        try {
            this.f163b = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (Exception e) {
            f164c.error(new StringBuffer().append("Could not open ObjectInputStream to ").append(socket).toString(), e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                LoggingEvent loggingEvent = (LoggingEvent) this.f163b.readObject();
                Logger logger = this.f162a.getLogger(loggingEvent.m14c());
                if (loggingEvent.m16b().isGreaterOrEqual(logger.getEffectiveLevel())) {
                    logger.callAppenders(loggingEvent);
                }
            } catch (EOFException e) {
                f164c.info("Caught java.io.EOFException closing conneciton.");
                try {
                    this.f163b.close();
                    return;
                } catch (Exception e2) {
                    f164c.info("Could not close connection.", e2);
                    return;
                }
            } catch (SocketException unused) {
                f164c.info("Caught java.net.SocketException closing conneciton.");
                this.f163b.close();
                return;
            } catch (IOException e3) {
                f164c.info(new StringBuffer().append("Caught java.io.IOException: ").append(e3).toString());
                f164c.info("Closing connection.");
                this.f163b.close();
                return;
            } catch (Exception e4) {
                f164c.error("Unexpected exception. Closing conneciton.", e4);
                this.f163b.close();
                return;
            }
        }
    }

    /* renamed from: a */
    private static Class m105a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        Class cls;
        if (f165d == null) {
            cls = m105a("org.apache.log4j.c.c");
            f165d = cls;
        } else {
            cls = f165d;
        }
        f164c = Logger.getLogger(cls);
    }
}
