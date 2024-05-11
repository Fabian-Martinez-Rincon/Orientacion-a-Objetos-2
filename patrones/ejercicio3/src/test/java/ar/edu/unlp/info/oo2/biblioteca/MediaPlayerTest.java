package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaPlayerTest {
	Audio audio;
	VideoFile video;
	VideoStream stream;
	VideoStreamAdapter adapter;
	MediaPlayer client;
	
	@BeforeEach
	void setUp() throws Exception{
		audio = new Audio();
		video = new VideoFile();
		stream = new VideoStream();
		adapter = new VideoStreamAdapter(stream);
	}
	@Test
	public void testClientDirecto() {
		client = new MediaPlayer(adapter);
		assertEquals("Directo.stream",client.playMedia());
	}
	@Test
	public void testClientAudio() {
		client = new MediaPlayer(audio);
		assertEquals("musica.mp3",client.playMedia());
	}
	@Test
	public void testClientVideo() {
		client = new MediaPlayer(video);
		assertEquals("Video.mp4",client.playMedia());
	}
}
