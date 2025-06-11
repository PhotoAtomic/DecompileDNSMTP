package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: input.jar:org/apache/log4j/helpers/AbsoluteTimeDateFormat.class */
public class AbsoluteTimeDateFormat extends DateFormat {

    /* renamed from: a */
    private static long f197a;

    /* renamed from: b */
    private static char[] f198b = new char[9];

    public AbsoluteTimeDateFormat() {
        setCalendar(Calendar.getInstance());
    }

    public AbsoluteTimeDateFormat(TimeZone timeZone) {
        setCalendar(Calendar.getInstance(timeZone));
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        long time = date.getTime();
        int i = (int) (time % 1000);
        if (time - i != f197a) {
            this.calendar.setTime(date);
            int length = stringBuffer.length();
            int i2 = this.calendar.get(11);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(':');
            int i3 = this.calendar.get(12);
            if (i3 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i3);
            stringBuffer.append(':');
            int i4 = this.calendar.get(13);
            if (i4 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i4);
            stringBuffer.append(',');
            stringBuffer.getChars(length, stringBuffer.length(), f198b, 0);
            f197a = time - i;
        } else {
            stringBuffer.append(f198b);
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

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }
}
