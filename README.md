<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>


### Patrones de Diseño



- [Ejercicio 1 Red Social](#ejercicio-1-red-social)
- [Ejercicio 2 Friday the 13th en Java](#ejercicio-2-friday-the-13th-en-java)
- [Ejercicio 2.b Usando la librería JSON.simple](#ejercicio-2b-usando-la-librería-jsonsimple)
- [Ejercicio 3 Media Player](#ejercicio-3-media-player)
- [Ejercicio 4 Topografías](#ejercicio-4-topografías)
- [Ejercicio 4.b Más Topografías](#ejercicio-4b-más-topografías)
- [Ejercicio 5 FileSystem](#ejercicio-5-filesystem)
- [Ejercicio 6 Cálculo de sueldos](#ejercicio-6-cálculo-de-sueldos)
- [Ejercicio 7 ToDoItem](#ejercicio-7-todoitem)
- [Ejercicio 8 Excursiones](#ejercicio-8-excursiones)
- [Ejercicio 9 Encriptador](#ejercicio-9-encriptador)
- [Ejercicio 10 Administrador de proyectos](#ejercicio-10-administrador-de-proyectos)
- [Ejercicio 11 Dispositivo móvil y conexiones](#ejercicio-11-dispositivo-móvil-y-conexiones)
- [Ejercicio 12 Decodificador de películas](#ejercicio-12-decodificador-de-películas)
- [Ejercicio 13 Acceso a la base de datos](#ejercicio-13-acceso-a-la-base-de-datos)
- [Ejercicio 14 File Manager](#ejercicio-14-file-manager)
- [Ejercicio 15 Estación meteorológica](#ejercicio-15-estación-meteorológica)
- [Ejercicio 16 Productos Financieros](#ejercicio-16-productos-financieros)
- [Ejercicio 17 Infraestructura en la Nube](#ejercicio-17-infraestructura-en-la-nube)
- [Ejercicio 18 SubteWay](#ejercicio-18-subteway)
- [Ejercicio 19 Personajes de juegos de rol](#ejercicio-19-personajes-de-juegos-de-rol)
- [Ejercicio 19.b Mas Personajes](#ejercicio-19b-mas-personajes)
- [Ejercicio 20 Aerolínea Regional](#ejercicio-20-aerolínea-regional)
- [Ejercicio 21 Genealogía salvaje](#ejercicio-21-genealogía-salvaje)
- [Ejercicio 22 Monitoreo de proceso industrial](#ejercicio-22-monitoreo-de-proceso-industrial)

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 1 Red Social

Se quiere programar en objetos una versión simplificada de una red social parecida a Twitter. Este servicio debe permitir a los usuarios registrados postear y leer mensajes de hasta 280 caracteres. Ud. debe modelar e implementar parte del sistema donde nos interesa que quede claro lo siguiente:

- Cada usuario conoce todos los Tweets que hizo.
- Un tweet puede ser re-tweet de otro, y este tweet debe conocer a su tweet de origen.
- Twitter debe conocer a todos los usuarios del sistema.
- Los tweets de un usuario se deben eliminar cuando el usuario es eliminado. No existen tweets no referenciados por un usuario.
- Los usuarios se identifican por su screenName.
- No se pueden agregar dos usuarios con el mismo screenName.
- Los tweets deben tener un texto de 1 carácter como mínimo y 280 caracteres como máximo.

### Tareas

Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos

- **1)** Diagrama de clases UML.
- **2)** Implementación en Java de la funcionalidad requerida.
- **3)** Implementar los tests (JUnit) que considere necesarios

> **Nota** para crear el proyecto Java, lea el material llamado “Trabajando en OO2 con proyectos Maven”.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 2 Friday the 13th en Java

> **Nota** Para realizar este ejercicio, utilice el recurso que se encuentra en el sitio de la cátedra. Allí encontrará un proyecto Maven que contiene el código fuente de las clases Biblioteca, Socio y VoorheesExporter.

La clase Biblioteca implementa la funcionalidad de exportar el listado de sus socios en formato JSON. Para ello define el método **exportarSocios()** de la siguiente forma:

```java
/**
* Retorna la representación JSON de la colección de socios.
*/
public String exportarSocios() {
    return exporter.exportar(socios);
}
```

La Biblioteca delega la responsabilidad de exportar en una instancia de la clase VoorheesExporter que dada una colección de socios, retorna un texto con la representación de la misma en formato JSON. Esto lo hace mediante el mensaje de instancia **exportar(List\<Socio>)**.

<table><tr>
<td>

- Nombre: Arya Stark
- e-mail:needle@stark.com
- legajo: 5234-5
</td>
    
<td>

- Nombre: Tyron Lannister
- e-mail:tyron@thelannisters.com
- legajo: 2345-2
</td>
</tr></table>

Ud. puede probar la funcionalidad ejecutando el siguiente código:

```java
Biblioteca biblioteca = new Biblioteca();
biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2"));
System.out.println(biblioteca.exportarSocios());
```

Al ejecutar, el mismo imprimirá el siguiente JSON:

```json
[
    {
        "nombre": "Arya Stark",
        "email": "needle@stark.com",
        "legajo": "5234-5"
    },
    {
        "nombre": "Tyron Lannister",
        "email": "tyron@thelannisters.com",
        "legajo": "2345-2"
    }
]
```

Note los corchetes de apertura y cierre de la colección, las llaves de apertura y cierre para cada socio y la coma separando a los socios

### Tareas

- **1)** Analice la implementación de la clase Biblioteca, Socio y VoorheesExporter que se provee con el material adicional de esta práctica (Archivo biblioteca.zip).
- **2)** Documente la implementación mediante un diagrama de clases UML.
- **3)** Programe los Test de Unidad para la implementación propuesta.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 2.b Usando la librería JSON.simple

Su nuevo desafío consiste en utilizar la librería JSON.simple para imprimir en formato JSON a los socios de la Biblioteca en lugar de utilizar la clase VoorheesExporter. Pero con la siguiente condición: **nada de esto debe generar un cambio en el código de la clase Biblioteca.**

La librería JSON.simple es liviana y muy utilizada para leer y escribir archivos JSON. Entre las clases que contiene se encuentran:

- **JSONObject:** Usada para representar los datos que se desean exportar de un objeto. Esta clase provee el método **``put(Object, Object)``** para agregar los campos al mismo. Aunque el primer argumento sea de tipo Object, usted debe proveer el nombre del atributo como un string. El segundo argumento contendrá el valor del mismo. Por ejemplo, si point es una instancia de JSONObject, se podrá ejecutar **`point.put(“x”, 50);`**
- **JSONArray**: Usada para generar listas. Provee el método **`add(Object)`** para agregar los elementos a la lista, los cuales, para este caso, deben ser JSONObject. 

Ambas clases implementan el mensaje **`toJSONString()`** el cual retorna un String con la representación JSON del objeto.

- **JSONParser** : Usada para recuperar desde un String con formato JSON los elementos que lo componen.

### Tareas

1. Instale la librería JSON.simple agregando la siguiente dependencia al archivo pom.xml
de Maven
    ```xml
    <dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
    </dependency>
    ```
2. Utilice esta librería para imprimir, en formato JSON, los socios de la Biblioteca en lugar de utilizar la clase VoorheesExporter, sin que esto genere un cambio en el código de la clase Biblioteca.
    - **a)** Modele una solución a esta alternativa utilizando un diagrama de clases UML. Si utiliza patrones de diseño indique los roles en las clases utilizando estereotipos.
    - **b)** Implemente en Java la solución incluyendo los tests que crea necesarios.
3. Investigue sobre la librería Jackson, la cual también permite utilizar el formato JSON para serializar objetos Java. Extienda la implementación para soportar también esta librería.


<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 3 Media Player

Usted ha implementado una clase Media player, para reproducir archivos de audio y video en formatos que usted ha diseñado. Cada Media se puede reproducir con el mensaje play(). Para continuar con el desarrollo, usted desea incorporar la posibilidad de reproducir Video Stream. Para ello, dispone de la clase VideoStream que pertenece a una librería de terceros y usted no puede ni debe modificarla. El desafío que se le presenta es hacer que la clase MediaPlayer pueda interactuar con la clase VideoStream.

La situación se resume en el siguiente diagrama UML:

![image](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/1e6a42f0-f944-476a-8a83-e5e6af060243)

### Tareas

- **1)** Modifique el diagrama de clases UML para considerar los cambios necesarios. Si utiliza patrones de diseño indique los roles en las clases utilizando estereotipos.
- **2)** Implemente en Java

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 4 Topografías

Un objeto Topografía representa la distribución de agua y tierra de una región cuadrada del planeta, la cual está formada por porciones de “agua” y de “tierra”. La siguiente figura muestra:
- **(a)** el aspecto de una topografía formada únicamente por agua.
- **(b)** otra formada sólamente por tierra.
- **(c)** y **(d)** topografías mixtas.

![image (1)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/43c59000-70b8-4492-99ef-60ad7653b792)

Una topografía mixta está formada por partes de agua y partes de tierra (4 partes en total). 

Éstas a su vez podrían descomponerse en 4 más y así siguiendo.

La proporción de agua de una topografía sólo agua es 1. La proporción de agua de una topografía sólo tierra es 0. La proporción de agua de una topografía compuesta está dada por la suma de la proporción de agua de sus componentes dividida por 4. En el ejemplo, la proporción de agua es: (1 + 0 + 0 + 1) / 4 = 1/2. La proporción siempre es un valor entre 0 y 1.

### Tareas

- `1)` Diseñe e implemente las clases necesarias para que sea posible:
    - **a)** Crear Topografías,
    - **b)** Calcular su proporción de agua y tierra,
    - **c)** Comparar igualdad entre topografías. Dos topografías son iguales si tienen exactamente la misma composición. Es decir, son iguales las proporciones de agua y tierra, y además, para aquellas que son mixtas, la disposición de sus partes es igual.

> Pista: notar que la definición de igualdad para topografías mixtas corresponde
exactamente a la misma que implementan las listas en Java.

https://docs.oracle.com/javase/8/docs/api/java/util/AbstractList.html#equals-java.lang.Object-

- `2)` Diseñe e implemente test cases para probar la funcionalidad implementada. Incluya en el set up de los tests, la topografía compuesta del ejemplo.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 4.b Más Topografías

Extienda el ejercicio anterior para soportar (además de Agua y Tierra) el terreno Pantano. Un pantano tiene una proporción de agua de 0.7 y una proporción de tierra de 0.3. No olvide hacer las modificaciones necesarias para responder adecuadamente la comparación por igualdad.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 5 FileSystem

Un file system contiene un conjunto de directorios y archivos organizados jerárquicamente mediante una relación de inclusión. De cada archivo se conoce el nombre, fecha de creación y tamaño en bytes. De un directorio se conoce el nombre, fecha de creación y contenido (el tamaño es siempre 32kb). Modele el file system y provea la siguiente funcionalidad:

```java
public class Archivo {
    /**
    * Crea un nuevo archivo con nombre <nombre>, de <tamano> tamano
    * y en la fecha <fecha>.
    */
    public Archivo (String nombre, LocalDate fecha, int tamano) 
}
public class Directorio {
    /**
    * Crea un nuevo Directorio con nombre <nombre> y en la fecha <fecha>.
    */
    public Directorio(String nombre, LocalDate fecha)
    /**
    * Retorna el espacio total ocupado, incluyendo su contenido.
    */
    public int tamanoTotalOcupado()
    /**
    * Retorna el archivo con mayor cantidad de bytes en cualquier nivel del
    * filesystem contenido por directorio receptor
    */
    public Archivo archivoMasGrande()
    /**
    * Retorna el archivo con fecha de creación más reciente en cualquier nivel
    * del filesystem contenido por directorio receptor.
    */
    public Archivo archivoMasNuevo()
}
```

### Tareas

- **1)** Diseñe y represente un modelo UML de clases de su aplicación, identifique el patrón de diseño empleado (utilice estereotipos UML para indicar los roles de cada una de las clases en ese patrón).
- **2)** Diseñe, implemente y ejecute test cases para verificar el funcionamiento de su aplicación. En el archivo [DirectorioTest.java del material adicional](https://drive.google.com/file/d/1NH51KfoI_fEtYfT9ZM99CCwDHj2wJ5FL/view) se provee la clase DirectorioTest que contiene tests para los métodos arriba descritos y la definición del método setUp. Utilice el código provisto como guía de su solución y extienda lo que sea necesario.
- **3)** Implemente completamente en Java.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 6 Cálculo de sueldos

Sea una empresa que paga sueldos a sus empleados, los cuales están organizados en tres tipos: Temporarios, Pasantes y Planta. El sueldo se compone de 3 elementos: sueldo básico, adicionales y descuentos.

<table>
<tr>
<th></th>
<th>Temporario</th>
<th>Pasante</th>
<th>Planta</th>
</tr>
<tr>
<td>básico</td>
<td>

\$ 20.000 + cantidad de horas que trabajo * $ 300.

</td>
<td>$20.000</td>
<td>$50.000</td>
</tr>
<tr>
<td>adicional</td>
<td>

\$5.000 si está casado
$2.000 por cada hijo
</td>
<td>$2.000 por examen que rindió</td>
<td>

\$5.000 si está casado
\$2.000 por cada hijo
$2.000 por cada año de antigüedad

</td>
</tr>
<tr>
<td>descuento</td>
<td>

13% del sueldo básico
5% del sueldo adiciona
</td>
<td>

13% del sueldo básico
5% del sueldo adicional

</td>
<td>

13% del sueldo básico
5% del sueldo adicional

</td>
</tr>
</table>

### Tareas

- **1)** Diseñe la jerarquía de Empleados de forma tal que cualquier empleado puede responder al mensaje #sueldo.
- **2)** Desarrolle los test cases necesarios para probar todos los casos posibles.
- **3)** Implemente en Java.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 7 ToDoItem

Se desea definir un sistema de seguimiento de tareas similar a Jira

En este sistema hay tareas en las cuales se puede definir el nombre y una serie de comentarios. Las tareas atraviesan diferentes etapas a lo largo de su ciclo de vida y ellas son: 

- pending
- in-progress
- paused
- finished

Cada tarea debe estar modelada mediante la claseToDoItem con el siguiente protocolo.

```java
public class ToDoItem {
    /**
    * Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
    */
    public ToDoItem(String name)
    /**
    * Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
    * pending. Si se encuentra en otro estado, no hace nada.
    */
    public void start()
    /**
    * Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress si su
    * estado es paused. Caso contrario (pending o finished) genera un error
    * informando la causa específica del mismo.
    */
    public void togglePause()
    /**
    * Pasa el ToDoItem a finished, siempre y cuando su estado actual sea
    * in-progress o paused. Si se encuentra en otro estado, no hace nada.
    */
    public void finish()
    /**
    * Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
    * hasta que se finalizó. En caso de que no esté finalizado, el tiempo que
    * haya transcurrido hasta el momento actual. Si el ToDoItem no se inició,
    * genera un error informando la causa específica del mismo.
    */
    public Duration workedTime()
    /**
    * Agrega un comentario al ToDoItem siempre y cuando no haya finalizado. Caso
    * contrario no hace nada."
    */
    public void addComment(String comment)
}
```

> **Nota** para generar o levantar un error debe utilizar la expresión

```java
throw new RuntimeException("Este es mi mensaje de error");
```

El mensaje de error específico que se espera en este ejercicio debe ser descriptivo del caso. Por ejemplo, para el método togglePause() , el mensaje de error debe indicar que el ToDoItem no se encuentra en in-progress o paused:

```java
throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
```

### Tareas

- **1)** Modele una solución orientada a objetos para el problema planteado utilizando un diagrama de clases UML. Si utilizó algún patrón de diseño indique cuáles son los participantes en su modelo de acuerdo a Gamma et al.
- **2)** Implemente su solución en Java. Para comprobar cómo funciona recomendamos usar test cases.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 8 Excursiones

Sea una aplicación que ofrece excursiones como por ejemplo “dos días en kayak bajando el Paraná”. Una excursión posee nombre, fecha de inicio, fecha de fin, punto de encuentro, costo, cupo mínimo y cupo máximo.

La aplicación ofrece las excursiones pero éstas sólo se realizan si alcanzan el cupo mínimo de inscriptos. Un usuario se inscribe a una excursión y si aún no se alcanzó el cupo mínimo, la inscripción se considera provisoria. Luego, cuando se alcanza el cupo mínimo, la inscripción se considera definitiva y podrá llevarse a cabo.

Finalmente, cuando se alcanza el cupo máximo, la excursión solo registrará nuevos inscriptos en su lista de espera.

De los usuarios inscriptos, la aplicación registra su nombre, apellido e email.

Por otro lado, en todo momento la excursión ofrece información de la misma, la cual consiste en una serie de datos que varían en función de la situación.


- Si la excursión no alcanza el cupo mínimo, la información es la siguiente: nombre, costo, fechas, punto de encuentro, cantidad de usuarios faltantes para alcanzar el cupo mínimo.
- Si la excursión alcanzó el cupo mínimo pero aún no el máximo, la información es la siguiente: nombre, costo, fechas, punto de encuentro, los mails de los usuarios inscriptos y cantidad de usuarios faltantes para alcanzar el cupo máximo.
- Si la excursión alcanzó el cupo máximo, la información solamente incluye nombre, costo, fechas y punto de encuentro.

En una primera versión, al no contar con una interfaz de usuario y a los efectos de debugging, este comportamiento puede implementarlo en un método que retorne un String con la información solicitada.

### Tareas:
- **1)** Realice un diseño UML. Si utiliza algún patrón indique cuál(es) y justifique su uso.
- **2)** Implemente lo necesario para instanciar una excursión y para instanciar un usuario.
- **3)** Implemente los siguientes mensajes de la clase Excursion:
    - (i) public void inscribir (Usuario unUsuario)
    - (ii) public String obtenerInformacion().
- **4)** Escriba un test para inscribir a un usuario en la excursión “Dos días en kayak bajando el Paraná”, con cupo mínimo de 1 persona y cupo máximo 2, con dos personas ya inscriptas. Implemente todos los mensajes que considere necesarios.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 9 Encriptador

En un sistema de mensajes instantáneos (como Hangouts) se envían mensajes de una máquina a otra a través de una red. Para asegurar que la información que pasa por la red no es espiada, el sistema utiliza una conexión segura. Este tipo de conexión encripta la información antes de enviarla y la desencripta al recibirla. La siguiente figura ilustra un posible diseño para este enunciado

![image (2)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/173094b5-e56a-417a-bae5-b388d0134ba3)

El encriptador utiliza el algoritmo RSA. Sin embargo, se desea agregar otros algoritmos
(diferentes algoritmos ofrecen distintos niveles de seguridad, overhead en la transmisión, etc.).

### Tareas

 - **1)** Modifique el diseño para que el objeto Encriptador pueda encriptar mensajes usando los algoritmos Blowfish y RC4, además del ya soportado RSA.
 - **2)** Documente mediante un diagrama de clases UML indicando los roles de cada clase.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 10 Administrador de proyectos

