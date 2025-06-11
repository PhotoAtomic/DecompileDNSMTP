package org.apache.log4j;
/* loaded from: input.jar:org/apache/log4j/Priority.class */
public class Priority {

    /* renamed from: a */
    int f124a;

    /* renamed from: b */
    private String f125b;

    /* renamed from: c */
    private int f126c;
    public static final int OFF_INT = Integer.MAX_VALUE;
    public static final int FATAL_INT = 50000;
    public static final int ERROR_INT = 40000;
    public static final int WARN_INT = 30000;
    public static final int INFO_INT = 20000;
    public static final int DEBUG_INT = 10000;
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final Priority FATAL = new Level(50000, "FATAL", 0);
    public static final Priority ERROR = new Level(40000, "ERROR", 3);
    public static final Priority WARN = new Level(30000, "WARN", 4);
    public static final Priority INFO = new Level(20000, "INFO", 6);
    public static final Priority DEBUG = new Level(10000, "DEBUG", 7);

    /* JADX INFO: Access modifiers changed from: protected */
    public Priority(int i, String str, int i2) {
        this.f124a = i;
        this.f125b = str;
        this.f126c = i2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Priority) && this.f124a == ((Priority) obj).f124a;
    }

    public final int getSyslogEquivalent() {
        return this.f126c;
    }

    public boolean isGreaterOrEqual(Priority priority) {
        return this.f124a >= priority.f124a;
    }

    public static Priority[] getAllPossiblePriorities() {
        return new Priority[]{FATAL, ERROR, Level.WARN, INFO, DEBUG};
    }

    public final String toString() {
        return this.f125b;
    }

    public final int toInt() {
        return this.f124a;
    }

    public static Priority toPriority(String str) {
        return Level.toLevel(str);
    }

    public static Priority toPriority(int i) {
        return toPriority(i, DEBUG);
    }

    public static Priority toPriority(int i, Priority priority) {
        return Level.toLevel(i, (Level) priority);
    }

    public static Priority toPriority(String str, Priority priority) {
        return Level.toLevel(str, (Level) priority);
    }
}
