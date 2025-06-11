package org.apache.log4j.helpers;

import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: input.jar:org/apache/log4j/helpers/DateTimeDateFormat.class */
public class DateTimeDateFormat extends AbsoluteTimeDateFormat {
    String[] shortMonths;

    public DateTimeDateFormat() {
        this.shortMonths = new DateFormatSymbols().getShortMonths();
    }

    public DateTimeDateFormat(TimeZone timeZone) {
        this();
        setCalendar(Calendar.getInstance(timeZone));
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.calendar.setTime(date);
        int i = this.calendar.get(5);
        if (i < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i);
        stringBuffer.append(' ');
        stringBuffer.append(this.shortMonths[this.calendar.get(2)]);
        stringBuffer.append(' ');
        stringBuffer.append(this.calendar.get(1));
        stringBuffer.append(' ');
        return super.format(date, stringBuffer, fieldPosition);
    }

    @Override // org.apache.log4j.helpers.AbsoluteTimeDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }
}
