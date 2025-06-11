package org.apache.log4j;
/* loaded from: input.jar:org/apache/log4j/Level.class */
public class Level extends Priority {
    public static final Level OFF = new Level(Priority.OFF_INT, "OFF", 0);
    public static final Level FATAL = new Level(50000, "FATAL", 0);
    public static final Level ERROR = new Level(40000, "ERROR", 3);
    public static final Level WARN = new Level(30000, "WARN", 4);
    public static final Level INFO = new Level(20000, "INFO", 6);
    public static final Level DEBUG = new Level(10000, "DEBUG", 7);
    public static final Level ALL = new Level(Priority.ALL_INT, "ALL", 7);

    /* JADX INFO: Access modifiers changed from: protected */
    public Level(int i, String str, int i2) {
        super(i, str, i2);
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level) {
        switch (i) {
            case Priority.ALL_INT /* -2147483648 */:
                return ALL;
            case 10000:
                return DEBUG;
            case 20000:
                return INFO;
            case 30000:
                return WARN;
            case 40000:
                return ERROR;
            case 50000:
                return FATAL;
            case Priority.OFF_INT /* 2147483647 */:
                return OFF;
            default:
                return level;
        }
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        String upperCase = str.toUpperCase();
        return upperCase.equals("ALL") ? ALL : upperCase.equals("DEBUG") ? DEBUG : upperCase.equals("INFO") ? INFO : upperCase.equals("WARN") ? WARN : upperCase.equals("ERROR") ? ERROR : upperCase.equals("FATAL") ? FATAL : upperCase.equals("OFF") ? OFF : level;
    }
}