Consideremos una empresa que brinda servicios y los gestiona a través de proyectos. Los proyectos tienen una fecha de inicio y de fin, un objetivo, un número de integrantes (quienes cobran un monto fijo por día) y un margen de ganancia. Durante el armado del proyecto, el mismo debe pasar por un proceso de aprobación que involucra las etapas: En construcción ->

En evaluación -> Confirmada. Se desea implementar la siguiente funcionalidad:

![image (3)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/8811a5fa-9739-4444-846f-893e9bbb47f0)
![image (6)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/4dccd3d8-426d-4b90-bf3b-0a57c21e6701)

### Tareas:
1- Modele una solución y provea el diagrama de clases UML para el problema planteado. Si utiliza algún patrón, indique cuál.
2- Implemente en Java.
3- Implemente un test para aprobar un proyecto con las siguientes características: (i) se encuentra en evaluación, (ii) se llama “Vacaciones de invierno”, (iii) tiene como objetivo “salir con amigos”, y (iv) lo integran 3 personas.

> Nota: para generar o levantar un error debe utilizar la expresión


```java
throw new RuntimeException("Este es mi mensaje de error");
```
<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 11 Dispositivo móvil y conexiones

Sea el software de un dispositivo móvil que utiliza una conexión WiFi para transmitir datos. La figura muestra parte de su diseño:

![image](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/113b66e3-1a3e-443e-be49-c5e260b4f010)

El dispositivo utiliza, para asegurar la integridad de los datos emitidos, el mecanismo de cálculo de redundancia cíclica que le provee la clase CRC16_Calculator que recibe el mensaje crcFor(data: String) con los datos a enviar y devuelve un valor numérico. Luego el dispositivo envía a la conexión el mensaje sendData con ambos parámetros (los datos y el valor numérico calculado).

Se desea hacer dos cambios en el software. En primer lugar, se quiere que el dispositivo tenga capacidad de ser configurado para utilizar conexiones 4G. Para este cambio se debe utilizar la clase 4GConnection.

Además se desea poder configurar el dispositivo para que utilice en distintos momentos un cálculo de CRC de 16 o de 32 bits. Es decir que en algún momento el dispositivo seguirá utilizando CRC16_Calculator y en otros podrá ser configurado para utilizar la clase CRC32_Calculator. Se desea permitir que en el futuro se puedan utilizar otros algoritmos de CRC.

Cuando se cambia de conexión, el dispositivo muestra en pantalla el símbolo correspondiente
(que se obtiene con el getter pict() para el caso de WiFiConn y symb() de 4GConnection) y
se utiliza el objeto Ringer para emitir un ring().

