import java.io.*;
import javax.sound.sampled.*;

public class SoundPlay {

	public static void main(String[] args) {
		SoundPlay s = new SoundPlay();
		s.play("samples/loop.wav");
		System.exit(0); // Java Sound bug fix...
	}

	public boolean play(String filename)
	{
		try {
			File file = new File(filename);
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			AudioFormat	format = stream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			Thread.sleep(100);
			while (clip.isRunning()) { Thread.sleep(100); }
			clip.close();
		}
		catch (Exception e) { return false;	}
		return true;
	}
}
