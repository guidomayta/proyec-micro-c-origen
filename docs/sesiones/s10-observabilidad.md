# S10 - Observabilidad

Resumen
-------
Instrumentación de métricas, logs y tracing (Prometheus, Grafana, Loki, Jaeger si aplica).

Objetivos
---------
- Exponer métricas `/actuator/prometheus`.
- Agregar logback config centralizada.

Arranque de observabilidad
-------------------------
```powershell
cd observability
docker-compose up -d
```

Proyecto (este repo)
---------------------
La carpeta `observability/` incluye `prometheus`, `grafana` y `loki` para métricas y logs. Asegura que los servicios exponen endpoints de `actuator` y Prometheus (`/actuator/prometheus`).

Resumen: `docs/sesiones/_project_summary.md`.
