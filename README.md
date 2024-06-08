<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

![alt text](image.png)

Basándome en la información de los documentos proporcionados sobre herencia y composición en frameworks, aquí están las respuestas a las preguntas planteadas en el ejercicio original:

1. **¿La ejecución del código de esta subclase, se realiza mediante inversión de control? Justifique su respuesta de forma concisa.**
   
   Sí, se realiza mediante inversión de control. En el marco del `RuleEngine`, la clase `Rule` define los métodos abstractos `shouldProcess()` y `process()`, y el método `run()` controla cuándo se llaman estos métodos. La ejecución del comportamiento específico de cada regla depende de cómo estas funciones son implementadas en las subclases de `Rule`, mientras que `RuleEngine` maneja el flujo de ejecución general sin saber los detalles específicos de las implementaciones de las reglas. Este patrón donde el control del flujo del programa está invertido, con el marco llamando a métodos definidos por el usuario, es un ejemplo clásico de inversión de control.

2. **¿Cuáles son los hook methods?**
   
   Los hook methods en el contexto del documento y el diagrama de clases son `shouldProcess()` y `process()`. Estos métodos actúan como ganchos porque proporcionan puntos de intervención específicos para que el usuario del framework personalice el comportamiento del mismo sin cambiar su código base. Permiten que la lógica de la decisión (`shouldProcess()`) y la acción (`process()`) sean definidas por el usuario, adaptando el framework a necesidades específicas.

3. **Describa, de forma concisa, el frozen spot del extracto del framework presentado.**
   
   El frozen spot en el marco de `RuleEngine` es la estructura y el flujo de control definidos en el método `run()` de la clase `RuleEngine`. Este método gestiona cómo las reglas se revisan y ejecutan, invocando `rule.run()` para cada `Rule` en la lista `this.rules`. La lógica que determina que todas las reglas deben ser evaluadas y ejecutadas en orden y la forma en que esto se orquesta, son aspectos del framework que no están destinados a ser modificados por el usuario, estableciendo así un frozen spot.

Estas respuestas utilizan la conceptualización de hotspots, hooks y frozen spots tal como se describen en los documentos que has subido, aplicándolos específicamente al contexto y estructura del framework `RuleEngine` mostrado en la imagen inicial.

![alt text](image-1.png)

Basado en la imagen proporcionada y el contenido del ejercicio, aquí están las respuestas a las preguntas planteadas:

1. **¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición? Justifique su respuesta.**
   - El comportamiento variable del framework está implementado mediante **herencia**. Esto se puede ver en la clase `EmailFilter`, que es una clase abstracta con métodos abstractos `isEmailAllowed` y `addEmail`. Estos métodos deben ser implementados por las subclases que extienden `EmailFilter`, permitiendo personalizar cómo se filtran y agregan los correos electrónicos a `EmailInbox`. La herencia se utiliza aquí para definir un "contrato" o una interfaz que las subclases deben cumplir, permitiendo diferentes comportamientos mientras se mantiene la estructura básica del filtro de correo.

2. **Indique la(s) línea(s) donde encuentra inversión de control. Justifique su respuesta.**
   - La inversión de control se encuentra en la línea 8 dentro del método `filterEmail`, específicamente en el llamado `this.isEmailAllowed(anEmail)`. Este método es abstracto y su implementación será proporcionada por las subclases de `EmailFilter`. Aquí, el control del flujo del programa es "invertido" porque la clase `EmailFilter` no controla cómo se realiza la verificación de los correos; en cambio, delega esta responsabilidad a las subclases que definen el comportamiento específico de `isEmailAllowed`. Esto es inversión de control porque la clase base (framework) llama a métodos que son implementados por el usuario del framework (las subclases).

3. **El método `isEmailAllowed`, ¿es un hot spot? ¿Por qué?**
   - Sí, el método `isEmailAllowed` es un hot spot. Un hot spot en un framework es una parte del código que está intencionadamente diseñada para ser modificada o extendida para adaptar el comportamiento del framework a necesidades específicas. En este caso, `isEmailAllowed` es un método abstracto que debe ser implementado por cualquier subclase de `EmailFilter`, lo que permite a los usuarios del framework definir criterios específicos para decidir si un correo electrónico debe ser aceptado en el inbox. Esto proporciona un punto flexible donde el comportamiento puede ser modificado sin cambiar el código del framework en sí.

