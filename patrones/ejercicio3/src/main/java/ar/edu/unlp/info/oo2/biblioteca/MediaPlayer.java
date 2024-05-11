package ar.edu.unlp.info.oo2.biblioteca;

public class MediaPlayer {
	private Media media;
	public MediaPlayer(Media media) {
		this.media = media;
	}	
	public String playMedia() {
		return media.play();
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
}