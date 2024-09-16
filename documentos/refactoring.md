# 🧢 Refactoring

---

### Malos Olores y como Actuar

- [Declaración de atributos pública](#declaración-de-atributos-pública)
- [Mala asignación de responsabilidades](#mala-asignación-de-responsabilidades)
- [Reinventando la Rueda](#reinventando-la-rueda)
- [Nombre Misterioso/Poco Explicativo](#nombre-misteriosopoco-explicativo)
- [Envidia de Atributos](#envidia-de-atributos)
- [Metodo Largo](#metodo-largo)
- [Switch Statements](#switch-statements)

---

### Declaración de atributos pública

La declaración pública de atributos de una clase, genera una ruptura del encapsulamiento. Declaramos los atributos como privados y hacemos que se acceda a ellos sólo a través de los getters y setters.

<table>
<tr><td>Antes del Refactoring</td><td>Encapsulate Field</td></tr>
<tr><td>

```java
public class Persoona {
    public List<Llamada> lista1 = new ArrayList<Llamada>();
    public String t;
    public String nya;
    public String tel;
    public String cuit;
    public String doc;
    public Persoona1 sis;
}
```

```java
else if (t.equals("juridica")) {
    String tel = lista3.guia.last();
    lista3.guia.remove(tel);
    var.nya = nombre;
    var.t = t;
    var.tel = tel;
    var.cuit = data;
    var.sis = this;
}
```
</td><td>

```java
public class Persoona {
    private List<Llamada> lista1 = new ArrayList<Llamada>();
    private String t;
    private String nya;
    private String tel;
    private String cuit;
    private String doc;
    private Persoona1 sis;
}
```

```java
else if (t.equals("juridica")) {
    String tel = lista3.guia.last();
    lista3.guia.remove(tel);
    var.setNya(nombre);
    var.setT(t);
    var.setTel(tel);
    var.setCuit(data);
}
var.setSis(this);
```
</td></tr>

</table>

## Mala asignación de responsabilidades

Se observa una mala asignación de responsabilidades en la clase X que en la mayoria de las veces esta asociada a una evidente envidia de atributos.

- [Move Method](#move-method)

### Move Method

En este ejemplo, la clase `Persoona` no deberia tener esta responsabilidad, y la delegamos a la clase `GuiaTelefonica`. `Move Method` Del metodo `agregarTelefono` a la clase GuiaTelefonica

Mecánica `Move Method`:
1. Revisar las v.i. usadas por el método a mover. Tiene sentido moverlas también?
2. Revisar super y subclases por otras declaraciones del método. Si hay otras tal vez no se pueda mover.
3. Crear un nuevo método en la clase target cuyo nombre explique su propósito
4. Copiar el código a mover al nuevo método. Ajustar lo que haga falta
5. Compilar la clase target
6. Determinar como referenciar al target desde el source
7. Reemplazar el método original por llamada a método en target
8. Compilar y testear
9. Decidir si remover el método original o mantenerlo como delegación


<table>
<tr><td>Antes del Refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public Class Persoona{
    public boolean agregarTelefono(String str) {
        boolean encontre = lista3.guia.contains(str);
        if (!encontre) {
            lista3.guia.add(str);
            encontre = true;
            return encontre;
        } else {
            encontre = false;
            return encontre;
        }
    }
}
```
</td><td>

```java
public class Persoona {
    public boolean agregarTelefono(String str) {
        return this.lista3.agregarTelefono(str);
    }
}
public class GuiaTelefonica {
    public boolean agregarTelefono(String str) {
        boolean encontre = guia.contains(str);
        if (!encontre) {
            guia.add(str);
            encontre = true;
            return encontre;
        } else {
            encontre = false;
            return encontre;
        }
    }
}
```
</td></tr>
</table>

---

### Extract Method y Move Method

`Extract Method` del método `obtenerNuevoTelefono` y despues un `Move Method` a la clase GuiaTelefonica

<table>
<tr><td>Antes del refactoring</td><td>Extract Method</td><td>Move Method</td></tr>

<tr>
<td>

```java
public Persoona registrarUsuario(String data, String nombre, String t) {
    Persoona var = new Persoona();
    if (t.equals("fisica")) {
        var.setNya(nombre);
        String tel = lista3.guia.last();
        lista3.guia.remove(tel);
        var.setT(t);
        var.setTel(tel);
        var.setDoc(data);
    } else if (t.equals("juridica")) {
        String tel = lista3.guia.last();
        lista3.guia.remove(tel);
        var.setNya(nombre);
        var.setT(t);
        var.setTel(tel);
        var.setCuit(data);
    }
    var.setSis(this);
    lista1.add(var);
    return var;
}
```
</td>

<td>

```java
public class Persoona {
    public String obtenerNuevoTelefono() {
        String tel = this.guia.last();
        this.guia.remove(tel);
        return tel;
    }
    public Persoona registrarUsuario(String data, String nombre, String t) {
        Persoona var = new Persoona();
        if (t.equals("fisica")) {
            var.setNya(nombre);
            String tel = this.obtenerNuevoTelefono();
            var.setT(t);
            var.setTel(tel);
            var.setDoc(data);
        } else if (t.equals("juridica")) {
            String tel = this.obtenerNuevoTelefono();
            var.setNya(nombre);
            var.setT(t);
            var.setTel(tel);
            var.setCuit(data);
        }
        var.setSis(this);
        lista1.add(var);
        return var;
    }
}
```
</td><td>

```java
public class GuiaTelefonica {
    public String obtenerNuevoTelefono() {
        String tel = this.guia.last();
        this.guia.remove(tel);
        return tel;
    }
}
public class Persoona{
    public Persoona registrarUsuario(String data, String nombre, String t) {
        Persoona var = new Persoona();
        if (t.equals("fisica")) {
            var.setNya(nombre);
            String tel = this.lista3.obtenerNuevoTelefono();
            var.setT(t);
            var.setTel(tel);
            var.setDoc(data);
        } else if (t.equals("juridica")) {
            String tel = this.lista3.obtenerNuevoTelefono();
            var.setNya(nombre);
            var.setT(t);
            var.setTel(tel);
            var.setCuit(data);
        }
        var.setSis(this);
        lista1.add(var);
        return var;
    }
}
```
</td></tr>
</table>


---

## Reinventando la Rueda

Basicamente es usar logica que ya se encuentra en una libreria, el refactoring es `sustituir algoritmo`. 

Aca dejo ejemplos

<table>
<tr><td>Antes del refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public boolean agregarTelefono(String str) {
    boolean encontre = guia.contains(str);
    if (!encontre) {
        guia.add(str);
        encontre = true;
        return encontre;
    } else {
        encontre = false;
        return encontre;
    }
}
```
</td><td>

```java
public boolean agregarTelefono(String str) {
    return this.guia.add(str);
}
```
</td></tr>
</table>

Tambien se puede aplicar de `for` a un `stream`

<table>
<tr><td>Antes del refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public double calcularPromedioEdades() {
    int totalEdades = 0;
    for (Empleado empleado : personal) {
        totalEdades = totalEdades + empleado.getEdad();
    }
    return totalEdades / personal.size();
}
```
</td><td>

```java
public double calcularPromedioEdades(){ 
    return personal.stream()
        .mapToDouble(empleado -> empleado.getEdad())
        .sum()/personal.size(); 
}
```
</td></tr>
</table>

---

## Nombre Misterioso/Poco Explicativo

En caso de que se tengan que modificar los metodos, hacemos el `Rename Method` para que el nombre sea mas explicativo y modificamos actualizamos todas las llamas que haga referencia a este metodo.

Para los parametros lo mismo `Rename Parameter` pero solo modificamos los parametros que se encuentran en la firma del metodo.

Siempre es el rename que corresponda.

<table>
<tr><td>Antes del refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
protected double lmtCrdt() {...
protected double mtFcE(LocalDate f1, LocalDate f2) {...
protected double mtCbE(LocalDate f1, LocalDate f2) {...
```

</td><td>

```java
protected double obtenerLimiteCredito() { ... }
protected double calcularMontoFacturadoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) { ... }
protected double calcularMontoCobradoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) { ... }
```
</td></tr>
</table>

---

## Envidia de Atributos

La envidia de atributos es cuando una clase usa mas atributos de otra clase que la propia.

- Hacemos un `Move Method` del metodo `registrarLlamada` y en `Llamada` hacemos uso del constructor.

### Ejemplo 1

<table>
<tr><td>Antes del refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public class Persoona{
    public Llamada registrarLlamada(Persoona q, Persoona q2, String t, int d) {
        Llamada x = new Llamada();
        x.tipoDeLlamada = t;
        x.setEmisor(q.getTel());
        x.setRemitente(q2.getTel());
        x.dur = d;
        q.getLista1().add(x);
        return x;
    }
}
```
</td><td>

```java
public class Llamada{
    public Llamada registrarLlamada(Persoona q, Persoona q2, String t, int d) {
        Llamada x = new Llamada(t, q.getTel(), q2.getTel(), q, d);
        q.getLista1().add(x);
        return x;
    }
}
```
</td></tr>
</table>

### Ejemplo 2

- Hacemos un `Extract Method` y despues hacemos un `Move Method` a la clase `Llamada`

<table>
<tr><td>Antes del refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public class Persoona{
    public double calcularMontoTotalLlamadas(Persoona p) {
        double c = 0;
        Persoona aux = null;
        for (Persoona pp : lista1) {
            if (pp.getTel() == p.getTel()) {
                aux = pp;
                break;
            }
        }
        if (aux == null) return c;
        if (aux != null) {
            for (Llamada l : aux.getLista1()) {
                double auxc = 0;
                if (l.tipoDeLlamada == "nacional") {
                    auxc += l.dur * 3 + (l.dur * 3 * 0.21);
                } else if (l.tipoDeLlamada == "internacional") {
                    auxc += l.dur * 200 + (l.dur * 200 * 0.21);
                }
                c += auxc;
            }
        }
        return c;
    }
}
```
</td><td>

```java
public class Llamada{
    public double calcularMontoLlamada() {
        if (this.tipoDeLlamada == "nacional") {
            return this.dur * 3 + (this.dur * 3 * 0.21);
        } else if (this.tipoDeLlamada == "internacional") {
            return this.dur * 200 + (this.dur * 200 * 0.21);
        }
        return 0;
    }
}
public class Persoona{
    public double calcularMontoTotalLlamadas(Persoona p) {
        double c = 0;
        Persoona aux = null;
        for (Persoona pp : lista1) {
            if (pp.getTel() == p.getTel()) {
                aux = pp;
                break;
            }
        }
        if (aux == null) return c;
        if (aux != null) {
            for (Llamada l : aux.getLista1()) {
                double auxc = l.calcularMontoLlamada();
                c += auxc;
            }
        }
        return c;
    }
}
```
</td></tr>
</table>

---

## Metodo Largo

En la clase `Persoona` observamos que el método `calcularMontoTotalLlamada()` posee varias responsabilidades que podrían delegarse en métodos diferentes para mejorar la legibilidad del código y respetar el principio de Single responsibility.

<table>
<tr><td>Antes del refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public class Persoona {
    public double calcularMontoTotalLlamadas() {
        return this.lista1
            .stream()
            .mapToDouble(llamada -> {
                double auxc = llamada.calcularMontoLlamada();
                
                if (this.getT() == "fisica") {
                    auxc -= auxc * descuentoFis;
                } else if (this.getT() == "juridica") {
                    auxc -= auxc * descuentoJur;
                }
                
                return auxc;
            })
            .sum();
    }
}
```
</td><td>

```java
public class Persoona {
    private double computarMontoLlamada(Llamada llamada) {
        double auxc = llamada.calcularMontoLlamada()
        if (this.getT() == "fisica") {
            auxc -= auxc * descuentoFis;
        } 
        else if (this.getT() == "juridica") {
            auxc -= auxc * descuentoJur;
        }       
        return auxc;
    }
    public double calcularMontoTotalLlamadas() {
        return this.lista1
            .stream()
            .mapToDouble(llamada -> this.computarMontoLlamada(llamada))
            .sum();
    }
}
```
</td></tr>
</table>

En el anterior codigo seguis teniendo malos olores pero eso es para otro refactoring.

---


## Switch Statements

Ejemplo de la practica

<table>
<tr><td>Antes del Refactoring</td><td>Despues del refactoring</td></tr>

<tr><td>

```java
public class Partido{
    public String puntosJugadorToString(Jugador unJugador) {
        int totalGames = 0;
        String result = "Puntaje del jugador: " + unJugador.nombre() + ": ";
        for (int gamesGanados: puntosPorSetDe(unJugador)) {
            result += Integer.toString(gamesGanados) + ";";
            totalGames += gamesGanados; 
        }
        result += "Puntos del partido: ";
        if (unJugador.zona() == "A")
            result += Integer.toString(totalGames * 2);
        if (unJugador.zona() == "B")
            result += Integer.toString(totalGames);
        if (unJugador.zona() == "C") 
            if (this.ganador() == unJugador)
                result += Integer.toString(totalGames);
            else
                result += Integer.toString(0);
            return result;
    }
}
```
</td><td>

```java
public clase Partido{
    public String puntosJugadorToString(Jugador unJugador) {
        return unJugador.puntosEnPartidoToString(this);
    }
}
public abstract class Jugador {
    public abstract String puntosGanadosEnPartido(Partido partido);

    public String puntosEnPartidoToString(Partido partido) {
        int totalGames = 0;
        String result = "Puntaje del jugador: " + nombre() + ": ";
        for (int gamesGanados: partido.puntosPorSetDe(this)) {
            result += Integer.toString(gamesGanados) + ";";
            totalGames += gamesGanados;
        }
        result += "Puntos del partido: ";
        result += Integer.toString(this.puntosGanadosEnPartido(partido, totalGames));
        return result;
    }
}
public class JugadorZonaA {
    public int puntosGanadosEnPartido(Partido partido, int totalGames) {
        return totalGames * 2;
    }
}
```
</td></tr>
</table>



![image](https://github.com/user-attachments/assets/eee3b9ae-3063-4df1-8370-ebd9d872f16e)

- Aplico Move Method
    - Partido>>puntosJugadorToString(Jugador j) a Jugador>>puntosEnPartidoToString(Partido p)
- Aplico Replace Conditional with Polymorphism 
    - E n Jugador>>puntosEnPartidoToString(Partido p)

Proceso para realizar el refactoring

1. Crear la jerarquía de clases necesaria
2. Si el condicional es parte de un método largo: Extract 
Method
3. Por cada subclase:
    1. Crear un método que sobreescribe al método que contiene el
    condicional
    2. Copiar el código de la condición correspondiente en el método
    de la subclase y ajustar
    3. Compilar y testear
    4. Borrar la condición y código del branch del método en la 
    superclase
    5. Compilar y testear
4. Hacer que el método en la superclase sea abstract


## STOP 🛑

Vamos a seguir el ejemplo de la practica con las instrucciones de arriba


```java
public class Usuario {
    String tipoSubscripcion;
    // ...
    public void setTipoSubscripcion(String unTipo) {
        this.tipoSubscripcion = unTipo;
    }
    public double calcularCostoPelicula(Pelicula pelicula) {
        double costo = 0;
        if (tipoSubscripcion=="Basico") {
            costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
        }
        else if (tipoSubscripcion== "Familia") {
            costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
        }
        else if (tipoSubscripcion=="Plus") {
            costo = pelicula.getCosto();
        }
        else if (tipoSubscripcion=="Premium") {
            costo = pelicula.getCosto() * 0.75;
        }
        return costo;
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...
    public double getCosto() {
        return this.costo;
    }
    public double calcularCargoExtraPorEstreno(){
        // Si la Película se estrenó 30 días antes de la fecha actual, retorna
        un cargo de 0$, caso contrario, retorna un cargo extra de 300$
        return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) )
        > 30 ? 0 : 300;
    }
}
```


El Paso a Paso Seria

1. Crear la jerarquía de clases necesaria
2. Si el condicional es parte de un método largo: Extract 
Method
3. Por cada subclase:
    1. Crear un método que sobreescribe al método que contiene el
    condicional
    2. Copiar el código de la condición correspondiente en el método
    de la subclase y ajustar
    3. Compilar y testear
    4. Borrar la condición y código del branch del método en la 
    superclase
    5. Compilar y testear
4. Hacer que el método en la superclase sea abstract

### Paso 1: Crear la jerarquía de clases necesaria

`Refactoring`: Extract Subclass

```java
public class UsuarioBasico extends Usuario { }

public class UsuarioFamilia extends Usuario { }

public class UsuarioPlus extends Usuario { }

public class UsuarioPremium extends Usuario { }
```

### Paso 2: Extraer Método (Extract Method) si el condicional es parte de un método largo

En este caso, el método `calcularCostoPelicula` es corto, por lo que no es necesario extraer un método.

### Paso 3: Por cada subclase:

#### 3.1: Crear un método que sobrescriba al método que contiene el condicional

`Refactoring`: Push Down Method

El método calcularCostoPelicula es movido a cada una de las subclases.

```java
public class UsuarioBasico extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return 0;  // Método sobrescrito, aún sin lógica
    }
}

public class UsuarioFamilia extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return 0;  // Método sobrescrito, aún sin lógica
    }
}

public class UsuarioPlus extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return 0;  // Método sobrescrito, aún sin lógica
    }
}

public class UsuarioPremium extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return 0;  // Método sobrescrito, aún sin lógica
    }
}
```

#### 3.2: Copiar el código de la condición correspondiente en el método de la subclase y ajustar

Para cada subclase, copiamos la lógica del cálculo de costo que corresponde a cada tipo de suscripción y ajustamos el método.

`Refactoring`: Move Method

La lógica correspondiente a cada caso en el condicional se copia en las subclases, ajustándose a las necesidades de cada una.
Esto elimina la necesidad de un condicional en la clase base.

```java
public class UsuarioBasico extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();  // Lógica para "Basico"
    }
}

