package com.synametrics.commons.util.logging;

import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: input.jar:com/synametrics/commons/util/logging/LogTester.class */
public class LogTester {
    /* renamed from: a */
    private static void m188a() {
        try {
            Thread.currentThread();
            Thread.sleep((long) (Math.random() * 1000.0d));
        } catch (InterruptedException unused) {
        }
    }

    public static void main(String[] strArr) {
        LoggingFW.enableRemoteLoggingForPerformance("tarzan", 7500);
        LoggingFW.log(20000, "TESTER", "Logging framework test started");
        LogTester logTester = new LogTester();
        for (int i = 0; i < 100; i++) {
            LoggingFW.perf(1, logTester, "Write Log");
            m188a();
            LoggingFW.perf(1, logTester, "Before debug");
            LoggingFW.log(10000, logTester, "Total tables in database are 400");
            m188a();
            LoggingFW.perf(1, logTester, "Before info");
            LoggingFW.log(20000, logTester, "Increasing connection pool size to 20");
            m188a();
            LoggingFW.perf(1, logTester, "Before warning");
            LoggingFW.log(30000, logTester, "Running low on memory");
            m188a();
            LoggingFW.perf(1, logTester, "Before error");
            LoggingFW.log(40000, logTester, "Invalid SQL statement");
            m188a();
            LoggingFW.perf(1, logTester, "Before fatal");
            LoggingFW.log(50000, logTester, "Database not responding");
            m188a();
            LoggingFW.perf(0, logTester, "Before fatal");
            LoggingFW.perf(0, logTester, "Before error");
            LoggingFW.perf(0, logTester, "Before warning");
            LoggingFW.perf(0, logTester, "Before info");
            LoggingFW.perf(0, logTester, "Before debug");
            LoggingFW.perf(0, logTester, "Write Log");
            m188a();
            try {
                System.out.println("Hit enter to exit...");
                new InputStreamReader(System.in).read();
            } catch (IOException unused) {
            }
        }
    }
}
