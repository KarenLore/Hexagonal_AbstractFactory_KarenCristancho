# Hexagonal Abstract Factory and Singleton 
## Descripción

Este proyecto demuestra el uso de los patrones de diseño Hexagonal, Abstract Factory y Singleton en una aplicación de ejemplo.

## Patrones de Diseño

### Hexagonal
El patrón Hexagonal, también conocido como Arquitectura de Puertos y Adaptadores, se utiliza para crear aplicaciones que son fácilmente testeables y mantenibles. Este patrón separa la lógica de negocio de las preocupaciones externas como bases de datos y servicios web.

### Abstract Factory
El patrón Abstract Factory proporciona una interfaz para crear familias de objetos relacionados o dependientes sin especificar sus clases concretas. Este patrón es útil cuando el sistema debe ser independiente de cómo se crean y componen sus productos.

### Singleton
El patrón Singleton asegura que una clase tenga solo una instancia y proporciona un punto de acceso global a ella. Este patrón es útil cuando se necesita exactamente una instancia de una clase para coordinar acciones en todo el sistema.

## Estructura del Proyecto

- **src/**: Contiene el código fuente de la aplicación.
- **tests/**: Contiene las pruebas unitarias y de integración.
- **docs/**: Contiene la documentación del proyecto.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/KarenLoreHexagonal_AbstractFactory_KarenCristancho.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd Hexagonal_AbstractFactory_Karen
    ```
3. Compila el proyecto usando Maven:
    ```bash
    mvn clean install
    ```