public class UsuarioFamilia extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;  // Lógica para "Familia"
    }
}

public class UsuarioPlus extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto();  // Lógica para "Plus"
    }
}

public class UsuarioPremium extends Usuario {
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto() * 0.75;  // Lógica para "Premium"
    }
}
```

#### 3.3: Compilar y testear

Compilamos el código y ejecutamos los tests de la clase refactoringTest. Todos los tests deben pasar.

#### 3.4: Borrar la condición y código del branch del método en la superclase

Una vez que la lógica de cada condición ha sido movida a la subclase correspondiente, eliminamos las condiciones del método de la superclase.

`Refactoring`: Replace Conditional with Polymorphism

Una vez que el condicional fue movido a las subclases y la lógica ha sido eliminada de la clase base, se borra el método que contenía el condicional.

```java
public class Usuario {
    public double calcularCostoPelicula(Pelicula pelicula){

    }
}
```

#### 3.5: Compilar y testear

Compilamos el código nuevamente y ejecutamos los tests para asegurarnos de que todo sigue funcionando correctamente.

### Paso 4: Hacer que el método en la superclase sea abstract

`Refactoring`: Pull Up Method to Abstract Class

Se convierte el método calcularCostoPelicula en un método abstracto en la clase Usuario. Esto asegura que todas las subclases deben implementar este método.

```java
public abstract class Usuario {
    public abstract double calcularCostoPelicula(Pelicula pelicula);
}
```

### Refactoring

En la clase de test, antes se usaba el método setTipoSubscripcion para cambiar el tipo de usuario. Después del refactoring, instancias de las subclases reemplazan ese comportamiento.

`Refactoring`: Replace Type Code with Subclasses

En lugar de utilizar un campo de tipo de suscripción en la clase Usuario, se crea una instancia de la subclase correspondiente.

<table>
<tr><td>Antes del Refactoring</td><td>Despues del Refactoring</td></tr><tr><td>

```java
public class refactoringTest {

