package com.synametrics.devnull.panel;

import com.synametrics.commons.gui.panel.EnhancedStatusBar;
import com.synametrics.commons.util.C0012b;
import com.synametrics.commons.util.C0015d;
import com.synametrics.commons.util.logging.LoggingFW;
import com.synametrics.commons.util.net.p005a.p006a.C0021b;
import com.synametrics.commons.util.net.p005a.p006a.C0026g;
import com.synametrics.commons.util.net.p005a.p006a.InterfaceC0022c;
import com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d;
import com.synametrics.devnull.C0027a;
import com.synametrics.devnull.C0029b;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/* loaded from: input.jar:com/synametrics/devnull/panel/MainPanel.class */
public class MainPanel extends JPanel implements InterfaceC0022c, InterfaceC0023d {
    private boolean insideApplet;
    String[] acceptableDomains;
    private int messageCount = 0;
    private int lineCount = 0;
    private int logLineCount = 0;
    private String waveFile = null;
    private int messageID = 0;
    private C0021b server = new C0021b();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel3 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JLabel jLabel1 = new JLabel();
    JTextField txtPort = new JTextField();
    JButton btnStart = new JButton();
    JLabel jLabel2 = new JLabel();
    JLabel lblMessageCount = new JLabel();
    JTextArea txtMessages = new JTextArea();
    EnhancedStatusBar stbMain = new EnhancedStatusBar();
    JLabel jLabel3 = new JLabel();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTextArea txtAcceptableDomains = new JTextArea();
    JTabbedPane jTabbedPane1 = new JTabbedPane();
    JScrollPane jScrollPane3 = new JScrollPane();
    JTextArea txtSummary = new JTextArea();
    JButton btnIPSummary = new JButton();
    JScrollPane jScrollPane4 = new JScrollPane();
    JTextArea txtSmtpLog = new JTextArea();
    JScrollPane jScrollPane5 = new JScrollPane();
    JTextArea txtLastMessage = new JTextArea();
    JCheckBox chkSaveMessages = new JCheckBox();
    JTextField txtCacheDir = new JTextField();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v150, types: [com.synametrics.commons.util.net.a.a.g] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.synametrics.devnull.panel.MainPanel] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.Exception] */
    public MainPanel(boolean z) {
        this.insideApplet = false;
        this.insideApplet = false;
        ?? r0 = this;
        r0.enableEvents(64L);
        try {
            setLayout(this.borderLayout1);
            setSize(new Dimension(663, 467));
            this.jPanel1.setMinimumSize(new Dimension(10, 10));
            this.jPanel1.setPreferredSize(new Dimension(10, 150));
            this.jPanel1.setLayout((LayoutManager) null);
            this.jPanel3.setLayout(this.borderLayout2);
            this.jLabel1.setText("Listening port:");
            this.jLabel1.setBounds(new Rectangle(12, 17, 134, 14));
            this.txtPort.setText("25");
            this.txtPort.setBounds(new Rectangle(145, 14, 63, 20));
            this.btnStart.setBounds(new Rectangle(274, 13, 118, 24));
            this.btnStart.setText("Start Server");
            this.btnStart.addActionListener(new C0037f(this));
            this.jLabel2.setText("Message received: ");
            this.jLabel2.setBounds(new Rectangle(9, 36, 136, 14));
            this.lblMessageCount.setFont(new Font("Tahoma", 1, 11));
            this.lblMessageCount.setText("0");
            this.lblMessageCount.setBounds(new Rectangle(146, 38, 81, 14));
            this.jLabel3.setText("Acceptable domains");
            this.jLabel3.setBounds(new Rectangle(9, 55, 136, 14));
            this.jScrollPane2.setBounds(new Rectangle(145, 58, 246, 87));
            this.txtAcceptableDomains.setToolTipText("Leave blank to accept any domain. (AKA Open Relay)");
            this.txtAcceptableDomains.setText("");
            this.btnIPSummary.setBounds(new Rectangle(396, 120, 125, 24));
            this.btnIPSummary.setText("IP Summary");
            this.btnIPSummary.addActionListener(new C0036e(this));
            this.chkSaveMessages.setToolTipText("If selected ALL incoming messages will be saved to directory specified below");
            this.chkSaveMessages.setText("Save incoming messages to:");
            this.chkSaveMessages.setBounds(new Rectangle(395, 56, 216, 22));
            this.chkSaveMessages.addActionListener(new C0035d(this));
            this.txtCacheDir.setToolTipText("Directory name where messages are stored locally");
            this.txtCacheDir.setEnabled(false);
            this.txtCacheDir.setText("/cachedMessages");
            this.txtCacheDir.setBounds(new Rectangle(415, 79, 150, 20));
            add(this.jPanel1, "North");
            this.jPanel1.add(this.jLabel1, (Object) null);
            add(this.jPanel3, "Center");
            this.jPanel3.add(this.jTabbedPane1, "Center");
            this.jTabbedPane1.add(this.jScrollPane4, "SMTP Log");
            this.jTabbedPane1.add(this.jScrollPane1, "Email Watch");
            this.jTabbedPane1.add(this.jScrollPane3, "Summary");
            this.jTabbedPane1.add(this.jScrollPane5, "Last Message");
            this.jScrollPane5.getViewport().add(this.txtLastMessage, (Object) null);
            this.jScrollPane4.getViewport().add(this.txtSmtpLog, (Object) null);
            this.jScrollPane3.getViewport().add(this.txtSummary, (Object) null);
            this.jScrollPane1.getViewport().add(this.txtMessages, (Object) null);
            add(this.stbMain, "South");
            this.jPanel1.add(this.jLabel2, (Object) null);
            this.jPanel1.add(this.jLabel3, (Object) null);
            this.jPanel1.add(this.lblMessageCount, (Object) null);
            this.jPanel1.add(this.btnStart, (Object) null);
            this.jPanel1.add(this.txtPort, (Object) null);
            this.jPanel1.add(this.jScrollPane2, (Object) null);
            this.jPanel1.add(this.btnIPSummary, (Object) null);
            this.jPanel1.add(this.chkSaveMessages, (Object) null);
            this.jPanel1.add(this.txtCacheDir, (Object) null);
            this.jScrollPane2.getViewport().add(this.txtAcceptableDomains, (Object) null);
            r0 = C0026g.m170a();
            r0.m169a(this);
        } catch (Exception e) {
            r0.printStackTrace();
        }
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d
    /* renamed from: c */
    public final void mo150c(String str) {
        m143h(str);
    }

    /* renamed from: a */
    public final void m160a(int i) {
        this.txtPort.setText(new StringBuilder().append(i).toString());
    }

    /* renamed from: e */
    public final void m146e(String str) {
        this.txtAcceptableDomains.setText(str);
    }

    /* renamed from: f */
    public final void m145f(String str) {
        this.txtCacheDir.setText(str);
        this.chkSaveMessages.setSelected(true);
        this.txtCacheDir.setEnabled(this.chkSaveMessages.isSelected());
    }

    /* renamed from: g */
    public final void m144g(String str) {
        this.waveFile = str;
    }

    /* renamed from: h */
    private void m143h(String str) {
        RunnableC0033b runnableC0033b = new RunnableC0033b(this, this, str);
        if (SwingUtilities.isEventDispatchThread()) {
            runnableC0033b.run();
        } else {
            SwingUtilities.invokeLater(runnableC0033b);
        }
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d
    /* renamed from: d */
    public final String mo148d(String str) {
        String lowerCase = str.toLowerCase();
        if (this.acceptableDomains == null) {
            return null;
        }
        for (int i = 0; i < this.acceptableDomains.length; i++) {
            if (lowerCase.indexOf("@" + this.acceptableDomains[i]) > 0) {
                return null;
            }
        }
        return "Relaying denied";
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0023d
    /* renamed from: a */
    public final String mo155a(String str, String str2, byte[] bArr) {
        this.messageCount++;
        C0029b.m163a().m162a(str);
        RunnableC0034c runnableC0034c = new RunnableC0034c(this, str2, bArr);
        if (SwingUtilities.isEventDispatchThread()) {
            runnableC0034c.run();
        } else {
            SwingUtilities.invokeLater(runnableC0034c);
        }
        if (this.waveFile != null) {
            new C0012b(this.waveFile).start();
            return null;
        }
        return null;
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0022c
    /* renamed from: a */
    public final void mo156a(String str) {
        RunnableC0032a runnableC0032a = new RunnableC0032a(this, str);
        if (SwingUtilities.isEventDispatchThread()) {
            runnableC0032a.run();
        } else {
            SwingUtilities.invokeLater(runnableC0032a);
        }
    }

    @Override // com.synametrics.commons.util.net.p005a.p006a.InterfaceC0022c
    /* renamed from: b */
    public final void mo152b(String str) {
        mo156a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m159a(MainPanel mainPanel) {
        if (!mainPanel.btnStart.getText().equals("Start Server")) {
            mainPanel.server.m183a();
            mainPanel.btnStart.setText("Start Server");
            mainPanel.txtPort.setEnabled(true);
            mainPanel.txtAcceptableDomains.setEnabled(true);
            mainPanel.stbMain.m216a("SMTP is not running");
            return;
        }
        try {
            mainPanel.messageCount = 0;
            mainPanel.acceptableDomains = mainPanel.txtAcceptableDomains.getText().split("\n");
            for (int i = 0; i < mainPanel.acceptableDomains.length; i++) {
                mainPanel.acceptableDomains[i] = mainPanel.acceptableDomains[i].trim();
                LoggingFW.log(20000, mainPanel, "Acceptable domains are: " + mainPanel.acceptableDomains[i]);
            }
            if (mainPanel.server.m182a(Integer.parseInt(mainPanel.txtPort.getText()), mainPanel)) {
                mainPanel.txtPort.setEnabled(false);
                mainPanel.txtAcceptableDomains.setEnabled(false);
                mainPanel.stbMain.m216a("Server started on " + C0015d.m201a(System.currentTimeMillis()));
                mainPanel.btnStart.setText("Stop Server");
            }
        } catch (NumberFormatException unused) {
            mainPanel.m143h("Invalid port number specified");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m154b(MainPanel mainPanel) {
        List m161b = C0029b.m163a().m161b();
        mainPanel.txtSummary.setText("");
        for (int i = 0; i < m161b.size(); i++) {
            C0027a c0027a = (C0027a) m161b.get(i);
            mainPanel.txtSummary.append(String.valueOf(C0015d.m197a(c0027a.m165b(), 20, ' ')) + "\t" + c0027a.m166a() + "\r\n");
            if (i > 100) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m157a(MainPanel mainPanel, byte[] bArr) {
        if (mainPanel.chkSaveMessages.isSelected()) {
            mainPanel.messageID++;
            String str = String.valueOf(mainPanel.messageID) + "_" + System.currentTimeMillis() + ".eml";
            File file = new File(mainPanel.txtCacheDir.getText());
            if (!file.exists()) {
                file.mkdir();
            }
            C0015d.m195a(String.valueOf(file.getAbsolutePath()) + C0015d.f26b + str, bArr);
        }
    }
}
