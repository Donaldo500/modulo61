# modulo61 - Inyección de dependencias con Spring

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_Framework-6-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

Ejemplos prácticos del contenedor de **Inversión de Control (IoC)** de Spring y de las distintas formas de **inyección de dependencias**, configurando los beans tanto por **XML** como por **anotaciones**.

## Descripción

El proyecto se divide en dos paquetes independientes, cada uno con su propia clase `Contexto` ejecutable:

### `com.ebac.Inyecciones` - configuración por XML

Define los beans en `META-INF/applicationContext.xml` y muestra tres estrategias para inyectar un `Model` en un servicio:

| Clase | Estrategia |
| --- | --- |
| `ServicioSetter` | Inyección por **setter** (`<property name="model" ref="ModelBean"/>`) |
| `ServicioConstructor` | Inyección por **constructor** (`<constructor-arg ref="ModelBean"/>`) |
| `ServicioAnotaciones` | Inyección con **`@Autowired`** habilitada por `<context:annotation-config/>` |

### `com.ebac.Anotaciones` - configuración por anotaciones

- `AnnotationConfigApplicationContext` con escaneo de paquetes (`context.scan(...)`).
- Clase `@Configuration` que declara un `@Bean` y carga propiedades con `@PropertySource`.
- Lectura de valores con `@Value("${db.dev.url}")` desde `application.properties` y de variables de entorno.
- Bean con alcance explícito `@Scope(SCOPE_SINGLETON)`.
- Resolución de múltiples implementaciones de una interfaz (`Figura` → `Cuadrado`, `Triangulo`) con `@Qualifier`.

## Tecnologías utilizadas

- Java 21
- Spring Framework (Spring Context, incluido a través de `spring-boot-starter-data-jpa` 3.3.5)
- Maven con `exec-maven-plugin`

## Estructura del proyecto

```text
src/main/
├── java/com/ebac/
│   ├── Inyecciones/
│   │   ├── Contexto.java
│   │   └── componentes/     # Model, ServicioSetter, ServicioConstructor, ServicioAnotaciones
│   └── Anotaciones/
│       ├── Contexto.java
│       ├── configuration/   # AppConfiguration (@Configuration, @PropertySource)
│       ├── interfaces/      # Figura, Cuadrado, Triangulo, FiguraService
│       └── service/         # Service (singleton), DataBase (@Value)
└── resources/META-INF/
    ├── applicationContext.xml
    └── application.properties
```

## Instalación y uso

```bash
git clone https://github.com/Donaldo500/modulo61.git
cd modulo61
mvn compile
```

### Ejemplo por XML

```bash
mvn exec:java -Dexec.mainClass="com.ebac.Inyecciones.Contexto"
```

Salida esperada:

```text
Datos obtenidos de la base de datos
```

Para probar las otras estrategias, descomenta las líneas de `ServicioSetterBean` o `ServicioConstructorBean` en `Inyecciones/Contexto.java`.

### Ejemplo por anotaciones

La clase `DataBase` lee la variable `VARIABLE_AMBIENTE`, por lo que debe existir antes de ejecutar:

```bash
# Linux / macOS
export VARIABLE_AMBIENTE=desarrollo
# Windows (PowerShell)
$env:VARIABLE_AMBIENTE="desarrollo"

mvn exec:java -Dexec.mainClass="com.ebac.Anotaciones.Contexto"
```

Salida esperada:

```text
HashCode del objeto Service: <hash>
Conectando a la base de datos en: http://localhost:3306/nombreDeBD
Usuario: root
Contraseña: root
Variable de ambiente: desarrollo
Data for ID: 17
----------------------------------------------
Soy un cuadrado
Soy un triangulo
```

## Ejemplo de código

```java
@Component
public class FiguraService {
    @Autowired
    @Qualifier("cuadrado")
    Figura figura1;

    @Autowired
    @Qualifier("triangulo")
    Figura figura2;
}
```

## Contribuciones

Proyecto individual con fines de aprendizaje. Las sugerencias son bienvenidas mediante issues o pull requests.

## Autor

**Donaldo Ibarra** - [@Donaldo500](https://github.com/Donaldo500)