    Pelicula pelicula;
    Usuario usuario;

    @BeforeEach
    void setUp() throws Exception {
        usuario = new Usuario();
        pelicula = new Pelicula(10);
    }

    @Test
    public void testBasico() {
        usuario.setTipoSubscripcion("Basico");
        assertEquals(10.0, usuario.calcularCostoPelicula(pelicula));
    }

    @Test
    public void testFamilia() {
        usuario.setTipoSubscripcion("Familia");
        assertEquals(9, usuario.calcularCostoPelicula(pelicula));
    }

    @Test
    public void testPremium() {
        usuario.setTipoSubscripcion("Premium");
        assertEquals(7.5, usuario.calcularCostoPelicula(pelicula));
    }
}
```
</td><td>

```java
public class refactoringTest {

    Pelicula pelicula;
    Usuario usuario;

    @BeforeEach
    void setUp() throws Exception {
        pelicula = new Pelicula(10);
    }

    @Test
    public void testBasico() {
        usuario = new UsuarioBasico();
        assertEquals(10.0, usuario.calcularCostoPelicula(pelicula));
    }

    @Test
    public void testFamilia() {
        usuario = new UsuarioFamilia();
        assertEquals(9, usuario.calcularCostoPelicula(pelicula));
    }

    @Test
    public void testPlus() {
        usuario = new UsuarioPlus();
        assertEquals(10, usuario.calcularCostoPelicula(pelicula));
    }

    @Test
    public void testPremium() {
        usuario = new UsuarioPremium();
        assertEquals(7.5, usuario.calcularCostoPelicula(pelicula));
    }
}
```
</td></tr>
</table>


Resumen de refactorings usados:
- `Extract Subclass`: Creación de subclases para cada tipo de usuario.
- `Push Down Method`: Movemos la lógica específica de cada tipo de suscripción a sus respectivas subclases.
- `Move Method`: El método que contenía el condicional es movido a las subclases.
- `Replace Conditional with Polymorphism`: Eliminamos el condicional y usamos polimorfismo.
- `Pull Up Method to Abstract Class`: Convertimos el método en la clase base en abstracto.
- `Replace Type Code with Subclasses`: En los tests, en lugar de asignar un tipo de suscripción, se crean instancias de subclases correspondientes.

---