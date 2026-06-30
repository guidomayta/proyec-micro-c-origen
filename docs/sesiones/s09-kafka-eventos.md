# S09 - Kafka y eventos

Resumen
-------
Patrón de eventos usando Kafka para comunicación asíncrona entre servicios.

Objetivos
---------
- Configurar topics, producers y consumers.
- Probar flujo de eventos para procesos como `orden` y `pago`.

Arranque de Kafka (carpeta `kafka`):
```powershell
cd kafka
docker-compose up -d
```

Proyecto (este repo)
---------------------
La carpeta `kafka/` contiene la configuración para los brokers y topics utilizados por servicios de eventos. Asegúrate de comprobar los topics necesarios para `orden` y `pago`.

Resumen: `docs/sesiones/_project_summary.md`.
