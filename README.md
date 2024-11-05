# Eureka Server - Spring Cloud
Esta es un a simple implementación de un servidor Eureka, el cual es un servidor de registro y descubrimiento de servicios.

En este proyecto se crea un microservicio de gestion de estudiantes.

Para poder correr el proyecto se debe de correr primero una base de datos Postgres, para hacer más sencillo el proceso dentro de la carpeta `postgres` se encuentra un archivo `docker-compose.yml` que se puede correr con el siguiente comando:

```bash
cd postgres
docker compose up -d
```

Con esto se creará una base de datos Postgres y un PgAdmin para poder visualizar la base de datos con las siguientes credenciales:

- **PgAdmin**
  - **URL:** http://localhost:5050
  - **Usuario:** admin@admin.com
  - **Contraseña:** admin

- **Postgres**
    - **Host:** postgres
    - **Puerto:** 5432
    - **Usuario:** admin
    - **Contraseña:** admin
    - **Base de datos:** postgresdb

En el proyecto ya esta configurado el archivo `application.properties` para que se conecte a la base de datos.

Ya con esto solo sería correr primero el servidor Eureka y después el microservicio de usuarios.