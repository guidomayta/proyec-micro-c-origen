# S04 - Gateway y Load Balancer

Resumen
-------
Configuración del `gateway` y balanceo de carga frontal entre microservicios.

Objetivos
---------
- Documentar rutas, filtros y manejo de CORS.
- Configurar políticas de timeout y reintento si procede.

Revisión
--------
- Ver `gateway/src/main/resources/application.yml` para rutas y prefijos.

Pruebas
------
Usar `curl` o Postman para probar rutas a través del gateway.

Proyecto (este repo)
---------------------
El `gateway` está en `gateway/`. Revisa `application.yml` para las rutas configuradas. Prueba rutas como `/api/v1/productos` a través del gateway y verifica balanceo si hay múltiples instancias.

Levantar gateway localmente:
```powershell
cd gateway
./mvnw spring-boot:run
```

Resumen: `docs/sesiones/_project_summary.md`.
