# S02 - Configuración centralizada

Resumen
-------
Explicación del `config-server` y cómo centralizamos propiedades para todos los servicios.

Objetivos
---------
- Mostrar cómo configurar propiedades por perfil (dev/prod).
- Indicar localización de los ficheros de configuración en el repo.

Pasos
-----
1. Revisar `config-server/` y cómo carga `application.yml`.
2. Propiedades sensibles: usar Vault o variables de entorno (no en repo).

Ejecutar localmente
-------------------
```powershell
cd config-server
./mvnw spring-boot:run
```

Entregables
-----------
- Guía de configuración y ejemplos de `application-{profile}.yml`.

Proyecto (este repo)
---------------------
El `config-server` está en la carpeta `config-server/`. Se usa `spring.cloud.config` en los servicios para obtener propiedades remotas.

- Variables sensibles: revisar `.env` y `config-repo/` en `infra/config-repo` para plantillas de configuración.
- Ejecutar: `cd config-server && ./mvnw spring-boot:run`.

Resumen de endpoints y ejecución: `docs/sesiones/_project_summary.md`.
