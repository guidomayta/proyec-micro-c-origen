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
