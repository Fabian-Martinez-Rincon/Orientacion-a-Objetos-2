package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaPlayerTest {
	
	MediaPlayer mp;
	Audio a;
	VideoFile vf;
	VideoStream vs;
	AdapterVideoStream adapter;
	
	@BeforeEach
	void setUp() throws Exception {
		mp = new MediaPlayer();
		a = new Audio();
		vf = new VideoFile();
		adapter = new AdapterVideoStream();
		
		mp.agregarMedia(a);
		mp.agregarMedia(vf);
		mp.agregarMedia(adapter);
	}
	
    @Test
    public void testNombreCompleto() {
    	assertEquals("audio, video file, video stream", mp.concatenarNombresMedia());
    }
}