Estas respuestas están basadas en la estructura del código y los principios de diseño de software como la inversión de control y la definición de hot spots en un framework orientado a objetos.

![alt text](image-2.png)

En el ejercicio presentado, que muestra un framework para sistemas de redundancia de información utilizando un patrón de composición, analizaremos el uso de hotspots, hooks y la identificación de un frozen spot en base a las clases y métodos mostrados.

### 1. ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición? Justifique su respuesta.

El comportamiento variable en este framework está implementado mediante **composición**. Esto se observa en cómo `RedundancyEngine` gestiona múltiples objetos de tipo `Storage`. El framework permite que diferentes tipos de almacenamiento (como `FileStorage` o `InMemoryStorage`) sean agregados dinámicamente a la lista de `storages`. Cada `Storage` puede tener una implementación diferente de cómo guardar y recuperar datos, pero `RedundancyEngine` los maneja uniformemente a través de la interfaz `Storage`. Este enfoque de composición permite la flexibilidad de agregar o cambiar las implementaciones de almacenamiento sin modificar el código existente del motor de redundancia.

### 2. ¿Cuáles son los hook methods?

Los métodos hook en este caso son `save(String key, String data)`, `hasKey(String key)` y `get(String key)` definidos en la interfaz `Storage`. Estos métodos permiten a las clases que implementan la interfaz `Storage` definir cómo se realizan estas operaciones esenciales. Al ser métodos que deben ser implementados por cualquier almacenamiento que se quiera integrar en el `RedundancyEngine`, actúan como puntos de extensión donde se puede alterar el comportamiento del almacenamiento.

### 3. ¿Cuál es el Frozen Spot?

El **Frozen Spot** en este framework es la clase `RedundancyEngine` y su interacción con la interfaz `Storage`. En particular, la forma en que `RedundancyEngine` itera sobre cada almacenamiento disponible para guardar y recuperar datos (los bucles en los métodos `save` y `get`) constituye un frozen spot. Estas partes del código están diseñadas para no ser modificadas, ya que dictan cómo se debe interactuar con los objetos `Storage` en cualquier configuración del framework. El flujo de guardar datos en todos los almacenamientos y recuperar el primer dato disponible que corresponde a una clave garantiza la redundancia de datos y no está destinado a ser cambiado por los usuarios del framework.

Este análisis refleja cómo el diseño y la arquitectura del framework permiten extender su funcionalidad a través de la composición y definir comportamientos específicos mediante la implementación de interfaces, sin alterar la lógica central definida en los frozen spots.

![alt text](image-3.png)

Basándome en los documentos proporcionados sobre frameworks, herencia y composición, responderé a las preguntas sobre el extracto de código y diagrama de clases UML para un framework de autorización de acceso de APIs.

### 1. ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición?

El comportamiento variable del framework, representado en este caso por la capacidad de definir diferentes estrategias de autorización, se implementa a través de **composición**. Esto se evidencia en la utilización de la interfaz `Permission`, que diferentes implementaciones pueden cumplir para proporcionar distintas lógicas de autorización. Al crear un objeto `API` con una lista de `Permission`, se delega la responsabilidad de la verificación de acceso a los objetos de `Permission` que se pasen en tiempo de ejecución. Esta estructura permite modificar el comportamiento del framework sin alterar su código fuente, adheriéndose al principio de composición sobre herencia para mejorar la flexibilidad y mantenibilidad.

### 2. ¿Observa hook methods? ¿Cuáles?

Los hook methods en este framework son `allowAccess(Request request)` y `throwException(Request request)`, definidos en la interfaz `Permission`. Estos métodos actúan como ganchos, permitiendo a los implementadores de la interfaz `Permission` definir cómo se manejan las verificaciones de permisos y las excepciones. Esta estructura permite a los usuarios del framework personalizar cómo se gestionan los permisos y las respuestas en caso de acceso denegado, ofreciendo un punto flexible para adaptar el comportamiento del sistema a requerimientos específicos.

### 3. ¿Cuál es el Frozen Spot?

El frozen spot en este framework está representado por la clase `API`, en particular, por la lógica encapsulada en el método `processRequest(Request request)`. Este método establece el flujo de procesamiento de solicitudes, donde siempre se verifica la autorización mediante `checkPermissions(request)` y se manejan las respuestas basadas en si el acceso es permitido o denegado. Este flujo de procesamiento es fijo y no está destinado a ser modificado por los usuarios del framework, garantizando que todas las solicitudes sean procesadas de manera consistente.

