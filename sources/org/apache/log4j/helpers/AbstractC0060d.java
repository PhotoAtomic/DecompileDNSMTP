package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
/* renamed from: org.apache.log4j.helpers.d */
/* loaded from: input.jar:org/apache/log4j/helpers/d.class */
public abstract class AbstractC0060d extends Layout {
    public static final String NULL_DATE_FORMAT = "NULL";
    public static final String RELATIVE_TIME_DATE_FORMAT = "RELATIVE";
    public static final String DATE_FORMAT_OPTION = "DateFormat";
    public static final String TIMEZONE_OPTION = "TimeZone";

    /* renamed from: a */
    private String f205a;

    /* renamed from: b */
    private String f206b;
    protected DateFormat dateFormat;
    protected FieldPosition pos = new FieldPosition(0);
    protected Date date = new Date();

    public String[] getOptionStrings() {
        return new String[]{DATE_FORMAT_OPTION, TIMEZONE_OPTION};
    }

    public void setOption(String str, String str2) {
        if (str.equalsIgnoreCase(DATE_FORMAT_OPTION)) {
            this.f206b = str2.toUpperCase();
        } else if (str.equalsIgnoreCase(TIMEZONE_OPTION)) {
            this.f205a = str2;
        }
    }

    public void setDateFormat(String str) {
        if (str != null) {
            this.f206b = str;
        }
        setDateFormat(this.f206b, TimeZone.getDefault());
    }

    public String getDateFormat() {
        return this.f206b;
    }

    public void setTimeZone(String str) {
        this.f205a = str;
    }

    public String getTimeZone() {
        return this.f205a;
    }

    @Override // org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
        setDateFormat(this.f206b);
        if (this.f205a == null || this.dateFormat == null) {
            return;
        }
        this.dateFormat.setTimeZone(TimeZone.getTimeZone(this.f205a));
    }

    public void dateFormat(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        if (this.dateFormat != null) {
            this.date.setTime(loggingEvent.timeStamp);
            this.dateFormat.format(this.date, stringBuffer, this.pos);
            stringBuffer.append(' ');
        }
    }

    public void setDateFormat(DateFormat dateFormat, TimeZone timeZone) {
        this.dateFormat = dateFormat;
        this.dateFormat.setTimeZone(timeZone);
    }

    public void setDateFormat(String str, TimeZone timeZone) {
        if (str == null) {
            this.dateFormat = null;
        } else if (str.equalsIgnoreCase(NULL_DATE_FORMAT)) {
            this.dateFormat = null;
        } else if (str.equalsIgnoreCase(RELATIVE_TIME_DATE_FORMAT)) {
            this.dateFormat = new RelativeTimeDateFormat();
        } else if (str.equalsIgnoreCase("ABSOLUTE")) {
            this.dateFormat = new AbsoluteTimeDateFormat(timeZone);
        } else if (str.equalsIgnoreCase("DATE")) {
            this.dateFormat = new DateTimeDateFormat(timeZone);
        } else if (str.equalsIgnoreCase("ISO8601")) {
            this.dateFormat = new ISO8601DateFormat(timeZone);
        } else {
            this.dateFormat = new SimpleDateFormat(str);
            this.dateFormat.setTimeZone(timeZone);
        }
    }
}
