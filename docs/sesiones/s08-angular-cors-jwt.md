# S08 - Angular, CORS y JWT

Resumen
-------
Integración del frontend Angular (`erpng/`) con los microservicios, manejo de CORS y autenticación JWT en la UI.

Objetivos
---------
- Habilitar CORS en los servicios.
- Proteger rutas en Angular con guardas y almacenar token en `localStorage` con precauciones.

Ejecutar frontend
-----------------
```powershell
cd erpng
npm install
npm start
```

Proyecto (este repo)
---------------------
El frontend está en `erpng/`. Asegúrate de configurar el proxy (`proxy.conf.json`) para apuntar al gateway o directamente a los servicios durante desarrollo.

Autenticación UI:
- La UI utiliza JWT desde `POST /auth/login` y almacena el token en `localStorage`.

Resumen: `docs/sesiones/_project_summary.md`.
