# S03 - Eureka y escalado

Resumen
-------
Servicio de descubrimiento y cómo aporta tolerancia y escalado automático a la arquitectura.

Objetivos
---------
- Explicar registro y heartbeat de instancias.
- Mostrar cómo escalar réplicas de un servicio y cómo el gateway balancea.

Comandos Docker
---------------
```powershell
cd registry-server
docker build -t registry-server .
docker run -d -p 8761:8761 registry-server
```

Entregables
-----------
- Instrucciones para comprobar instancias en `http://localhost:8761`.
