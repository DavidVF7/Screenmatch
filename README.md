# 🎬 Proyecto ScreenMatch 

Este proyecto fue desarrollado durante los cursos de la formación en Java como parte del programa ONE de Alura Latam en colaboración con Oracle. 
Durante el desarrollo, se exploraron conceptos avanzados de Java y se aplicaron en la creación de esta aplicación.

## 📝 Descripción 

Este proyecto, desarrollado en Java, utiliza los principios de la programación orientada a objetos para facilitar consulta y la gestión de toda la información de una película y/o serie por medio del de estas. 
Desde la creación de clases que representan los diferentes tipos de títulos hasta el cálculo de tiempos de visualización y la clasificación de recomendaciones, ScreenMatch proporciona una herramienta para buscar información sobre peliculas y series.
El proyecto incorpora conceptos avanzados de Java, como herencia, interfaces, manejo de excepciones, manipulación de listas y consumo de APIs externas, ofreciendo 
una experiencia de aprendizaje integral para aquellos que deseen explorar y comprender en profundidad las capacidades de este lenguaje de programación.

## 📂 Estructura del Proyecto 

El proyecto está organizado en varios paquetes que contienen clases con funcionalidades específicas:

- **`com.aluracursos.screenmatch.calculos`:** Contiene clases relacionadas con cálculos y filtros.
- **`com.aluracursos.screenmatch.excepcion`:** Define una excepción personalizada.
- **`com.aluracursos.screenmatch.modelos`:** Contiene las clases que representan los diferentes títulos y la interfaz de clasificación.
- **`com.aluracursos.screenmatch.principal`:** Contiene las clases principales que ejecutan el programa.

## 🚀 Clases y Funcionalidades 

### ⏰`CalculadoraDeTiempo` 

- **Funcionalidad:** Calcula el tiempo total de visualización de títulos.
- **Métodos:**
  - `getTiempoTotal`: Obtiene el tiempo total de visualización.
  - `incluye`: Agrega un título a la calculadora para incluir su duración en el tiempo total.

### 🌟 `FiltroRecomendacion` 

- **Funcionalidad:** Filtra títulos según su clasificación.
- **Métodos:**
  - `filtra`: Filtra títulos según su clasificación y muestra un mensaje correspondiente.

### ❌ `ErrorEnConversionDeDuracionException` 

- **Funcionalidad:** Excepción personalizada para errores en la conversión de duración de títulos.

### 📑 `Titulo` 

- **Funcionalidad:** Representa un título genérico.
- **Implementa:** `Comparable<Titulo>`
- **Métodos:**
  - `compareTo`: Compara dos títulos por nombre.
  - `muestraFichaTecnica`: Muestra la ficha técnica del título.
  - `evalua`: Registra una evaluación del título.
  - `calculaMediaEvaluaciones`: Calcula la media de las evaluaciones.

### 🎥 `Pelicula` 

- **Funcionalidad:** Representa una película.
- **Extiende:** `Titulo`
- **Implementa:** `Clasificacion`
- **Métodos:**
  - `getClasificacion`: Calcula la clasificación de la película.
  - `toString`: Devuelve una representación en cadena de la película.

### 📺 `Serie` 

- **Funcionalidad:** Representa una serie.
- **Extiende:** `Titulo`
- **Métodos:**
  - `getDuracionEnMinutos`: Calcula la duración total de la serie en minutos.
 
### 📺`Episodio` 

- **Funcionalidad:** Representa un episodio de una serie.
- **Implementa:** `Clasificacion`
- **Métodos:**
  - `getClasificacion`: Calcula la clasificación del episodio según el total de visualizaciones.

### 🌐 `TituloOmdb` 

- **Funcionalidad:** Representa un título obtenido de la API OMDb.
- **Campos:** `title`, `year`, `runtime`

### 🚀 `Principal` 

- **Funcionalidad:** Clase principal que contiene métodos `main` para ejecutar el programa.
- **Métodos:**
  - `main`: Contiene ejemplos de uso de las clases y funcionalidades del proyecto.

## ▶️ Ejecución del Proyecto 

El proyecto cuenta con varias clases `Principal` que contienen métodos `main` para ejecutar diferentes partes del programa, incluyendo la integración con la API OMDb y la manipulación de listas de títulos.

Para ejecutar el programa, puede utilizar la clase `Principal` correspondiente a la funcionalidad que desee probar. Por ejemplo:

- `Principal`: Ejecuta ejemplos de creación y manipulación de títulos.
- `PrincipalConBusqueda`: Realiza búsquedas de títulos en la API OMDb y guarda los resultados en un archivo JSON.
- `PrincipalConListas`: Ejecuta ejemplos de manipulación de listas de títulos y ordenamiento.

## 👨‍💻 Desarrollado por
- David Velasco Fierros

## 💻 Tecnologías Utilizadas 

- **Java**: Lenguaje de programación principal utilizado en el desarrollo del proyecto.
- **IntelliJ IDEA**: Entorno de desarrollo integrado utilizado para escribir, depurar y compilar el código.
- **API de OMDb**: Utilizada para obtener información sobre películas y series.
- **Biblioteca Gson**: Utilizada para la conversión de objetos Java a JSON y viceversa.

## 📝Notas Finales 

Este proyecto proporciona una base sólida para la gestión de títulos de películas y series en Java, aplicando conceptos avanzados de programación orientada a objetos y manipulación de datos. Se recomienda explorar y modificar el código para adaptarlo a sus necesidades específicas.

