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
- [Template Method](#template-comportamiento)
- [Composite](#composite-estructural)
- [Strategy](#strategy-comportamiento)
- [State](#state-comportamiento)

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

Este patron no tiene mucho secreto, en el primer objeto se define el esqueleto del algoritmo y en los objetos hijos se implementan los pasos.

### Ejemplo Practico

<details><summary>AbstractClass</summary>

```java
public abstract class Empleado {
	private int cantidadHijos;
	private boolean casado;
	
	public Empleado(int cantidadHijos, boolean casado) {
		this.cantidadHijos = cantidadHijos;
		this.casado = casado;
	}
	public double sueldo() {
		return this.sueldoBasico() + this.sueldoAdicional() - this.descuento();
	}
	public double descuento(){
		return this.sueldoBasico() * 0.13 + this.sueldoAdicional() * 0.5;
	}
	public int getCantidadHijos() {
		return this.cantidadHijos;
	}
	public boolean isCasado() {
		return this.casado;
	}

	public abstract double sueldoBasico();
	public abstract double sueldoAdicional();
}
```
</details>
<details><summary>ConcreteClass1</summary>

```java
public class Pasante extends Empleado {
	private int cantidadExamen;

	public Pasante(int cantidadHijos, boolean casado, int cantidadExamen) {
		super(cantidadHijos, casado);
		this.cantidadExamen = cantidadExamen;
	}

	public double sueldoBasico() {
		return 20000;
	}

	public double sueldoAdicional() {
		return this.cantidadExamen * 2000;
	}
}
```
</details>
<details><summary>ConcreteClass2</summary>

```java
public class Planta extends Empleado{
	private int aniosAntiguedad;

	public Planta(int cantidadHijos, boolean casado, int aniosAntiguedad) {
		super(cantidadHijos, casado);
		this.aniosAntiguedad = aniosAntiguedad;
	}

	public double sueldoBasico() {
		return 50000;
	}

	public double sueldoAdicional() {
		double sum = this.getCantidadHijos() * 2000 + this.aniosAntiguedad * 2000;
		return this.isCasado()? sum + 5000 : sum;
	}
}
```
</details>
<details><summary>ConcreteClass3</summary>

```java
public class Temporario extends Empleado{
	private int cantidadHoras;

	public Temporario(int cantidadHijos, boolean casado, int cantidadHoras) {
		super(cantidadHijos, casado);
		this.cantidadHoras = cantidadHoras;
	}

	public double sueldoBasico() {
		return 20000 + this.cantidadHoras * 300 ;
	}

	public double sueldoAdicional() {
		double sum = this.getCantidadHijos() * 2000;
		return this.isCasado()? sum + 5000 : sum;
	}
}
```
</details>

<details><summary>Test</summary>

```java
public class MediaPlayerTest {
	Empleado pasante;
	Empleado planta;
	Empleado temporario;
	
	@BeforeEach
	void setUp() throws Exception{
		pasante = new Pasante(10, false, 10);
		planta = new Planta(10, true, 10);
		temporario = new Temporario(10, false, 10);
	}
	@Test
	public void testSueldos() {
		assertEquals(27400.0,pasante.sueldo());
		assertEquals(66000.0,planta.sueldo());
		assertEquals(30010.0,temporario.sueldo());
	}
}
```
</details>

## Composite (Estructural)

Este patrón es utilizado principalmente para organizar objetos en estructuras de árbol que representan jerarquías parte-todo. Permite a los clientes tratar objetos individuales y composiciones de objetos de manera uniforme.

![](/archivos/composite.webp)

- `Component` Es la interfaz o clase abstracta que define las operaciones comunes para tanto los objetos simples (Leaf) como los compuestos (Composite). Actúa como la clase base para todos los objetos dentro de la estructura.
	- `Operation():` Debe ser implementado por todos los objetos concretos, tanto hojas como compuestos.
	- `Add(Component):` Agrega subcomponentes, utilizado principalmente en los Composite.
	- `Remove(Component):` Remueve subcomponentes, utilizado principalmente en los Composite.
	- `GetChild(int):` Obtiene un subcomponente específico, utilizado principalmente en los Composite.
- `Leaf` Son los bloques de construcción básicos de la estructura, donde se implementan las operaciones más concretas sin delegar a otros objetos.
- `Composite` Implementa métodos para manejar sus hijos y también implementa la operación que se aplica a cada uno de sus hijos.
	- `Operation()`: Implementa el método realizando una operación que generalmente implica iterar sobre sus hijos y llamando a su método Operation().
	- `Add(Component)`, `Remove(Component)`, `GetChild(int)`: Estos métodos están implementados para manipular y acceder a los subcomponentes.

### Ejemplo Practico

<details><summary>Component</summary>

```java
public abstract class FileSystem{
	private String nombre;
	private LocalDate fecha;

	public FileSystem(String nombre, LocalDate fecha) {
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public abstract int tamanoTotalOcupado();
	public abstract Archivo archivoMasGrande();
	public abstract Archivo archivoMasNuevo();
}
```
</details>
<details><summary>Leaf</summary>

```java
public class Archivo extends FileSystem{
	private int tamano;

	public Archivo(String nombre, LocalDate fecha, int tamano) {
		super(nombre, fecha);
		this.tamano = tamano;
	}
	public Archivo archivoMasGrande() {
		return this;
	}
	public Archivo archivoMasNuevo() {
		return this;
	}
	public int tamanoTotalOcupado() {
		return this.tamano;
	}
}
```
</details>
<details><summary>Composite</summary>

```java
public class Directorio extends FileSystem {
	private List<FileSystem> files;

	public Directorio(String nombre, LocalDate fecha) {
		super(nombre, fecha);
		this.files = new ArrayList<>();
	}

	public void agregar(FileSystem archivo) {
		this.files.add(archivo);	
	}

	public int tamanoTotalOcupado() {
		return (
			this.files.stream()
			.mapToInt(file -> file.tamanoTotalOcupado())
			.sum()
			) + 32;
	}

	public Archivo archivoMasGrande() {
		return this.files.stream()
			.map(file -> file.archivoMasGrande())
			.max((a1,a2) -> Integer.compare(a1.tamanoTotalOcupado(),a2.tamanoTotalOcupado()))
			.orElse(null);
	}

	public Archivo archivoMasNuevo() {
		return this.files.stream()
			.map(file -> file.archivoMasNuevo())
			.max((a1,a2) -> a1.getFecha().compareTo(a2.getFecha()))
			.orElse(null);
	}
}
```
</details>
<details><summary>ClientTest</summary>

```java
public class MediaPlayerTest {
	Archivo archivoChico, archivoGrande;
	Directorio directorio, directorioCompuesto;
	
	@BeforeEach
	void setUp() throws Exception{
		archivoChico = new Archivo("notas.txt", LocalDate.of(2000, 2, 20), 10);
		archivoGrande = new Archivo("apuntes.txt", LocalDate.of(2010, 2, 20), 50);
		
		directorio = new Directorio("Carpeta1", LocalDate.now());
		directorio.agregar(archivoChico);
		directorio.agregar(archivoGrande);
		
		directorioCompuesto = new Directorio("CarpetaCompuesta", LocalDate.now());
		directorioCompuesto.agregar(directorio);
	}
	
	@Test
	public void testEspacio() {
		assertEquals((10 + 50 + 32), directorio.tamanoTotalOcupado());
		assertEquals((10 + 50 + 32 + 32), directorioCompuesto.tamanoTotalOcupado());
		assertEquals(archivoGrande, directorioCompuesto.archivoMasGrande());
		assertEquals(archivoGrande, directorioCompuesto.archivoMasNuevo());
	}
}
```
</details>

## Strategy (Comportamiento)

Define una familia de algoritmos, encapsula cada uno de ellos y los hace intercambiables. Este patrón permite que el algoritmo varíe independientemente de los clientes que lo utilizan.

![](/archivos/Strategy.webp)

- `Context` Delega trabajo a la estrategia asociada, pero mantiene el control sobre cómo y cuándo se llama a las estrategias. Puede proporcionar datos adicionales necesarios para la ejecución de la estrategia.
	- `Ejemplo`  Una aplicación de navegación que puede calcular rutas utilizando diferentes algoritmos de estrategia. El contexto sería el planificador de rutas que decide cuándo y cómo calcular la ruta dependiendo de la estrategia seleccionada por el usuario (la más rápida, la más corta, la más económica, etc.).
- `Strategy` Es una interfaz que define un método común para todas las estrategias concretas.
	- `Ejemplo` En el contexto de una aplicación de navegación, la interfaz `Strategy` podría definir un método `calculateRoute()`, que será implementado de diferente manera por cada estrategia concreta.
- `ConcreteStrategyA`, `ConcreteStrategyB`, `ConcreteStrategyC` Son implementaciones específicas de la interfaz `Strategy`. Cada una proporciona un comportamiento concreto o un algoritmo específico
	- `ConctreteStrategyA` Podría ser una estrategia que calcula la ruta más rápida usando autopistas.
	- `ConctreteStrategyB` Podría calcular la ruta más corta, evitando autopistas
	- `ConctreteStrategyC` Podría optar por la ruta que consume menos combustible.

### Ejemplo Practico

<details><summary>Context</summary>

```java
public class Decodificador {
	private List<Pelicula> grilla;
	private List<Pelicula> reproducidas;
	private Sugerencia criterioSugerencia;
	
	public Decodificador() {
		this.grilla = new ArrayList<>();
		this.reproducidas = new ArrayList<>();
		this.criterioSugerencia = new SugerenciaNovedad();
	}
	public void agregarAGrilla(Pelicula pelicula) { this.grilla.add(pelicula); }
	public void agregarReproducida(Pelicula pelicula) { this.reproducidas.add(pelicula);}
	public void setCriterioSugerencia(Sugerencia sugerencia) { this.criterioSugerencia = sugerencia; }
	public List<Pelicula> obtenerSugerencias() {
		return this.criterioSugerencia.obtenerSugerencias(this);
	}
	public List<Pelicula> getGrilla() { return this.grilla; }
	public List<Pelicula> getReproducidas() { return this.reproducidas; }
}
```

### Pelicula
```java
public class Pelicula {
	private String titulo;
	private Year anioEstreno;
	private double puntaje;
	private List<Pelicula> peliculasSimilares;
	
	public Pelicula(String titulo, double puntaje, Year anioEstreno) {
		this.titulo = titulo;
		this.anioEstreno = anioEstreno;
		this.puntaje = puntaje;
		this.peliculasSimilares = new ArrayList<>();
	}
	public String getTitulo() { return titulo;}
	public Year getAnioEstreno() { return anioEstreno;}
	public double getPuntaje() { return puntaje;}

	public void establecerSimilitud(Pelicula pelicula) {
		if (!this.peliculasSimilares.contains(pelicula)) {
			this.peliculasSimilares.add(pelicula);
			pelicula.establecerSimilitud(this);
		}
	}
	public List<Pelicula> getPeliculasSimilares(){ return this.peliculasSimilares;}
}
```

</details>
<details><summary>Strategy</summary>

```java
public abstract class Sugerencia {
	public List<Pelicula> obtenerSugerencias(Decodificador decodificador){
		return this.sugerirPeliculas(decodificador).stream()
				.filter(pelicula -> !decodificador.getReproducidas().contains(pelicula))
				.limit(3).collect(Collectors.toList());
	}	
	public abstract List<Pelicula> sugerirPeliculas(Decodificador decodificador);
}
```
</details>
<details><summary>ConcreteStrategyA</summary>

```java
public class SugerenciaNovedad extends Sugerencia {

	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getGrilla().stream()
				.sorted((p2,p1) -> p1.getAnioEstreno().compareTo(p2.getAnioEstreno()))
				.collect(Collectors.toList());
	}
}
```
</details>
<details><summary>ConcreteStrategyB</summary>

```java
public class SugerenciaPuntaje extends Sugerencia {
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getGrilla().stream()
				.sorted((p1,p2) -> Double.compare(p2.getPuntaje(), p1.getPuntaje()))
				.collect(Collectors.toList());
	}
}
```
</details>
<details><summary>ConcreteStrategyC</summary>

```java
public class SugerenciaSimilaridad extends Sugerencia {
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getReproducidas().stream()
				.map(pelicula -> pelicula.getPeliculasSimilares()).flatMap(lista -> lista.stream())
				.distinct()
				.collect(Collectors.toList());
	} 
}
```
</details>

<details><summary>DecodificadorTest</summary>

```java
public class DecodificadorTest {
	Decodificador decodificador;
	Pelicula rocky1, rocky2, rocky3, rocky4, rocky5, terminator1, terminator2, terminator3;
	Sugerencia novedad, puntaje, similaridad;
	
	@BeforeEach
	void setUp() throws Exception{
		rocky1 = new Pelicula("Rocky 1", 10, Year.of(2000));
		rocky2 = new Pelicula("Rocky 2", 9, Year.of(2001));
		rocky3 = new Pelicula("Rocky 3", 8, Year.of(2002));
		rocky4 = new Pelicula("Rocky 4", 7, Year.of(2003));
		rocky5 = new Pelicula("Rocky 5", 6, Year.of(2004));
		
		//Se podria establecer la similitud con cada pelicula pero es mucho
		//Se hace con rocky2 porque busca las mimilares con las reproducidas
		rocky2.establecerSimilitud(rocky1);
		rocky2.establecerSimilitud(rocky3);
		rocky2.establecerSimilitud(rocky4);
		rocky2.establecerSimilitud(rocky5);
		
		terminator1 = new Pelicula("Terminator1", 1, Year.of(2020));
		terminator2 = new Pelicula("Terminator2", 2, Year.of(2021));
		terminator3 = new Pelicula("Terminator3", 3, Year.of(2022));
		
		decodificador = new Decodificador();
		decodificador.agregarAGrilla(rocky1);
		decodificador.agregarAGrilla(rocky2);
		decodificador.agregarAGrilla(rocky3);
		decodificador.agregarAGrilla(rocky4);
		decodificador.agregarAGrilla(rocky5);
		decodificador.agregarAGrilla(terminator1);
		decodificador.agregarAGrilla(terminator2);
		decodificador.agregarAGrilla(terminator3);
		
		decodificador.agregarReproducida(rocky2);
		decodificador.agregarReproducida(rocky4);
	}
	@Test
	public void testSugerenciaNovedad() {
		List<Pelicula> ultimas3 = new ArrayList<>();
		ultimas3.add(terminator3);
		ultimas3.add(terminator2);
		ultimas3.add(terminator1);
		assertEquals(ultimas3, decodificador.obtenerSugerencias());
	}
	@Test
	public void testSugerenciaPuntaje() {
		puntaje = new SugerenciaPuntaje();
		decodificador.setCriterioSugerencia(puntaje);
		List<Pelicula> masPuntaje = new ArrayList<>();
		masPuntaje.add(rocky1);
		masPuntaje.add(rocky3);
		masPuntaje.add(rocky5);
		assertEquals(masPuntaje, decodificador.obtenerSugerencias());
	}
	
	@Test
	public void testSugerenciaSimilaridad() {
		similaridad = new SugerenciaSimilaridad();
		decodificador.setCriterioSugerencia(similaridad);
		//Son las 3 similares sin reproducir
		List<Pelicula> similaresRocky = new ArrayList<>();
		similaresRocky.add(rocky1);
		similaresRocky.add(rocky3);
		similaresRocky.add(rocky5);
		assertEquals(similaresRocky, decodificador.obtenerSugerencias());
	}
}
```

</details>

## State (Comportamiento)

Se utiliza para permitir a un objeto alterar su comportamiento cuando su estado interno cambia. El objeto parecerá cambiar su clase.

![](/archivos/state.webp)

- `Context` Accede a la interfaz de State para realizar su comportamiento, que cambia dinámicamente según el estado actual.
	- `request()` Este método debería delegar la operación a la instancia actual de State
	- `Ejemplo` Imagina una aplicación de procesamiento de pedidos donde el `Context` es un `Pedido`. El `Pedido` puede tener varios estados como `Pendiente`, `Pagado`, `Enviado`, y `Entregado`. Cada uno de estos estados alterará cómo se procesan ciertas operaciones (por ejemplo, no se puede enviar un pedido antes de que esté pagado).
- `State` es una interfaz o una clase abstracta que define un método `handle()` que todas las clases concretas de estado implementarán.
	- `Ejemplo` En el sistema de pedidos, `State` tendría un método `handle()` que podría ser llamado algo así como `procesarSiguientePaso()`. Este método determinaría qué hacer a continuación con el pedido (por ejemplo, procesar el pago, enviar el pedido, etc.).
- `ConcreteStateA`, `ConcreteStateB` Cada clase representa un estado específico del `Context` y proporciona su propia implementación del método `handle()`.
	- `ConcreteStateA` (PedidoPagado): Este estado podría manejar la lógica de preparar el pedido para el envío. La implementación de `handle()` en este estado podría cambiar el estado del pedido a `Enviado` si todo está listo para el envío.
	- `ConcreteStateB` (PedidoEnviado): Este estado manejaría las acciones posteriores al envío, como notificar al cliente o cambiar el estado a `Entregado`. La implementación de `handle()` aquí podría involucrar la verificación del progreso del envío y la actualización del estado del pedido.

<details><summary>Preguntar ¿Cuando el objeto state debe tener una instancia del context</summary>

En el patrón de diseño State, es común que los objetos de estado (`State`) tengan acceso al objeto de contexto (`Context`) para poder realizar cambios en el estado del contexto directamente. Sin embargo, si los objetos `State` tienen una referencia directa al `Context` o no depende del diseño específico y de los requisitos del sistema. Aquí te detallo los dos enfoques posibles:

### 1. State con Referencia a Context
- **Descripción**: En esta configuración, cada objeto `State` mantiene una referencia al `Context`. Esto les permite no solo manejar su comportamiento específico sino también cambiar el estado del `Context` directamente cuando se cumplan ciertas condiciones.
- **Ventajas**:
  - **Control Directo**: Los estados pueden controlar las transiciones a otros estados sin involucrar al `Context`, lo que simplifica el código del `Context`.
  - **Flexibilidad**: Facilita la implementación de comportamientos complejos que dependen del estado y contexto actuales, como revertir a un estado anterior o saltar a estados no secuenciales.
- **Ejemplo**: Un objeto `State` en un juego puede verificar si el jugador ha alcanzado ciertos puntos de logro y directamente cambiar el estado del juego para reflejar un nuevo nivel o modo de juego.

### 2. State sin Referencia Directa a Context
- **Descripción**: En esta configuración, los objetos `State` no mantienen una referencia directa al `Context`. En su lugar, dependen de que el `Context` pase de alguna forma cualquier información necesaria y maneje explícitamente los cambios de estado.
- **Ventajas**:
  - **Desacoplamiento**: Mayor desacoplamiento entre el estado y el contexto, lo que puede facilitar la prueba y mantenimiento de cada clase por separado.
  - **Reusabilidad**: Los objetos `State` pueden ser más fácilmente reutilizables en diferentes contextos si no están fuertemente acoplados a una clase de contexto específica.
- **Ejemplo**: Un objeto `State` en una aplicación de procesamiento de documentos podría realizar operaciones como guardar o cargar archivos sin necesitar saber en qué estado específico de la UI se encuentra la aplicación.

</details>

### Ejemplo Practico

<details><summary>Context</summary>

```java
public class Excursion {
	private String nombre;
	private Estado estado;
	private List<Usuario> inscriptos;
	private List<Usuario> enEspera;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMinimo, int cupoMaximo) {
		this.nombre = nombre;
		this.estado = new Provisoria(this);
		this.inscriptos = new ArrayList<>();
		this.enEspera = new ArrayList<>();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMinimo = cupoMinimo;
		this.cupoMaximo = cupoMaximo;
	}
	
	public List<Usuario> getInscriptos() {
		return inscriptos;
	}

	public List<Usuario> getEnEspera() { 
		return enEspera;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getCupoMinimo() {
		return cupoMinimo;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void inscribir (Usuario unUsuario) {
		this.estado.inscribir(unUsuario);
	}
	
	public boolean alcanzoMinimo() {
		return this.getInscriptos().size() >= this.cupoMinimo;
	}
	
	public boolean alcanzoMaximo() {
		return this.getInscriptos().size() >= this.cupoMaximo;
	}
	public String obtenerInformacion() {
		return "La excursion '" + this.nombre 
				+ "' tiene un costo de " + this.costo
				+ " con fecha de inicio " + this.fechaInicio.toString()
				+ " y fecha de fin " + this.fechaFin.toString()
				+ ".\nEl punto de encuentro es en '" + this.puntoEncuentro
				+ "'. " + this.estado.obtenerInformacion();
	}
	public String getMailsInscriptos() {
		return this.inscriptos.stream()
				.map(inscripto -> inscripto.getMail())
				.reduce("",(acumulator, element)-> acumulator +"\n" + element);
	}
}
```

#### Usuario
```java
public class Usuario {
    private String nombre;
    private String apellido;
    private String mail;

    public Usuario(String nombre, String apellido, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }
}
```

</details>

<details><summary>State</summary>

```java
public abstract class Estado {
    protected Excursion excursion;

    public Estado(Excursion excursion) {
        this.excursion = excursion;
    }

    public abstract void inscribir(Usuario unUsuario);
    public abstract String obtenerInformacion();
}
```

</details>

<details><summary>ConcreteStateA</summary>

```java
public class Provisoria extends Estado {
    public Provisoria(Excursion excursion) {
        super(excursion);
    }

    public void inscribir(Usuario unUsuario) {
        if (!this.excursion.alcanzoMaximo()) {
            this.excursion.getInscriptos().add(unUsuario);
            if (this.excursion.alcanzoMinimo()) {
                this.excursion.setEstado(new Definitiva(this.excursion));
            }
        }
    }

    public String obtenerInformacion() {
        return "\nActualmente faltan " + (this.excursion.getCupoMinimo() - this.excursion.getInscriptos().size())
                + " personas para alcanzar el cupo mínimo.";
    }
}
```

</details>

<details><summary>ConcreteStateB</summary>

```java
public class Definitiva extends Estado {
    public Definitiva(Excursion excursion) {
        super(excursion);
    }

    public void inscribir(Usuario unUsuario) {
        if (!this.excursion.alcanzoMaximo()) {
            this.excursion.getInscriptos().add(unUsuario);
        } else {
            this.excursion.setEstado(new Completa(this.excursion));
            this.excursion.inscribir(unUsuario); 
        }
    }

    public String obtenerInformacion() {
        return "\nLa excursión está confirmada y tiene espacio para más inscripciones.";
    }
}
```

</details>

<details><summary>ConcreteStateC</summary>

```java
public class Completa extends Estado {
    public Completa(Excursion excursion) {
        super(excursion);
    }

    public void inscribir(Usuario unUsuario) {
        this.excursion.getEnEspera().add(unUsuario);
    }

    public String obtenerInformacion() {
        return "\nLa excursión está completa. Todos los nuevos inscriptos serán puestos en lista de espera.";
    }
}
```
</details>

<details><summary>ExcursionTest</summary>

```java
public class ExcursionTest {
	Excursion excursion;
	Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception{
		usuario = new Usuario("Fabian", "Martinez", "fabian@gmail.com");
		excursion = new Excursion("Viaje", 
				LocalDate.of(2000, 1, 1), 
				LocalDate.of(2000,2,1), "La Ciudad", 100, 3, 6);
	}
	@Test
	public void testExcursion() {
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		assertEquals(3, excursion.getInscriptos().size());
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		assertEquals(6, excursion.getInscriptos().size());
		excursion.inscribir(usuario);
		assertEquals(1, excursion.getEnEspera().size());
	}
}
```
</details>

> Tengo que consultar porque tengo bajo acoplamiento, pero no se si esta bien

## Decorator (Estructural)

Permite añadir nuevas funcionalidades a objetos de manera dinámica, ofreciendo una alternativa flexible a la herencia para extender funcionalidades.

![](/archivos/decorator.webp)

- `Component`
- `ConcreteComponent`	
- `Decorator`
- `ConcreteDecoratorA`, `ConcreteDecoratorB`