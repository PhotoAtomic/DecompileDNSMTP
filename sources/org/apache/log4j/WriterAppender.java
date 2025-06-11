package org.apache.log4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.log4j.helpers.C0059c;
import org.apache.log4j.helpers.C0075s;
import org.apache.log4j.spi.InterfaceC0087e;
import org.apache.log4j.spi.LoggingEvent;
/* loaded from: input.jar:org/apache/log4j/WriterAppender.class */
public class WriterAppender extends AppenderSkeleton {
    protected boolean immediateFlush;
    protected String encoding;

    /* renamed from: qw */
    protected C0075s f134qw;

    public WriterAppender() {
        this.immediateFlush = true;
    }

    public WriterAppender(Layout layout, OutputStream outputStream) {
        this(layout, new OutputStreamWriter(outputStream));
    }

    public WriterAppender(Layout layout, Writer writer) {
        this.immediateFlush = true;
        this.layout = layout;
        setWriter(writer);
    }

    public void setImmediateFlush(boolean z) {
        this.immediateFlush = z;
    }

    public boolean getImmediateFlush() {
        return this.immediateFlush;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.InterfaceC0089g
    public void activateOptions() {
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        if (checkEntryConditions()) {
            subAppend(loggingEvent);
        }
    }

    protected boolean checkEntryConditions() {
        if (this.closed) {
            C0059c.m78c("Not allowed to write to a closed appender.");
            return false;
        } else if (this.f134qw == null) {
            this.errorHandler.mo5a(new StringBuffer().append("No output stream or file set for the appender named [").append(this.name).append("].").toString());
            return false;
        } else if (this.layout == null) {
            this.errorHandler.mo5a(new StringBuffer().append("No layout set for the appender named [").append(this.name).append("].").toString());
            return false;
        } else {
            return true;
        }
    }

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        writeFooter();
        reset();
    }

    protected void closeWriter() {
        if (this.f134qw != null) {
            try {
                this.f134qw.close();
            } catch (IOException e) {
                C0059c.m79b(new StringBuffer().append("Could not close ").append(this.f134qw).toString(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OutputStreamWriter createWriter(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = null;
        String encoding = getEncoding();
        if (encoding != null) {
            try {
                outputStreamWriter = new OutputStreamWriter(outputStream, encoding);
            } catch (IOException unused) {
                C0059c.m78c("Error initializing output writer.");
                C0059c.m78c("Unsupported encoding?");
            }
        }
        if (outputStreamWriter == null) {
            outputStreamWriter = new OutputStreamWriter(outputStream);
        }
        return outputStreamWriter;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.Appender
    public synchronized void setErrorHandler(InterfaceC0087e interfaceC0087e) {
        if (interfaceC0087e == null) {
            C0059c.m78c("You have tried to set a null error-handler.");
            return;
        }
        this.errorHandler = interfaceC0087e;
        if (this.f134qw != null) {
            this.f134qw.m36a(interfaceC0087e);
        }
    }

    public synchronized void setWriter(Writer writer) {
        reset();
        this.f134qw = new C0075s(writer, this.errorHandler);
        writeHeader();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void subAppend(LoggingEvent loggingEvent) {
        String[] m7j;
        this.f134qw.write(this.layout.format(loggingEvent));
        if (this.layout.ignoresThrowable() && (m7j = loggingEvent.m7j()) != null) {
            for (String str : m7j) {
                this.f134qw.write(str);
                this.f134qw.write(Layout.LINE_SEP);
            }
        }
        if (this.immediateFlush) {
            this.f134qw.flush();
        }
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reset() {
        closeWriter();
        this.f134qw = null;
    }

    protected void writeFooter() {
        String footer;
        if (this.layout == null || (footer = this.layout.getFooter()) == null || this.f134qw == null) {
            return;
        }
        this.f134qw.write(footer);
        this.f134qw.flush();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeHeader() {
        String header;
        if (this.layout == null || (header = this.layout.getHeader()) == null || this.f134qw == null) {
            return;
        }
        this.f134qw.write(header);
    }
}
