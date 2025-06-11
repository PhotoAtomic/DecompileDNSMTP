package com.synametrics.commons.util.logging;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:com/synametrics/commons/util/logging/SocketReceiver.class */
public class SocketReceiver implements Runnable {

    /* renamed from: a */
    private Hierarchy f37a;

    /* renamed from: b */
    private ObjectInputStream f38b;

    public SocketReceiver(Socket socket, Hierarchy hierarchy) {
        this.f37a = hierarchy;
        try {
            this.f38b = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (Exception e) {
            LoggingFW.log(40000, this, "Could not open ObjectInputStream to " + socket.toString() + e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                LoggingEvent loggingEvent = (LoggingEvent) this.f38b.readObject();
                Logger logger = this.f37a.getLogger(loggingEvent.m14c());
                if (loggingEvent.m16b().isGreaterOrEqual(logger.getEffectiveLevel())) {
                    logger.callAppenders(loggingEvent);
                }
            } catch (EOFException e) {
                LoggingFW.log(30000, this, "Caught java.io.EOFException closing conneciton.");
                try {
                    this.f38b.close();
                    return;
                } catch (Exception e2) {
                    LoggingFW.log(30000, this, "Could not close connection.", e2);
                    return;
                }
            } catch (SocketException e3) {
                LoggingFW.log(30000, this, "Caught java.net.SocketException closing conneciton.");
                this.f38b.close();
                return;
            } catch (IOException e4) {
                LoggingFW.log(30000, this, "Caught java.io.IOException: " + e4);
                LoggingFW.log(30000, this, "Closing connection.");
                this.f38b.close();
                return;
            } catch (Exception e5) {
                LoggingFW.log(30000, this, "Unexpected exception. Closing conneciton.", e5);
                this.f38b.close();
                return;
            }
        }
    }
}
