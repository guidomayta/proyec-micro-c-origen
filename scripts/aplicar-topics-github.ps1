# Aplica los topics academicos UPEU al repositorio remoto.
# Requiere: gh auth login
# Referencia: docs/anexos/estandar-topics-repositorio.md

$ErrorActionPreference = "Stop"
$repo = "guidomayta/proyec-micro-c-origen"

$topics = @(
    "campus-lima",
    "semestre-2026-1",
    "linea-software",
    "tipo-pi",
    "dist",
    "pds",
    "seccion-g1",
    "grupo-1-micro-c-origen"
)

Write-Host "Aplicando topics a $repo..." -ForegroundColor Cyan
gh repo edit $repo --add-topic ($topics -join ",")
Write-Host "Topics aplicados:" -ForegroundColor Green
gh repo view $repo --json repositoryTopics -q ".repositoryTopics[].name"
