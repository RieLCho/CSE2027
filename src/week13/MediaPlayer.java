// 2019112130 ������
// MediaPlayer.java
package week13;

import java.io.File;
import javax.sound.sampled.*;

public class MediaPlayer {
	// ���ڷ� ���� �̸����� ���� (Ȯ���� ����)
	public void play(String name) {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		// ������ ���� ��� - �ٸ� ��ǻ�Ϳ��� ���� �ʿ�
		bgm = new File("C:\\Users\\70339\\OneDrive\\"
				+ "���� ȭ��\\Github\\Workspace\\week13\\src\\week13\\"+name+".wav");
		
		Clip clip;
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
