package com.synametrics.commons.util;

import com.synametrics.commons.util.logging.LoggingFW;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
/* renamed from: com.synametrics.commons.util.b */
/* loaded from: input.jar:com/synametrics/commons/util/b.class */
public final class C0012b extends Thread {

    /* renamed from: a */
    private String f22a;

    /* renamed from: b */
    private WavePlayer$Position f23b = WavePlayer$Position.f7c;

    public C0012b(String str) {
        this.f22a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        File file = new File(this.f22a);
        if (!file.exists()) {
            LoggingFW.log(40000, this, "Wave file not found: " + this.f22a);
            return;
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioInputStream.getFormat();
            try {
                SourceDataLine line = AudioSystem.getLine(new DataLine.Info(SourceDataLine.class, format));
                line.open(format);
                if (line.isControlSupported(FloatControl.Type.PAN)) {
                    FloatControl control = line.getControl(FloatControl.Type.PAN);
                    if (this.f23b == WavePlayer$Position.f6b) {
                        control.setValue(1.0f);
                    } else if (this.f23b == WavePlayer$Position.f5a) {
                        control.setValue(-1.0f);
                    }
                }
                line.start();
                int i = 0;
                byte[] bArr = new byte[524288];
                try {
                    while (i != -1) {
                        int read = audioInputStream.read(bArr, 0, bArr.length);
                        i = read;
                        if (read >= 0) {
                            line.write(bArr, 0, i);
                        }
                    }
                } catch (IOException e) {
                    LoggingFW.log(40000, this, e.getMessage(), e);
                } finally {
                    line.drain();
                    line.close();
                }
            } catch (LineUnavailableException e2) {
                LoggingFW.log(40000, this, e2.getMessage(), e2);
            } catch (Exception e3) {
                LoggingFW.log(40000, this, e3.getMessage(), e3);
            }
        } catch (UnsupportedAudioFileException e4) {
            LoggingFW.log(40000, this, e4.getMessage(), e4);
        } catch (IOException e5) {
            LoggingFW.log(40000, this, e5.getMessage(), e5);
        }
    }
}
