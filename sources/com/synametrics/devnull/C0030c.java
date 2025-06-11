package com.synametrics.devnull;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* renamed from: com.synametrics.devnull.c */
/* loaded from: input.jar:com/synametrics/devnull/c.class */
final class C0030c implements ActionListener {

    /* renamed from: a */
    private MainFrame f74a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0030c(MainFrame mainFrame) {
        this.f74a = mainFrame;
    }

    public final void actionPerformed(ActionEvent actionEvent) {
        MainFrame mainFrame = this.f74a;
        MainFrame_AboutBox mainFrame_AboutBox = new MainFrame_AboutBox(mainFrame);
        Dimension preferredSize = mainFrame_AboutBox.getPreferredSize();
        Dimension size = mainFrame.getSize();
        Point location = mainFrame.getLocation();
        mainFrame_AboutBox.setLocation(((size.width - preferredSize.width) / 2) + location.x, ((size.height - preferredSize.height) / 2) + location.y);
        mainFrame_AboutBox.setModal(true);
        mainFrame_AboutBox.pack();
        mainFrame_AboutBox.setVisible(true);
    }
}
