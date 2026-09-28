# Course Registration System

A simple course registration application with a Spring Boot REST API, a MySQL database, and a static HTML/JavaScript frontend.

## Requirements

- Java 17 or later
- MySQL
- A browser and a local static-file server for the frontend

## Run the backend

Create the MySQL database before starting the application:

```sql
CREATE DATABASE mine;
```

From the repository root, configure the database connection in the current PowerShell session and start Spring Boot:

```powershell
cd backend
$env:SPRING_DATASOURCE_URL = "jdbc:mysql://localhost:3306/mine"
$env:SPRING_DATASOURCE_USERNAME = "root"
$env:SPRING_DATASOURCE_PASSWORD = "your-mysql-password"
.\mvnw.cmd spring-boot:run
```

On macOS or Linux, use the Unix Maven wrapper instead:

```bash
cd backend
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/mine"
export SPRING_DATASOURCE_USERNAME="root"
export SPRING_DATASOURCE_PASSWORD="your-mysql-password"
./mvnw spring-boot:run
```

The API runs at `http://localhost:8081`. Hibernate updates the database schema on startup. The available-courses page reads course records from the `Course` table; add course records to the database for them to appear.

Run the backend tests from the `backend` directory:

```powershell
.\mvnw.cmd test
```

On macOS or Linux, run `./mvnw test` instead.

## Run the frontend

Serve the `frontend` directory with a local static-file server. In VS Code, open `frontend/index.html` with Live Server and use `http://127.0.0.1:5500/index.html`. The backend allows browser requests from this origin.

The home page links to course registration, the available-course list, and the enrolled-student list.

## API

The backend exposes these endpoints at `http://localhost:8081`:

| Method   | Path                | Description                                                                  |
| -------- | ------------------- | ---------------------------------------------------------------------------- |
| `GET`    | `/courses`          | List available courses                                                       |
| `GET`    | `/courses/enrolled` | List course registrations                                                    |
| `POST`   | `/courses/register` | Register a student using the `name`, `emailId`, and `courseName` form fields |
| `DELETE` | `/{id}`             | Delete a registration by ID                                                  |

## Project layout

```text
backend/   Spring Boot application and Maven build
frontend/  Static HTML pages and JavaScript
```

## Database credentials

Do not commit real database credentials. Configure the connection with environment variables as shown above, and remove or rotate any real password already present in `backend/src/main/resources/application.properties` before publishing the repository.
