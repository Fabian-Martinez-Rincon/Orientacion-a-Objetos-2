<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

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