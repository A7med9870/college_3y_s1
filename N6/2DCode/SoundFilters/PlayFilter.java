import java.io.*;
import javax.sound.sampled.*;

public class PlayFilter {

	public static void main(String[] args) {
		PlayFilter s = new PlayFilter();
		s.play("samples/groovey.wav");
		System.exit(0); // Java Sound bug fix...
	}

	public boolean play(String filename)
	{
		try {
			File file = new File(filename);
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			AudioFormat	format = stream.getFormat();
			FadeFilterStream filtered = new FadeFilterStream(stream);
			AudioInputStream f = new AudioInputStream(filtered,format,stream.getFrameLength());
			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(f);
			clip.start();
			Thread.sleep(100);
			while (clip.isRunning()) { Thread.sleep(100); }
			clip.close();
		}
		catch (Exception e) { return false;	}
		return true;
	}
}