Tanto las clases existentes como las nuevas a utilizar pueden ser ubicadas en las jerarquías que corresponda (modificar la clase de la que extienden o la interfaz que implementan) y se les pueden agregar mensajes, pero no se pueden modificar los mensajes que ya existen porque otras partes del sistema podrían dejar de funcionar.

Dado que esto es una simulación, y no dispone de hardware ni emulador para esto, la signatura de los mensajes se ha simplificado para que se retorne un String descriptivo de los eventos que suceden en el dispositivo y permitir de esta forma simplificar la escritura de los tests.

Modele los cambios necesarios para poder agregar al protocolo de la clase Dispositivo los mensajes para
- cambiar la conexión, ya sea la 4GConnection o la WifiConn. En este método se espera que se pase a utilizar la conexión recibida, muestre en el display su símbolo y genere el sonido.
- poder configurar el calculador de CRC, que puede ser el CRC16_Calculator, el CRC32_Calculator, o pueden ser nuevos a futuro.

### Tareas

- **1)** Realice un diagrama UML de clases para su solución al problema planteado. Indique claramente el o los patrones de diseño que utiliza en el modelo y el rol que cada clase cumple en cada uno.
- **2)** Implemente en Java todo lo necesario para asegurar el envío de datos por cualquiera de las conexiones y el cálculo adecuado del índice de redundancia cíclica.
- **3)** Implemente test cases para los siguientes métodos de la clase Dispositivo
    - (i) send
    - (ii) conectarCon
    - (iii) configurarCRC

En cuanto a CRC16_Calculator, puede utilizar la siguiente implementación

