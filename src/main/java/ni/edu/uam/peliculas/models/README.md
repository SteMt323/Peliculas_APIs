# Models

Esta carpeta contiene los modelos o entidades del dominio. Estas clases se mapean a tablas de PostgreSQL mediante JPA/Hibernate.

## Responsabilidades

- Representar las tablas de la base de datos.
- Definir campos, restricciones y relaciones entre entidades.
- Usar anotaciones como `@Entity`, `@Table`, `@Id`, `@OneToMany` y `@ManyToOne`.

## Entidades

### Autor

Entidad que representa la tabla `autores`.

Campos principales:

- `id`
- `nombre`
- `nacionalidad`
- `fechaNacimiento`
- `peliculas`

Relacion:

```text
Autor 1 ---- N Pelicula
```

### Pelicula

Entidad que representa la tabla `peliculas`.

Campos principales:

- `id`
- `titulo`
- `genero`
- `anioEstreno`
- `duracionMinutos`
- `sinopsis`
- `autor`

Relacion:

```text
Pelicula N ---- 1 Autor
```

Estas clases forman la base del modelo de datos de la aplicacion.
