<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

- [Parciales Frameworks](#parciales-frameworks)
- [Cuadernillo](#cuadernillo)

## Parciales Frameworks

![alt text](/Finales/image.png)

<details><summary>1 ¿La ejecución del código de esta subclase, se realiza mediante inversión de control? Justifique su respuesta de forma concisa. </summary>

Sí, se realiza mediante inversión de control. En el marco del `RuleEngine`, la clase `Rule` define los métodos abstractos `shouldProcess()` y `process()`, y el método `run()` controla cuándo se llaman estos métodos. La ejecución del comportamiento específico de cada regla depende de cómo estas funciones son implementadas en las subclases de `Rule`, mientras que `RuleEngine` maneja el flujo de ejecución general sin saber los detalles específicos de las implementaciones de las reglas. Este patrón donde el control del flujo del programa está invertido, con el marco llamando a métodos definidos por el usuario, es un ejemplo clásico de inversión de control.
</details>

<details><summary>2 ¿Cuáles son los hook methods?</summary>
   
Los hook methods en el contexto del documento y el diagrama de clases son `shouldProcess()` y `process()`. Estos métodos actúan como ganchos porque proporcionan puntos de intervención específicos para que el usuario del framework personalice el comportamiento del mismo sin cambiar su código base. Permiten que la lógica de la decisión (`shouldProcess()`) y la acción (`process()`) sean definidas por el usuario, adaptando el framework a necesidades específicas.</details>

<details><summary>3 Describa, de forma concisa, el frozen spot del extracto del framework presentado.</summary>
   
El frozen spot en el marco de `RuleEngine` es la estructura y el flujo de control definidos en el método `run()` de la clase `RuleEngine`. Este método gestiona cómo las reglas se revisan y ejecutan, invocando `rule.run()` para cada `Rule` en la lista `this.rules`. La lógica que determina que todas las reglas deben ser evaluadas y ejecutadas en orden y la forma en que esto se orquesta, son aspectos del framework que no están destinados a ser modificados por el usuario, estableciendo así un frozen spot.

</details>

---

![alt text](/Finales/image-1.png)

<details><summary>1 ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición? Justifique su respuesta.</summary>

El comportamiento variable del framework está implementado mediante **herencia**. Esto se puede ver en la clase `EmailFilter`, que es una clase abstracta con métodos abstractos `isEmailAllowed` y `addEmail`. Estos métodos deben ser implementados por las subclases que extienden `EmailFilter`, permitiendo personalizar cómo se filtran y agregan los correos electrónicos a `EmailInbox`. La herencia se utiliza aquí para definir un "contrato" o una interfaz que las subclases deben cumplir, permitiendo diferentes comportamientos mientras se mantiene la estructura básica del filtro de correo.

</details>

<details><summary>2 Indique la(s) línea(s) donde encuentra inversión de control. Justifique su respuesta.</summary>

La inversión de control se encuentra en la línea 8 dentro del método `filterEmail`, específicamente en el llamado `this.isEmailAllowed(anEmail)`. Este método es abstracto y su implementación será proporcionada por las subclases de `EmailFilter`. Aquí, el control del flujo del programa es "invertido" porque la clase `EmailFilter` no controla cómo se realiza la verificación de los correos; en cambio, delega esta responsabilidad a las subclases que definen el comportamiento específico de `isEmailAllowed`. Esto es inversión de control porque la clase base (framework) llama a métodos que son implementados por el usuario del framework (las subclases).

</details>

<details><summary>3. El método isEmailAllowed, ¿es un hot spot? ¿Por qué?</summary>

Sí, el método `isEmailAllowed` es un hot spot. Un hot spot en un framework es una parte del código que está intencionadamente diseñada para ser modificada o extendida para adaptar el comportamiento del framework a necesidades específicas. En este caso, `isEmailAllowed` es un método abstracto que debe ser implementado por cualquier subclase de `EmailFilter`, lo que permite a los usuarios del framework definir criterios específicos para decidir si un correo electrónico debe ser aceptado en el inbox. Esto proporciona un punto flexible donde el comportamiento puede ser modificado sin cambiar el código del framework en sí.

</details>

---

![alt text](/Finales/image-2.png)

<details><summary>1. ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición? Justifique su respuesta.</summary>

El comportamiento variable en este framework está implementado mediante **composición**. Esto se observa en cómo `RedundancyEngine` gestiona múltiples objetos de tipo `Storage`. El framework permite que diferentes tipos de almacenamiento (como `FileStorage` o `InMemoryStorage`) sean agregados dinámicamente a la lista de `storages`. Cada `Storage` puede tener una implementación diferente de cómo guardar y recuperar datos, pero `RedundancyEngine` los maneja uniformemente a través de la interfaz `Storage`. Este enfoque de composición permite la flexibilidad de agregar o cambiar las implementaciones de almacenamiento sin modificar el código existente del motor de redundancia.

</details>

<details><summary>2. ¿Cuáles son los hook methods?</summary>

Los métodos hook en este caso son `save(String key, String data)`, `hasKey(String key)` y `get(String key)` definidos en la interfaz `Storage`. Estos métodos permiten a las clases que implementan la interfaz `Storage` definir cómo se realizan estas operaciones esenciales. Al ser métodos que deben ser implementados por cualquier almacenamiento que se quiera integrar en el `RedundancyEngine`, actúan como puntos de extensión donde se puede alterar el comportamiento del almacenamiento.

</details>


<details><summary>3. ¿Cuál es el Frozen Spot?</summary>

El **Frozen Spot** en este framework es la clase `RedundancyEngine` y su interacción con la interfaz `Storage`. En particular, la forma en que `RedundancyEngine` itera sobre cada almacenamiento disponible para guardar y recuperar datos (los bucles en los métodos `save` y `get`) constituye un frozen spot. Estas partes del código están diseñadas para no ser modificadas, ya que dictan cómo se debe interactuar con los objetos `Storage` en cualquier configuración del framework. El flujo de guardar datos en todos los almacenamientos y recuperar el primer dato disponible que corresponde a una clave garantiza la redundancia de datos y no está destinado a ser cambiado por los usuarios del framework.

</details>

---

![alt text](/Finales/image-3.png)

<details><summary>1. ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición?</summary>

El comportamiento variable del framework, representado en este caso por la capacidad de definir diferentes estrategias de autorización, se implementa a través de **composición**. Esto se evidencia en la utilización de la interfaz `Permission`, que diferentes implementaciones pueden cumplir para proporcionar distintas lógicas de autorización. Al crear un objeto `API` con una lista de `Permission`, se delega la responsabilidad de la verificación de acceso a los objetos de `Permission` que se pasen en tiempo de ejecución. Esta estructura permite modificar el comportamiento del framework sin alterar su código fuente, adheriéndose al principio de composición sobre herencia para mejorar la flexibilidad y mantenibilidad.

</details>


<details><summary>2. ¿Observa hook methods? ¿Cuáles?</summary>

Los hook methods en este framework son `allowAccess(Request request)` y `throwException(Request request)`, definidos en la interfaz `Permission`. Estos métodos actúan como ganchos, permitiendo a los implementadores de la interfaz `Permission` definir cómo se manejan las verificaciones de permisos y las excepciones. Esta estructura permite a los usuarios del framework personalizar cómo se gestionan los permisos y las respuestas en caso de acceso denegado, ofreciendo un punto flexible para adaptar el comportamiento del sistema a requerimientos específicos.

</details>


<details><summary>3. ¿Cuál es el Frozen Spot?</summary>

El frozen spot en este framework está representado por la clase `API`, en particular, por la lógica encapsulada en el método `processRequest(Request request)`. Este método establece el flujo de procesamiento de solicitudes, donde siempre se verifica la autorización mediante `checkPermissions(request)` y se manejan las respuestas basadas en si el acceso es permitido o denegado. Este flujo de procesamiento es fijo y no está destinado a ser modificado por los usuarios del framework, garantizando que todas las solicitudes sean procesadas de manera consistente.

</details>

<details><summary>4. ¿En lo que se describe anteriormente y lo que se indica debe hacer quien utiliza el framework, ¿observa inversión de control? ¿dónde?</summary>

Sí, hay una inversión de control evidente en cómo la clase `API` maneja las solicitudes. En lugar de la clase `API` controlar directamente cómo se verifican los permisos, este control se invierte hacia las implementaciones de la interfaz `Permission` que son pasadas al constructor de `API`. Este patrón es un ejemplo clásico de inversión de control, donde el framework (clase `API`) no realiza directamente las tareas de verificación, sino que llama a métodos definidos en objetos que son proporcionados por el usuario del framework (implementaciones de `Permission`), permitiendo que detalles específicos de la autorización sean definidos externamente y pasados al framework para su uso.

</details>

---

![alt text](/Finales/image-4.png)


`1)` Indique, para cada uno de los siguientes items, si es parte de algún hotspot o si no corresponde a ninguno de los dos.

<details><summary> a. El framework se asegura de que la preparación y el desarmado se efectúan antes y después de cada test.</summary>

**Frozen spot:** Esto es parte del frozen spot porque la lógica que maneja el setup (`setUp()`) y el teardown (`tearDown()`) antes y después de cada test es parte del flujo controlado por el framework (`TestCase`) y no está destinado a ser modificado por el usuario.

</details>

<details><summary> b. Al definir una prueba, el programador determina cómo hacer la preparación (si es necesaria).</summary>

**Hotspot:** Esto es un hotspot, ya que permite al desarrollador personalizar cómo se prepara cada prueba al sobrescribir el método `setUp()`.

</details>

<details><summary> c. La clase Test es abstracta.</summary>

**Hotspot:** La clase `Test` ser abstracta es un diseño que requiere que el usuario del framework implemente el método `test()`, lo que indica un punto de extensión o hotspot, ya que permite al usuario definir el comportamiento específico de la prueba.

</details>

<details><summary> d. Al correr un caso de prueba se corren todas las pruebas incluidas en el caso.</summary>

**Frozen spot:** Esto es parte del frozen spot porque la lógica de ejecución de todas las pruebas (`runTests()`) dentro de un caso de prueba está controlada por el framework y no se espera que los usuarios la modifiquen.

</details>

<details><summary>e. Al definir una prueba el programador define los pasos de la prueba (usando los asserts que provee el framework).</summary>

**Hotspot:** Definir los pasos específicos de la prueba y cómo se utilizan los asserts es un hotspot, ya que permite al usuario del framework especificar la lógica de verificación dentro del método `test()` que deben implementar.

</details>

<details><summary>2. ¿Observa métodos gancho? ¿Cuáles?</summary>

Los métodos gancho observados en este framework incluyen:
- **`setUp()`:** Método que puede ser sobrescrito por el usuario para preparar el entorno antes de cada test.
- **`tearDown()`:** Método que puede ser sobrescrito para limpiar después de cada test.
- **`test()`:** Método abstracto que debe ser implementado por el usuario para definir los pasos específicos de la prueba.

</details>

<details><summary>3. ¿Observa inversión de control? ¿Dónde?</summary>

Sí, se observa inversión de control en la manera en que el framework gestiona la ejecución de las pruebas:
- **En `TestCase`:** La clase `TestCase` controla cuándo y cómo se ejecutan los métodos `setUp()`, `test()` y `tearDown()`. No es el código del usuario el que llama a estos métodos directamente, sino el framework quien los invoca en orden específico, lo cual es un claro ejemplo de inversión de control.

</details>

<details><summary>4. ¿Caracterizaría el framework como caja blanca o caja negra? ¿Por qué?</summary>

El framework podría caracterizarse como **caja blanca** debido a que:
- Los usuarios necesitan tener un conocimiento interno de cómo funciona el framework para poder implementar correctamente sus pruebas. Deben saber qué métodos sobrescribir (`setUp()`, `tearDown()`, `test()`) y cómo se comportan en el contexto del flujo de control del framework.
- La estructura del framework y los métodos que deben ser implementados o extendidos son visibles y accesibles para el usuario, lo que es típico de los frameworks de caja blanca.

</details>

---

### Cuadernillo

- [Ejercicio 1 Red Social](#ejercicio-1-red-social)
- [Ejercicio 2 Piedra Papel o Tijera](#ejercicio-2-piedra-papel-o-tijera)
- [Ejercicio 3: Friday the 13th en Java](#ejercicio-3-friday-the-13th-en-java)
- [Ejercicio 3.b - Usando la librería JSON.simple](#ejercicio-3b---usando-la-librería-jsonsimple)
- [Ejercicio 4: Cálculo de sueldos](#ejercicio-4-cálculo-de-sueldos)
- [Ejercicio 5: Media Player](#ejercicio-5-media-player)
- [Ejercicio 6: Topografías](#ejercicio-6-topografías)
- [Ejercicio 6b: Más Topografías](#ejercicio-6b-más-topografías)
- [Ejercicio 7: FileSystem](#ejercicio-7-filesystem)
- [Ejercicio 8: ToDoItem](#ejercicio-8-todoitem)
- [Ejercicio 9: Excursiones](#ejercicio-9-excursiones)
- [Ejercicio 10: Encriptador](#ejercicio-10-encriptador)
- [Ejercicio 11: Administrador de proyectos](#ejercicio-11-administrador-de-proyectos)
- [Ejercicio 12 - Dispositivo móvil y conexiones](#ejercicio-12---dispositivo-móvil-y-conexiones)
- [Ejercicio 13 - Decodificador de películas](#ejercicio-13---decodificador-de-películas)
- [Ejercicio 14: Acceso a la base de datos](#ejercicio-14-acceso-a-la-base-de-datos)
- [Ejercicio 15 - File Manager](#ejercicio-15---file-manager)
- [Ejercicio 16 - Estación meteorológica](#ejercicio-16---estación-meteorológica)
- [Ejercicio 17 - Productos Financieros](#ejercicio-17---productos-financieros)
- [Ejercicio 18 - Sistema de monitoreo](#ejercicio-18---sistema-de-monitoreo)
- [Ejercicio 19 - Personajes de juegos de rol](#ejercicio-19---personajes-de-juegos-de-rol)
- [Ejercicio 19b - Mas Personajes](#ejercicio-19b---mas-personajes)
- [Ejercicio 20 - Filtros de Imágenes](#ejercicio-20---filtros-de-imágenes)
- [Ejercicio 20b - Secuencia de Filtros](#ejercicio-20b---secuencia-de-filtros)
- [Ejercicio 20c - Instanciando Secuencia de Filtros](#ejercicio-20c---instanciando-secuencia-de-filtros)
- [Ejercicio 21 - Genealogía salvaje](#ejercicio-21---genealogía-salvaje)
- [Ejercicio 22 - SubteWay](#ejercicio-22---subteway)
- [Ejercicio 23: Aerolínea Regional](#ejercicio-23-aerolínea-regional)
- [Ejercicio 24 - Monitoreo de proceso industrial](#ejercicio-24---monitoreo-de-proceso-industrial)
- [Ejercicio 25 - Acceso bajo demanda ](#ejercicio-25---acceso-bajo-demanda)

---

### Ejercicio 1 Red Social

Se quiere programar en objetos una versión simplificada de una red social parecida a Twitter. Este servicio debe permitir a los usuarios registrados postear y leer mensajes de hasta 280 caracteres. Ud. debe modelar e implementar parte del sistema donde nos interesa que quede claro lo siguiente:

- Cada usuario conoce todos los Tweets que hizo.
- Un tweet puede ser re-tweet de otro, y este tweet debe conocer a su tweet de origen.
- Twitter debe conocer a todos los usuarios del sistema.
- Los tweets de un usuario se deben eliminar cuando el usuario es eliminado. No existen tweets no referenciados por un usuario.
- Los usuarios se identifican por su screenName.
- No se pueden agregar dos usuarios con el mismo screenName.
- Los tweets deben tener un texto de 1 carácter como mínimo y 280 caracteres como máximo.
- Un re-tweet no tiene texto adicional.

#### Tareas

Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos.

- Diagrama de clases UML.
- Implementación en Java de la funcionalidad requerida.
- Implementar los tests (JUnit) que considere necesarios.

> Nota: para crear el proyecto Java, lea el material llamado “Trabajando en OO2 con proyectos Maven”.

---

### Ejercicio 2 Piedra Papel o Tijera

Se quiere programar en objetos una versión del juego Piedra Papel o Tijera. En este juego dos jugadores eligen entre tres opciones: piedra, papel o tijera. La piedra aplasta la tijera, la tijera corta el papel, y el papel envuelve la piedra. Los jugadores eligen una opción y se determina un ganador según las reglas: 

Here is the table in text format:

|        | Piedra | Papel | Tijera |
|--------|--------|-------|--------|
| Piedra | Empate | Papel | Piedra |
| Papel  | Papel  | Empate| Tijera |
| Tijera | Piedra | Tijera| Empate |

#### Tareas:

`Ejercicio 1)` Diseñe e implemente una solución a este problema, de forma tal que dadas dos opciones, determine cuál fue la ganadora, o si hubo empate

`Ejercicio 2)` Se desea extender al juego a una versión más equitativa que integre a lagarto y Spock, con las siguientes reglas:

- Piedra aplasta tijera y aplasta lagarto.
- Papel cubre piedra y desaprueba Spock.
- Tijera corta papel y decapita lagarto.
- Lagarto come papel y envenena Spock.
- Spock rompe tijera y vaporiza piedra.

¿Qué cambios se necesitan agregar?

Agregue los cambios a la solución anterior.


---

### Ejercicio 3: Friday the 13th en Java

> Nota: Para realizar este ejercicio, utilice el material adicional que se encuentra en el siguiente [link](https://drive.google.com/file/d/1xCC1uWt8DC_beCwg6vJTb7brcD7_2W7T/view). Allí encontrará un proyecto Maven que contiene el código fuente de las clases Biblioteca, Socio y VoorheesExporter.

La clase Biblioteca implementa la funcionalidad de exportar el listado de sus socios en formato JSON. Para ello define el método **exportarSocios()** de la siguiente forma:

```java
/**
 * Retorna la representación JSON de la colección de socios.
 */
public String exportarSocios() {
   return exporter.exportar(socios);
}
```


La Biblioteca delega la responsabilidad de exportar en una instancia de la clase  VoorheesExporter que dada una colección de socios, retorna un texto con la representación de la misma en formato JSON. Esto lo hace mediante el mensaje de instancia **exportar(List<.Socio>)**. 

De un socio se conoce el nombre, el email y el número de legajo. Por ejemplo, para una biblioteca que posee una colección con los siguientes socios:

<table>
    <tr>
        <td>
            <ul>
                <li>Nombre: Arya Stark</li>
                <li>e-mail: needle@stark.com</li>
                <li>legajo: 5234-5</li>
            </ul>
        </td>
        <td>
            <ul>
                <li>Nombre: Tyron Lannister</li>
                <li>e-mail: tyron@thelannisters.com</li>
                <li>legajo: 2345-2</li>
            </ul>
        </td>
    </tr>
</table>

Ud. puede probar la funcionalidad ejecutando el siguiente código:

```java
Biblioteca biblioteca = new Biblioteca();
biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
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

Note los corchetes de apertura y cierre de la colección, las llaves de apertura y cierre para cada socio y la coma separando a los socios.

#### Tareas:
- Analice la implementación de la clase Biblioteca, Socio y VoorheesExporter que se provee con el material adicional de esta práctica ([Archivo biblioteca.zip](https://drive.google.com/file/d/1xCC1uWt8DC_beCwg6vJTb7brcD7_2W7T/view)).
- Documente la implementación mediante un diagrama de clases UML. 
- Programe los Test de Unidad para la implementación propuesta.


---

### Ejercicio 3.b - Usando la librería JSON.simple

Su nuevo desafío consiste en utilizar la librería JSON.simple para imprimir en formato JSON a los socios de la Biblioteca en lugar de utilizar la clase VoorheesExporter. Pero con la siguiente condición: **nada de esto debe generar un cambio en el código de la clase Biblioteca.**

La librería JSON.simple es liviana y muy utilizada para leer y escribir archivos JSON.  

Entre las clases que contiene se encuentran:

- JSONObject : Usada para representar los datos que se desean exportar de un objeto.  Esta clase provee el método put(Object, Object) para agregar los campos al mismo. Aunque el primer argumento sea de tipo Object, usted debe proveer el nombre del atributo como un string. El segundo argumento contendrá el valor del mismo. Por ejemplo, si point es una instancia de JSONObject, se podrá ejecutar point.put(“x”, 50);
- JSONArray: Usada para generar listas. Provee el método add(Object) para agregar los elementos a la lista, los cuales, para este caso, deben ser JSONObject.

Ambas clases implementan el mensaje toJSONString() el cual retorna un String con la representación JSON del objeto.

- JSONParser : Usada para recuperar desde un String con formato JSON los elementos que lo componen. 

#### Tareas

`1)` Instale la librería JSON.simple agregando la siguiente dependencia al archivo pom.xml de Maven

```xml
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
```

`2)` Utilice esta librería para imprimir, en formato JSON, los socios de la Biblioteca en lugar de utilizar la clase VoorheesExporter, sin que esto genere un cambio en el código de la clase Biblioteca.

- Modele una solución a esta alternativa utilizando un diagrama de clases UML. Si utiliza patrones de diseño indique los roles en las clases utilizando estereotipos.
- Implemente en Java la solución incluyendo los tests que crea necesarios.

`3)` Investigue sobre la librería Jackson, la cual también permite utilizar el formato JSON para serializar objetos Java.  Extienda la implementación para soportar también esta librería.

---

### Ejercicio 4: Cálculo de sueldos

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
        <td>$ 20.000 + cantidad de horas que trabaje * $ 300.</td>
        <td>$20.000</td>
        <td>$50.000</td>
    </tr>
    <tr>
        <td>adicional</td>
        <td>$5.000 si está casado<br>$2.000 por cada hijo</td>
        <td>$2.000 por examen que rindió</td>
        <td>$5.000 si está casado<br>$2.000 por cada hijo<br>$2.000 por cada año de antigüedad</td>
    </tr>
    <tr>
        <td>descuento</td>
        <td>13% del sueldo básico<br>5% del sueldo adicional</td>
        <td>13% del sueldo básico<br>5% del sueldo adicional</td>
        <td>13% del sueldo básico<br>5% del sueldo adicional</td>
    </tr>
</table>

### Tareas

- Diseñe la jerarquía de Empleados de forma tal que cualquier empleado puede responder al mensaje #sueldo. 
- Desarrolle los test cases necesarios para probar todos los casos posibles.
- Implemente en Java.


---

### Ejercicio 5: Media Player

Usted ha implementado una clase Media player, para reproducir archivos de audio y video en formatos que usted ha diseñado. Cada Media se puede reproducir con el mensaje play(). Para continuar con el desarrollo, usted desea incorporar la posibilidad de reproducir Video Stream. Para ello, dispone de la clase VideoStream que pertenece a una librería de terceros y usted no puede ni debe modificarla. El desafío que se le presenta es hacer que la clase MediaPlayer pueda interactuar con la clase VideoStream. 

La situación se resume en el siguiente diagrama UML:

![image](https://github.com/user-attachments/assets/12411d5b-3b54-40e2-9fec-bc1bee968c74)

#### Tareas

- Modifique el diagrama de clases UML para considerar los cambios necesarios. Si utiliza patrones de diseño indique los roles en las clases utilizando estereotipos.
- Implemente en Java

---

### Ejercicio 6: Topografías

Un uso común de imágenes satelitales es el estudio de las cuencas hídricas que incluye saber la proporción entre la parte seca y la parte bajo agua. En general las imágenes satelitales están divididas en celdas. Las celdas son imágenes digitales (con píxeles) de las cuales se quiere extraer su “topología”.

Un objeto Topografía representa la distribución de agua y tierra de una celda satelital, la cual está formada por porciones de “agua” y de “tierra”. La siguiente figura muestra:

- (a) el aspecto de una topografía formada únicamente por agua.
- (b) otra formada solamente por tierra. 
- (c) y (d) topografías mixtas.

![image](https://github.com/user-attachments/assets/e064b3d9-2c88-41c9-aed8-928a697c6921)

Una topografía mixta está formada por partes de agua y partes de tierra (4 partes en total). Estas a su vez, podrían descomponerse en 4 más y así siguiendo.
					
La proporción de agua de una topografía sólo agua es 1. La proporción de agua de una topografía sólo tierra es 0. La proporción de agua de una topografía compuesta está dada por la suma de la proporción de agua de sus componentes dividida por 4. En el ejemplo, la proporción de agua es: (1 +0+0 + 1) / 4 = 1/2. La proporción siempre es un valor entre 0 y 1. 

#### Tareas

`1)` Diseñe e implemente las clases necesarias para que sea posible:
- crear Topografías,
- calcular su proporción de agua y tierra,
- comparar igualdad entre topografías. Dos topografías son iguales si tienen exactamente la misma composición. Es decir, son iguales las proporciones de agua y tierra, y además, para aquellas que son mixtas, la disposición de sus partes es igual. 

> Pista: notar que la definición de igualdad para topografías mixtas corresponde exactamente a la misma que implementan las listas en Java. https://docs.oracle.com/javase/8/docs/api/java/util/AbstractList.html#equals-java.lang.Object-

`2)` Diseñe e implemente test cases para probar la funcionalidad implementada. Incluya en el set up de los tests, la topografía compuesta del ejemplo. 


---

### Ejercicio 6b: Más Topografías

Extienda el ejercicio anterior para soportar (además de Agua y Tierra) el terreno Pantano. Un pantano tiene una proporción de agua de 0.7 y una proporción de tierra de 0.3. No olvide hacer las modificaciones necesarias para responder adecuadamente la comparación por igualdad.


---

### Ejercicio 7: FileSystem

Un File System es un componente que forma parte del sistema operativo. Este está estructurado jerárquicamente en forma de árbol, comenzando con un directorio raíz.

Los elementos del file system pueden ser directorios o archivos. Los archivos contienen datos y los directorios contienen archivos u otros directorios. De cada archivo se conoce el nombre, fecha de creación y tamaño en bytes. De cada directorio se conoce el nombre, fecha de creación y contenido (el tamaño es siempre la cantidad inicial de 32kb más la suma del tamaño de su contenido). Modele el file system y provea la siguiente funcionalidad:

```javascript
public class FileSystem {
   /**
   * Retorna el espacio total ocupado, incluyendo todo su contenido.
   */
   public int tamanoTotalOcupado()

   /**
   * Retorna el archivo con mayor cantidad de bytes en cualquier nivel del 
   * filesystem 
   */
   public Archivo archivoMasGrande()
   /**
   * Retorna el archivo con fecha de creación más reciente en cualquier nivel 
   * del filesystem
   */
   public Archivo archivoMasNuevo()

   /**
   * Retorna el primer elemento con el nombre solicitado contenido en cualquier
   * nivel del filesystem
   */
   public ?? buscar(String nombre)

   /**
   * Retorna la lista con los elementos que coinciden con el nombre solicitado 
   * contenido en cualquier nivel del filesystem
   */
   public List<??> buscarTodos(String nombre)

   /**
   * Retorna un String con los nombres de los elementos contenidos en todos los 
   * niveles del filesystem. De cada elemento debe retornar el path completo
   * (similar al comando pwd de linux) siguiendo el modelo presentado a
   * continuación
      /Directorio A
      /Directorio A/Directorio A.1
      /Directorio A/Directorio A.1/Directorio A.1.1
      /Directorio A/Directorio A.1/Directorio A.1.2 	
      /Directorio A/Directorio A.2
      /Directorio B
   */
   public String listadoDeContenido()
}
```

#### Tareas:
- Diseñe y represente un modelo UML de clases de su aplicación, identifique el patrón de diseño empleado (utilice estereotipos UML para indicar los roles de cada una de las clases en ese patrón).
- Diseñe, implemente y ejecute test cases para verificar el funcionamiento de su aplicación. 
- Implemente completamente en Java.


---

### Ejercicio 8: ToDoItem

Se desea definir un sistema de seguimiento de tareas similar a Jira. 

En este sistema hay tareas en las cuales se puede definir el nombre y una serie de comentarios. Las tareas atraviesan diferentes etapas a lo largo de su ciclo de vida y ellas son: pending, in-progress, paused y finished. Cada tarea debe estar modelada mediante la clase ToDoItem con el siguiente protocolo: 

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

> Nota: para generar o levantar un error debe utilizar la expresión 

```java
throw new RuntimeException("Este es mi mensaje de error");
```

El mensaje de error específico que se espera en este ejercicio debe ser descriptivo del caso. Por ejemplo, para el método togglePause() , el mensaje de error debe indicar que el ToDoItem no se encuentra en in-progress o paused: 

```java
throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
```

#### Tareas

- Modele una solución orientada a objetos para el problema planteado utilizando un diagrama de clases UML. Si utilizó algún patrón de diseño indique cuáles son los participantes en su modelo de acuerdo a Gamma et al.
- Implemente su solución en Java. Para comprobar cómo funciona recomendamos usar test cases.


---

### Ejercicio 9: Excursiones

Sea una aplicación que ofrece excursiones como por ejemplo “dos días en kayak bajando el Paraná”. Una excursión posee nombre, fecha de inicio, fecha de fin, punto de encuentro, costo, cupo mínimo y cupo máximo.
La aplicación ofrece las excursiones pero éstas sólo se realizan si alcanzan el cupo mínimo de inscriptos. Un usuario se inscribe a una excursión y si aún no se alcanzó el cupo mínimo, la inscripción se considera provisoria. Luego, cuando se alcanza el cupo mínimo, la inscripción se considera definitiva y podrá llevarse a cabo. Finalmente, cuando se alcanza el cupo máximo, la excursión solo registrará nuevos inscriptos en su lista de espera. 
De los usuarios inscriptos, la aplicación registra su nombre, apellido e email.

Por otro lado, en todo momento la excursión ofrece información de la misma, la cual consiste en una serie de datos que varían en función de la situación.
- Si la excursión no alcanza el cupo mínimo, la información es la siguiente: nombre, costo, fechas, punto de encuentro, cantidad de usuarios faltantes para alcanzar el cupo mínimo.
- Si la excursión alcanzó el cupo mínimo pero aún no el máximo, la información es la siguiente: nombre, costo, fechas, punto de encuentro, los mails de los usuarios inscriptos y cantidad de usuarios faltantes para alcanzar el cupo máximo.
- Si la excursión alcanzó el cupo máximo, la información solamente incluye nombre, costo, fechas y punto de encuentro.

En una primera versión, al no contar con una interfaz de usuario y a los efectos de debugging, este comportamiento puede implementarlo en un método que retorne un String con la información solicitada.

#### Tareas

- `1)` Realice un diseño UML. Si utiliza algún patrón indique cuál(es) y justifique su uso.
- `2)` Implemente lo necesario para instanciar una excursión y para instanciar un usuario.
- `3)` Implemente los siguientes mensajes de la clase Excursion:  
    - (i) public void inscribir (Usuario unUsuario) 
    - (ii) public String obtenerInformacion().
- `4)` Escriba un test para inscribir a un usuario en la excursión “Dos días en kayak bajando el Paraná”, con cupo mínimo de 1 persona y cupo máximo 2, con dos personas ya inscriptas. Implemente todos los mensajes que considere necesarios.


---

### Ejercicio 10: Encriptador

En un sistema de mensajes instantáneos (como WhatsApp) se envían mensajes de una máquina a otra a través de una red. Para asegurar que la información que pasa por la red no es espiada, el sistema utiliza una conexión segura. Este tipo de conexión encripta la información antes de enviarla y la desencripta al recibirla. La siguiente figura ilustra un posible diseño para este enunciado.

![image](https://github.com/user-attachments/assets/5541736a-5572-4811-96d9-17a3e6a6d0d4)

El encriptador utiliza el algoritmo RSA. Sin embargo, se desea agregar otros algoritmos (diferentes algoritmos ofrecen distintos niveles de seguridad, overhead en la transmisión, etc.).

#### Tareas:

- Modifique el diseño para que el objeto Encriptador pueda encriptar mensajes usando los algoritmos Blowfish y RC4, además del ya soportado RSA.
- Documente mediante un diagrama de clases UML indicando los roles de cada clase.


---

### Ejercicio 11: Administrador de proyectos

Consideremos una empresa que brinda servicios y los gestiona a través de proyectos. Los proyectos tienen una fecha de inicio y de fin, un objetivo, un número de integrantes (quienes cobran un monto fijo por día) y un margen de ganancia. Durante el armado del proyecto, el mismo debe pasar por un proceso de aprobación que involucra las etapas: En construcción -> En evaluación  -> Confirmada. Se desea implementar la siguiente funcionalidad: 

![image](https://github.com/user-attachments/assets/b121b84c-2d32-48f7-bc51-89bfe66fe2b5)

#### Tareas:
- `1)` Modele una solución y provea el diagrama de clases UML para el problema planteado. Si utiliza algún patrón, indique cuál.
- `2)` Implemente en Java.
- `3)` Implemente un test para aprobar un proyecto con las siguientes características: 
    - (i) se encuentra en evaluación, 
    - (ii) se llama “Vacaciones de invierno”, 
    - (iii) tiene como objetivo “salir con amigos”, y 
    - (iv) lo integran 3 personas.

> Nota: para generar o levantar un error debe utilizar la expresión 

```java
throw new RuntimeException("Este es mi mensaje de error");
```

---

### Ejercicio 12 - Dispositivo móvil y conexiones

Sea el software de un dispositivo móvil que utiliza una conexión WiFi para transmitir datos. La figura muestra parte de su diseño:

![image](https://github.com/user-attachments/assets/69a051be-5641-49c7-9f43-b9453274f773)

El dispositivo utiliza, para asegurar la integridad de los datos emitidos, el mecanismo de cálculo de redundancia cíclica que le provee la clase CRC16_Calculator que recibe el mensaje crcFor(data: String) con los datos a enviar y devuelve un valor numérico. Luego el dispositivo envía a la conexión el mensaje sendData con ambos parámetros (los datos y el valor numérico calculado).

Se desea hacer dos cambios en el software. En primer lugar, se quiere que el dispositivo tenga capacidad de ser configurado para utilizar conexiones 4G. Para este cambio se debe utilizar la clase 4GConnection.

Además se desea poder configurar el dispositivo para que utilice en distintos momentos un cálculo de CRC de 16 o de 32 bits. Es decir que en algún momento el dispositivo seguirá utilizando CRC16_Calculator y en otros podrá ser configurado para utilizar la clase CRC32_Calculator. Se desea permitir que en el futuro se puedan utilizar otros algoritmos de CRC. 

Cuando se cambia de conexión, el dispositivo muestra en pantalla el símbolo correspondiente (que se obtiene con el getter pict() para el caso de WiFiConn y symb() de 4GConnection) y se utiliza el objeto Ringer para emitir un ring().  

Tanto las clases existentes como las nuevas a utilizar pueden ser ubicadas en las jerarquías que corresponda (modificar la clase de la que extienden o la interfaz que implementan)  y se les pueden agregar mensajes, pero no se pueden modificar los mensajes que ya existen porque otras partes del sistema podrían dejar de funcionar. 

Dado que esto es una simulación, y no dispone de hardware ni emulador para esto, la signatura de los mensajes se ha simplificado para que se retorne un String descriptivo de los eventos que suceden en el dispositivo y permitir de esta forma simplificar la escritura de los tests.

Modele los cambios necesarios para poder agregar al protocolo de la clase Dispositivo los mensajes para 
- cambiar la conexión, ya sea la 4GConnection o la WifiConn. En este método se espera que se pase a utilizar la conexión recibida, muestre en el display su símbolo y genere el sonido. 
- poder configurar el calculador de CRC, que puede ser el CRC16_Calculator, el CRC32_Calculator, o pueden ser nuevos a futuro.

#### Tareas

- Realice un diagrama UML de clases para su solución al problema planteado. Indique claramente el o los patrones de diseño que utiliza en el modelo y el rol que cada clase cumple en cada uno.
- Implemente en Java todo lo necesario para asegurar el envío de datos por cualquiera de las conexiones y el cálculo adecuado del índice de redundancia cíclica.
- Implemente test cases para los siguientes métodos de la clase Dispositivo:
    - send
    - conectarCon
    - configurarCRC 

En cuanto a CRC16_Calculator, puede utilizar la siguiente implementación:

![image](https://github.com/user-attachments/assets/9ea3ea4c-f181-45be-95f7-c14679610f90)

Nota: para implementar CRC32_Calculator utilice la clase java.util.zip.CRC32 de la siguiente manera:

![image](https://github.com/user-attachments/assets/b3bfa8a7-f703-4f23-80fa-82e0033711e0)

---

### Ejercicio 13 - Decodificador de películas

Sea una empresa de cable on demand que entrega decodificadores a sus clientes para que miren las películas que ofrece. El decodificador muestra la grilla de películas y también sugiere películas. 

Usted debe implementar la aplicación para que el decodificador sugiera películas. El decodificador conoce la grilla de películas (lista completa que ofrece la empresa), como así también las películas que reproduce. De cada película se conoce título, año de estreno, películas similares y puntaje. La similaridad establece una relación recíproca entre dos películas, por lo que si A es similar a B entonces también B es similar a A. 

Cada decodificador puede ser configurado para que sugiera 3 películas (que no haya reproducido) por alguno de los siguientes criterios:

- (i) novedad: las películas más recientes. 
- (ii) similaridad: las películas similares a alguna película que reprodujo, ordenadas de más a menos reciente.
- (iii) puntaje: las películas de mayor puntaje, para igual puntaje considera las más recientes.

Tenga en cuenta que la configuración del criterio de sugerencia del decodificador no es fija, sino que el usuario la debe poder cambiar en cualquier momento. El sistema debe soportar agregar nuevos tipos de sugerencias aparte de las tres mencionadas.

Sea un decodificador que reprodujo Thor y Rocky, y posee la siguiente lista de películas:

```
Thor, 7.9, 2007 (Similar a Capitan America, Iron Man)
Capitan America, 7.8, 2016 (Similar a Thor, Iron Man)
Iron man, 7.9, 2010 (Similar a Thor, Capitan America)
Dunkirk, 7.9, 2017
Rocky, 8.1, 1976 (Similar a Rambo)
Rambo, 7.8, 1979 (Similar a Rocky)
```

Las películas que debería sugerir son:

```
(i) Dunkirk, Capitan America,  Iron man
(ii) Capitán América,  Iron man, Rambo
(iii) Dunkirk, Iron man, Capitan America
```

> Nota: si existen más de 3 películas con el mismo criterio, retorna 3 de ellas sin importar cuales. Por ejemplo, si las 6 películas son del 2018,  el criterio (i) retorna 3 cualquiera. 

#### Tareas:
- Realice el diseño de una correcta solución orientada a objetos con un diagrama UML de clases.
- Si utiliza patrones de diseño indique cuáles y también indique los participantes de esos patrones en su solución según el libro de Gamma et al.
- Escriba un test case que incluya estos pasos, con los ejemplos mencionados anteriormente:
    - configure al decodificador para que sugiera por similaridad (ii)
    - solicite al mismo decodificador las sugerencias
    - configure al mismo decodificador para que sugiera por puntaje (iii)
    - solicite al mismo decodificador las sugerencias
- Programe su solución en Java. Debe implementarse respetando todas las buenas prácticas de diseño y programación de POO.

---

### Ejercicio 14: Acceso a la base de datos

Queremos acceder a una base de datos que contiene información sobre cómics. Este acceso está dado por el comportamiento de la clase DatabaseRealAccess con el siguiente protocolo y modelado como muestra la siguiente figura.

![image](https://github.com/user-attachments/assets/76d0f7c7-29e2-4926-ab78-9e8b8981ed24)

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
    * Retorna una colección de acuerdo al texto que posee "queryString"
    *
    * @param queryString
    * @return
    */
   public Collection<String> getSearchResults(String queryString);
}
```

En este caso, ustedes recibirán una implementación prototípica de la clase DatabaseRealAccess (ver [material extra](https://drive.google.com/file/d/1pR6rCjLZ2EpPvHcHhP195gy5mpghhHdE/view)) que simula el uso de una base datos de la siguiente forma (mire el código y los tests para entender cómo está implementada).


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

#### Tareas

En esta oportunidad, usted debe proveer una solución utilizando un patrón que le permita brindar protección al acceso a la base de datos de forma que lo puedan realizar solamente usuarios que se hayan autenticado previamente. Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos.

- Diagrama de clases UML.
- Implementación en Java de la funcionalidad requerida.
- Implementación de los tests (JUnit) que considere necesarios.

---

### Ejercicio 15 - File Manager

En un File Manager se muestran los archivos. De los archivos se conoce:

- Nombre
- Extensión 
- Tamaño
- Fecha de creación
- Fecha de modificación
- Permisos

Implemente la clase FileOO2, con las correspondientes variables de instancia y accessors.

En el File Manager el usuario debe poder elegir cómo se muestra un archivo (instancia de la clase FileOO2), es decir, cuáles de los aspectos mencionados anteriormente se muestran,  y en qué orden.  Esto quiere decir que un usuario podría querer ver los archivos de muchas maneras. Algunas de ellas son:

- nombre - extensión
- nombre - extensión - fecha de creación
- permisos - nombre - extensión - tamaño

Para esto, el objeto o los objetos que representen a los archivos en el FileManager debe(n) entender el mensaje prettyPrint().

Es decir, un objeto cliente (digamos el FileManager) le enviará al objeto que Ud. determine, el mensaje prettyPrint(). **De acuerdo a cómo el usuario lo haya configurado se deberá retornar un String con los aspectos seleccionados por el usuario en el orden especificado por éste**. Considere que un mismo archivo podría verse de formas diferentes desde distintos puntos del sistema, y que el usuario podría cambiar la configuración del sistema (qué y en qué orden quiere ver) en runtime.

#### Tareas:
- Discuta los requerimientos y diseñe una solución. Si aplica un patrón de diseño, indique cuál es y justifique su aplicabilidad.
- Implemente en Java.
- Instancie un objeto para cada uno de los ejemplos citados anteriormente y verifique escribiendo tests de unidad.

---

### Ejercicio 16 - Estación meteorológica

Sea una estación meteorológica hogareña que permite conocer información de varios aspectos del clima. Esta estación está implementada con la clase HomeWeatherStation que interactúa con varios sensores para conocer fenómenos físicos. La misma implementa los siguientes métodos:

```java
//retorna la temperatura en grados Fahrenheit. 
public double getTemperatura()

//retorna la presión atmosférica en hPa
public double getPresion()

//retorna la radiación solar
public double getRadiacionSolar()

//retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
public List<Double> getTemperaturas()

//retorna  un reporte de todos los datos: temperatura, presión, y radiación solar.
public String displayData(){
    return "Temperatura F: " + this.getTemperatura() +
        "Presión atmosf: " + this.getPresion() +
        "Radiación solar: " + this.getRadiacionSolar();
}
```

Esta clase se encuentra implementada por terceros y no se puede modificar. Pero sabemos que implementa la interfaz WeatherData que define los mismos mensajes. 

Si bien el código de la clase HomeWeatherStation no se puede modificar, se requiere poder integrar diferentes configuraciones que combinen algunas de las siguientes funcionalidades:

- La temperatura en grados Celsius (ºC = (ºF-32) ÷ 1.8). 
- El promedio de las temperaturas históricas.
- Las temperaturas mínima y máxima histórica.

Esto implica que la aplicación debe ser capaz de adaptarse a diferentes necesidades de visualización. Por ejemplo:

```
Ej 1:  “Temperatura F: 86; Presión atmosf.: 1008; Radiación solar: 200;”
Ej 2:  “Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200;”
Ej 3:  “Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Promedio: 30;”
Ej 4:  “Temperatura F: 86; Presión atmosf: 1008; Radiación solar: 200; Promedio: 86;”
Ej 5: “Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Promedio: 30; Mínimo: 27 Máximo: 32;”
Ej 6:  “Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Mínimo: 27 Máximo: 32;”
Ej 7: “Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; Mínimo: 27 Máximo: 32; Promedio: 30;”
```

En cada uno de los ejemplos, la aplicación puede mostrar diferentes configuraciones de los datos, según lo que el usuario haya seleccionado previamente. Por ejemplo, la inclusión del promedio de temperatura (ya sea en grados Celsius o Fahrenheit) dependerá de la configuración de temperatura previamente establecida por el usuario.
Usted debe proveer la implementación del mensaje public String displayData() que devuelva los datos según lo configurado (dado que la app aun no cuenta con interface de usuario). 

#### Tareas:
- `1)` Modele una solución para el problema planteado. Si utiliza algún patrón, indique cuál
- `2)` Implemente en Java
- `3)` Implemente un test para validar la configuración del ejemplo 5, asumiendo que en el momento de la ejecución del mismo, los sensores arrojan los valores del ejemplo. 


---

### Ejercicio 17 - Productos Financieros

El banco ofrece los siguientes productos financieros a sus clientes:
- Compra de Dólares 
- Compra de Pesos
- Plazo Fijo (requiere indicar plazo e interés diario)
- Compra de bonos de bajo riesgo (tienen una variación máxima del 10% y se debe indicar un plazo mínimo o parking)
Compra de bonos de alto riesgo (tienen una variación máxima del 70% y se debe indicar un plazo mínimo o parking)

A menudo, el banco también innova creando nuevos productos financieros que son combinaciones de estos productos existentes. 

![image](https://github.com/user-attachments/assets/9e218ea9-d78a-47a5-8fea-62b05db9adaf)

Cuando se invoca el mensaje retornoInversión(), se indica un monto inicial, para que calcule y retorne el capital que se obtiene al invertir ese monto inicial. 

Algunos de los productos que ofrece, son combinaciones de otros, como por ejemplo: 

![image](https://github.com/user-attachments/assets/e0f181fc-dd94-4c47-b967-d2fbebf41a85)
![image](https://github.com/user-attachments/assets/f4c9b926-aee7-449a-8949-718452d04d71)

En el banco, cada cliente posee un tipo de membresía que determina sus beneficios. Contamos con dos niveles de membresía: Silver y Gold. Los clientes con membresía Silver tienen acceso exclusivo a los productos 1 y 2. Además, al realizar plazos fijos, disfrutan de una tasa del 5% y un plazo mínimo de 35 días. Asimismo, al comprar bonos, el periodo mínimo de parking es de 72 horas. Por otro lado, los clientes con membresía Gold reciben una tasa de plazo fijo del 6%, con un plazo mínimo de 30 días, y un periodo de parking de 24 horas. 

Se sabe que el banco se esfuerza constantemente por lanzar nuevos productos para satisfacer aún más las necesidades de inversión de sus clientes.

#### Tareas
- `a)` Proponga una solución para que los desarrolladores no tengan que instanciar el Composite de Productos financieros explícitamente cada vez que sea necesario crear uno nuevo.
    - `i)` ¿Qué ventaja y que desventaja tiene su solución?

> Nota: Para simular el comportamiento de los bonos se puede generar un número aleatorio dentro del rango de variación máxima, reflejando la típica volatilidad del mercado financiero

---

### Ejercicio 18 - Sistema de monitoreo

Una empresa ha desarrollado un sistema de monitoreo de viveros que incluye: temperatura y humedad. Para realizar esta tarea se utilizan módulos que incluyen sensores para ambos temperatura y humedad. El sistema fue desarrollado utilizando una familia de módulos que tienen diferentes prestaciones y que tienen un protocolo en común.

Instancias de ControlPanel cumplen el rol de cliente de las instancias de alguna de las clases de la Jerarquía SensingModule (variable module). Por la manera en la que una instancia de ControlPanel es inicializada con un "pollingPeriod" (ver pseudocódigo del constructor de ControlPanel), la instancia de ControlPanel recibirá periódicamente el mensaje updateView(), lo cual hace que se envíen los mensajes apropiados al “module” asociado.

![image](https://github.com/user-attachments/assets/1fb276e6-487c-48af-b289-b8bf742a0da4)

La empresa planea agregar un nuevo módulo que corresponda a uno de baja resolución (Low Resolution). Para implementar esto la empresa se propone adquirir un nuevo tipo de sensor cuya librería tiene el protocolo que muestra el diagrama de la clase CombinedMatrixSensor.

![image](https://github.com/user-attachments/assets/f72b522e-353c-4577-b7ae-16d874408af7)

Las operaciones que implementa la CombinedMatrixSensor son:
- `acquireSensor(mode:Integer)`. El parámetro “mode” que indica que tipo de medición se realizará. El valor 1 es para temperatura y el valor 2 es para humedad.
acquireAll(), no tiene parámetros y retorna un HashMap con valores para temperatura (clave “temp”) y humedad (clave “hum”).
reset(), no tiene parámetros y resetea todos los sensores
calibrate(timeout:Integer), el parámetro “timeout” indica cuál es el tiempo máximo que el sensor puede demorar en ejecutar una lectura.

---

### Ejercicio 19 - Personajes de juegos de rol

---

### Ejercicio 19b - Mas Personajes

---

### Ejercicio 20 - Filtros de Imágenes

---

### Ejercicio 20b - Secuencia de Filtros

---

### Ejercicio 20c - Instanciando Secuencia de Filtros

---

### Ejercicio 21 - Genealogía salvaje

---

### Ejercicio 22 - SubteWay

---

### Ejercicio 23: Aerolínea Regional

---

### Ejercicio 24 - Monitoreo de proceso industrial

---

### Ejercicio 25 - Acceso bajo demanda

---