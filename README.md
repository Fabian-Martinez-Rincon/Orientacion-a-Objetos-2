<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

- [Parciales Frameworks](#parciales-frameworks)
- [Cuadernillo](#cuadernillo)

---

Que hacer ante cada bad smell:
- **Data Expose** (Atributos que son publicos)
    - `Refactoring`: Encapsulate Field
    - `Que hacer`: Pasamos los atributos a privados y en los lugares en donde se usaban los atributos, se cambia por los metodos get y set.
- **Envidia de Atributos** (Nos tenemos que acordar de aplicar el refactor anterior antes de este)
    - `Refactoring`: Move Method to Component
    - `Que hacer`: Mover el metodo a la clase que tiene los atributos que necesita.
- **Long Method** (Casi siempre se corresponde al exceso de responsabilidades)
    - `Refactoring`: Extract Method
    - `Que hacer`: Movemos el codigo a un metodo de la misma clase con un nombre descriptivo
- **Reinventado la rueda**: (Despues de hacer el extract method que contiene fors)
    - `Refactoring`: Remplazar el codigo por funcion de la libreria
    - `Que hacer`: Si tenemos algun for, buscar en los streams con cual se puede remplazar.

> [!TIP]
> En la consulta me dijeron que no hace falta copiar y pegar el codigo, con explicar el paso a paso de los refactorings basta. Podes usar las reglas que se encuentran arriba.

---

**`Refactoring`**: Transformaciones de código que preservan el comportamiento
- Preservar el comportamiento
- (Hace lo que hacía antes) & (No hace lo que no hacía antes) *

---

### 1.1 Protocolo de Cliente

La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo?


```java
/**
* Retorna el límite de crédito del cliente
*/
protected double lmtCrdt() {...
/**
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {...
/**
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtCbE(LocalDate f1, LocalDate f2) {...
```

El bad smell es `nombre poco descriptivo` ya que si en un futuro vienen nuevos desarrolladores a trabajar, no van a entender como funciona el código. 

El **refactoring** a utilizar es `rename method`, sobre los metodos. Pero esto no termina aca, el refactoring termina recien cuando en todas las llamadas a estos metodos se cambie el nombre. En caso contrario, no se considera refactoring ya que tendremos errores al llamar un metodo que antes no existia.

Hacemos lo mismo con los parametros pero en este caso, solo hace falta modificarlos en el metodo, ya que la funcionalidad externa se abstrae del nombre de los parametros.

---

### 1.2 Participación en proyectos

Al revisar el siguiente diseño inicial (Figura 1), se decidió realizar un cambio para evitar lo que se consideraba un mal olor. El diseño modificado se muestra en la Figura 2. Indique qué tipo de cambio se realizó y si lo considera apropiado. Justifique su respuesta.

Diseño inicial:

![image](https://github.com/user-attachments/assets/0a186728-efb2-4feb-9dd0-fc1bd050c2cc)

La clase `Persona` tiene el mal olor de que no cumple con **`el principio de responsabilidad única`**. Se utiliza el refactoring de `move method to component` para mover el metodo `participaEnProyecto` a la clase `Proyecto`.

No se considera un refactoring ya que estas eliminando el metodo del objeto `Persona` esto no preserva el comportamiento en la clase.

Si queremos que de verdad sea un refactoring podemos tener a la clase `Persona` de la siguiente manera:


<table><td>

```java
public class Persona {
    public String id;
    public boolean participaEnProyecto(Proyecto proyecto) {
        return proyecto.participa(this);
    }
}
```
</td><td>

```java
public clase  Proyecto {
    private List<Persona> participantes;
    public boolean participa(Persona persona) {
        return participantes.contains(persona);
    }
}
```
</td></table>

De esta forma, la gente que trabaja con la clase, no se ve afectada por el cambio.

---

### 1.3 Cálculos

Analice el código que se muestra a continuación. Indique qué defectos encuentra y cómo pueden corregirse.

```java
public void imprimirValores() {
    int totalEdades = 0;
    double promedioEdades = 0;
    double totalSalarios = 0;
    for (Empleado empleado : personal) {
        totalEdades = totalEdades + empleado.getEdad();
        totalSalarios = totalSalarios + empleado.getSalario();
    }
    promedioEdades = totalEdades / personal.size();
    String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
    System.out.println(message);
}
```

El mal olor es `Long Method` ya que el metodo esta teniendo muchas responsabilidades como "Calcular el promedio de edades" y "Calcular el total de salarios".

Para mejorar el codigo aplicamos `extract method` y creamos dos metodos `calcularPromedioEdades` y `calcularTotalSalarios`.


```java
public double calcularPromedioEdades() {
    int totalEdades = 0;
    for (Empleado empleado : personal) {
        totalEdades = totalEdades + empleado.getEdad();
    }
    return totalEdades / personal.size();
}

public double calcularTotalSalarios() {
    double totalSalarios = 0;
    for (Empleado empleado : personal) {
        totalSalarios = totalSalarios + empleado.getSalario();
    }
    return totalSalarios;
}

public void imprimirValores() {
    System.out.println(String.format(
        "El promedio de las edades es %s y el total de salarios es %s", 
        this.calcularPromedioEdades(), this.calcularTotalSalarios())
    );
}
```

Otro bads mell `Reinventando la rueda` es que se puede reemplazar el for por un stream. 

> [!WARNING]  
> Tiene que cumplir con el mismo comportamiento que antes.

En este caso al dividir por cero, el codigo lanza una excepcion que debe seguir teniendo despues del refactoring.

<table>

<tr><td>Esto god</td><td>Esto es morir</td></tr>

<tr><td>

```java
public double calcularPromedioEdades(){ 
    return personal.stream()
        .mapToDouble(empleado -> empleado.getEdad())
        .sum()/personal.size(); 
}
```
</td><td>

```java
public double calcularPromedioEdades(){ 
    return personal.stream()
        .mapToDouble(empleado -> empleado.getEdad())
        .average()
        .orElse(0); 
}
```
</td></tr>
</table>

---


### Ejercicio 2
Para cada una de las siguientes situaciones, realice en forma iterativa los siguientes pasos:

- (i) indique el mal olor,
- (ii) indique el refactoring que lo corrige,
- (iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda).

Si vuelve a encontrar un mal olor, retorne al paso (i).

### 2.1 Empleados

```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) +
        (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    }
}
public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000) -
        (this.sueldoBasico * 0.13);
    }
}
public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

Aca tenemos el bad smell de `Data Expose` y `Codigo Duplicado`.

Para solucionar el bad smell de `Data Expose` aplicamos el refactoring `Encapsulate Field`, pasamos los atributos publicos a privados, y en donde se usaban los atributos, se cambia por los metodos get y set.

```java
public class EmpleadoTemporario {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) +
        (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    }
}
public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000) -
        (this.sueldoBasico * 0.13);
    }
}
public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

