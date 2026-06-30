# Proyecto Grupal: Documento General Profesional

## 1. Objetivo

Ofrecer una descripción técnica y profesional del sistema, sus componentes, herramientas, arquitectura, flujos de ejecución y pasos de despliegue.

Este documento está orientado a:

- desarrolladores que integran el proyecto,
- evaluadores académicos,
- líderes técnicos que revisan la arquitectura,
- operadores que despliegan el sistema.

## 1.1 Identificación académica y topics del repositorio

Este repositorio cumple el [estándar transversal de topics UPEU](https://upeuoficial.github.io/planb/anexos/estandar-topics-repositorios/). La documentación completa del estándar aplicado a este proyecto está en `docs/anexos/estandar-topics-repositorio.md`.

Topics configurados:

```text
campus-lima
semestre-2026-1
linea-software
tipo-pi
dist
pds
seccion-g1
grupo-1-micro-c-origen
```

| Campo | Valor |
|---|---|
| Repositorio | [guidomayta/proyec-micro-c-origen](https://github.com/guidomayta/proyec-micro-c-origen) |
| Línea | Software — microservicios y arquitectura distribuida |
| Tipo | Proyecto Integrador (PI) |
| Cursos | DIST, PDS |
| Grupo | 1 — micro-c-origen |

## 2. Visión global del proyecto

La solución es una plataforma de microservicios basada en Java Spring Boot, complementada con un frontend Angular y con infraestructura Dockerizada para desarrollo y despliegue.

### Componentes principales

- `infra/`: servicios de infraestructura comunes.
  - `config-server/`: Spring Cloud Config Server.
  - `registry-server/`: Eureka Service Registry.
  - `gateway/`: Spring Cloud Gateway.
  - `config-repo/`: repositorio de configuración remota.
- `services/`: microservicios de negocio y módulos de apoyo.
  - `auth/`, `carrito/`, `categoria/`, `media/`, `orden-ms/`, `pago/`, `pedido/`, `producto/`.
  - `erpng/`: frontend Angular ERP.
  - `kafka/`: infraestructura Apache Kafka.
  - `observability/`: plataforma de métricas y logs.
- `docs/sesiones/`: documentación de las sesiones del curso y prácticas.

### Arquitectura de comunicación

```text
Angular UI -> API Gateway -> Microservicios
               \-> Auth Service (login / JWT)
Microservicios -> Eureka Registry
Microservicios -> Config Server -> config-repo
Kafka -> eventos asíncronos -> servicios de orden y pago
Observability -> Prometheus / Grafana / Loki
```

## 3. Herramientas y stack tecnológico

### 3.1 Backend

- Java 17
- Spring Boot 3.5.x
- Spring Cloud 2025.0.2
- Maven 3.9+ (wrapper `mvnw` / `mvnw.cmd`)
- Spring Cloud Config
- Eureka Service Registry
- Spring Cloud Gateway
- Spring Security
- OAuth2 Resource Server
- Spring Data JPA
- Flyway
- SpringDoc OpenAPI
- Micrometer Prometheus
- JWT (`io.jsonwebtoken:jjwt`)
- Spring Kafka
- MySQL

### 3.2 Frontend

- Angular 21
- TypeScript 5.9
- NPM 11
- RxJS 7.8
- Angular CLI
- Prettier
- Vitest

### 3.3 Infraestructura y contenedores

- Docker
- Docker Compose
- Docker network: `ms-net`
- Apache Kafka
- Prometheus
- Grafana
- Loki
- Keycloak (material de integración disponible)

### 3.4 Documentación y pruebas

- Markdown para documentación técnica
- Postman Collection: `postman-collection.json`
- Guías de práctica y sesiones en `docs/sesiones/`
- `HELP.md` en varios módulos

## 4. Organización del repositorio

### 4.1 Estructura raíz

- `infra/`
- `services/`
- `docs/`
- `postman-collection.json`
- `project-summary.json`
- `git-tracked-files.txt`

### 4.2 Infraestructura

- `infra/config-server/`
- `infra/registry-server/`
- `infra/gateway/`
- `infra/config-repo/`
- `infra/docker-compose.yml`

### 4.3 Servicios de negocio

- `services/auth/`
- `services/carrito/`
- `services/categoria/`
- `services/media/`
- `services/orden-ms/`
- `services/pago/`
- `services/pedido/`
- `services/producto/`
- `services/erpng/`
- `services/kafka/`
- `services/observability/`

### 4.4 Estructura típica de microservicio Java

- `pom.xml`
- `Dockerfile`
- `mvnw`, `mvnw.cmd`
- `src/main/java/`
- `src/main/resources/`
- `target/`
- `docker-compose.yml` o `docker-compose-dev.yml`

### 4.5 Estructura del frontend Angular

- `package.json`
- `angular.json`
- `src/`
- `proxy.conf.json`
- `proxy.gateway.conf.json`
- `proxy.direct.conf.json`

## 5. Infraestructura base y configuración

### 5.1 Config Server

- Ubicación: `infra/config-server/`
- Dependencia principal: `spring-cloud-config-server`
- Función: carga centralizada de configuración desde `infra/config-repo/`
- Modos: `dev`, `prod`

### 5.2 Eureka Registry

- Ubicación: `infra/registry-server/`
- Dependencia: `spring-cloud-starter-netflix-eureka-server`
- Función: descubrimiento dinámico de instancias de servicio

### 5.3 API Gateway

- Ubicación: `infra/gateway/`
- Dependencias:
  - `spring-cloud-starter-gateway-server-webmvc`
  - `spring-boot-starter-security`
  - `spring-boot-starter-oauth2-resource-server`
  - `micrometer-registry-prometheus`
- Función: enrutamiento, seguridad de borde, balanceo simple y centralización de acceso

### 5.4 Repositorio de configuración

- Ubicación: `infra/config-repo/`
- Archivos por servicio y ambiente:
  - `auth-dev.yml`, `auth-prod.yml`
  - `producto-dev.yml`, `producto-prod.yml`
  - `pedido-dev.yml`, `pedido-prod.yml`
  - `...`
- Función: valores externos de `server.port`, base de datos, JWT, endpoints y `spring.profiles.active`

### 5.5 Docker Compose de infraestructura

- Archivo principal: `infra/docker-compose.yml`
- Servicios orquestados:
  - `config-server`
  - `registry-server`
  - `gateway`
- Red Docker externa: `ms-net`

## 6. Catálogo de servicios y responsabilidades

| Servicio | Descripción | Tecnologías destacadas | Endpoints principales |
|---|---|---|---|
| `auth` | Servicio de autenticación y emisión JWT | Spring Security, JJWT, MySQL, Flyway, Actuator | `POST /auth/login` |
| `producto` | Catálogo de productos | OAuth2 Resource Server, Spring Data JPA | `/api/v1/productos` |
| `carrito` | Carrito de compras | Spring Boot, JPA | `/api/v1/carritos` |
| `categoria` | Gestión de categorías | Spring Boot, JPA | `/api/v1/categorias` |
| `pago` | Simulación de pagos | Spring Boot, JPA | `/api/v1/pagos` |
| `pedido` | Administración de pedidos | Spring Boot, OpenFeign | `/api/v1/pedidos` |
| `orden-ms` | Orquestación de ordenes y eventos Kafka | Spring Kafka, Prometheus | `/api/v1/ordenes` |
| `media` | Servicio de archivos y recursos | Spring Boot | `/api/v1/media` |
| `erpng` | Frontend Angular ERP | Angular 21, HTTP Client | UI / login JWT |
| `kafka` | Broker y stack de eventos | Kafka broker, Kafka UI, Kafka Exporter | infraestructura de mensajería |
| `observability` | Métricas y logs | Prometheus, Grafana, Loki | plataforma de monitoreo |

### 6.1 `auth`

- Rol: identidad central y emisor de tokens.
- Características:
  - `Spring Security` para autenticación.
  - JWT con `jjwt-api`, `jjwt-impl`, `jjwt-jackson`.
  - Persistencia MySQL y migraciones Flyway.
  - Documentación OpenAPI.
  - Registro en Eureka y configuración desde Config Server.

### 6.2 `producto`

- Rol: catálogo de productos.
- Características:
  - Protegido a nivel de recurso.
  - Expone CRUD de productos.
  - Consumido por frontend y gateway.

### 6.3 `carrito`

- Rol: manejo de la cesta de compras.
- Características:
  - Almacena items seleccionados.
  - Forma parte del flujo de compra.

### 6.4 `categoria`

- Rol: catálogo de categorías.
- Características:
  - Exposición de datos maestros para formularios.
  - Soporte para selección y filtrado.

### 6.5 `pedido`

- Rol: gestión de solicitudes de compra.
- Características:
  - Creación y consulta de pedidos.
  - Posible integración con `carrito` y `pago`.

### 6.6 `pago`

- Rol: simulación de procesamiento de pagos.
- Características:
  - Flujo de pago parcial.
  - Integración con orden y pedido.

### 6.7 `orden-ms`

- Rol: orquestación de órdenes y eventos.
- Características:
  - Publica eventos Kafka.
  - Monitorea métricas con Prometheus.

### 6.8 `media`

- Rol: servicio de medios y archivos.
- Características:
  - Gestión de recursos estáticos o media.

### 6.9 `erpng`

- Rol: frontend cliente ERP.
- Características:
  - Login JWT.
  - Interceptor HTTP para `Authorization: Bearer <token>`.
  - Guardas de ruta y protección de vistas.
  - Consumo de servicios a través del gateway.

### 6.10 `kafka`

- Rol: infraestructura de mensajería.
- Características:
  - Broker Kafka.
  - Kafka UI para administración.
  - Kafka Exporter para métricas Prometheus.

### 6.11 `observability`

- Rol: plataforma de monitoreo.
- Características:
  - Prometheus para métricas.
  - Grafana para dashboards.
  - Loki para agregación de logs.

## 7. Seguridad y autenticación

### 7.1 Patrón de seguridad

- `auth` emite JWT.
- `gateway` actúa como primera línea de defensa.
- Servicios críticos (`producto`, `pedido`, `orden-ms`) pueden validar tokens internamente.
- El proyecto está preparado para migrar a Keycloak en el futuro.

### 7.2 CORS y frontend

- El frontend usa `proxy.conf.json` y variantes para desarrollo.
- El gateway centraliza las solicitudes y evita problemas de CORS cuando se usa en producción.
- `services/erpng` incluye un interceptor para enviar tokens en las solicitudes.

### 7.3 Identidad futura

- El directorio `keycloak/` contiene material para integrar un proveedor OAuth2/OIDC.
- Actualmente la autenticación utiliza un servidor de identidad propio, no un proveedor externo.

## 8. Observabilidad y monitoreo

### 8.1 Métricas

- Todos los servicios Java exponen `/actuator/prometheus`.
- Se usa `micrometer-registry-prometheus` para exportar métricas.
- Grafana consume métricas de Prometheus.

### 8.2 Logs

- Loki agrega logs cuando el stack de observabilidad está activo.
- La configuración de logs se basa en Spring Boot y Logback.

### 8.3 Dashboards

- Grafana permite construir vistas de salud, uso de recursos, latencia y estado de Kafka.
- Se pueden crear dashboards para servicios y pipelines de eventos.

## 9. Ejecución del proyecto

### 9.1 Preparación inicial

1. Confirmar Docker Desktop en ejecución.
2. Generar red Docker si no existe:

```powershell
docker network create ms-net
```

### 9.2 Arranque de infraestructura

```powershell
cd infra
docker compose up -d
```

Servicios levantados:

- `config-server`
- `registry-server`
- `gateway`

### 9.3 Arranque de servicios Java

Ejecutar cada uno en modo desarrollo desde su carpeta:

```powershell
cd services\auth
.\mvnw spring-boot:run
```

### 9.4 Arranque de Kafka

```powershell
cd services\kafka
docker compose up -d
```

### 9.5 Arranque de observabilidad

```powershell
cd services\observability
docker compose up -d
```

### 9.6 Arranque del frontend

```powershell
cd services\erpng
npm install
npm start
```

Abrir en el navegador:

```text
http://localhost:4200
```

## 10. Endpoints y puertos clave

### 10.1 Endpoints principales

- `POST /auth/login`
- `/api/v1/productos`
- `/api/v1/carritos`
- `/api/v1/categorias`
- `/api/v1/media`
- `/api/v1/ordenes`
- `/api/v1/pagos`
- `/api/v1/pedidos`

### 10.2 Puertos de infraestructura

- Config Server: `7071` / `7072`
- Eureka Registry: `7081` / `7082`
- API Gateway: `7091` / `7092`
- Angular UI: `4200`

### 10.3 Puertos de ejemplo

- Auth DEV: `8041`
- Auth PROD: `8042`
- Producto: `9091`
- Carrito: `8083`
- Categoria: `8087`

## 11. Validación y pruebas

### 11.1 Validaciones básicas

- `http://localhost:7071` -> Config Server
- `http://localhost:7081` -> Eureka Registry
- `http://localhost:7091/actuator/health` -> Gateway
- `http://localhost:4200` -> Angular UI

### 11.2 Pruebas frontend

```powershell
npm run build
npm test -- --watch=false
```

### 11.3 Pruebas backend

```powershell
cd services\auth
.\mvnw test
```

## 12. Documentación de soporte

- `README.md`
- `docs/anexos/estandar-topics-repositorio.md`
- `scripts/aplicar-topics-github.ps1`
- `docs/sesiones/s01-arquitectura-base.md`
- `docs/sesiones/s04-gateway-load-balancer.md`
- `docs/sesiones/s08-angular-cors-jwt.md`
- `docs/sesiones/s10-observabilidad.md`
- `docs/sesiones/_project_summary.md`
- `services/auth/README.md`
- `services/erpng/README.md`
- `services/kafka/README.md`
- `services/observability/README.md`
- `postman-collection.json`
- `infra/config-repo/`

---

Este documento ofrece una guía técnica completa y profesional del proyecto, con énfasis en la arquitectura, herramientas, despliegue y documentación de soporte.