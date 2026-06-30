# S05 - Evaluación U1

Resumen
-------
En esta sesión se evalúan los conceptos de la Unidad 1: arquitectura, discovery y gateway.

Contenido esperado
------------------
- Entregable: desplegable mínimo con gateway, registry y un servicio de ejemplo funcionando.
- Nota de evaluación: pruebas de endpoints y arquitectura.

Checklist de entrega
-------------------
- `infra/docker-compose.yml` con servicios levantables.
- Documentación mínima y postman collection.

Proyecto (este repo)
---------------------
Asegúrate de que `infra/docker-compose.yml` está actualizado. Para la evaluación U1, levanta `registry-server`, `gateway` y al menos `producto` y `auth`.

Comprobar endpoints:
- `POST /auth/login` (auth)
- `GET /api/v1/productos` (producto)

Resumen: `docs/sesiones/_project_summary.md`.
