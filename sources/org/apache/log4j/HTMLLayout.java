package org.apache.log4j;

import java.util.Date;
import org.apache.log4j.helpers.C0063g;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/HTMLLayout.class */
public class HTMLLayout extends Layout {

    /* renamed from: a */
    private static String f101a = "<br>&nbsp;&nbsp;&nbsp;&nbsp;";
    public static final String LOCATION_INFO_OPTION = "LocationInfo";
    public static final String TITLE_OPTION = "Title";
    protected final int BUF_SIZE = 256;
    protected final int MAX_CAPACITY = 1024;

    /* renamed from: b */
    private StringBuffer f102b = new StringBuffer(256);

    /* renamed from: c */
    private boolean f103c = false;

    /* renamed from: d */
    private String f104d = "Log4J Log Messages";

    public void setLocationInfo(boolean z) {
        this.f103c = z;
    }

    public boolean getLocationInfo() {
        return this.f103c;
    }

    public void setTitle(String str) {
        this.f104d = str;
    }

    public String getTitle() {
        return this.f104d;
    }

    @Override // org.apache.log4j.Layout
    public String getContentType() {
        return "text/html";
    }

    @Override // org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        if (this.f102b.capacity() > 1024) {
            this.f102b = new StringBuffer(256);
        } else {
            this.f102b.setLength(0);
        }
        this.f102b.append(new StringBuffer().append(Layout.LINE_SEP).append("<tr>").append(Layout.LINE_SEP).toString());
        this.f102b.append("<td>");
        this.f102b.append(loggingEvent.timeStamp - LoggingEvent.m9h());
        this.f102b.append(new StringBuffer().append("</td>").append(Layout.LINE_SEP).toString());
        this.f102b.append(new StringBuffer().append("<td title=\"").append(loggingEvent.m8i()).append(" thread\">").toString());
        this.f102b.append(C0063g.m73a(loggingEvent.m8i()));
        this.f102b.append(new StringBuffer().append("</td>").append(Layout.LINE_SEP).toString());
        this.f102b.append("<td title=\"Level\">");
        if (loggingEvent.m16b().equals(Level.DEBUG)) {
            this.f102b.append("<font color=\"#339933\">");
            this.f102b.append(loggingEvent.m16b());
            this.f102b.append("</font>");
        } else if (loggingEvent.m16b().isGreaterOrEqual(Level.WARN)) {
            this.f102b.append("<font color=\"#993300\"><strong>");
            this.f102b.append(loggingEvent.m16b());
            this.f102b.append("</strong></font>");
        } else {
            this.f102b.append(loggingEvent.m16b());
        }
        this.f102b.append(new StringBuffer().append("</td>").append(Layout.LINE_SEP).toString());
        this.f102b.append(new StringBuffer().append("<td title=\"").append(loggingEvent.m14c()).append(" category\">").toString());
        this.f102b.append(C0063g.m73a(loggingEvent.m14c()));
        this.f102b.append(new StringBuffer().append("</td>").append(Layout.LINE_SEP).toString());
        if (this.f103c) {
            LocationInfo m18a = loggingEvent.m18a();
            this.f102b.append("<td>");
            this.f102b.append(C0063g.m73a(m18a.m21b()));
            this.f102b.append(':');
            this.f102b.append(m18a.m20c());
            this.f102b.append(new StringBuffer().append("</td>").append(Layout.LINE_SEP).toString());
        }
        this.f102b.append("<td title=\"Message\">");
        this.f102b.append(C0063g.m73a(loggingEvent.m10g()));
        this.f102b.append(new StringBuffer().append("</td>").append(Layout.LINE_SEP).toString());
        this.f102b.append(new StringBuffer().append("</tr>").append(Layout.LINE_SEP).toString());
        if (loggingEvent.m12e() != null) {
            this.f102b.append("<tr><td bgcolor=\"#EEEEEE\" style=\"font-size : xx-small;\" colspan=\"6\" title=\"Nested Diagnostic Context\">");
            this.f102b.append(new StringBuffer().append("NDC: ").append(C0063g.m73a(loggingEvent.m12e())).toString());
            this.f102b.append(new StringBuffer().append("</td></tr>").append(Layout.LINE_SEP).toString());
        }
        String[] m7j = loggingEvent.m7j();
        if (m7j != null) {
            this.f102b.append("<tr><td bgcolor=\"#993300\" style=\"color:White; font-size : xx-small;\" colspan=\"6\">");
            m137a(m7j, this.f102b);
            this.f102b.append(new StringBuffer().append("</td></tr>").append(Layout.LINE_SEP).toString());
        }
        return this.f102b.toString();
    }

    /* renamed from: a */
    private static void m137a(String[] strArr, StringBuffer stringBuffer) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return;
        }
        stringBuffer.append(C0063g.m73a(strArr[0]));
        stringBuffer.append(Layout.LINE_SEP);
        for (int i = 1; i < length; i++) {
            stringBuffer.append(f101a);
            stringBuffer.append(C0063g.m73a(strArr[i]));
            stringBuffer.append(Layout.LINE_SEP);
        }
    }

    @Override // org.apache.log4j.Layout
    public String getHeader() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<html>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<head>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<title>").append(this.f104d).append("</title>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<style type=\"text/css\">").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<!--").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("body, table {font-family: arial,sans-serif; font-size: x-small;}").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("th {background: #336699; color: #FFFFFF; text-align: left;}").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("-->").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("</style>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("</head>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<hr size=\"1\" noshade>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("Log session start time ").append(new Date()).append("<br>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<br>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\">").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<tr>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<th>Time</th>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<th>Thread</th>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<th>Level</th>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<th>Category</th>").append(Layout.LINE_SEP).toString());
        if (this.f103c) {
            stringBuffer.append(new StringBuffer().append("<th>File:Line</th>").append(Layout.LINE_SEP).toString());
        }
        stringBuffer.append(new StringBuffer().append("<th>Message</th>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("</tr>").append(Layout.LINE_SEP).toString());
        return stringBuffer.toString();
    }

    @Override // org.apache.log4j.Layout
    public String getFooter() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("</table>").append(Layout.LINE_SEP).toString());
        stringBuffer.append(new StringBuffer().append("<br>").append(Layout.LINE_SEP).toString());
        stringBuffer.append("</body></html>");
        return stringBuffer.toString();
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return false;
    }
}
