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

## API Documentation for Student and Course Microservices

This documentation describes the API endpoints for the Student and Course microservices running behind an API Gateway on port `8080`. You can use tools like Postman or directly use `curl` commands in the terminal to test the endpoints.

### Base URL

All the requests to the microservices are routed through the API Gateway:

```
http://localhost:8080
```

### Endpoints for Student Microservice

**Base Path**: `/student`

#### 1. Create a Student
- **URL**: `http://localhost:8080/student/save`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "name": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }
  ```
- **Response**: Status `201 Created` with the created student data.
- **cURL Command**:
  ```sh
  curl -X POST http://localhost:8080/student/save -H "Content-Type: application/json" -d '{"name": "John", "lastName": "Doe", "email": "john.doe@example.com"}'
  ```

#### 2. Get All Students
- **URL**: `http://localhost:8080/student/get`
- **Method**: `GET`
- **Response**: Returns a list of all students.
- **cURL Command**:
  ```sh
  curl -X GET http://localhost:8080/student/get
  ```

#### 3. Get a Student by ID
- **URL**: `http://localhost:8080/student/get/{id}`
- **Method**: `GET`
- **Path Variable**: `{id}` - The ID of the student to retrieve.
- **Response**: Returns the student details if found, otherwise `404 Not Found`.
- **cURL Command**:
  ```sh
  curl -X GET http://localhost:8080/student/get/1
  ```

#### 4. Update a Student
- **URL**: `http://localhost:8080/student/update/{id}`
- **Method**: `PUT`
- **Path Variable**: `{id}` - The ID of the student to update.
- **Request Body**:
  ```json
  {
    "name": "Updated Name",
    "lastName": "Updated LastName",
    "email": "updated.email@example.com"
  }
  ```
- **Response**: Status `201 Created` with updated student data if successful, or `404 Not Found` if the student doesn't exist.
- **cURL Command**:
  ```sh
  curl -X PUT http://localhost:8080/student/update/1 -H "Content-Type: application/json" -d '{"name": "Updated Name", "lastName": "Updated LastName", "email": "updated.email@example.com"}'
  ```

#### 5. Delete a Student by ID
- **URL**: `http://localhost:8080/student/delete/{id}`
- **Method**: `DELETE`
- **Path Variable**: `{id}` - The ID of the student to delete.
- **Response**: Status `204 No Content`.
- **cURL Command**:
  ```sh
  curl -X DELETE http://localhost:8080/student/delete/1
  ```

#### 6. Balancer Test Endpoint
- **URL**: `http://localhost:8080/student/balancer-test`
- **Method**: `GET`
- **Response**: Returns a sample response that includes the configuration balancer information.
- **cURL Command**:
  ```sh
  curl -X GET http://localhost:8080/student/balancer-test
  ```

### Endpoints for Course Microservice

**Base Path**: `/course`

#### 1. Create a Course
- **URL**: `http://localhost:8080/course/save`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "name": "Math 101"
  }
  ```
- **Response**: Status `201 Created` with the created course data.
- **cURL Command**:
  ```sh
  curl -X POST http://localhost:8080/course/save -H "Content-Type: application/json" -d '{"name": "Math 101"}'
  ```

#### 2. Get All Courses
- **URL**: `http://localhost:8080/course/get`
- **Method**: `GET`
- **Response**: Returns a list of all courses.
- **cURL Command**:
  ```sh
  curl -X GET http://localhost:8080/course/get
  ```

#### 3. Get a Course by ID
- **URL**: `http://localhost:8080/course/get/{id}`
- **Method**: `GET`
- **Path Variable**: `{id}` - The ID of the course to retrieve.
- **Response**: Returns the course details if found, otherwise `404 Not Found`.
- **cURL Command**:
  ```sh
  curl -X GET http://localhost:8080/course/get/1
  ```

#### 4. Update a Course
- **URL**: `http://localhost:8080/course/update/{id}`
- **Method**: `PUT`
- **Path Variable**: `{id}` - The ID of the course to update.
- **Request Body**:
  ```json
  {
    "name": "Advanced Math"
  }
  ```
- **Response**: Status `201 Created` with updated course data if successful, or `404 Not Found` if the course doesn't exist.
- **cURL Command**:
  ```sh
  curl -X PUT http://localhost:8080/course/update/1 -H "Content-Type: application/json" -d '{"name": "Advanced Math"}'
  ```

#### 5. Add Students to a Course
- **URL**: `http://localhost:8080/course/{id}/add-student`
- **Method**: `PUT`
- **Path Variable**: `{id}` - The ID of the course to which students will be added.
- **Request Body**:
  ```json
  [
    {
      "id": 1,
      "name": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com"
    },
    {
      "id": 2,
      "name": "Jane",
      "lastName": "Doe",
      "email": "jane.doe@example.com"
    }
  ]
  ```
- **Response**: Status `201 Created` with the updated course data.
- **cURL Command**:
  ```sh
  curl -X PUT http://localhost:8080/course/1/add-student -H "Content-Type: application/json" -d '[{"id": 1, "name": "John", "lastName": "Doe", "email": "john.doe@example.com"}, {"id": 2, "name": "Jane", "lastName": "Doe", "email": "jane.doe@example.com"}]'
  ```

#### 6. Remove a Student from a Course
- **URL**: `http://localhost:8080/course/{id}/remove-student`
- **Method**: `PUT`
- **Path Variable**: `{id}` - The ID of the course from which a student will be removed.
- **Request Body**:
  ```json
  {
    "id": 1,
    "name": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }
  ```
- **Response**: Status `201 Created` with the updated course data.
- **cURL Command**:
  ```sh
  curl -X PUT http://localhost:8080/course/1/remove-student -H "Content-Type: application/json" -d '{"id": 1, "name": "John", "lastName": "Doe", "email": "john.doe@example.com"}'
  ```

#### 7. Balancer Test Endpoint
- **URL**: `http://localhost:8080/course/balancer-test`
- **Method**: `GET`
- **Response**: Returns a sample response that includes the configuration balancer information.
- **cURL Command**:
  ```sh
  curl -X GET http://localhost:8080/course/balancer-test
  ```

### Usage with API Gateway

All requests should be made through the API Gateway running on port `8080`. For example:

- **Get All Students**: `http://localhost:8080/student/get`
  ```sh
  curl -X GET http://localhost:8080/student/get
  ```
- **Create a Course**: `http://localhost:8080/course/save`
  ```sh
  curl -X POST http://localhost:8080/course/save -H "Content-Type: application/json" -d '{"name": "Math 101"}'
  ```
- **Add Students to a Course**: `http://localhost:8080/course/1/add-student`
  ```sh
    curl -X PUT http://localhost:8080/course/1/add-student -H "Content-Type: application/json" -d '[{"id": 1, "name": "John", "lastName": "Doe", "email": "
    ```
- **Remove a Student from a Course**: `http://localhost:8080/course/1/remove-student`
- **Balancer Test Endpoint for Student Microservice**: `http://localhost:8080/student/balancer-test`
- **Balancer Test Endpoint for Course Microservice**: `http://localhost:8080/course/balancer-test`