```java
public long crcFor(String datos) {
    int crc = 0xFFFF;
    for (int j = 0; j < datos.getBytes().length; j++) {
        crc = ((crc >>> 8) | (crc << 8)) & 0xffff;
        crc ^= (datos.getBytes()[j] & 0xff);
        crc ^= ((crc & 0xff) >> 4);
        crc ^= (crc << 12) & 0xffff;
        crc ^= ((crc & 0xFF) << 5) & 0xffff;
    }
    crc &= 0xffff;
    return crc;
}
```

> Nota: para implementar CRC32_Calculator utilice la clase java.util.zip.CRC32 de la siguiente manera:

```java
CRC32 crc = new CRC32();
String datos = "un mensaje";
crc.update(datos.getBytes());
long result = crc.getValue();
```


<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 12 Decodificador de películas

Sea una empresa de cable on demand que entrega decodificadores a sus clientes para que miren las películas que ofrece. El decodificador muestra la grilla de películas y también sugiere películas.

Usted debe implementar la aplicación para que el decodificador sugiera películas. El decodificador conoce la grilla de películas (lista completa que ofrece la empresa), como así también las películas que reproduce. De cada película se conoce título, año de estreno, películas similares y puntaje. La similaridad establece una relación recíproca entre dos películas, por lo que si A es similar a B entonces también B es similar a A.

Cada decodificador puede ser configurado para que sugiera 3 películas (que no haya reproducido) por alguno de los siguientes criterios: 
- **(i) novedad**: las películas más recientes
- **(ii) similaridad**: las películas similares a alguna película que reprodujo, ordenadas de más a menos reciente.
- **(iii) puntaje**: las películas de mayor puntaje, para igual puntaje considera las más recientes.

Tenga en cuenta que la configuración del criterio de sugerencia del decodificador no es fija, sino que el usuario la debe poder cambiar en cualquier momento. El sistema debe soportar agregar nuevos tipos de sugerencias aparte de las tres mencionadas.

Sea un decodificador que reprodujo Thor y Rocky, y posee la siguiente lista de películas

- Thor, 7.9, 2007 (Similar a Capitan America, Iron Man)
- Capitan America, 7.8, 2016 (Similar a Thor, Iron Man)
- Iron man, 7.9, 2010 (Similar a Thor, Capitan America)
- Dunkirk, 7.9, 2017
- Rocky, 8.1, 1976 (Similar a Rambo)
- Rambo, 7.8, 1979 (Similar a Rocky)

Las películas que debería sugerir son:

- **(i)** Dunkirk, Capitan America, Iron man
- **(ii)** Capitán América, Iron man, Rambo
- **(iii)** Dunkirk, Iron man, Capitan America

> **Nota**: si existen más de 3 películas con el mismo criterio, retorna 3 de ellas sin importar cuales. Por ejemplo, si las 6 películas son del 2018, el criterio (i) retorna 3 cualquiera.

### Tareas:
- **1)** Realice el diseño de una correcta solución orientada a objetos con un diagrama UML de clases.
- **2)** Si utiliza patrones de diseño indique cuáles y también indique los participantes de esos patrones en su solución según el libro de Gamma et al.
- **3)** Escriba un test case que incluya estos pasos, con los ejemplos mencionados anteriormente:
    - configure al decodificador para que sugiera por similaridad (ii)
    - solicite al mismo decodificador las sugerencias
    - configure al mismo decodificador para que sugiera por puntaje (iii)
    - solicite al mismo decodificador las sugerencias
- **4)** Programe su solución en Java. Debe implementarse respetando todas las buenas prácticas de diseño y programación de POO.



<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 13 Acceso a la base de datos

Queremos acceder a una base de datos que contiene información sobre cómics. Este acceso está dado por el comportamiento de la clase DatabaseRealAccess con el siguiente protocolo y modelado como muestra la siguiente figura.

![image (1)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/ec96378c-9038-4445-b622-02d13c28df5a)


```java
public interface DatabaseAccess {
    /**
    * Realiza la inserción de nueva información en la base de datos y
    * retorna el id que recibe la nueva inserción
    *
    * @param rowData
    * @return
    */
    public int insertNewRow(List<String> rowData);

    /**
    * Retorna una colección de acuerdo al texto que posee
    "queryString"
    *
    * @param queryString
    * @return
    */
    public Collection<String> getSearchResults(String queryString);
}
```

En este caso, ustedes recibirán una implementación prototípica de la clase
**DatabaseRealAccess** (ver [material extra](https://drive.google.com/file/d/1pR6rCjLZ2EpPvHcHhP195gy5mpghhHdE/view)) que simula el uso de una base datos de la siguiente forma (mire el código y los tests para entender cómo está implementada).

```java
// Instancia una base de datos que posee dos filas
database = new DatabaseRealAccess();
// Retorna el siguiente arreglo: ['Spiderman' 'Marvel'].
database.getSearchResults("select * from comics where id=1");
// Retorna 3, que es el id que se le asigna
database.insertNewRow(Arrays.asList("Patoruzú", "La flor"));
// Retorna el siguiente arreglo: ['Patoruzú', 'La flor'], ya que lo insertó antes
database.getSearchResults("select * from comics where id=3");
```

### Tareas

En esta oportunidad, usted debe proveer una solución utilizando un patrón que le permita brindar protección al acceso a la base de datos de forma que lo puedan realizar solamente usuarios que se hayan autenticado previamente. Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos.

- **1)** Diagrama de clases UML.
- **2)** Implementación en Java de la funcionalidad requerida.
- **3)** Implementación de los tests (JUnit) que considere necesarios.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 14 File Manager

En un **File Manager** se muestran los archivos. De los archivos se conoce:
- Nombre
- Extensión
- Tamaño
- Fecha de creación
- Fecha de modificación
- Permisos

Implemente la clase **FileOO2**, con las correspondientes variables de instancia y accessors.

En el File Manager el usuario debe poder elegir cómo se muestra un archivo (instancia de la clase FileOO2), es decir, cuáles de los aspectos mencionados anteriormente se muestran, y en qué orden. Esto quiere decir que un usuario podría querer ver los archivos de muchas maneras.

Algunas de ellas son:

