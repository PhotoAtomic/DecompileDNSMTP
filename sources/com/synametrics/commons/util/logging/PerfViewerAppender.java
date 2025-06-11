package com.synametrics.commons.util.logging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:com/synametrics/commons/util/logging/PerfViewerAppender.class */
public class PerfViewerAppender extends AppenderSkeleton {

    /* renamed from: a */
    private PerformanceViewer f31a;

    public PerfViewerAppender(PerformanceViewer performanceViewer) {
        this.f31a = performanceViewer;
    }

    @Override // org.apache.log4j.AppenderSkeleton
    protected void append(LoggingEvent loggingEvent) {
        PerformanceViewer performanceViewer = this.f31a;
        String m10g = loggingEvent.m10g();
        String[] strArr = new String[10];
        StringBuffer stringBuffer = new StringBuffer(512);
        int i = 0;
        for (int i2 = 0; i2 < m10g.length(); i2++) {
            if (m10g.charAt(i2) != ',' || i >= 10) {
                stringBuffer.append(m10g.charAt(i2));
            } else {
                strArr[i] = stringBuffer.toString().trim();
                i++;
                stringBuffer.setLength(0);
            }
        }
        PerformanceInfo performanceInfo = new PerformanceInfo(Integer.parseInt(strArr[5]), Long.parseLong(strArr[6]));
        performanceInfo.setEnterClassName(strArr[8]);
        performanceInfo.setEnterMessage(stringBuffer.toString().trim());
        performanceInfo.setExitClassName(strArr[8]);
        performanceInfo.setExitMessage(stringBuffer.toString().trim());
        performanceInfo.setSourceIP(strArr[0]);
        performanceInfo.setThreadName(strArr[4]);
        performanceInfo.setEnterTime(Long.parseLong(strArr[1]));
        performanceInfo.setExitTime(Long.parseLong(strArr[2]));
        performanceViewer.addRecord(performanceInfo);
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    @Override // org.apache.log4j.Appender
    public void close() {
    }
}
