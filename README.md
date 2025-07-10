# BlockOps Backend Application

Este proyecto es un backend Spring Boot compatible con despliegue en [Railway](https://railway.app/).

## Deploy en Railway

1. Pulsa en "+ New Project" en Railway y conecta este repositorio.
2. Railway detecta el Dockerfile automáticamente para el build.
3. Configura las siguientes variables de entorno en "Variables":
    - RAILWAY_DATABASE_URL: URL JDBC de tu base MySQL Railway
    - RAILWAY_DATABASE_USER: Usuario de la base
    - RAILWAY_DATABASE_PASSWORD: Contraseña de la base
    - PORT: (Railway lo gestiona por defecto, puedes dejarlo vacío normalmente)
4. Inicia el deploy. El microservicio quedará expuesto en el dominio generado por Railway.

Para desarrollo local usa:
```
./mvnw spring-boot:run
```
y asegúrate que tienes una base de datos `registroonboarding` corriendo en localhost (puede ser con Docker también).

### Endpoints disponibles

Revisa `/swagger-ui.html` al levantar el servicio.

---
