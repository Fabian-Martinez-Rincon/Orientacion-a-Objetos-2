<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

Antes de empezar vamos a ver que tipos de patrones tenemos, durante la materia solo vemos 3 tipos:
- `Patrones Creacionales` Estos patrones están relacionados con los mecanismos de creación de objetos, buscando adaptar el proceso de creación a diferentes situaciones. Los patrones creacionales ocultan los detalles de creación de objetos y ayudan a hacer el sistema independiente de cómo sus objetos son creados, compuestos y representados.
- `Patrones Estructurales` Estos patrones se ocupan de cómo las clases y objetos son compuestos para formar estructuras más grandes. Los patrones estructurales ayudan a asegurar que si cambia una parte del sistema, el sistema completo no necesita cambiar. También son útiles para compartir funcionalidades de una manera que ofrece ventajas significativas.
- `Patrones de Comportamiento` Estos patrones están relacionados con algoritmos y la asignación de responsabilidades entre objetos. Lo que describen es cómo interactúan y distribuyen la responsabilidad entre las clases y objetos. 

---

- [Adapter](#adapter-estructural)
- [Template Method]()

## Adapter (Estructural)

Permite a interfaces incompatibles trabajar juntas. Su principal uso es hacer que el código existente funcione con otra interfaz, sin alterar el código original. Actúa como un puente entre estas interfaces.

![Adapter](/archivos/adapter.webp)

- ``Cliente`` Es la parte que requiere un servicio.
    - `Ejemplo` Un programa de análisis de datos que requiere cargar datos. Supongamos que está diseñado para trabajar con datos en formato JSON, pero los datos disponibles están en formato XML.
- ``Target`` Es la interfaz en la que el cliente realiza las solicitudes.
   - `Ejemplo` En el caso de nuestro programa de análisis de datos, `Target` podría ser una interfaz con un método como `loadData()` que está diseñado para aceptar datos en formato JSON.
- ``Adapter`` Traduce las solicitudes del `Target` en una forma que el Adaptee puede entender, haciendo cualquier adaptación necesaria.
    - `Ejemplo` Un adaptador de datos que implementa `loadData()` donde, en lugar de requerir datos en formato JSON, convierte datos en formato XML a JSON y luego invoca el método `specificRequest()` del `Adaptee` para procesar los datos.
- ``Adaptee`` es la clase que tiene las funcionalidades que necesitamos, pero su interfaz no es compatible con lo que el `Client` espera. Esta clase no sabe nada sobre `Target` y trabaja de manera independiente.

### Ejemplo Practico

<details><summary>Client</summary>

```java
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
```
</details>

<details><summary>Target</summary>

```java
public interface Media {
	public String play();
}
```
</details>

<details><summary>Adapter</summary>

```java
public class VideoStreamAdapter implements Media {
	private VideoStream adaptee;
	
	public VideoStreamAdapter(VideoStream adaptee) {
		this.adaptee = adaptee;
	}
	public String play() {
		return adaptee.reproduce();
	}
}
```
</details>

<details><summary>Adaptee</summary>

```java
public class VideoStream {
	public String reproduce() {
		return "Directo.stream";
	}
}
```
</details>

<details><summary>Hijos de Media</summary>

```java
public class Audio implements Media {
	public String play() {
	    return "musica.mp3";
	}
}
```


```java
public class VideoFile implements Media {
	public String play() {
		return "Video.mp4";
	}
}
```

</details>

<details><summary>MediaPlayerTest</summary>

```java
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
```
</details>

## Template (Comportamiento)

Define la estructura de un algoritmo en una operación, delegando algunos pasos a las subclases. Permite que las subclases redefinan ciertos pasos de un algoritmo sin cambiar su estructura general.

![](/archivos/template.webp)

