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
expr: ID   //EXPR 1
| INT      //EXPR 2
| func     //EXPR 3
| ID DOT ID //empleado.sueldo // EXPR 4
| ID DOT func //empleado.calcularSueldo() // EXPR 5
| 'not' expr // EXPR 6
| expr 'and' expr // EXPR 7
| expr 'or' expr // EXPR 8
| expr (MUL | DIV) expr // EXPR 9
| expr (SUM | SUB) expr // EXPR 10
| expr POW expr // EXPR 11
| expr '?' expr ':' expr // EXPR 12
| expr '?' expr // EXPR 13
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


#### Pseudocodigo

El Bad Smell encontrado es `condicional redundante` y el pseudocodigo para detectarlo es el siguiente:

Recorro el arbol hasta encontrar un nodo EXPR con la siguiente estructura `EXPR ? EXPR : EXPR` y si los dos ultimos hijos tienen el mismo valor, significa que el condicional no es necerario que se encuentre.

---

#### 6.6

```javascript
f(y) {
    a = g.x() + g.x() + g.x();
}
```

![image](https://github.com/user-attachments/assets/5afabd73-1540-421f-85fd-c97797b74465)

#### Pseudocodigo

Tenemos dos Bad Smell un `parametro sin utilizar`

- Recorro el arbol hasta encontrar el nodo con expresión `def` y me guardo en una lista, los valores de  los `ID` que se encuentran entre parentesis.
- Volvemos a recorrer el arbol buscando que los elementos de la lista no sean hijos de ningun nodo `EXPR`. En caso de que no sea hijo de ningun nodo `EXPR`, significa que el parametro no se utiliza.

---

#### 6.7

```javascript
f(y) {
    a = not not y;
}
```

![image](https://github.com/user-attachments/assets/cec6da85-c68f-4c9a-9d34-f3b276220f3a)

#### Pseudocodigo

El Bad Smell es `Logica Reduntante` y el pseudocodigo para detectarlo es el siguiente:

- Recorro el arbol hasta encontrar un nodo `EXPR` que tenga como hijo un `not` y si su nodo hermano `EXPR` tiene como hijo otro `not`, significa que es logica redundante.

---

#### 6.8

```javascript
f(y, z) {
    z + 12;
}
``` 

![image](https://github.com/user-attachments/assets/c373848a-c847-4045-9cc2-0de330bd22c6)

#### Pseudocodigo

Tenemos dos Bad Smell un `parametro sin utilizar`

- Recorro el arbol hasta encontrar el nodo con expresión `def` y me guardo en una lista, los valores de  los `ID` que se encuentran entre parentesis.
- Volvemos a recorrer el arbol buscando que los elementos de la lista no sean hijos de ningun nodo `EXPR`. En caso de que no sea hijo de ningun nodo `EXPR`, significa que el parametro no se utiliza.

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

El Bad smell es `Switch statement` ya que estoy utilizando clase de empleado para determinar el sueldo a setear. Esto no es escalable ya que si en un futuro quiero seguir agregando tipos de empleados, tengo que modificar el metodo.

El pseudocodigo para detectar este bad smell es el siguiente:

- Busco el nodo `def` y me guardo en una variable auxiliar los valores pasados por parametro, en este caso es `empleado`
- Vuelvo a recorrer el arbol y busco un nodo con `STAT:1` que representa la asignación y si tiene como hijo un nodo `EXPR` que contiene el valor de mi variable auxiliar y la siguiente estructura `aux.class`. Me quedo con el primer hijo que en este caso es `clase`
- Una vez que tengo guardado `clase` en una variable `auxiliar`, vuelvo a recorrer el arbol hasta encontrar un nodo `EXPR` con la siguiente estructura `auxiliar . equals ( EXPR )`.
- Si encuentro un nodo con esta estructura, significa que tengo un `Switch statement`. 



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

El Bad Smell es `Reinventado la rueda` ya que tengo operaciones que repiten un patron en secuencia, por lo que se podrian remplazar por un for. Como por ejemplo

```javascript
agregarOnceNumeros(lista) {
    for (int i = 1; i <= 11; i++) {
        lista.agregar(i);
    }
}
```

#### Pseudocodigo

Para encontrar el Bad Smell hacemos lo siguiente:

- Recorro el arbol quedandome con la estructura completa de los nodos `stat:3`
- Sobre la lista que guarde, elimino todas las estructuras duplicadas
- Si el resultado me queda una secuencia de numeros, significa que puedo remplazarlo por un for.

El resultado quedaria algo asi

[1,2,3,4,5,6,7,8,9,10,11]


---

#### 6.11

```javascript
numeroTelefonoCompleto(telefono, numero) { 
    numero = telefono.codigoArea + telefono.prefijo + telefono.numero;
}
```

![image](https://github.com/user-attachments/assets/455918b3-076e-4489-afbc-9dc61d851756)

#### Pseudocodigo

El Bad Smell es `Envidia de Atributos`

- Recorro el arbol hasta encontrar el nodo con expresión `def` y me guardo en una lista, los valores de  los `ID` que se encuentran entre parentesis.
- Volvemos a recorrer el arbol buscando que los elementos de la lista no sean hijos de un nodo `EXPR:4` con la siguiente estructura `telefono . atributoX`
- En caso de encontrar estos nodos, estamos en presencia de un `Envidia de Atributos`.

---

#### 6.11

```javascript
f(x,y) { x = true , y = 2
    x or not x ? y + 1;  
    x and x ? y - 1;
    x ? x ? y - 1;
}
```

![image](https://github.com/user-attachments/assets/757dd775-b7a7-47d7-a52d-b588073eba42)

Resultado con if

<details><summary>ejemplo</summary>

```javascript
f(x, y) {//x = true, y = 2;
    
    // Primera Condición
    if (x || !x) {
        y = y + 1;
    }
    
    // Segunda Condición
    if (x && x) {
        y = y - 1;
    }
    
    // Tercera Condición
    if (x) {
        if (x) {
            y = y - 1;
        }
    }
}
```

El bad smell es codigo reduntante, el codigo sin redundacia quedaria asi

```javascript
f(x, y) {//x = true, y = 2;
    if (x) {
        y = y - 1;
    }
}
```

</details>

#### Pseudocodigo


Primer `Stat` 3
- Recorro el arbol hasta encontrar un nodo `EXPR:8` y me guardo el hijo izquierdo en una variable auxiliar.
- Si el hijo mas derecho de mi nodo `EXPR:8`, tiene el hijo izquierdo un `not` y el hijo derecho es igual a la variable auxiliar, significa que es logica redundante.

Segundo `Stat` 3
- Recorro el arbol hasta encontrar un nodo `EXPR:7` y me guardo la estructura del hijo izquierdo en una variable auxiliar.
- Si el hijo mas derecho de mi nodo `EXPR:7`, tiene la misma estructura que la variable auxiliar, significa que es logica redundante.

Tercer `Stat` 3
- Recorro el arbol hasta encontrar un nodo `EXPR:13` y me guardo la estructura del hijo izquierdo en una variable auxiliar.
- Si el hijo mas derecho de mi nodo `EXPR:13`, tiene la misma estructura que la variable auxiliar, significa que es logica redundante.

---

#### 6.12

# "¡REZÁ MALENA... REZÁ!"

> LA ULTIMA LINEA SE RETORNA
> SI EN LA ULTIMA TENES UNA ASIGNACION, SE RETORNA EL VALOR DE LA COMPARACION

```javascript
// La funcionalidad es que siempre retorna TRUE
f(x) {//x = 4  -> True
    x = x;
}
```

![image](https://github.com/user-attachments/assets/f345f5d3-2c81-43f6-894b-038557765cdf)

- `Paso 1)` Recorro el arbol el arbol hasta encontrar el nodo con `stat:1`, me guardo el valor en una variable auxiliar
- `Paso 2)` 

---

#### 6.13

```javascript
f(x,y) { // x = TRUE -> f  // y = 5
    x ? y - 1; // y = 4
    not x ? y - 2;  // if (not x) return y-2
}
```

ESTO TIENE QUE RETORNAR LA ULTIMA | Si el valor de X es falso, no retorno NADA

![image](https://github.com/user-attachments/assets/39115451-38ff-4499-90bf-34956187738e)

El bad smell es que si x es falso, no estaria retornando ningun valor. Ya que el return se encuentra dentro del if

Busco el nodo `expr:13` de mi ultimo `stat:3`, y busco sobre sus nodos hijos, en caso de que no tenga el valor `:` que me indica que es un else, significa que no estoy retornando nada para una situación en especifico. 

---

#### 6.14

```javascript
f(a,b,c,d,e,f,g,h,i,j,k) {
    a+b+c+d+e+f+g+h+i+j+k;
}
```

![image](https://github.com/user-attachments/assets/9b98124f-8bc7-4432-8474-dc0b760d20bd)

El bad smell es `Long Parameter List` y el pseudocodigo para detectarlo es el siguiente:

Recorremos el arbol buscando el nodo `def:1` y nos quedamos con todos los elementos de la lista, y a esa lista le hacemos un .size() y si es mayor a 3/4 es un indicador `Long Parameter List`.

---

#### 6.15

```javascript
someOperation(x,y,z) {
    other.someOperation(x,y,z);
}
```
```javascript
Persona {
    Contador contador;

    calcularSueldo(sueldoBruto, obraSocial, jubilacion) {
        contador.calcularSueldoNeto(sueldoBruto, obraSocial, jubilacion);
    }
}
```

![image](https://github.com/user-attachments/assets/c4137e10-eaad-40d8-9dbe-869e110870e1)

El bad smell es `Middle Man` y el pseudocodigo para detectarlo es el siguiente:

- Recorremos el arbol hasta encontrar el nodo `def:1`, nos guardamos los valores que estan entre parentesis en una lista auxiliar y el valor del hijo izquierdo en otro variable llamada `nombreFuncion`
- Volvemos a recorrer el arbol buscando que tenga solo un nodo `STAT:3`
- El Hijo izquierdo tiene que ser un nodo `EXPR:5` y me quedo con su hijo derecho `func:1`
-  Si el hijo izquierdo de `func:1` es igual a `nombreFuncion` y el resto de los hijos que estan entre parentesis es igual a la `lista auxiliar` que me guarde significa que es un `Middle Man`.


---

### Como actuar ante los malos olores

<details><summary>Declaración de atributos pública</summary>
La declaración pública de atributos de una clase, genera una ruptura del encapsulamiento. Como por ejemplo:

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
</details>

El unico refactoring a aplicar es:

<details><summary>Encapsulate Field</summary>

Declaramos los atributos como privados y hacemos que se acceda a ellos sólo a través de los getters y setters.

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

</details>