# Anexo técnico: Estándar transversal de topics para repositorios académicos

> Referencia oficial: [Estándar de topics — Escuela de Sistemas UPEU](https://upeuoficial.github.io/planb/anexos/estandar-topics-repositorios/)

## Alcance

Este estándar es de aplicación transversal para todos los repositorios académicos de las líneas de Software, Ciencia de Datos e Inteligencia Artificial, Infraestructura Tecnológica y Gestión de Tecnologías de Información.

Los estándares técnicos o académicos particulares de cada línea se documentarán en anexos específicos y deberán mantener compatibilidad con este estándar transversal.

## Estándar de topics

Todos los repositorios académicos deben configurar como mínimo los siguientes **topics**:

```text
campus-<lima|juliaca|tarapoto>
semestre-<2026-1|2026-2>
linea-<software|cdia|infraestructura|gestion>

# Tipo de proyecto (elegir solo uno)
tipo-ps          # Proyecto Sello
tipo-pi          # Proyecto Integrador
tipo-epe         # Evaluación de Perfil de Egreso

# Cursos (usar únicamente los nombres oficiales)
# Agregar solo los cursos que participan en el proyecto.
<curso1>
<curso2>
...

seccion-<gu|g1|g2|g3|g4>
grupo-<numero>-<nombre-proyecto>
```

## Topics configurados en este repositorio

Repositorio: [guidomayta/proyec-micro-c-origen](https://github.com/guidomayta/proyec-micro-c-origen)

| Topic | Valor | Justificación |
|---|---|---|
| Campus | `campus-lima` | Sede de la Escuela de Sistemas |
| Semestre | `semestre-2026-1` | Periodo académico vigente |
| Línea | `linea-software` | Microservicios Java, Angular y arquitectura distribuida |
| Tipo | `tipo-pi` | Proyecto Integrador con múltiples componentes y sesiones |
| Curso | `dist` | Desarrollo de Aplicaciones Distribuidas (microservicios, gateway, Kafka) |
| Curso | `pds` | Pruebas y Despliegue de Software (Docker, observabilidad, CI) |
| Sección | `seccion-g1` | Sección del curso |
| Grupo | `grupo-1-micro-c-origen` | Grupo 1 — plataforma microservicios Corigen |

Lista completa de topics a configurar en GitHub:

```text
campus-lima
semestre-2026-1
linea-software
tipo-pi
dist
pds
seccion-g1
grupo-1-micro-c-origen
```

### Cómo aplicar los topics en GitHub

**Opción A — Interfaz web**

1. Abrir [github.com/guidomayta/proyec-micro-c-origen](https://github.com/guidomayta/proyec-micro-c-origen).
2. Clic en el ícono de engranaje junto a **About**.
3. En **Topics**, pegar cada topic de la lista anterior (separados por Enter).

**Opción B — GitHub CLI**

```powershell
gh auth login
.\scripts\aplicar-topics-github.ps1
```

## Catálogo oficial de topics para cursos

### Línea Software

| Curso | Topic |
|---|---|
| Fundamentos de Programación (FP) | `fp` |
| Programación Orientada a Objetos (POO) | `poo` |
| Ingeniería de Requerimientos (REQ) | `req` |
| Administración de Base de Datos I (BD1) | `bd1` |
| Lenguaje de Programación I (LP1) | `lp1` |
| Análisis y Diseño de Sistemas de Información (ADS) | `ads` |
| Administración de Base de Datos II (BD2) | `bd2` |
| Lenguaje de Programación II (LP2) | `lp2` |
| Desarrollo de Aplicaciones Distribuidas (DIST) | `dist` |
| Desarrollo de Aplicaciones Móviles (MOV) | `mov` |
| Ingeniería de Software I (IS1) | `is1` |
| Ingeniería de Software II (IS2) | `is2` |
| Pruebas y Despliegue de Software (PDS) | `pds` |

### Línea CDIA

| Curso | Topic |
|---|---|
| Big Data | `bigdata` |
| Minería de Datos | `mineriadatos` |
| Inteligencia de Negocios (BI) | `bi` |
| Inteligencia Artificial (IA) | `ia` |
| Machine Learning (ML) | `ml` |
| Internet de las Cosas (IoT) | `iot` |

Utilizar únicamente los topics definidos en este catálogo. No crear variantes, traducciones ni abreviaturas diferentes.

## Relación con la documentación del proyecto

| Documento | Descripción |
|---|---|
| [README.md](../../README.md) | Resumen del repositorio y acceso rápido |
| [PROYECTO-GENERAL-PASO-A-PASO.md](../PROYECTO-GENERAL-PASO-A-PASO.md) | Guía técnica completa del sistema |
| [docs/sesiones/](../sesiones/) | Documentación por sesión del curso (S01–S16) |
| [postman-collection.json](../../postman-collection.json) | Colección de pruebas de API |
