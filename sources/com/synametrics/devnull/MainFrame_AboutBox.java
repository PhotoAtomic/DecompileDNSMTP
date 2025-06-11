package com.synametrics.devnull;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
/* loaded from: input.jar:com/synametrics/devnull/MainFrame_AboutBox.class */
public class MainFrame_AboutBox extends JDialog implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JPanel insetsPanel1;
    JPanel insetsPanel2;
    JPanel insetsPanel3;
    JButton button1;
    JLabel imageLabel;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    ImageIcon image1;
    BorderLayout borderLayout1;
    BorderLayout borderLayout2;
    FlowLayout flowLayout1;
    GridLayout gridLayout1;
    String product;
    String version;
    String copyright;
    String comments;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.synametrics.devnull.MainFrame_AboutBox] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v79, types: [com.synametrics.devnull.MainFrame_AboutBox] */
    public MainFrame_AboutBox(Frame frame) {
        super(frame);
        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.insetsPanel1 = new JPanel();
        this.insetsPanel2 = new JPanel();
        this.insetsPanel3 = new JPanel();
        this.button1 = new JButton();
        this.imageLabel = new JLabel();
        this.label1 = new JLabel();
        this.label2 = new JLabel();
        this.label3 = new JLabel();
        this.label4 = new JLabel();
        this.image1 = new ImageIcon();
        this.borderLayout1 = new BorderLayout();
        this.borderLayout2 = new BorderLayout();
        this.flowLayout1 = new FlowLayout();
        this.gridLayout1 = new GridLayout();
        this.product = "Dev Null SMTP server - destined to nowhere";
        this.version = "1.0";
        this.copyright = "Copyright (c) 2004";
        this.comments = "This is a fake SMTP server that accepts messages but does not do anything with it";
        ?? r0 = this;
        r0.enableEvents(64L);
        try {
            this.image1 = new ImageIcon(MainFrame.class.getResource("about.png"));
            this.imageLabel.setIcon(this.image1);
            setTitle("About");
            this.panel1.setLayout(this.borderLayout1);
            this.panel2.setLayout(this.borderLayout2);
            this.insetsPanel1.setLayout(this.flowLayout1);
            this.insetsPanel2.setLayout(this.flowLayout1);
            this.insetsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            this.gridLayout1.setRows(4);
            this.gridLayout1.setColumns(1);
            this.label1.setText(this.product);
            this.label2.setText(this.version);
            this.label3.setText(this.copyright);
            this.label4.setText(this.comments);
            this.insetsPanel3.setLayout(this.gridLayout1);
            this.insetsPanel3.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 10));
            this.button1.setText("Ok");
            this.button1.addActionListener(this);
            this.insetsPanel2.add(this.imageLabel, (Object) null);
            this.panel2.add(this.insetsPanel2, "West");
            getContentPane().add(this.panel1, (Object) null);
            this.insetsPanel3.add(this.label1, (Object) null);
            this.insetsPanel3.add(this.label2, (Object) null);
            this.insetsPanel3.add(this.label3, (Object) null);
            this.insetsPanel3.add(this.label4, (Object) null);
            this.panel2.add(this.insetsPanel3, "Center");
            this.insetsPanel1.add(this.button1, (Object) null);
            this.panel1.add(this.insetsPanel1, "South");
            this.panel1.add(this.panel2, "North");
            r0 = this;
            r0.setResizable(true);
        } catch (Exception e) {
            r0.printStackTrace();
        }
    }

    MainFrame_AboutBox() {
        this(null);
    }

    protected void processWindowEvent(WindowEvent windowEvent) {
        if (windowEvent.getID() == 201) {
            dispose();
        }
        super.processWindowEvent(windowEvent);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.button1) {
            dispose();
        }
    }
}
