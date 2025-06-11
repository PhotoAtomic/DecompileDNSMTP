package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0064h;
import org.apache.log4j.helpers.C0069m;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/RollingFileAppender.class */
public class RollingFileAppender extends FileAppender {
    protected long maxFileSize;
    protected int maxBackupIndex;

    public RollingFileAppender() {
        this.maxFileSize = 10485760L;
        this.maxBackupIndex = 1;
    }

    public RollingFileAppender(Layout layout, String str, boolean z) {
        super(layout, str, z);
        this.maxFileSize = 10485760L;
        this.maxBackupIndex = 1;
    }

    public RollingFileAppender(Layout layout, String str) {
        super(layout, str);
        this.maxFileSize = 10485760L;
        this.maxBackupIndex = 1;
    }

    public int getMaxBackupIndex() {
        return this.maxBackupIndex;
    }

    public long getMaximumFileSize() {
        return this.maxFileSize;
    }

    public void rollOver() {
        C0059c.m83a(new StringBuffer().append("rolling over count=").append(((C0064h) this.f134qw).m72a()).toString());
        C0059c.m83a(new StringBuffer().append("maxBackupIndex=").append(this.maxBackupIndex).toString());
        if (this.maxBackupIndex > 0) {
            File file = new File(new StringBuffer().append(this.fileName).append('.').append(this.maxBackupIndex).toString());
            if (file.exists()) {
                file.delete();
            }
            for (int i = this.maxBackupIndex - 1; i >= 1; i--) {
                File file2 = new File(new StringBuffer().append(this.fileName).append(".").append(i).toString());
                if (file2.exists()) {
                    File file3 = new File(new StringBuffer().append(this.fileName).append('.').append(i + 1).toString());
                    C0059c.m83a(new StringBuffer().append("Renaming file ").append(file2).append(" to ").append(file3).toString());
                    file2.renameTo(file3);
                }
            }
            File file4 = new File(new StringBuffer().append(this.fileName).append(".").append(1).toString());
            closeFile();
            File file5 = new File(this.fileName);
            C0059c.m83a(new StringBuffer().append("Renaming file ").append(file5).append(" to ").append(file4).toString());
            file5.renameTo(file4);
        }
        try {
            setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
        } catch (IOException e) {
            C0059c.m79b(new StringBuffer().append("setFile(").append(this.fileName).append(", false) call failed.").toString(), e);
        }
    }

    @Override // org.apache.log4j.FileAppender
    public synchronized void setFile(String str, boolean z, boolean z2, int i) {
        super.setFile(str, z, this.bufferedIO, this.bufferSize);
        if (z) {
            ((C0064h) this.f134qw).m71a(new File(str).length());
        }
    }

    public void setMaxBackupIndex(int i) {
        this.maxBackupIndex = i;
    }

    public void setMaximumFileSize(long j) {
        this.maxFileSize = j;
    }

    public void setMaxFileSize(String str) {
        this.maxFileSize = C0069m.m63a(str, this.maxFileSize + 1);
    }

    @Override // org.apache.log4j.FileAppender
    protected void setQWForFiles(Writer writer) {
        this.f134qw = new C0064h(writer, this.errorHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.log4j.WriterAppender
    public void subAppend(LoggingEvent loggingEvent) {
        super.subAppend(loggingEvent);
        if (this.fileName == null || ((C0064h) this.f134qw).m72a() < this.maxFileSize) {
            return;
        }
        rollOver();
    }
}
