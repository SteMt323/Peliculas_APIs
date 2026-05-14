# Controllers

Esta carpeta contiene los controladores REST de la aplicacion. Los controladores representan la capa de entrada de la API y reciben las solicitudes HTTP del cliente.

## Responsabilidades

- Definir las rutas disponibles de la API.
- Recibir parametros de URL, variables de ruta y cuerpos JSON.
- Llamar a los servicios correspondientes.
- Devolver respuestas HTTP con codigos adecuados, como `200 OK`, `201 Created` o `204 No Content`.

## Clases

- `AutorController`: expone las operaciones CRUD para autores y el endpoint para consultar las peliculas de un autor.
- `PeliculaController`: expone las operaciones CRUD para peliculas.

## Endpoints principales

```text
GET    /api/autores
GET    /api/autores/{id}
GET    /api/autores/{id}/peliculas
POST   /api/autores
PUT    /api/autores/{id}
DELETE /api/autores/{id}

GET    /api/peliculas
GET    /api/peliculas/{id}
POST   /api/peliculas
PUT    /api/peliculas/{id}
DELETE /api/peliculas/{id}
```

Los controladores no contienen logica de negocio compleja. Esa responsabilidad pertenece a la capa de servicios.
