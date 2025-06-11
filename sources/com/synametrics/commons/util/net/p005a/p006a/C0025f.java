package com.synametrics.commons.util.net.p005a.p006a;

import com.synametrics.commons.util.C0014c;
import com.synametrics.commons.util.C0015d;
import com.synametrics.commons.util.C0017f;
import com.synametrics.commons.util.logging.LoggingFW;
import com.synametrics.commons.util.p003a.C0007a;
import com.synametrics.commons.util.p003a.C0010d;
import com.synametrics.commons.util.p003a.InterfaceC0008b;
import com.synametrics.commons.util.p004b.C0013a;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
/* renamed from: com.synametrics.commons.util.net.a.a.f */
/* loaded from: input.jar:com/synametrics/commons/util/net/a/a/f.class */
public final class C0025f {

    /* renamed from: d */
    private Socket f53d;

    /* renamed from: f */
    private InterfaceC0023d f55f;

    /* renamed from: g */
    private static int f56g = 0;

    /* renamed from: h */
    private int f57h;

    /* renamed from: a */
    private String f50a = null;

    /* renamed from: b */
    private String f51b = null;

    /* renamed from: i */
    private String f58i = null;

    /* renamed from: c */
    private ArrayList f52c = new ArrayList(10);

    /* renamed from: e */
    private int f54e = -1;

    public C0025f(Socket socket, InterfaceC0023d interfaceC0023d) {
        this.f53d = socket;
        this.f55f = interfaceC0023d;
        f56g++;
        this.f57h = f56g;
    }

    /* renamed from: b */
    private void m172b() {
        try {
            this.f53d.close();
        } catch (IOException unused) {
        } finally {
            this.f53d = null;
        }
    }

    /* renamed from: a */
    private boolean m178a(int i, OutputStream outputStream) {
        if (this.f54e >= i) {
            return true;
        }
        switch (i) {
            case LoggingFW.EXIT /* 0 */:
                m173a("503 5.5.2 Send HELO first ", outputStream);
                return false;
            case 10:
                m173a("503 5.5.2 Need MAIL FROM first ", outputStream);
                return false;
            case 20:
                m173a("503 5.5.2 Need RCPT TO first ", outputStream);
                return false;
            default:
                return true;
        }
    }

