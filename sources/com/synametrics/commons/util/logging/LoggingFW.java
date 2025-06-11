package com.synametrics.commons.util.logging;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Stack;
import org.apache.log4j.AsyncAppender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.p008a.C0040b;
import org.apache.log4j.p010c.C0048b;
/* loaded from: input.jar:com/synametrics/commons/util/logging/LoggingFW.class */
public class LoggingFW {
    public static final int FATAL = 50000;
    public static final int ERROR = 40000;
    public static final int WARN = 30000;
    public static final int INFO = 20000;
    public static final int DEBUG = 10000;
    public static final int ENTER = 1;
    public static final int EXIT = 0;

    /* renamed from: a */
    private static C0048b f30a;
    public static Hashtable perfCounters;

    static {
        String str = null;
        try {
            str = System.getProperty("LoggingConfigFile");
        } catch (SecurityException unused) {
        }
        perfCounters = new Hashtable(23);
        if (str == null || str.length() == 0) {
            m186b();
        } else if (str.endsWith(".xml")) {
            C0040b.m130a(str);
            m187a();
        } else if (str.endsWith(".properties")) {
            PropertyConfigurator.configure(str);
            m187a();
        } else {
            System.out.println("Invalid configuration file. It must be a valid log4j configuration. That is either a .xml or .properties file. Using default configuration");
            m186b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v14, types: [org.apache.log4j.Logger] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* renamed from: a */
    private static void m187a() {
        ?? length;
        String str = null;
        try {
            str = System.getProperty("com.synametrics.perfFileName", "");
        } catch (SecurityException e) {
        }
        if (str != null && (length = str.length()) > 0) {
            try {
                FileAppender fileAppender = new FileAppender(new PerformanceLayout(), str, true);
                length = Logger.getLogger("PERFORMANCE");
                length.addAppender(fileAppender);
            } catch (IOException e2) {
                length.printStackTrace();
            }
        }
        Logger.getLogger("PERFORMANCE").addAppender(new ConsoleAppender(new PerformanceLayout()));
        Logger.getLogger("PERFORMANCE").setAdditivity(false);
        Logger.getLogger("PERFORMANCE").setLevel(Level.OFF);
    }

    public static void disableRemoteLogging() {
        if (f30a == null) {
            return;
        }
        LogManager.getLoggerRepository$1ce6f9a2().getRootLogger().removeAppender(f30a);
        f30a.close();
    }

    public static void enableRemoteLogging(String str, int i) {
        f30a = new CustomSocketAppender(str, i);
        LogManager.getLoggerRepository$1ce6f9a2().getRootLogger().addAppender(f30a);
        f30a.setThreshold(Priority.INFO);
    }

    public static void enableRemoteLoggingForPerformance(String str, int i) {
        Logger.getLogger("PERFORMANCE").addAppender(new C0048b(str, i));
    }

    public static void enablePerformanceLogging(boolean z) {
        if (z) {
            Logger.getLogger("PERFORMANCE").setLevel(Level.INFO);
        } else {
            Logger.getLogger("PERFORMANCE").setLevel(Level.OFF);
        }
    }

    public static boolean isDebugEnabled(Object obj) {
        return Logger.getLogger(obj instanceof String ? obj.toString() : obj.getClass().getName()).isDebugEnabled();
    }

    public static void log(int i, Object obj, String str, Throwable th) {
        Logger.getLogger(obj instanceof String ? obj.toString() : obj.getClass().getName()).log(Level.toLevel(i), str, th);
    }

    public static void log(int i, Object obj, String str) {
        if (obj instanceof String) {
            log(i, obj, str, null);
        } else {
            log(i, obj.getClass().getName(), str, null);
        }
    }

    public static void perf(int i, Object obj, String str) {
        PerformanceInfo performanceInfo;
        String name = Thread.currentThread().getName();
        String obj2 = obj instanceof String ? obj.toString() : obj.getClass().getName();
        Stack stack = (Stack) perfCounters.get(name);
        if (i == 1) {
            if (stack == null) {
                stack = new Stack();
            }
            PerformanceInfo performanceInfo2 = new PerformanceInfo(stack.size(), Sequence.getNextVal("PerformanceSequence"));
            performanceInfo = performanceInfo2;
            performanceInfo2.setEnterClassName(obj2);
            performanceInfo.setThreadName(name);
            performanceInfo.setEnterMessage(str);
            stack.push(performanceInfo);
        } else {
            if (stack == null) {
                stack = new Stack();
                PerformanceInfo performanceInfo3 = new PerformanceInfo(stack.size(), Sequence.getNextVal(name));
                performanceInfo = performanceInfo3;
                performanceInfo3.setEnterMessage("ERROR: No enter for this EXIT. " + str);
            } else {
                PerformanceInfo performanceInfo4 = (PerformanceInfo) stack.pop();
                performanceInfo = performanceInfo4;
                performanceInfo4.setExitMessage(str);
            }
            performanceInfo.setEnterClassName(obj2);
            performanceInfo.setThreadName(name);
        }
        perfCounters.put(name, stack);
        Logger.getLogger("PERFORMANCE").log(Level.INFO, performanceInfo);
    }

    public static void registerRemoteViewer(RemoteViewer remoteViewer, int i) {
        new Thread(new RunnableC0019b(remoteViewer, i)).start();
    }

    /* renamed from: b */
    private static void m186b() {
        System.out.println("Running under default configuration");
        BasicConfigurator.configure();
        LogManager.getLoggerRepository$1ce6f9a2().getRootLogger().setLevel(Level.INFO);
        m187a();
    }

    public static void setPerformanceViewer(PerformanceViewer performanceViewer) {
        AsyncAppender asyncAppender = new AsyncAppender();
        asyncAppender.setBufferSize(4096);
        asyncAppender.addAppender(new PerfViewerAppender(performanceViewer));
        Logger.getLogger("PERFORMANCE").addAppender(asyncAppender);
        Logger.getLogger("PERFORMANCE").setAdditivity(false);
        Logger.getLogger("PERFORMANCE").setLevel(Level.INFO);
    }

    public static void terminate() {
        LogManager.shutdown();
    }
}