Continuamos con el bad smell de `codigo duplicado`. Para solucionarlo hacemos un refactoring `Extract Class` (aca tengo dudas del nombre) con los atributos y metodos en comun.

```java
public class Empleado {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......
    public abstract double sueldo();
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) +
        (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000) -
        (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado {
    // ......
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

Seguimos con el bad smell `Codigo Duplicado` en la logica del calculo del sueldo basico. Para solucionarlo hacemos el refactoring `Extract Method` y despues aplicamos el refactoring `Pull Up Method` para que el metodo `calcularBasico` se encuentre en la clase padre.

```java
public class Empleado {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......
    public double calcularBasico() {
        return this.sueldoBasico * 0.13;
    }
    public abstract double sueldo();
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) +
        (this.cantidadHijos * 1000) - this.calcularBasico();
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000) -
        this.calcularBasico();
    }
}

public class EmpleadoPasante extends Empleado {
    // ......
    public double sueldo() {
        return this.sueldoBasico - this.calcularBasico();
    }
}
```

---

### 2.2 Juego

```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}
public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
```

De primeras tenemos el bad smell de `Data Expose` y lo tratamos como siempre, cambiamos la visibilidad de `public` por `private` y remplazamos todas las llamadas por los metodos `get` y `set`.

```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() + 100);
    }
    public void decrementar(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() - 50);
    }
}
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
```

El bad smell que tenemos ahora es `Envidia de atributos`, lo que hacemos en este caso es `move method to component` y delegamos la responsabilidad de incrementar y decrementar la puntuacion al objeto `Jugador`.

```java
public class Juego {
    public void incrementar(Jugador j) {
        j.incrementarPuntuacion(100);
    }
    public void decrementar(Jugador j) {
        j.decrementarPuntuacion(50);
    }
}
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public void incrementarPuntuacion(int puntos) {
        this.puntuacion += puntos;
    }

    public void decrementarPuntuacion(int puntos) {
        this.puntuacion -= puntos;
    }
}
```

---

![image](https://github.com/user-attachments/assets/cbec12f5-0477-4c7a-9023-0d64874fecb5)

```java
/*
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
    // ordena los posts por fecha
    for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
        int masNuevo = i;
        for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
            if (postsOtrosUsuarios.get(j).getFecha().isAfter(
                postsOtrosUsuarios.get(masNuevo).getFecha())) {
                masNuevo = j;
            }
        }
        Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
        postsOtrosUsuarios.set(masNuevo, unPost);
    }
    
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() && index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```

En este caso tenemos el bad smell de `Long Method` y `Reinventando la rueda`. Hacemos el refactoring `Extract Method` y despues el de `Remplazar el codigo por funcion de la libreria`.

```java
public List<Examen> filtrarYOrdenar(){
    return posts.stream()
        .filter(alumno->alumno.getNombre().startsWith(x))
        .sorted((p1, p2) -> 
            p1.getFecha().compareTo(p2.getFecha()))
        .collect(Collectors.toList());
}
```

```java
/*
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = filtrarYOrdenar();
    
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() && index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```

Aca tenemos el bad smell de `Codigo Reduntante` y el refactoring es `Remover codigo reduntante`. 

```java
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    return filtrarYOrdenar();
}
```

Tenemos el mal olor de `marametro sin utilizar` y el refactoring es `Remover parametro no utilizado`. Esto no queda aca, sino que tambien en todos los lugar en donde se llama a este metodo, vamos a tener que remover ese parametro. Sigue cumpliendo con el principio de refactoring ya que no estamos modificando el comportamiento en asboluto.

```java
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    return filtrarYOrdenar();
}
```

---

#### 2.4 Carrito de compras

![image](https://github.com/user-attachments/assets/2ddaf7ab-148f-456f-8921-0cbd8e33cfb5)

```java
public class Producto {
    private String nombre;
    private double precio;
    public double getPrecio() {
        return this.precio;
    }
}
public class ItemCarrito {
    private Producto producto;
    private int cantidad;
    public Producto getProducto() {
        return this.producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
}
public class Carrito {
    private List<ItemCarrito> items;
    public double total() {
        return this.items.stream().mapToDouble(item ->
        item.getProducto().getPrecio() * item.getCantidad()).sum();
    }
}
```

---

### Ejercicio 6: Antlr lab
Con cada uno de los siguientes ejemplos,
- `1)` Considere que en el lenguaje dado por la cátedra el llamado a una función o método retorna el valor generado por la evaluacion de la última sentencia (stat, en la gramática)
- `2)` Determine si hay un code smell y cual es.
- `3)` Evalue el código en antlr lab usando las especificaciones del lexer y el parser
- `4)` Estudie el árbol generado por antlr lab
- `5)` Escriba un pseudocódigo que permita detectar el code smell en el árbol
- [Pagina para ver los diagramas](http://lab.antlr.org/)


### Configuración

#### Lexer

```
// DELETE THIS CONTENT IF YOU PUT COMBINED GRAMMAR IN Parser TAB
lexer grammar ExprLexer;
AND : 'and' ;
OR : 'or' ;
NOT : 'not' ;
EQ : '=' ;
COMMA : ',' ;
SEMI : ';' ;
LPAREN : '(' ;
RPAREN : ')' ;
LCURLY : '{' ;
RCURLY : '}' ;
SUM : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
POW : '^' ;
DOT : '.' ;
COLON : ':' ;
ASK : '?' ;
INT : [0-9]+ ;
ID: [a-zA-Z_][a-zA-Z_0-9]* ;
WS: [ \t\n\r\f]+ -> skip ;
```

#### Parser

```
parser grammar ExprParser;
options { tokenVocab=ExprLexer; }
program
: stat EOF
| def EOF
;
stat: ID '=' expr ';'
| ID DOT ID '=' expr ';'
| expr ';'
;
def : ID '(' ID (',' ID)* ')' '{' stat* '}' ;
expr: ID
| INT
| func
| ID DOT ID
| ID DOT func
| 'not' expr
| expr 'and' expr
| expr 'or' expr
| expr (MUL | DIV) expr
| expr (SUM | SUB) expr
| expr POW expr
| expr '?' expr ':' expr
| expr '?' expr
;
func : ID '(' expr (',' expr)* ')'
| ID '(' ')'
;
```

### Tabla de Code Smell con su correspondiente psudocodigo


> [!TIP]
> **`Pseudo`** deriva del griego, de `seudo`, que puede traducirse como `falso`.
> **`Código`**, por su parte, emana del latín. En concreto, de “codices, codex” que se empleaban para referirse a los documentos o libros donde los romanos tenían escritas todas y cada una de sus leyes.

### 6.1

```javascript
f(x,y) {
    a = 4
    a = 3 + y;
    x * x + y * x; 
}
```

![image](https://github.com/user-attachments/assets/50ef3ba2-c1e5-46d1-af15-4cdd2838a3e6)

#### Pseudocodigo

El Bad Smell 1 encontrado es `variable pisada` y el pseudocodigo para detectarlo es el siguiente:

- Recorro el arbol hasta encontrar el primer `stat` con ID1 que representa la asignación, me quedo con el primer hijo y lo guardo en una variable auxiliar.
- Vuelvo a recorrer el arbol y si encuento otro `stat` con ID1 (asignación) y el hijo es igual a la variable auxiliar y en el medio no se encuentra como hija de ningun nodo `EXPR`, significa que es un valor pisado.

El Bad Smell 2 encontrado es `variable no utilizada` y el pseudocodigo para detectarlo es el siguiente:

- Recorro el arbol hasta encontrar el primer `stat` con ID1 que representa la asignación, me quedo con el primer hijo y lo guardo en una variable/lista auxiliar.
- Vuelvon a recorrer el arbol y si no es hijo de algun nodo EXPR, significa que no se utiliza.

---

#### 6.2

```javascript
f(x, y, z) {
    a = 3 + y;
    x * x + y * x;  
}
```

![image](https://github.com/user-attachments/assets/9786d787-72cd-4537-8ab9-f2f108dcc5ef)

#### Pseudocodigo

Tenemos dos Bad Smell un `parametro sin utilizar` y una `variable que no se utiliza`

- Recorro el arbol hasta encontrar el nodo con expresión `def` y me guardo en una lista, los valores de  los `ID` que se encuentran entre parentesis.
- Volvemos a recorrer el arbol buscando que los elementos de la lista no sean hijos de ningun nodo `EXPR`. En caso de que no sea hijo de ningun nodo `EXPR`, significa que el parametro no se utiliza.

---

#### 6.3

```javascript
f(x,y) {
    a = 4;
    x + a;
}
```

![image](https://github.com/user-attachments/assets/00db97d0-84fc-45a2-9bd6-be369c7905e4)

#### Pseudocodigo

Tenemos dos Bad Smell un `parametro sin utilizar`

- Recorro el arbol hasta encontrar el nodo con expresión `def` y me guardo en una lista, los valores de  los `ID` que se encuentran entre parentesis.
- Volvemos a recorrer el arbol buscando que los elementos de la lista no sean hijos de ningun nodo `EXPR`. En caso de que no sea hijo de ningun nodo `EXPR`, significa que el parametro no se utiliza.



---

#### 6.4

```javascript
f(x) {
    a = 4;
    a = 5;
}
```

![image](https://github.com/user-attachments/assets/62de7514-56f8-41e2-85b8-647c6e3f285c)

El Bad Smell encontrado es `variable pisada` y el pseudocodigo para detectarlo es el siguiente:

- Recorro el arbol hasta encontrar el primer `stat` con ID1 que representa la asignación, me quedo con el primer hijo y lo guardo en una variable auxiliar.
- Vuelvo a recorrer el arbol y si encuento otro `stat` con ID1 (asignación) y el hijo es igual a la variable auxiliar y en el medio no se encuentra como hija de ningun nodo `EXPR`, significa que es un valor pisado.

---

#### 6.5

```javascript
f(x) {
    a = x ? 3 : 3;
}
```

![image](https://github.com/user-attachments/assets/a96184fe-c13f-4ad4-a08f-3ea858492f00)

---

#### 6.6

```javascript
f(y) {
    a = g.x() + g.x() + g.x();
}
```

![image](https://github.com/user-attachments/assets/5afabd73-1540-421f-85fd-c97797b74465)

---

#### 6.7

```javascript
f(y) {
    a = not not y;
}
```

![image](https://github.com/user-attachments/assets/cec6da85-c68f-4c9a-9d34-f3b276220f3a)

---

#### 6.8

```javascript
f(y, z) {
    z + 12;
}
```

![image](https://github.com/user-attachments/assets/c373848a-c847-4045-9cc2-0de330bd22c6)

---

#### 6.9

```javascript
elegirSueldo(empleado) {
    clase = empleado.class;
    clase.equals(pasante) ? empleado.setSueldo(20000);
    clase.equals(planta) ? empleado.setSueldo(50000);
}
```

![image](https://github.com/user-attachments/assets/232dba17-8c2f-4feb-b81a-1051729a4341)

---

#### 6.10

```javascript
agregarOnceNumeros(lista) {
    lista.agregar(1);
    lista.agregar(2);
    lista.agregar(3);
    lista.agregar(4);
    lista.agregar(5);
    lista.agregar(6);
    lista.agregar(7);
    lista.agregar(8);
    lista.agregar(9);
    lista.agregar(10);
    lista.agregar(11);
}
```

![image](https://github.com/user-attachments/assets/0baf7077-bded-4745-ab14-b8856793eb36)

---

#### 6.11

```javascript
numeroTelefonoCompleto(telefono, numero) {
    numero = telefono.codigoArea + telefono.prefijo + telefono.numero;
}
```

![image](https://github.com/user-attachments/assets/455918b3-076e-4489-afbc-9dc61d851756)

---

#### 6.11

```javascript
f(x,y) {
    x or not x ? y + 1;
    x and x ? y - 1;
    x ? x ? y - 1;
}
```

![image](https://github.com/user-attachments/assets/757dd775-b7a7-47d7-a52d-b588073eba42)

---

#### 6.12

```javascript
f(x) {
    x = x;
}
```

![image](https://github.com/user-attachments/assets/f345f5d3-2c81-43f6-894b-038557765cdf)

---

#### 6.13

```javascript
f(x,y) {
    x ? y - 1;
    not x ? y - 2;
}
```

![image](https://github.com/user-attachments/assets/39115451-38ff-4499-90bf-34956187738e)

---

#### 6.14

```javascript
f(a,b,c,d,e,f,g,h,i,j,k) {
    a+b+c+d+e+f+g+h+i+j+k;
}
```

![image](https://github.com/user-attachments/assets/9b98124f-8bc7-4432-8474-dc0b760d20bd)

---

#### 6.15

```javascript
someOperation(x,y,z) {
    other.someOperation(x,y,z);
}
```

![image](https://github.com/user-attachments/assets/c4137e10-eaad-40d8-9dbe-869e110870e1)
