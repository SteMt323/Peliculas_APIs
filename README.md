# API de Peliculas y Autores

API REST desarrollada con Spring Boot y Java para administrar peliculas y autores. El proyecto implementa una relacion entre dos entidades usando JPA/Hibernate y una base de datos relacional PostgreSQL.

La relacion principal es:

- Un autor puede tener muchas peliculas.
- Una pelicula pertenece a un autor.

## Tecnologias

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven

## Configuracion de base de datos

La configuracion actual se encuentra en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/peliculas
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

Antes de ejecutar el proyecto, asegurese de tener creada la base de datos `peliculas` en PostgreSQL.

## Distribucion del proyecto

```text
src/main/java/ni/edu/uam/peliculas
|-- controllers     Controladores REST de la API.
|-- dtos            Objetos para recibir y devolver datos.
|-- exceptions      Manejo centralizado de errores.
|-- mappers         Conversion entre entidades y DTOs.
|-- models          Entidades JPA del dominio.
|-- repositories    Acceso a datos con Spring Data JPA.
|-- services        Logica de negocio e interfaces de servicio.
|   |-- impl        Implementaciones de los servicios.
```

## Arquitectura MVC

El proyecto sigue una organizacion basada en MVC y capas de apoyo:

- Model: contiene las entidades `Autor` y `Pelicula`.
- View/Response: se representa mediante DTOs que definen los datos expuestos por la API.
- Controller: recibe solicitudes HTTP y devuelve respuestas REST.
- Service: contiene la logica de negocio.
- Repository: comunica la aplicacion con la base de datos.

## Entidades

### Autor

Representa a la persona asociada a una o varias peliculas.

Campos principales:

- `id`
- `nombre`
- `nacionalidad`
- `fechaNacimiento`
- `peliculas`

### Pelicula

Representa una pelicula registrada en el sistema.

Campos principales:

- `id`
- `titulo`
- `genero`
- `anioEstreno`
- `duracionMinutos`
- `sinopsis`
- `autor`

## Endpoints de Autores

Base URL:

```text
http://localhost:8080/api/autores
```

### Listar autores

```http
GET /api/autores
```

### Buscar autor por id

```http
GET /api/autores/{id}
```

### Crear autor

```http
POST /api/autores
Content-Type: application/json
```

Body:

```json
{
  "nombre": "",
  "nacionalidad": "",
  "fechaNacimiento": ""
}
```

### Actualizar autor

```http
PUT /api/autores/{id}
Content-Type: application/json
```

Body:

```json
{
  "nombre": "",
  "nacionalidad": "",
  "fechaNacimiento": ""
}
```

### Eliminar autor

```http
DELETE /api/autores/{id}
```

### Listar peliculas de un autor

```http
GET /api/autores/{id}/peliculas
```

## Endpoints de Peliculas

Base URL:

```text
http://localhost:8080/api/peliculas
```

### Listar peliculas

```http
GET /api/peliculas
```

### Buscar pelicula por id

```http
GET /api/peliculas/{id}
```

### Crear pelicula

```http
POST /api/peliculas
Content-Type: application/json
```

Body:

```json
{
  "titulo": "",
  "genero": "",
  "anioEstreno": ,
  "duracionMinutos": ,
  "sinopsis": "",
  "autorId": ,
}
```

### Actualizar pelicula

```http
PUT /api/peliculas/{id}
Content-Type: application/json
```

Body:

```json
{
  "titulo": "",
  "genero": "",
  "anioEstreno": ,
  "duracionMinutos": ,
  "sinopsis": "",
  "autorId": ,
}
```

### Eliminar pelicula

```http
DELETE /api/peliculas/{id}
```

## Respuestas de error

La API usa un manejador global de errores para responder de forma clara.

Ejemplo de error cuando no existe un recurso:

```json
{
  "timestamp": "2026-05-13T19:20:00",
  "status": 404,
  "error": "Not Found",
  "message": "No se encontro la pelicula con id 99",
  "path": "/api/peliculas/99"
}
```

## Como ejecutar

La API quedara disponible en:

```text
http://localhost:8080
```
