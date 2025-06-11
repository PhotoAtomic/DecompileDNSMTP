package com.synametrics.commons.util.logging;

import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Category;
import org.apache.log4j.LogManager;
/* loaded from: input.jar:com/synametrics/commons/util/logging/SimpleSocketServer.class */
public class SimpleSocketServer {

    /* renamed from: a */
    private static Category f35a = Category.getInstance(SimpleSocketServer.class.getName());

    /* renamed from: b */
    private static int f36b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.NumberFormatException] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
    public static void main(String[] strArr) {
        ?? r0;
        String str;
        if (strArr.length == 2) {
            ?? r02 = strArr[0];
            try {
                r02 = Integer.parseInt(r02);
                f36b = r02;
                str = r02;
            } catch (NumberFormatException e) {
                r02.printStackTrace();
                String str2 = "Could not interpret port number [" + r02 + "].";
                m185a(str2);
                str = str2;
            }
            BasicConfigurator.configure();
            r0 = str;
        } else {
            m185a("Wrong number of arguments.");
            r0 = "Wrong number of arguments.";
        }
        try {
            f35a.info("Listening on port " + f36b);
            ServerSocket serverSocket = new ServerSocket(f36b);
            while (true) {
                f35a.info("Waiting to accept a new client.");
                Socket accept = serverSocket.accept();
                f35a.info("Connected to client at " + accept.getInetAddress());
                f35a.info("Starting new socket node.");
                r0 = new Thread(new SocketReceiver(accept, LogManager.getLoggerRepository$1ce6f9a2()));
                r0.start();
            }
        } catch (Exception e2) {
            r0.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m185a(String str) {
        System.err.println(str);
        System.err.println("Usage: java " + SimpleSocketServer.class.getName() + " port configFile");
        System.exit(1);
    }
}
