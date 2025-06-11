package com.synametrics.commons.util.logging;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: input.jar:com/synametrics/commons/util/logging/PerformanceInfo.class */
public class PerformanceInfo implements Serializable {
    protected static String sourceIP = null;
    protected int stackNumber;
    protected long serialNumber;
    protected String enterClassName;
    protected String enterMessage;
    protected long enterTime;
    protected String exitClassName;
    protected String exitMessage;
    protected long exitTime;
    protected String threadName;

    public PerformanceInfo(int i, long j) {
        if (sourceIP == null) {
            try {
                sourceIP = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException unused) {
                sourceIP = "localhost";
            }
        }
        this.serialNumber = j;
        this.stackNumber = i;
        this.enterTime = 0L;
        this.exitTime = -1L;
    }

    public String format() {
        return this.exitTime == -1 ? "ENTER, " + this.threadName + ", " + this.stackNumber + ", " + this.serialNumber + ", 0, " + this.enterClassName + ", " + this.enterMessage : "EXIT , " + this.threadName + ", " + this.stackNumber + ", " + this.serialNumber + ", " + getElapsedTime() + ", " + this.enterClassName + ", " + this.enterMessage;
    }

    public long getElapsedTime() {
        if (this.exitTime == -1) {
            return -1L;
        }
        return this.exitTime - this.enterTime;
    }

    public String getEnterClassName() {
        return this.enterClassName;
    }

    public String getEnterMessage() {
        return this.enterMessage;
    }

    public long getEnterTime() {
        return this.enterTime;
    }

    public String getExitClassName() {
        return this.exitClassName;
    }

    public String getExitMessage() {
        return this.exitMessage;
    }

    public long getExitTime() {
        return this.exitTime;
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public int getStackNumber() {
        return this.stackNumber;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setEnterClassName(String str) {
        this.enterClassName = str;
    }

    public void setEnterMessage(String str) {
        this.enterTime = System.currentTimeMillis();
        this.enterMessage = str;
    }

    public void setEnterTime(long j) {
        this.enterTime = j;
    }

    public void setExitClassName(String str) {
        this.exitClassName = str;
    }

    public void setExitMessage(String str) {
        this.exitTime = System.currentTimeMillis();
        this.exitMessage = str;
    }

    public void setExitTime(long j) {
        this.exitTime = j;
    }

    public void setSourceIP(String str) {
        sourceIP = str;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public String toString() {
        return String.valueOf(sourceIP) + ", " + this.enterTime + ", " + this.exitTime + ", " + format();
    }
}
