package org.apache.log4j;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0075s;
/* loaded from: input.jar:org/apache/log4j/FileAppender.class */
public class FileAppender extends WriterAppender {
    protected boolean fileAppend;
    protected String fileName;
    protected boolean bufferedIO;
    protected int bufferSize;

    public FileAppender() {
        this.fileAppend = true;
        this.fileName = null;
        this.bufferedIO = false;
        this.bufferSize = 8192;
    }

    public FileAppender(Layout layout, String str, boolean z, boolean z2, int i) {
        this.fileAppend = true;
        this.fileName = null;
        this.bufferedIO = false;
        this.bufferSize = 8192;
        this.layout = layout;
        setFile(str, z, z2, i);
    }

    public FileAppender(Layout layout, String str, boolean z) {
        this.fileAppend = true;
        this.fileName = null;
        this.bufferedIO = false;
        this.bufferSize = 8192;
        this.layout = layout;
        setFile(str, z, false, this.bufferSize);
    }

    public FileAppender(Layout layout, String str) {
        this(layout, str, true);
    }

    public void setFile(String str) {
        this.fileName = str.trim();
    }

    public boolean getAppend() {
        return this.fileAppend;
    }

    public String getFile() {
        return this.fileName;
    }

    @Override // org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
        if (this.fileName == null) {
            C0059c.m78c(new StringBuffer().append("File option not set for appender [").append(this.name).append("].").toString());
            C0059c.m78c("Are you using FileAppender instead of ConsoleAppender?");
            return;
        }
        try {
            setFile(this.fileName, this.fileAppend, this.bufferedIO, this.bufferSize);
        } catch (IOException e) {
            this.errorHandler.mo4a(new StringBuffer().append("setFile(").append(this.fileName).append(",").append(this.fileAppend).append(") call failed.").toString(), e, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeFile() {
        if (this.f134qw != null) {
            try {
                this.f134qw.close();
            } catch (IOException e) {
                C0059c.m79b(new StringBuffer().append("Could not close ").append(this.f134qw).toString(), e);
            }
        }
    }

    public boolean getBufferedIO() {
        return this.bufferedIO;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setAppend(boolean z) {
        this.fileAppend = z;
    }

    public void setBufferedIO(boolean z) {
        this.bufferedIO = z;
        if (z) {
            this.immediateFlush = false;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public synchronized void setFile(String str, boolean z, boolean z2, int i) {
        C0059c.m83a(new StringBuffer().append("setFile called: ").append(str).append(", ").append(z).toString());
        if (z2) {
            setImmediateFlush(false);
        }
        reset();
        Writer createWriter = createWriter(new FileOutputStream(str, z));
        if (z2) {
            createWriter = new BufferedWriter(createWriter, i);
        }
        setQWForFiles(createWriter);
        this.fileName = str;
        this.fileAppend = z;
        this.bufferedIO = z2;
        this.bufferSize = i;
        writeHeader();
        C0059c.m83a("setFile ended");
    }

    protected void setQWForFiles(Writer writer) {
        this.f134qw = new C0075s(writer, this.errorHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.log4j.WriterAppender
    public void reset() {
        closeFile();
        this.fileName = null;
        super.reset();
    }
}
