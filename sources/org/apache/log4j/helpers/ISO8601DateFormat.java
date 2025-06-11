package org.apache.log4j.helpers;

import com.synametrics.commons.util.logging.LoggingFW;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: input.jar:org/apache/log4j/helpers/ISO8601DateFormat.class */
public class ISO8601DateFormat extends AbsoluteTimeDateFormat {

    /* renamed from: a */
    private static long f199a;

    /* renamed from: b */
    private static char[] f200b = new char[20];

    public ISO8601DateFormat() {
    }

    public ISO8601DateFormat(TimeZone timeZone) {
        super(timeZone);
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String str;
        long time = date.getTime();
        int i = (int) (time % 1000);
        if (time - i != f199a) {
            this.calendar.setTime(date);
            int length = stringBuffer.length();
            stringBuffer.append(this.calendar.get(1));
            switch (this.calendar.get(2)) {
                case LoggingFW.EXIT /* 0 */:
                    str = "-01-";
                    break;
                case LoggingFW.ENTER /* 1 */:
                    str = "-02-";
                    break;
                case 2:
                    str = "-03-";
                    break;
                case 3:
                    str = "-04-";
                    break;
                case 4:
                    str = "-05-";
                    break;
                case 5:
                    str = "-06-";
                    break;
                case 6:
                    str = "-07-";
                    break;
                case 7:
                    str = "-08-";
                    break;
                case 8:
                    str = "-09-";
                    break;
                case 9:
                    str = "-10-";
                    break;
                case 10:
                    str = "-11-";
                    break;
                case 11:
                    str = "-12-";
                    break;
                default:
                    str = "-NA-";
                    break;
            }
            stringBuffer.append(str);
            int i2 = this.calendar.get(5);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(' ');
            int i3 = this.calendar.get(11);
            if (i3 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i3);
            stringBuffer.append(':');
            int i4 = this.calendar.get(12);
            if (i4 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i4);
            stringBuffer.append(':');
            int i5 = this.calendar.get(13);
            if (i5 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i5);
            stringBuffer.append(',');
            stringBuffer.getChars(length, stringBuffer.length(), f200b, 0);
            f199a = time - i;
        } else {
            stringBuffer.append(f200b);
        }
        if (i < 100) {
            stringBuffer.append('0');
        }
        if (i < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i);
        return stringBuffer;
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }
}
