# Mappers

Esta carpeta contiene las clases que convierten datos entre entidades JPA y DTOs.

## Responsabilidades

- Convertir un request DTO en una entidad.
- Convertir una entidad en un response DTO.
- Actualizar entidades existentes con datos recibidos desde el cliente.
- Evitar repetir codigo de conversion dentro de controladores y servicios.

## Clases

- `AutorMapper`: convierte entre `Autor`, `AutorRequest`, `AutorResponse` y `AutorResumenResponse`.
- `PeliculaMapper`: convierte entre `Pelicula`, `PeliculaRequest` y `PeliculaResponse`.

## Ejemplo conceptual

```text
PeliculaRequest -> Pelicula -> PeliculaResponse
```

El mapper permite que la entidad siga enfocada en la persistencia y que el DTO siga enfocado en la comunicacion con el cliente.
