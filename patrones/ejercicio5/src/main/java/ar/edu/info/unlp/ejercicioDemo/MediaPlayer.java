package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
	private List<Media> media = new ArrayList<Media>(); 
	
	public void play() {
		System.out.println("Play");
	}
	
	public void agregarMedia(Media m) {
		this.media.add(m);
	}
	
	public String concatenarNombresMedia() {
        String nombresConcatenados = "";
        for (int i = 0; i < media.size(); i++) {
            nombresConcatenados += media.get(i).play(); 
            if (i < media.size() - 1) {
                nombresConcatenados += ", "; 
            }
        }
        return nombresConcatenados;
    }
}