- nombre - extensión
- nombre - extensión - fecha de creación
- permisos - nombre - extensión - tamaño

Para esto, el objeto o los objetos que representen a los archivos en el FileManager debe(n) entender el mensaje `prettyPrint().`

Es decir, un objeto cliente (digamos el FileManager) le enviará al objeto que Ud. determine, el mensaje `prettyPrint()`. **De acuerdo a cómo el usuario lo haya configurado se deberá retornar un String con los aspectos seleccionados por el usuario en el orden especificado por éste**. Considere que un mismo archivo podría verse de formas diferentes desde distintos puntos del sistema, y que el usuario podría cambiar la configuración del sistema (qué y en qué orden quiere ver) en runtime.

### Tareas

- **1)** Discuta los requerimientos y diseñe una solución. Si aplica un patrón de diseño, indique cuál es y justifique su aplicabilidad.
- **2)** Implemente en Java.
- **3)** Instancie un objeto para cada uno de los ejemplos citados anteriormente y verifique escribiendo tests de unidad.


<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 15 Estación meteorológica

Sea una estación meteorológica hogareña que permite conocer información de varios aspectos del clima. Esta estación está implementada con la clase HomeWeatherStation que interactúa con varios sensores para conocer fenómenos físicos. La misma implementa los siguientes métodos:

```java
//retorna la temperatura en grados Fahrenheit
public double getTemperaturaFahrenheit()
//retorna la presión atmosférica en hPa
public double getPresion()
//retorna la radiación solar
public double getRadiacionSolar()
//retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
public List<Double> getTemperaturasFahrenheit()
```

Esta clase se encuentra implementada por terceros y **no se puede modificar**.

Nos piden construir una aplicación que además de lo anteriormente descripto pueda obtener:

- La temperatura en grados Celsius `(ºC = (ºF-32) ÷ 1.8).`
- El promedio de las temperaturas históricas en grados Fahrenheit.

Además, la aplicación debe permitir al usuario configurar qué datos mostrar y en qué orden. Esto significa que podría querer ver la información de muchas maneras, por ejemplo:

- **Ejemplo 1** “Presión atmosférica: 1008”
- **Ejemplo 2** “Presión atmosférica: 1008 Radiación solar: 500”
- **Ejemplo 3** “Radiación solar: 500 Temperatura C: 28 Promedio de temperaturas C: 25”

Para ello, usted debe proveer en algún punto de su solución, la implementación del mensaje public String displayData() que devuelva los datos elegidos en el orden configurado (dado que la app aun no cuenta con interface de usuario).

Haga uso de la clase HomeWeatherStation sin modificarla.

### Tareas

- **1)** Modele una solución para el problema planteado. Si utiliza algún patrón, indique cuál
- **2)** Implemente en Java
- **3)** Implemente un test para validar la configuración del ejemplo 2, asumiendo que en el momento de la ejecución del mismo, los sensores arrojan los valores del ejemplo


<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 16 Productos Financieros

Un banco ofrece los siguientes productos financieros a sus clientes:

- Compra de Dolares
- Compra de Pesos
- Plazo Fijo
- Plazo Fijo Auto-Renovable

A menudo el banco crea nuevos productos financieros que son combinaciones de estos productos

![image (2)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/8e6a17f7-4030-489c-921d-565ea1063d24)

Por ejemplo, el banco ofrece un nuevo producto que combina los siguientes productos: 
- 1) Compra de dólares
- 2) Plazo fijo (en dólares a 30 días y 50% interés) 
- 3) Compra de pesos 
- 4) Plazo fijo renovable (en pesos a 60 días y 80% de interés). 

Cuando se invoca el mensaje ganancia(), se indica un monto inicial, para que calcule y retorne la ganancia


### Tareas:

- `a)` Proponga una solución para que los desarrolladores no tengan que instanciar el Composite de Productos financieros explícitamente cada vez que sea necesario crear uno nuevo.
    - `i)` ¿Qué ventaja y que desventaja tiene su solución?
- `b)` La gerencia financiera ha decidido enviar la especificación de los nuevos productos en formato JSON. ¿Cómo afecta esto a la solución presentada hasta el momento?



<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 17 Infraestructura en la Nube

Una empresa ofrece servicios de cómputo en la Nube para micro procesos. Los micro procesos son procesos que corren por un plazo muy corto y producen una salida conocida, por ejemplo comprimir un directorio o correr un algoritmo sobre una serie de archivos JPEG.

Los micro procesos son instanciados bajo demanda (cada vez que se necesita) en diferentes (grandes) proveedores de infraestructura en la nube: Amazon, Microsoft y Google . Cada proveedor de infraestructura en la nube tiene una manera diferente y única de proveer el servicio, como por ejemplo: RPC, SOAP, REST.

Los micro procesos son definidos por un archivo JSON con la descripción del hardware: 

Procesador, GPU, Memoria RAM, FileSystem y un directorio que contiene el código fuente y los scripts de compilación. La empresa provee a sus abonados una interfaz WebDAV donde guardar la información antes descripta y una REST API para lanzar la ejecución. Cada vez que se lanza la ejecución de un micro proceso la empresa crea una nueva instancia.

Actualmente el método que implementa el REST API para lanzar un micro proceso tiene toda la lógica para manejar los distintos proveedores de infraestructura. La empresa planea ampliar la lista de proveedores para incorporar nuevos como ARSAT, DATCO, BlueOcean entre otros.

Más allá de los detalles técnicos de la instanciación de los micro procesos, ¿qué patrón facilitaría la necesidad de expansión de la empresa?

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 18 SubteWay

Sugerencia: no resuelva este ejercicio en ayunas.

Una cadena de comidas rápidas especializada en sándwiches necesita resolver el cálculo de precios de éstos. El cálculo es simple: el precio de un sándwich equivale a la suma del precio de cada uno de sus componentes; el problema es la dificultad para representar y crear cada uno de los sándwiches distintos.

Existen cuatro sandwiches distintos, pero podrían aparecer nuevos en el futuro

