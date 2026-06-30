# S06 - Feign y Circuit Breaker

Resumen
-------
Uso de Spring Cloud OpenFeign para llamadas entre servicios y patrones de resiliencia (Circuit Breaker / Resilience4j).

Objetivos
---------
- Configurar clientes Feign tipados.
- Añadir fallback y métricas de fallos.

Comprobación
------------
- Revisar clases `*Client` en los microservicios y añadir `@FeignClient`.

Proyecto (este repo)
---------------------
Revisa en los servicios que consumen otros microservicios (por ejemplo `pedido` puede invocar `carrito`/`pago`). Añade `@FeignClient` y configura `Resilience4j` para circuit breaker si es necesario.

Resumen y ejemplos: `docs/sesiones/_project_summary.md`.
