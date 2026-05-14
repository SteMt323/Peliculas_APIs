# Repositories

Esta carpeta contiene los repositorios de Spring Data JPA. Los repositorios son la capa encargada de comunicarse con la base de datos.

## Responsabilidades

- Ejecutar operaciones CRUD sobre las entidades.
- Consultar datos desde PostgreSQL.
- Aprovechar los metodos heredados de `JpaRepository`.
- Definir consultas personalizadas cuando sean necesarias.

## Clases

- `AutorRepository`: administra operaciones de base de datos para la entidad `Autor`.
- `PeliculaRepository`: administra operaciones de base de datos para la entidad `Pelicula`.

## Metodos importantes

Los repositorios heredan metodos como:

```text
findAll()
findById(id)
save(entidad)
delete(entidad)
existsById(id)
```

`PeliculaRepository` tambien define:

```java
List<Pelicula> findByAutorId(Long autorId);
```

Ese metodo permite buscar todas las peliculas asociadas a un autor especifico.
