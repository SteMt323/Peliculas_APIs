# Exceptions

Esta carpeta contiene las clases encargadas del manejo de errores de la API.

## Responsabilidades

- Representar errores especificos de la aplicacion.
- Centralizar la conversion de excepciones a respuestas HTTP.
- Devolver mensajes claros cuando un recurso no existe o una solicitud es invalida.
- Evitar respuestas de error genericas dificiles de interpretar.

## Clases

- `RecursoNoEncontradoException`: se usa cuando no existe un autor o pelicula con el id solicitado.
- `SolicitudInvalidaException`: se usa cuando faltan datos obligatorios en una solicitud.
- `ApiErrorResponse`: define el formato JSON de los errores.
- `GlobalExceptionHandler`: captura excepciones y las transforma en respuestas HTTP.

## Ejemplo de respuesta

```json
{
  "timestamp": "2026-05-13T19:20:00",
  "status": 404,
  "error": "Not Found",
  "message": "No se encontro el autor con id 99",
  "path": "/api/autores/99"
}
```

Esta capa ayuda a mantener los controladores y servicios mas limpios, porque el manejo de errores queda en un solo lugar.