- **Clásico**: consta de pan brioche (100 pesos), aderezo a base de mayonesa (20 pesos), principal de carne de ternera(300 pesos) y adicional de tomate (80 pesos).
- **Vegetariano**: consta de pan con semillas (120 pesos), sin aderezo, principal de provoleta grillada (200 pesos) y adicional de berenjenas al escabeche (100 pesos).
- **Vegano**: consta de pan integral (100 pesos), aderezo de salsa criolla (20 pesos), principal de milanesa de girgolas (500 pesos), sin adicional.
- **Sin TACC**: consta de pan de chipá (150 pesos), aderezo de salsa tártara (18 pesos), principal de carne de pollo (250 pesos) y adicional de verduras grilladas (200 pesos).


### Tareas:

Proponga un diseño e implementación para la creación y cálculo de precios de estas
alternativas de sándwiches. 

Si en su solución aplicó algún(os) patrón(es) de diseño, indique cuál(es) y sus roles

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 19 Personajes de juegos de rol

Una empresa de videojuegos ofrece personajes para sus juegos de rol. Cada personaje tiene un nombre y viene equipado con armaduras, armas, y habilidades únicas que les permiten desempeñarse mejor.

Las armaduras pueden ser de cuero, de hierro y de acero. Las armas pueden ser espadas, arcos y bastón de mago. Las habilidades pueden ser de combate cuerpo a cuerpo, de combate a distancia, de curación y de magia.

Actualmente ofrece 3 personajes: guerreros, arqueros y magos.

Los magos son expertos en el uso de la magia. Están equipados con una armadura de cuero para permitir la máxima movilidad. Su arma es un bastón mágico, y su habilidad es la magia y el combate a distancia. Los guerreros son los expertos en combate cuerpo a cuerpo, por lo
tanto requieren una armadura de acero y una espada. Finalmente, los arqueros son
especialistas tiros de flechas. Como deben moverse rápidamente, tienen una armadura de
cuero y están equipados con arcos.

En el juego, los personajes tienen la posibilidad de enfrentarse entre sí. Durante un
enfrentamiento, el resultado dependerá del arma que utilice el atacante y de la armadura que lleve el defensor. A continuación, se muestra una tabla con el daño que cada arma causa. Ese valor afecta el puntaje del jugador atacado.

|           | ArmaduraDeCuero | ArmaduraDeHierro | ArmaduraDeAcero |
|-----------|-----------------|------------------|-----------------|
| Espada    | 8               | 5                | 3               |
| Arco      | 5               | 3                | 2               |
| Baston    | 2               | 1                | 1               |

Al inicio del juego, cada personaje comienza con 100 puntos de vida, los cuales se reducirán a medida que se enfrenten a otros jugadores. Un personaje podrá participar de un combate siempre que tenga vida


### Tareas:

- **1)** Diseñe una solución orientada a objetos que permita la creación de personajes y el enfrentamiento entre ellos. Tenga en cuenta que en un futuro, la empresa planea ofrecer nuevos personajes. Provea el diagrama de clases UML y si utiliza algún patrón de diseño, indique cuál.
- **2)** Implemente en Java el comportamiento descripto

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 19.b Mas Personajes

Extienda el ejercicio anterior para permitir que la empresa pueda ofrecer un nuevo personaje llamado “Thoor”, que requieren armadura de hierro y un martillo, con habilidades de lanzar rayos y combate a distancia.


> Nota: puede completar la tabla con los valores que desee.


<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 20 Aerolínea Regional

Una aerolínea regional (UFly) tiene vuelos diarios entre La Plata, Balcarce y Pergamino.

| Vuelo | Frecuencia | Salida        | Arriba         | Costo Base |
|-------|------------|---------------|----------------|------------|
| UF101 | Diario     | La Plata 07:00 am | Balcarce 08:00 am | $12000      |
| UF102 | Diario     | Balcarce 09:00 am | Pergamino 10:30 am | $15000      |
| UF201 | Diario     | La Plata 02:00 pm | Pergamino 03:15 pm | $14000      |
| UF202 | Diario     | Pergamino 05:00 pm | Balcarce 06:30 pm | $15000      |
| UF203 | Diario     | Balcarce 08:00 pm | La Plata 09:00 pm | $12000      |


La aerolínea opera una flota de 2 aviones Pilatus PC-12. Uno de ellos en configuración estándar (9 pasajeros) y el otro en configuración ejecutiva (6 pasajeros), ambos modelos tienen una capacidad de carga de 1.500 kg. La asignación de la aeronave a la ruta a volar está dada por políticas de operación de la flota que están fuera del problema.


Cada pasaje está compuesto por tramos que pueden requerir la realización de varios vuelos o conexiones, con el fin de llegar al destino final. Por ejemplo, si alguien desea viajar de La Plata a Pergamino, puede tomar un vuelo de La Plata a Balcarce y, posteriormente, otro vuelo de Balcarce a Pergamino. Cada uno de estos vuelos se consideraría un tramo del pasaje
completo

El valor de los pasajes se calcula de la siguiente manera:

**CostoBase** * **RateDiario** * **RateRoundtrip** * **RateMultiHop**

El RateRoundtrip se aplica a los pasajes que comienzan y terminan en la misma ciudad y es igual a 0.95. El RateMultiHop se aplica a los pasajes que incluyan al menos tres destinos diferentes y es igual a 0.93. El RateDiario varía según el día de la semana.

| RateRoundtrip | Pasajes que comienzan y terminan en la misma ciudad |
|---------------|--------------------------------------------------|
| Si            | 0.95  |
| No            | 1     |

| RateMultiHop | Pasaje incluye al menos tres destinos diferentes |	
|--------------|--------------------------------------------------------|
| Si           | 0.93  |
| No           | 1     |

| RateDiario | Día de la semana |
|------------|------------------|
| 1          | Lunes            |
| 1.01       | Martes           |
| 0.99       | Miércoles        |
| 0.95       | Jueves           |
| 1          | Viernes          |
| 1.01       | Sábado           |
| 1.01       | Domingo          |

