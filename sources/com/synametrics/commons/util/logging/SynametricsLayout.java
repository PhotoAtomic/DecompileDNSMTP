package com.synametrics.commons.util.logging;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:com/synametrics/commons/util/logging/SynametricsLayout.class */
public class SynametricsLayout extends PatternLayout {
    public SynametricsLayout(String str) {
        super(str);
    }

    public SynametricsLayout() {
    }

    @Override // org.apache.log4j.PatternLayout, org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        String format = super.format(loggingEvent);
        if (getConversionPattern().indexOf("$L") > 0) {
            int i = -1;
            Throwable th = new Throwable();
            th.fillInStackTrace();
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                } else if (stackTrace[length].getClassName().equals("com.synametrics.commons.util.logging.LoggingFW")) {
                    i = length;
                    break;
                } else {
                    length--;
                }
            }
            if (i > 0) {
                StringBuffer stringBuffer = new StringBuffer(100);
                stringBuffer.append(stackTrace[i + 1].getMethodName()).append("(Line: ");
                stringBuffer.append(stackTrace[i + 1].getLineNumber()).append(")");
                if (stringBuffer.toString().indexOf("$") == -1) {
                    format = format.replaceFirst("\\$L", stringBuffer.toString());
                }
            }
        }
        return format;
    }
}