    /* renamed from: a */
    private static String m174a(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf < 0) {
            return "";
        }
        String trim = str.substring(indexOf + 1).trim();
        String m189a = C0017f.m191a().m189a("Regex Extract - [^<][^>]*", false);
        String m204a = C0013a.m204a(trim, "[^<][^>]*", 1);
        C0017f.m191a().m190a(m189a);
        return m204a;
    }

    /* renamed from: c */
    private String m171c() {
        return "[" + C0015d.m194b(new StringBuilder().append(this.f57h).toString(), 8, ' ') + "]";
    }

    /* renamed from: a */
    private void m176a(BufferedReader bufferedReader, OutputStream outputStream) {
        long currentTimeMillis = System.currentTimeMillis();
        C0026g.m170a().m168a(String.valueOf(m171c()) + " ************** New Connection from: " + this.f58i + " ************** ");
        try {
            m173a("220 SMTP server ready " + C0015d.m201a(System.currentTimeMillis()), outputStream);
        } catch (IOException e) {
            LoggingFW.log(40000, this, e.getMessage());
        }
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                LoggingFW.log(10000, this, "CLIENT -->: " + readLine);
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    String upperCase = stringTokenizer.nextToken().toUpperCase();
                    C0026g.m170a().m168a(String.valueOf(m171c()) + " C --> " + readLine);
                    if (upperCase.equals("HELO")) {
                        m173a("250 " + this.f53d.getInetAddress().getHostName() + ". Please to meet you", outputStream);
                        this.f54e = 0;
                    } else if (upperCase.equals("EHLO")) {
                        m173a("250-" + this.f53d.getInetAddress().getHostName() + ". Please to meet you", outputStream);
                        m173a("250-AUTH LOGIN", outputStream);
                        m173a("250-AUTH=LOGIN", outputStream);
                        m173a("250 OK", outputStream);
                        this.f54e = 0;
                    } else if (upperCase.equals("AUTH")) {
                        this.f50a = null;
                        m173a("334 VXNlcm5hbWU6", outputStream);
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null) {
                            throw new IOException("User ID expected");
                        }
                        m173a("334 UGFzc3dvcmQ6", outputStream);
                        String readLine3 = bufferedReader.readLine();
                        if (readLine3 == null) {
                            throw new IOException("User password expected");
                        }
                        this.f50a = new String(C0014c.m203a(readLine2.toCharArray()));
                        new String(C0014c.m203a(readLine3.toCharArray()));
                        boolean z = true;
                        if (this.f55f != null) {
                            z = false;
                        }
                        if (z) {
                            m173a("235 2.7.0 Authentication successful.", outputStream);
                        } else {
                            this.f50a = null;
                            m173a("535 5.7.3 Authentication unsuccessful.", outputStream);
                        }
                    } else if (upperCase.equals("MAIL")) {
                        if (this.f51b != null && this.f51b.length() > 0) {
                            m173a("503 Sender already specified", outputStream);
                        } else if (m178a(0, outputStream)) {
                            this.f51b = m174a(readLine);
                            this.f54e = 10;
                            m173a("250 OK", outputStream);
                        }
                    } else if (upperCase.equals("RCPT")) {
                        if (m178a(10, outputStream)) {
                            String m174a = m174a(readLine);
                            if (this.f55f != null) {
                                String str = null;
                                try {
                                    InterfaceC0023d interfaceC0023d = this.f55f;
                                    this.f53d.getInetAddress().getHostAddress();
                                    str = interfaceC0023d.mo148d(m174a);
                                } catch (Exception e2) {
                                    LoggingFW.log(40000, this, e2.getMessage(), e2);
                                }
                                if (str != null) {
                                    m173a("550 5.7.1 " + str, outputStream);
                                }
                            }
                            this.f52c.add(m174a);
                            m173a("250 OK", outputStream);
                        }
                    } else if (upperCase.equals("DATA")) {
                        m173a("354 Start mail input; end with <CRLF>.<CRLF>", outputStream);
                        StringBuffer stringBuffer = new StringBuffer(512);
                        m175a(bufferedReader, stringBuffer);
                        if (stringBuffer.length() == 0) {
                            m173a("250 Message queued for delivery.", outputStream);
                        } else {
                            m173a("554 Transaction failed. " + stringBuffer.toString(), outputStream);
                        }
                        this.f54e = 0;
                        this.f51b = null;
                        this.f52c.clear();
                    } else if (upperCase.equals("QUIT")) {
                        m173a("221 Good bye. Hope to see you again", outputStream);
                        break;
                    } else if (upperCase.equals("NOOP")) {
                        m173a("250 Ok", outputStream);
                    } else if (upperCase.equals("RSET")) {
                        this.f51b = null;
                        this.f52c.clear();
                        this.f54e = 0;
                        m173a("250 reset state.", outputStream);
                    } else if (upperCase.equals("TERMINATESERVER")) {
                        System.exit(0);
                    } else {
                        m173a("500 Syntax error, command unrecognized", outputStream);
                    }
                } else {
                    m173a("500 Syntax error - No command entered.", outputStream);
                }
            } catch (IOException e3) {
                try {
                    outputStream.close();
                    bufferedReader.close();
                } catch (IOException e4) {
                }
                m172b();
                C0026g.m170a().m168a(String.valueOf(m171c()) + " ~~~~~~~~~~~~~~ Connection closed: " + this.f58i + " (" + (System.currentTimeMillis() - currentTimeMillis) + " ms)~~~~~~~~~~~~~~ ");
                return;
            }
        }
    }

    /* renamed from: a */
    private byte[] m175a(BufferedReader bufferedReader, StringBuffer stringBuffer) {
        boolean z = false;
        String str = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(32768);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                throw new EOFException();
            }
            if (!z && readLine.toLowerCase().startsWith("subject:")) {
                str = readLine.substring(8);
                z = true;
            }
            if (readLine.equals(".")) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (this.f55f != null) {
                    try {
                        this.f55f.mo155a(this.f58i, str, byteArray);
                    } catch (Exception e) {
                        LoggingFW.log(40000, this, e.getMessage(), e);
                    }
                }
                return byteArray;
            }
            LoggingFW.log(10000, this, "CLIENT DATA -->: " + readLine);
            byteArrayOutputStream.write(readLine.getBytes());
            byteArrayOutputStream.write("\r\n".getBytes());
        }
    }

    /* renamed from: a */
    private void m173a(String str, OutputStream outputStream) {
        C0026g.m170a().m167b(String.valueOf(m171c()) + " S <-- " + str);
        outputStream.write((String.valueOf(str) + "\r\n").getBytes());
        outputStream.flush();
    }

    /* renamed from: a */
    public final void m179a() {
        C0020a c0020a = new C0020a(this);
        C0010d m205c = C0010d.m205c();
        if (m205c == null) {
            LoggingFW.log(40000, this, "No more threads available in the Thread Pool");
            return;
        }
        C0007a c0007a = (C0007a) m205c.m207b();
        if (c0007a == null) {
            LoggingFW.log(40000, this, "No more threads available in the Thread Pool");
        }
        c0007a.m210a((InterfaceC0008b) c0020a);
        c0007a.m209a((Object) null);
        c0007a.interrupt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m177a(C0025f c0025f) {
        c0025f.f58i = c0025f.f53d.getInetAddress().getHostAddress();
        try {
            c0025f.m176a(new BufferedReader(new InputStreamReader(c0025f.f53d.getInputStream())), new BufferedOutputStream(c0025f.f53d.getOutputStream(), 255));
        } catch (IOException e) {
            LoggingFW.log(40000, c0025f, "Unable to create reader/writer for incoming email. " + e.getMessage());
            c0025f.m172b();
        }
    }
}
