// 2019112130 조양진
// MediaPlayer.java
package week13;

import java.io.File;
import javax.sound.sampled.*;

public class MediaPlayer {
	// 인자로 파일 이름명을 받음 (확장자 제외)
	public void play(String name) {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		// 음원의 절대 경로 - 다른 컴퓨터에선 변경 필요
		bgm = new File("C:\\Users\\70339\\OneDrive\\"
				+ "바탕 화면\\Github\\Workspace\\week13\\src\\week13\\"+name+".wav");
		
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
