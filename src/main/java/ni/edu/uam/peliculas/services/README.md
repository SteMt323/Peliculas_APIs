# Services

Esta carpeta contiene las interfaces de la capa de servicios. Los servicios definen las operaciones de negocio que la aplicacion ofrece.

## Responsabilidades

- Separar la logica de negocio de los controladores.
- Definir contratos para las operaciones CRUD.
- Coordinar el uso de repositorios, mappers y validaciones.
- Mantener los controladores simples y enfocados en HTTP.

## Interfaces

- `AutorService`: define las operaciones disponibles para autores.
- `PeliculaService`: define las operaciones disponibles para peliculas.

## Operaciones principales

Ambos servicios trabajan con operaciones como:

```text
listar()
buscarPorId(id)
crear(request)
actualizar(id, request)
eliminar(id)
```

`PeliculaService` tambien incluye:

```java
listarPorAutor(Long autorId)
```

Las implementaciones concretas se encuentran en la subcarpeta `impl`.
