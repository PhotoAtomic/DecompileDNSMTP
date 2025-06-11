package org.apache.log4j;

import com.synametrics.commons.util.logging.LoggingFW;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/DailyRollingFileAppender.class */
public class DailyRollingFileAppender extends FileAppender {

    /* renamed from: a */
    private String f94a;

    /* renamed from: b */
    private String f95b;

    /* renamed from: c */
    private long f96c;

    /* renamed from: d */
    private Date f97d;

    /* renamed from: e */
    private SimpleDateFormat f98e;

    /* renamed from: f */
    private RollingCalendar f99f;

    /* renamed from: g */
    private static TimeZone f100g = TimeZone.getTimeZone("GMT");

    public DailyRollingFileAppender() {
        this.f94a = "'.'yyyy-MM-dd";
        this.f96c = System.currentTimeMillis() - 1;
        this.f97d = new Date();
        this.f99f = new RollingCalendar();
    }

    public DailyRollingFileAppender(Layout layout, String str, String str2) {
        super(layout, str, true);
        this.f94a = "'.'yyyy-MM-dd";
        this.f96c = System.currentTimeMillis() - 1;
        this.f97d = new Date();
        this.f99f = new RollingCalendar();
        this.f94a = str2;
        activateOptions();
    }

    public void setDatePattern(String str) {
        this.f94a = str;
    }

    public String getDatePattern() {
        return this.f94a;
    }

    @Override // org.apache.log4j.FileAppender, org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
        super.activateOptions();
        if (this.f94a == null || this.fileName == null) {
            C0059c.m80b(new StringBuffer().append("Either File or DatePattern options are not set for appender [").append(this.name).append("].").toString());
            return;
        }
        this.f97d.setTime(System.currentTimeMillis());
        this.f98e = new SimpleDateFormat(this.f94a);
        int m138a = m138a();
        switch (m138a) {
            case LoggingFW.EXIT /* 0 */:
                C0059c.m83a(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled every minute.").toString());
                break;
            case LoggingFW.ENTER /* 1 */:
                C0059c.m83a(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled on top of every hour.").toString());
                break;
            case 2:
                C0059c.m83a(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at midday and midnight.").toString());
                break;
            case 3:
                C0059c.m83a(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at midnight.").toString());
                break;
            case 4:
                C0059c.m83a(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at start of week.").toString());
                break;
            case 5:
                C0059c.m83a(new StringBuffer().append("Appender [").append(this.name).append("] to be rolled at start of every month.").toString());
                break;
            default:
                C0059c.m78c(new StringBuffer().append("Unknown periodicity for appender [").append(this.name).append("].").toString());
                break;
        }
        this.f99f.type = m138a;
        this.f95b = new StringBuffer().append(this.fileName).append(this.f98e.format(new Date(new File(this.fileName).lastModified()))).toString();
    }

    /* renamed from: a */
    private int m138a() {
        RollingCalendar rollingCalendar = new RollingCalendar(f100g, Locale.ENGLISH);
        Date date = new Date(0L);
        if (this.f94a != null) {
            for (int i = 0; i <= 5; i++) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f94a);
                simpleDateFormat.setTimeZone(f100g);
                String format = simpleDateFormat.format(date);
                rollingCalendar.type = i;
                String format2 = simpleDateFormat.format(new Date(rollingCalendar.m132a(date)));
                if (format != null && format2 != null && !format.equals(format2)) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.log4j.WriterAppender
    public void subAppend(LoggingEvent loggingEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.f96c) {
            this.f97d.setTime(currentTimeMillis);
            this.f96c = this.f99f.m132a(this.f97d);
            try {
                if (this.f94a == null) {
                    this.errorHandler.mo5a("Missing DatePattern option in rollOver().");
                } else {
                    String stringBuffer = new StringBuffer().append(this.fileName).append(this.f98e.format(this.f97d)).toString();
                    if (!this.f95b.equals(stringBuffer)) {
                        closeFile();
                        File file = new File(this.f95b);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (new File(this.fileName).renameTo(file)) {
                            C0059c.m83a(new StringBuffer().append(this.fileName).append(" -> ").append(this.f95b).toString());
                        } else {
                            C0059c.m80b(new StringBuffer().append("Failed to rename [").append(this.fileName).append("] to [").append(this.f95b).append("].").toString());
                        }
                        try {
                            setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
                        } catch (IOException unused) {
                            this.errorHandler.mo5a(new StringBuffer().append("setFile(").append(this.fileName).append(", false) call failed.").toString());
                        }
                        this.f95b = stringBuffer;
                    }
                }
            } catch (IOException e) {
                C0059c.m79b("rollOver() failed.", e);
            }
        }
        super.subAppend(loggingEvent);
    }
}
