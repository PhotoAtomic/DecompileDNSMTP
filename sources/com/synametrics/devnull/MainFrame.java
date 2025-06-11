package com.synametrics.devnull;

import com.synametrics.commons.util.C0015d;
import com.synametrics.devnull.panel.MainPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/* loaded from: input.jar:com/synametrics/devnull/MainFrame.class */
public class MainFrame extends JFrame {
    MainPanel jPanel1;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46, types: [com.synametrics.devnull.panel.MainPanel] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.synametrics.devnull.MainFrame] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Exception] */
    public MainFrame(int i, String str, String str2, String str3) {
        this.jPanel1 = null;
        ?? r0 = this;
        r0.jPanel1 = new MainPanel(false);
        try {
            getContentPane().setLayout(this.borderLayout1);
            getContentPane().add(this.jPanel1, "Center");
            setSize(new Dimension(663, 467));
            setTitle("SMTP Server to dev null - where every e-mail counts");
            this.jMenuFile.setText("File");
            this.jMenuFileExit.setText("Exit");
            this.jMenuFileExit.addActionListener(new C0031d(this));
            this.jMenuHelp.setText("Help");
            this.jMenuHelpAbout.setText("About");
            this.jMenuFile.add(this.jMenuFileExit);
            this.jMenuHelp.add(this.jMenuHelpAbout);
            this.jMenuBar1.add(this.jMenuFile);
            this.jMenuBar1.add(this.jMenuHelp);
            this.jMenuHelpAbout.addActionListener(new C0030c(this));
            setJMenuBar(this.jMenuBar1);
            if (i != 25) {
                this.jPanel1.m160a(i);
            }
            if (str != null) {
                this.jPanel1.m145f(str);
            }
            if (str2 != null) {
                this.jPanel1.m146e(C0015d.m196a(str2, ",", "\n"));
            }
            if (str3 != null) {
                r0 = this.jPanel1;
                r0.m144g(str3);
            }
        } catch (Exception e) {
            r0.printStackTrace();
        }
    }

    protected void processWindowEvent(WindowEvent windowEvent) {
        super.processWindowEvent(windowEvent);
        if (windowEvent.getID() == 201) {
            System.exit(0);
        }
    }
}
