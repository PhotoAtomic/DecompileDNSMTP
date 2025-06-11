package com.synametrics.commons.util.logging;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:com/synametrics/commons/util/logging/PerformanceLayout.class */
public class PerformanceLayout extends PatternLayout {

    /* renamed from: a */
    private static final String f32a = System.getProperty("line.separator");

    public PerformanceLayout() {
        super("%d");
    }

    @Override // org.apache.log4j.PatternLayout, org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        String format = super.format(loggingEvent);
        if (loggingEvent.m13d() instanceof PerformanceInfo) {
            return String.valueOf(format) + " - [PERFORMANCE] " + ((PerformanceInfo) loggingEvent.m13d()).format() + f32a;
        }
        return String.valueOf(format) + loggingEvent.toString() + f32a;
    }
}
