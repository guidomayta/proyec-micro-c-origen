# Demo: seguridad JWT + observabilidad (DEV)
# Ejecutar con todo levantado: config-server, eureka, gateway, auth, microservicios, observability docker

Write-Host "=== 1. Health ===" -ForegroundColor Cyan
@(
  "http://localhost:7081",
  "http://localhost:7091/actuator/health",
  "http://localhost:8041/actuator/health",
  "http://localhost:9091/actuator/health",
  "http://localhost:19090/-/healthy"
) | ForEach-Object {
  try { Invoke-WebRequest $_ -UseBasicParsing -TimeoutSec 3 | Out-Null; Write-Host "OK  $_" -ForegroundColor Green }
  catch { Write-Host "FAIL $_" -ForegroundColor Red }
}

Write-Host "`n=== 2. Login JWT ===" -ForegroundColor Cyan
$body = @{ username = "admin"; password = "admin123" } | ConvertTo-Json
$r = Invoke-RestMethod -Method Post -Uri "http://localhost:8041/auth/login" -ContentType "application/json" -Body $body
$token = $r.accessToken
Write-Host "Usuario: $($r.username) | Roles: $($r.roles -join ', ')"

Write-Host "`n=== 3. Instancia (sin token) ===" -ForegroundColor Cyan
Invoke-RestMethod http://localhost:9091/api/v1/productos/instancia
Invoke-RestMethod http://localhost:7091/api/v1/productos/instancia

Write-Host "`n=== 4. API protegida (con token) ===" -ForegroundColor Cyan
$h = @{ Authorization = "Bearer $token" }
$productos = Invoke-RestMethod -Uri "http://localhost:7091/api/v1/productos" -Headers $h
Write-Host "Productos via gateway: $($productos.Count) registro(s)"

Write-Host "`n=== 5. Prometheus ===" -ForegroundColor Cyan
$q = [uri]::EscapeDataString("up")
Invoke-RestMethod "http://localhost:19090/api/v1/query?query=$q" | Out-Null
Write-Host "Consulta 'up' enviada -> http://localhost:19090/targets"

Write-Host "`n=== 6. Loki (logs carrito) ===" -ForegroundColor Cyan
$lq = [uri]::EscapeDataString('{service="carrito"}')
$logs = Invoke-RestMethod "http://localhost:13100/loki/api/v1/query_range?query=$lq&limit=3"
$count = ($logs.data.result | ForEach-Object { $_.values.Count } | Measure-Object -Sum).Sum
Write-Host "Lineas de log carrito: $count"
Write-Host "Grafana: http://localhost:13000 (admin/admin) -> Explore -> Loki"

Write-Host "`n=== FIN ===" -ForegroundColor Green
