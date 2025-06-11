package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
/* loaded from: input.jar:org/apache/log4j/helpers/RelativeTimeDateFormat.class */
public class RelativeTimeDateFormat extends DateFormat {
    protected final long startTime = System.currentTimeMillis();

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return stringBuffer.append(date.getTime() - this.startTime);
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }
}
