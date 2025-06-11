package org.apache.log4j.helpers;

import com.synametrics.commons.util.logging.LoggingFW;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.log4j.Layout;
/* renamed from: org.apache.log4j.helpers.q */
/* loaded from: input.jar:org/apache/log4j/helpers/q.class */
public final class C0073q {

    /* renamed from: c */
    private int f238c;

    /* renamed from: d */
    private int f239d;

    /* renamed from: e */
    private AbstractC0072p f240e;

    /* renamed from: f */
    private AbstractC0072p f241f;

    /* renamed from: h */
    private String f243h;

    /* renamed from: i */
    private static Class f244i;

    /* renamed from: b */
    private StringBuffer f237b = new StringBuffer(32);

    /* renamed from: g */
    private C0080x f242g = new C0080x();

    /* renamed from: a */
    private int f236a = 0;

    public C0073q(String str) {
        this.f243h = str;
        this.f238c = str.length();
    }

    /* renamed from: a */
    private void m48a(AbstractC0072p abstractC0072p) {
        if (this.f240e == null) {
            this.f241f = abstractC0072p;
            this.f240e = abstractC0072p;
            return;
        }
        this.f241f.f231a = abstractC0072p;
        this.f241f = abstractC0072p;
    }

    /* renamed from: b */
    private String m47b() {
        int indexOf;
        if (this.f239d >= this.f238c || this.f243h.charAt(this.f239d) != '{' || (indexOf = this.f243h.indexOf(125, this.f239d)) <= this.f239d) {
            return null;
        }
        String substring = this.f243h.substring(this.f239d + 1, indexOf);
        this.f239d = indexOf + 1;
        return substring;
    }

    /* renamed from: c */
    private int m46c() {
        String m47b = m47b();
        int i = 0;
        if (m47b != null) {
            try {
                int parseInt = Integer.parseInt(m47b);
                i = parseInt;
                if (parseInt <= 0) {
                    C0059c.m80b(new StringBuffer().append("Precision option (").append(m47b).append(") isn't a positive integer.").toString());
                    i = 0;
                }
            } catch (NumberFormatException e) {
                C0059c.m79b(new StringBuffer().append("Category option \"").append(m47b).append("\" not a decimal integer.").toString(), e);
            }
        }
        return i;
    }

    /* renamed from: a */
    public final AbstractC0072p m51a() {
        this.f239d = 0;
        while (this.f239d < this.f238c) {
            String str = this.f243h;
            int i = this.f239d;
            this.f239d = i + 1;
            char charAt = str.charAt(i);
            switch (this.f236a) {
                case LoggingFW.EXIT /* 0 */:
                    if (this.f239d != this.f238c) {
                        if (charAt != '%') {
                            this.f237b.append(charAt);
                            break;
                        } else {
                            switch (this.f243h.charAt(this.f239d)) {
                                case '%':
                                    this.f237b.append(charAt);
                                    this.f239d++;
                                    continue;
                                case 'n':
                                    this.f237b.append(Layout.LINE_SEP);
                                    this.f239d++;
                                    continue;
                                default:
                                    if (this.f237b.length() != 0) {
                                        m48a(new C0057a(this.f237b.toString()));
                                    }
                                    this.f237b.setLength(0);
                                    this.f237b.append(charAt);
                                    this.f236a = 1;
                                    this.f242g.m26a();
                                    continue;
                            }
                        }
                    } else {
                        this.f237b.append(charAt);
                        break;
                    }
                case LoggingFW.ENTER /* 1 */:
                    this.f237b.append(charAt);
                    switch (charAt) {
                        case '-':
                            this.f242g.f255c = true;
                            continue;
                        case '.':
                            this.f236a = 3;
                            continue;
                        default:
                            if (charAt >= '0' && charAt <= '9') {
                                this.f242g.f253a = charAt - '0';
                                this.f236a = 4;
                                break;
                            } else {
                                m50a(charAt);
                                continue;
                            }
                    }
                case 3:
                    this.f237b.append(charAt);
                    if (charAt >= '0' && charAt <= '9') {
                        this.f242g.f254b = charAt - '0';
                        this.f236a = 5;
                        break;
                    } else {
                        C0059c.m80b(new StringBuffer().append("Error occured in position ").append(this.f239d).append(".\n Was expecting digit, instead got char \"").append(charAt).append("\".").toString());
                        this.f236a = 0;
                        break;
                    }
                case 4:
                    this.f237b.append(charAt);
                    if (charAt >= '0' && charAt <= '9') {
                        this.f242g.f253a = (this.f242g.f253a * 10) + (charAt - '0');
                        break;
                    } else if (charAt != '.') {
                        m50a(charAt);
                        break;
                    } else {
                        this.f236a = 3;
                        break;
                    }
                    break;
                case 5:
                    this.f237b.append(charAt);
                    if (charAt >= '0' && charAt <= '9') {
                        this.f242g.f254b = (this.f242g.f254b * 10) + (charAt - '0');
                        break;
                    } else {
                        m50a(charAt);
                        this.f236a = 0;
                        break;
                    }
            }
        }
        if (this.f237b.length() != 0) {
            m48a(new C0057a(this.f237b.toString()));
        }
        return this.f240e;
    }

