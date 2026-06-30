Resumen de servicios y endpoints descubiertos en este repositorio:

- Servicios:
  - auth: POST /auth/login
  - producto: /api/v1/productos
  - carrito: /api/v1/carritos
  - categoria: /api/v1/categorias
  - media: /api/v1/media
  - orden-ms: /api/v1/ordenes
  - pago: /api/v1/pagos
  - pedido: /api/v1/pedidos

Instrucciones rápidas:

- Levantar todo con Docker Compose:

```powershell
cd infra
docker-compose up -d
```

- Ejecutar un servicio Java localmente:

```powershell
cd services/<servicio>
./mvnw spring-boot:run
```

- Ejecutar frontend Angular:

```powershell
cd erpng
npm install
npm start
```