### 4. ¿En lo que se describe anteriormente y lo que se indica debe hacer quien utiliza el framework, ¿observa inversión de control? ¿dónde?

Sí, hay una inversión de control evidente en cómo la clase `API` maneja las solicitudes. En lugar de la clase `API` controlar directamente cómo se verifican los permisos, este control se invierte hacia las implementaciones de la interfaz `Permission` que son pasadas al constructor de `API`. Este patrón es un ejemplo clásico de inversión de control, donde el framework (clase `API`) no realiza directamente las tareas de verificación, sino que llama a métodos definidos en objetos que son proporcionados por el usuario del framework (implementaciones de `Permission`), permitiendo que detalles específicos de la autorización sean definidos externamente y pasados al framework para su uso.

![alt text](image-4.png)

Vamos a abordar las preguntas basándonos en el diagrama de clases y la descripción del framework para automatización de pruebas de software que se muestra en el documento:

### 1. Indique, para cada uno de los siguientes items, si es parte de algún hotspot o si no corresponde a ninguno de los dos.

a. **El framework se asegura de que la preparación y el desarmado se efectúan antes y después de cada test.**
   - **Frozen spot:** Esto es parte del frozen spot porque la lógica que maneja el setup (`setUp()`) y el teardown (`tearDown()`) antes y después de cada test es parte del flujo controlado por el framework (`TestCase`) y no está destinado a ser modificado por el usuario.

b. **Al definir una prueba, el programador determina cómo hacer la preparación (si es necesaria).**
   - **Hotspot:** Esto es un hotspot, ya que permite al desarrollador personalizar cómo se prepara cada prueba al sobrescribir el método `setUp()`.

c. **La clase Test es abstracta.**
   - **Hotspot:** La clase `Test` ser abstracta es un diseño que requiere que el usuario del framework implemente el método `test()`, lo que indica un punto de extensión o hotspot, ya que permite al usuario definir el comportamiento específico de la prueba.

d. **Al correr un caso de prueba se corren todas las pruebas incluidas en el caso.**
   - **Frozen spot:** Esto es parte del frozen spot porque la lógica de ejecución de todas las pruebas (`runTests()`) dentro de un caso de prueba está controlada por el framework y no se espera que los usuarios la modifiquen.

e. **Al definir una prueba el programador define los pasos de la prueba (usando los asserts que provee el framework).**
   - **Hotspot:** Definir los pasos específicos de la prueba y cómo se utilizan los asserts es un hotspot, ya que permite al usuario del framework especificar la lógica de verificación dentro del método `test()` que deben implementar.

### 2. ¿Observa métodos gancho? ¿Cuáles?
Los métodos gancho observados en este framework incluyen:
- **`setUp()`:** Método que puede ser sobrescrito por el usuario para preparar el entorno antes de cada test.
- **`tearDown()`:** Método que puede ser sobrescrito para limpiar después de cada test.
- **`test()`:** Método abstracto que debe ser implementado por el usuario para definir los pasos específicos de la prueba.

### 3. ¿Observa inversión de control? ¿Dónde?
Sí, se observa inversión de control en la manera en que el framework gestiona la ejecución de las pruebas:
- **En `TestCase`:** La clase `TestCase` controla cuándo y cómo se ejecutan los métodos `setUp()`, `test()` y `tearDown()`. No es el código del usuario el que llama a estos métodos directamente, sino el framework quien los invoca en orden específico, lo cual es un claro ejemplo de inversión de control.

### 4. ¿Caracterizaría el framework como caja blanca o caja negra? ¿Por qué?
El framework podría caracterizarse como **caja blanca** debido a que:
- Los usuarios necesitan tener un conocimiento interno de cómo funciona el framework para poder implementar correctamente sus pruebas. Deben saber qué métodos sobrescribir (`setUp()`, `tearDown()`, `test()`) y cómo se comportan en el contexto del flujo de control del framework.
- La estructura del framework y los métodos que deben ser implementados o extendidos son visibles y accesibles para el usuario, lo que es típico de los frameworks de caja blanca.

Este análisis destaca la importancia de entender los componentes del framework y cómo interactúan para permitir la extensión y personalización mientras se mantienen ciertas operaciones como estándar y controladas centralmente.