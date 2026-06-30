# S01 - Arquitectura base

Resumen
-------
Descripción de la arquitectura de microservicios del proyecto: servicios independientes (`services/*`), gateway, registry, config-server e infra por contenedores.

Objetivos
---------
- Entender la topología del sistema.
- Documentar los componentes y cómo se comunican.

Contenido
--------
- Diagrama de alto nivel (añadir imagen en `docs/arch/` si procede).
- Componentes:
  - `gateway/` (API Gateway)
  - `registry-server/` (Eureka / Service Discovery)
  - `config-server/` (Configuración centralizada)
  - `services/*` (microservicios: auth, producto, pedido, etc.)

Comandos básicos
---------------
Arrancar todo con Docker Compose (carpeta `infra`):

```powershell
cd infra
docker-compose up -d
```

Entregables
-----------
- Documento de la arquitectura en `docs/sesiones/s01-arquitectura-base.md`.
- Diagrama y lista de endpoints principales.

Proyecto (este repo)
---------------------
Este repositorio contiene los siguientes servicios principales: `auth`, `producto`, `carrito`, `categoria`, `media`, `orden-ms`, `pago`, `pedido` y el frontend `erpng`.

- Levantar todo con Docker Compose: `cd infra && docker-compose up -d`.
- Ejecutar un servicio Java: `cd services/<servicio> && ./mvnw spring-boot:run`.
- Frontend: `cd erpng && npm install && npm start`.

Para un resumen rápido de endpoints y comandos, ver `docs/sesiones/_project_summary.md`.
