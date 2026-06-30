# proyec-micro-c-origen

Plataforma de microservicios para comercio electrónico / ERP, desarrollada con Java Spring Boot, Angular y Docker. Incluye gateway, service discovery, configuración centralizada, autenticación JWT, mensajería Kafka y observabilidad (Prometheus, Grafana, Loki).

**Repositorio:** [github.com/guidomayta/proyec-micro-c-origen](https://github.com/guidomayta/proyec-micro-c-origen)

## Topics del repositorio (estándar UPEU)

Este repositorio cumple el [estándar transversal de topics](https://upeuoficial.github.io/planb/anexos/estandar-topics-repositorios/) de la Escuela de Sistemas UPEU:

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

Documentación detallada: [docs/anexos/estandar-topics-repositorio.md](docs/anexos/estandar-topics-repositorio.md)

## Documentación

| Documento | Contenido |
|---|---|
| [docs/PROYECTO-GENERAL-PASO-A-PASO.md](docs/PROYECTO-GENERAL-PASO-A-PASO.md) | Guía técnica completa: arquitectura, stack, despliegue |
| [docs/sesiones/](docs/sesiones/) | Sesiones del curso S01–S16 |
| [docs/sesiones/_project_summary.md](docs/sesiones/_project_summary.md) | Resumen de endpoints y comandos |
| [postman-collection.json](postman-collection.json) | Colección Postman para pruebas de API |

## Estructura del proyecto

```text
infra/          Config Server, Eureka, Gateway, config-repo
services/       Microservicios (auth, producto, pedido, ...) + erpng (Angular)
docs/           Documentación académica y técnica
```

## Inicio rápido

```powershell
docker network create ms-net

cd infra
docker compose up -d

cd ..\services\auth
.\mvnw spring-boot:run

cd ..\erpng
npm install
npm start
```

Abrir `http://localhost:4200` (frontend) y `http://localhost:7091` (gateway).

Guía completa de despliegue: [docs/PROYECTO-GENERAL-PASO-A-PASO.md](docs/PROYECTO-GENERAL-PASO-A-PASO.md)

## Stack principal

- **Backend:** Java 17, Spring Boot 3.5, Spring Cloud, MySQL, Kafka
- **Frontend:** Angular 21, TypeScript
- **Infra:** Docker, Prometheus, Grafana, Loki
