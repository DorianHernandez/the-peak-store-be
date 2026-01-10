# The Peak Store Backend

## Project Overview

This project is a backend system for The Peak Store, built using Java, Spring Boot, and Maven. It includes two main services:

1. **Eureka Service**: Acts as a service registry for microservices.
2. **Operador Service**: Handles operations related to products, including Elasticsearch integration.

## Prerequisites

Ensure you have the following installed on your system:

- **Java Development Kit (JDK)**: Version 17 or higher
- **Maven**: Version 3.8 or higher
- **Git**: For cloning the repository

## Setup Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-repo/the-peak-store-be.git
   cd the-peak-store-be
   ```

2. **Build the Project**:
   Navigate to each service directory (`eureka` and `operador`) and verify the project builds successfully using Maven:

   ```bash
   cd eureka
   ./mvnw clean package
   cd ../operador
   ./mvnw clean package
   ```

3. **Configure the Application**:
   - Update the `application.yaml` files in `src/main/resources` for both services if needed.
   - Ensure the database and Elasticsearch configurations are correct for the Operador service.

## Running the Services

### 1. Start Eureka Service

Navigate to the `eureka` directory and run the application:

```bash
cd eureka
./mvnw spring-boot:run
```

The Eureka server will be available at `http://localhost:8761`.

### 2. Start Operador Service

Navigate to the `operador` directory and run the application:

```bash
cd operador
./mvnw spring-boot:run
```

The Operador service will be available at `http://localhost:8080`.

## Testing

To run the tests for each service, use the following command in the respective service directory:

```bash
./mvnw test
```

## Additional Notes

- Ensure that the `data.sql` file in the Operador service is correctly configured for initializing the database