- **a)** La empresa requiere un modelo que permita implementar la venta de pasajes (emitir, modificar y cancelar). De cada pasajero se conoce Nombre y DNI. De cada pasaje se conoce el pasajero, el/los vuelos y el/los asientos. Además de permitir emitir, modificar y cancelar pasajes, la empresa necesita conocer la siguiente información:
    - Promedios de ocupación de cada vuelo dado un periodo de tiempo,
    - Horas voladas por cada avión en un periodo de tiempo
    - Horas voladas por cada avión en total
    - Monto total de los descuentos por RoundTrip y por MultiHop
    - Eficiencia de Tarifas = Sumatoria de todo lo facturado/Sumatoria de CostosBasicos de pasajes vendidos
- **b)** La empresa desea evaluar agregar servicios de transporte de paquetes. En este
servicio los clientes dejan y retiran sus paquetes en alguno de los aeropuertos que sirve
la empresa. Los paquetes tienen como máximo una dimensión de 50cmx50cmx60cm y
un peso de 7Kg. La fórmula para calcular el valor del envío.

**CostoBase * RateDiario * RateMultiHop**

El CostoBase del servicio es $3000 por kilo. RateDario y RateMultiHop son los mismos ya presentados.

- **c)** La empresa desea evaluar cómo el modelo que responde al punto a) se vería afectado si los Costos Básicos por vuelo cambiarán a lo largo del tiempo. Si fuera necesario, se solicita modificar el modelo para responder a este nuevo requerimiento.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 21 Genealogía salvaje

Retomamos el ejercicio de genealogía salvaje de Objetos 1, ahora utilizando los conceptos vistos en Objetos 2.

Se trata de una reserva de vida salvaje (como la estación de cría ECAS, en el camino Centenario), donde los cuidadores están interesados en llevar un registro detallado de los animales que cuidan y sus familias. Para ello nos han pedido ayuda.

El siguiente es un diagrama de clases inicial (incompleto) y nos da una idea de los mensajes que un mamífero entiende.

![image](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/bf4a176e-b1cd-44ef-85ea-6412f70dfb19)

### Tareas:

- **1)** Complete el diagrama de clases para reflejar los atributos y relaciones requeridos.
- **2)** Implemente completamente en Java. Si utiliza algún patrón de diseño, indique cuál.



<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 22 Monitoreo de proceso industrial

Una empresa está desarrollando un sistema de monitoreo de un proceso industrial, el cual involucra un tanque mezclador. El proceso industrial se define como una secuencia de pasos.

El siguiente diagrama muestra dos de esos pasos. Los pasos implementan los métodos:

- execute(:MixingTank) recibe como parámetro un MixingTank y ejecuta comandos
sobre el mismo
- isDone() retorna un booleano que describe si el paso fue realizado con éxito

![image (3)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/19694606-70d2-4c5a-a655-6f2015bd66df)


<table>
    <tr>
        <th>LightMix.basicExecute(tank)</th>
        <th>Purge.basicExecute(tank)
</th>
</tr>
<tr>
<td>

```java
return (tank.heatPower(20%) &&
tank.mixerPower(5%))
```
</td>
<td>

```java
return (tank.heatPower(0%)&&
tank.mixerPower(0%)&&
tank.purge())
```
</td>
</tr>
</table>


El tanque mezclador posee un motor que mueve paletas internas y un calentador eléctrico. El fabricante del tanque provee una librería que permite conectar el tanque a una computadora de control. La librería implementa el driver que permite la comunicación entre el tanque y la computadora a través del protocolo I2C y provee una clase que ofrece una interfaz de alto nivel con las operaciones básicas del dispositivo (tanque).

![image (4)](https://github.com/Fabian-Martinez-Rincon/Fabian-Martinez-Rincon/assets/55964635/b0089380-9717-41eb-a39c-c951386bc0f7)


No se dispone de una implementación concreta de MixingTank pero su comportamiento esperado es el siguiente:

- **heatPower**: configura el nivel potencia de la fuente de calor del tanque de 0 a 100
- **mixerPower**: configura el nivel de potencia de la mezcladora del tanque de 0 a 100
- **purge**: comanda al tanque para que se desagote
- **upTo**: retorna el volumen ocupado del tanque de 0 a 100
- **temperature**: retorna la temperatura del contenido del tanque

---

#### Parte 1

Implemente las clases ProcessStep, LightMix y Purge, completando el pseudocódigo provisto.


#### Parte 2

Implemente Test de Unidad para ambas clases cubriendo casos de éxito y falla
- **a)** Explique qué tipo de TestDouble es necesario implementar para cubrir esta versión de test cases.


#### Parte 3

Se conocen especificaciones del tanque y se han redefinido las definiciones de LightMix y Purge. Actualice la implementación de clases y de los test cases cubriendo casos de éxito y falla.
- **a)** Explique qué tipo de TestDouble es necesario implementar para cubrir esta
versión de test cases

<table>
<tr>
<td>MixingTank</td>
<td>

CompletePurge time: 4 sec

Heat transfer

- At 100% = 5 ºC/sec
- At 75% = 4 ºC/sec
- At 50% = 2 ºC/sec
- At 25% = 1 ºC/sec
- At 0% = 0 ºC/sec
</td>
</tr>

</table>


<table>
<tr>
<th>LightMix.basicExecute(tank) </th>
<th>Purge.basicExecute(tank)</th>
</tr>
<tr>
<td>

```java
temp = tank.temperature()
tank.heatPower(100%)
delay(2sec)
if(tank.temperature()-temp == 10 ){
    tank.mixerPower(5%)
    return true
}
else{
    return false
}
```
</td>
<td>

```java
if (tank.upTo() = 0){
    return false
}
else{
    tank.heatPower(0%)
    tank.mixerPower(0%)
    tank.purge()
    delay(4sec)
    If (tank.upTo() != 0){
        return false
    }
}
return true
```

</td>
</tr>
</table>


