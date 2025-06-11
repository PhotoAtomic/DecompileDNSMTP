package com.synametrics.devnull;

import com.synametrics.devnull.p007a.C0028a;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
/* loaded from: input.jar:com/synametrics/devnull/DevNullSmtp.class */
public class DevNullSmtp {

    /* renamed from: a */
    private boolean f61a = false;

    private DevNullSmtp(int i, String str, String str2, String str3) {
        MainFrame mainFrame = new MainFrame(i, str, str2, str3);
        mainFrame.validate();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = mainFrame.getSize();
        if (size.height > screenSize.height) {
            size.height = screenSize.height;
        }
        if (size.width > screenSize.width) {
            size.width = screenSize.width;
        }
        mainFrame.setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
        mainFrame.setVisible(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v20 */
    public static void main(String[] strArr) {
        ?? r0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("-h") || strArr[i].equals("/h")) {
                System.out.println("USAGE:");
                System.out.println("------");
                System.out.println("java -jar DevNullSmtp.jar <options>");
                System.out.println("");
                System.out.println("Options:");
                System.out.println("-------");
                System.out.println("-console\tRuns server in console mode. Default mode is GUI");
                System.out.println("-p\t\tTCP/IP port. If omitted, 25 will be used");
                System.out.println("-s\t\tPath to the directory where files will be saved. Files are not saved if omitted or refers to an invalid path");
                System.out.println("-d\t\tAcceptable domain(s). Separate multiple values with a comma. If omitted, server runs as open relay");
                System.out.println("-h\t\tDisplays this help file");
                return;
            }
        }
        int i2 = 25;
        String str = null;
        String str2 = null;
        String str3 = null;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (strArr[i3].equals("-p") && strArr.length >= i3 + 1) {
                i2 = Integer.parseInt(strArr[i3 + 1]);
            }
            if (strArr[i3].equals("-s") && strArr.length >= i3 + 1) {
                str = strArr[i3 + 1];
            }
            if (strArr[i3].equals("-d") && strArr.length >= i3 + 1) {
                str2 = strArr[i3 + 1];
            }
            if (strArr[i3].equals("-w") && strArr.length >= i3 + 1) {
                str3 = strArr[i3 + 1];
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= strArr.length) {
                r0 = 0;
                break;
            } else if (strArr[i4].equals("-console")) {
                r0 = 1;
                break;
            } else {
                i4++;
            }
        }
        if (r0 != 0) {
            new C0028a(i2, str, str2, str3).m164a();
            return;
        }
        try {
            r0 = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel((String) r0);
        } catch (Exception e) {
            r0.printStackTrace();
        }
        new DevNullSmtp(i2, str, str2, str3);
    }
}
