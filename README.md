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

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 13 Acceso a la base de datos

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 14 File Manager

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 15 Estación meteorológica

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 16 Productos Financieros

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 17 Infraestructura en la Nube

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 18 SubteWay

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 19 Personajes de juegos de rol

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 19.b Mas Personajes

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 20 Aerolínea Regional

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 21 Genealogía salvaje

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 22 Monitoreo de proceso industrial

---
