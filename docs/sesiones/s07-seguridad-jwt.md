# S07 - Seguridad con JWT

Resumen
-------
Implementación de autenticación y autorización con JWT; integración con Keycloak si procede.

Objetivos
---------
- Generar y validar tokens JWT.
- Proteger endpoints y roles.

Configuración de ejemplo
------------------------
- Revisar `services/auth` para endpoints de login y generación de token.

Proyecto (este repo)
---------------------
El servicio `auth` expone `POST /auth/login` (ver `services/auth/src/main/java/com/upeu/auth/controller/AuthController.java`).

Ejemplo request:
```json
{
  "username": "user@example.com",
  "password": "secret"
}
```

El token resultante se debe incluir en `Authorization: Bearer <token>` para acceder a endpoints protegidos (producto, pedido, etc.).

Resumen: `docs/sesiones/_project_summary.md`.
