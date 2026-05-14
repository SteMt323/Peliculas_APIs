# DTOs

Esta carpeta contiene los Data Transfer Objects. Los DTOs son objetos usados para recibir datos desde el cliente y devolver respuestas sin exponer directamente las entidades JPA.

## Responsabilidades

- Definir el formato JSON que la API recibe.
- Definir el formato JSON que la API devuelve.
- Evitar que las entidades se usen directamente como contrato publico.
- Reducir problemas de serializacion, como ciclos infinitos entre `Autor` y `Pelicula`.

## Clases

- `AutorRequest`: datos necesarios para crear o actualizar un autor.
- `AutorResponse`: datos que se devuelven al consultar autores.
- `AutorResumenResponse`: version reducida de un autor, usada dentro de la respuesta de una pelicula.
- `PeliculaRequest`: datos necesarios para crear o actualizar una pelicula.
- `PeliculaResponse`: datos que se devuelven al consultar peliculas.

## Ejemplo

Para crear una pelicula, el cliente envia un `PeliculaRequest`:

```json
{
  "titulo": "Inception",
  "genero": "Ciencia ficcion",
  "anioEstreno": 2010,
  "duracionMinutos": 148,
  "sinopsis": "Un ladron especializado en extraer secretos de los suenos recibe una mision imposible.",
  "autorId": 1
}
```

La API responde usando un `PeliculaResponse`, incluyendo un resumen del autor asociado.
