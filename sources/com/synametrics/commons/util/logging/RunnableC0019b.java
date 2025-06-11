package com.synametrics.commons.util.logging;

import java.io.IOException;
import java.net.ServerSocket;
import org.apache.log4j.LogManager;
import org.apache.log4j.Priority;
import org.apache.log4j.p010c.RunnableC0049c;
/* renamed from: com.synametrics.commons.util.logging.b */
/* loaded from: input.jar:com/synametrics/commons/util/logging/b.class */
final class RunnableC0019b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ RemoteViewer f40a;

    /* renamed from: b */
    private final /* synthetic */ int f41b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0019b(RemoteViewer remoteViewer, int i) {
        this.f40a = remoteViewer;
        this.f41b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RemoteLogAppender remoteLogAppender = new RemoteLogAppender(this.f40a);
        remoteLogAppender.setThreshold(Priority.INFO);
        LogManager.getLoggerRepository$1ce6f9a2().getRootLogger().addAppender(remoteLogAppender);
        try {
            while (true) {
                new Thread(new RunnableC0049c(new ServerSocket(this.f41b).accept(), LogManager.getLoggerRepository$1ce6f9a2())).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while starting Remote Logging Server. " + e.getMessage());
        }
    }
}
