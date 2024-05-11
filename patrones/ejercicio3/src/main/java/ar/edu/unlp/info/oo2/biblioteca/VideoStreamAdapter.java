package ar.edu.unlp.info.oo2.biblioteca;

public class VideoStreamAdapter implements Media {
	private VideoStream adaptee;
	
	public VideoStreamAdapter(VideoStream adaptee) {
		this.adaptee = adaptee;
	}
	public String play() {
		return adaptee.reproduce();
	}
}