# S11 - Integración Fullstack

Resumen
-------
Pruebas end-to-end que involucren frontend (`erpng`) y backend (microservicios), validando flujos críticos (login, creación de pedido, pago simulado).

Objetivos
---------
- Definir scripts de prueba de integración (Playwright / Postman).
- Automatizar pruebas básicas en CI si procede.

Ejemplo: run collection con Newman
```powershell
npx newman run postman-collection.json
```

Proyecto (este repo)
---------------------
Pruebas end-to-end disponibles mediante `postman-collection.json` en la raíz del repo. Flujos clave:
- Login y obtención de token (`POST /auth/login`).
- Añadir items al carrito y crear pedido (`POST /api/v1/carritos/...`, `POST /api/v1/pedidos`).

Resumen: `docs/sesiones/_project_summary.md`.
