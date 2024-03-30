package ar.edu.info.unlp.ejercicioDemo;

public class AdapterVideoStream extends VideoFile{
	private VideoStream vs = new VideoStream();
	
	public String play() {
		return vs.reproduce();
	}
}
