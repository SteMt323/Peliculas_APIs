# Services Impl

Esta carpeta contiene las implementaciones concretas de las interfaces de servicio.

## Responsabilidades

- Implementar la logica de negocio definida en `AutorService` y `PeliculaService`.
- Validar datos obligatorios antes de guardar o actualizar.
- Buscar entidades relacionadas, como el autor de una pelicula.
- Lanzar excepciones controladas cuando un recurso no existe o una solicitud es invalida.
- Ejecutar operaciones dentro de transacciones con `@Transactional`.

## Clases

- `AutorServiceImpl`: implementa las operaciones de negocio para autores.
- `PeliculaServiceImpl`: implementa las operaciones de negocio para peliculas.

## Flujo general

Ejemplo al crear una pelicula:

```text
Controller -> PeliculaService -> PeliculaRepository / AutorRepository -> PeliculaMapper -> Response
```

Esta capa es importante porque concentra las reglas de negocio y evita que los controladores dependan directamente de la base de datos.