    /* renamed from: a */
    private void m50a(char c) {
        C0071o c0057a;
        Class cls;
        ISO8601DateFormat iSO8601DateFormat;
        switch (c) {
            case 'C':
                c0057a = new C0079w(this, this.f242g, m46c());
                this.f237b.setLength(0);
                break;
            case 'D':
            case 'E':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'Y':
            case 'Z':
            case '[':
            case '\\':
            case ']':
            case '^':
            case '_':
            case '`':
            case 'a':
            case 'b':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'n':
            case 'o':
            case 'q':
            case 's':
            case 'u':
            case 'v':
            case 'w':
            default:
                C0059c.m80b(new StringBuffer().append("Unexpected char [").append(c).append("] at position ").append(this.f239d).append(" in conversion patterrn.").toString());
                c0057a = new C0057a(this.f237b.toString());
                this.f237b.setLength(0);
                break;
            case 'F':
                c0057a = new C0061e(this, this.f242g, 1004);
                this.f237b.setLength(0);
                break;
            case 'L':
                c0057a = new C0061e(this, this.f242g, 1003);
                this.f237b.setLength(0);
                break;
            case 'M':
                c0057a = new C0061e(this, this.f242g, 1001);
                this.f237b.setLength(0);
                break;
            case 'X':
                c0057a = new C0077u(this.f242g, m47b());
                this.f237b.setLength(0);
                break;
            case 'c':
                c0057a = new C0071o(this, this.f242g, m46c());
                this.f237b.setLength(0);
                break;
            case 'd':
                String m47b = m47b();
                String str = m47b != null ? m47b : "ISO8601";
                if (str.equalsIgnoreCase("ISO8601")) {
                    iSO8601DateFormat = new ISO8601DateFormat();
                } else if (str.equalsIgnoreCase("ABSOLUTE")) {
                    iSO8601DateFormat = new AbsoluteTimeDateFormat();
                } else if (str.equalsIgnoreCase("DATE")) {
                    iSO8601DateFormat = new DateTimeDateFormat();
                } else {
                    try {
                        iSO8601DateFormat = new SimpleDateFormat(str);
                    } catch (IllegalArgumentException e) {
                        C0059c.m79b(new StringBuffer().append("Could not instantiate SimpleDateFormat with ").append(str).toString(), e);
                        if (f244i == null) {
                            cls = m49a("java.text.DateFormat");
                            f244i = cls;
                        } else {
                            cls = f244i;
                        }
                        iSO8601DateFormat = (DateFormat) C0069m.m62a("org.apache.log4j.helpers.ISO8601DateFormat", cls, (Object) null);
                    }
                }
                c0057a = new C0066j(this.f242g, iSO8601DateFormat);
                this.f237b.setLength(0);
                break;
            case 'l':
                c0057a = new C0061e(this, this.f242g, 1000);
                this.f237b.setLength(0);
                break;
            case 'm':
                c0057a = new C0070n(this.f242g, 2004);
                this.f237b.setLength(0);
                break;
            case 'p':
                c0057a = new C0070n(this.f242g, 2002);
                this.f237b.setLength(0);
                break;
            case 'r':
                c0057a = new C0070n(this.f242g, 2000);
                this.f237b.setLength(0);
                break;
            case 't':
                c0057a = new C0070n(this.f242g, 2001);
                this.f237b.setLength(0);
                break;
            case 'x':
                c0057a = new C0070n(this.f242g, 2003);
                this.f237b.setLength(0);
                break;
        }
        this.f237b.setLength(0);
        m48a(c0057a);
        this.f236a = 0;
        this.f242g.m26a();
    }

    /* renamed from: a */
    private static Class m49a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
