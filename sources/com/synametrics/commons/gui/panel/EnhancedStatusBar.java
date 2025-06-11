package com.synametrics.commons.gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
/* loaded from: input.jar:com/synametrics/commons/gui/panel/EnhancedStatusBar.class */
public class EnhancedStatusBar extends JPanel {
    private BorderLayout borderLayout1 = new BorderLayout();
    private JLabel lblMessage = new JLabel();
    private final int timerDelay = 1000;
    private StringBuffer memoryStatus = new StringBuffer(512);
    private JProgressBar pnlMemory = new JProgressBar();
    private JPanel jPanel1 = new JPanel();
    private BorderLayout borderLayout2 = new BorderLayout();
    private JLabel lblAllocMem = new JLabel();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v34, types: [javax.swing.JProgressBar] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.synametrics.commons.gui.panel.EnhancedStatusBar] */
    public EnhancedStatusBar() {
        ?? r0 = this;
        r0.setPreferredSize(new Dimension(10, 20));
        try {
            this.lblMessage.setText(" ");
            this.lblMessage.setFont(new Font("Dialog", 1, 10));
            setLayout(this.borderLayout1);
            this.pnlMemory.setPreferredSize(new Dimension(70, 10));
            this.jPanel1.setLayout(this.borderLayout2);
            this.jPanel1.setPreferredSize(new Dimension(180, 14));
            this.lblAllocMem.setFont(new Font("Dialog", 1, 10));
            this.lblAllocMem.setText("jLabel1");
            add(this.lblMessage, "Center");
            add(this.jPanel1, "East");
            this.jPanel1.add(this.pnlMemory, "East");
            this.jPanel1.add(this.lblAllocMem, "Center");
            new Timer(1000, new C0004a(this)).start();
            r0 = this.pnlMemory;
            r0.setStringPainted(true);
        } catch (Exception e) {
            r0.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m216a(String str) {
        this.lblMessage.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m217a(EnhancedStatusBar enhancedStatusBar) {
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        enhancedStatusBar.memoryStatus.setLength(0);
        enhancedStatusBar.memoryStatus.append((int) ((freeMemory * 100) / j)).append("% free");
        enhancedStatusBar.pnlMemory.setMaximum((int) (j / 1024));
        enhancedStatusBar.pnlMemory.setValue((int) (freeMemory / 1024));
        enhancedStatusBar.pnlMemory.setString(enhancedStatusBar.memoryStatus.toString());
        enhancedStatusBar.memoryStatus.setLength(0);
        enhancedStatusBar.memoryStatus.append("Allocated ").append(((int) j) / 1024000).append(" MB");
        enhancedStatusBar.lblAllocMem.setText(enhancedStatusBar.memoryStatus.toString());
    }
}
