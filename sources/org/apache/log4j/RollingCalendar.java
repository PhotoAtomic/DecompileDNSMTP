package org.apache.log4j;

import com.synametrics.commons.util.logging.LoggingFW;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: input.jar:org/apache/log4j/RollingCalendar.class */
class RollingCalendar extends GregorianCalendar {
    int type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RollingCalendar() {
        this.type = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RollingCalendar(TimeZone timeZone, Locale locale) {
        super(timeZone, locale);
        this.type = -1;
    }

    /* renamed from: a */
    public final long m132a(Date date) {
        setTime(date);
        switch (this.type) {
            case LoggingFW.EXIT /* 0 */:
                set(13, 0);
                set(14, 0);
                add(12, 1);
                break;
            case LoggingFW.ENTER /* 1 */:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(11, 1);
                break;
            case 2:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                if (get(11) >= 12) {
                    set(11, 0);
                    add(5, 1);
                    break;
                } else {
                    set(11, 12);
                    break;
                }
            case 3:
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(5, 1);
                break;
            case 4:
                set(7, getFirstDayOfWeek());
                set(11, 0);
                set(13, 0);
                set(14, 0);
                add(3, 1);
                break;
            case 5:
                set(5, 1);
                set(11, 0);
                set(13, 0);
                set(14, 0);
                add(2, 1);
                break;
            default:
                throw new IllegalStateException("Unknown periodicity type.");
        }
        return getTime().getTime();
    }
}
