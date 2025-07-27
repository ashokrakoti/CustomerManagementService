# Customer Management Service

## Authentication

This application uses Spring Security with Basic Authentication. Below are the details for accessing the API endpoints.

### Available Users

The following users are pre-configured in the system:

| Username | Password   | Role  |
|----------|------------|-------|
| admin    | adminpass  | ADMIN |
| tester   | password   | TESTER|
| guest    | guestpass  | GUEST |

### API Access

#### Authentication Header
Include the following header in your requests:
```
Authorization: Basic <credentials>
```
Where `<credentials>` is the Base64-encoded string of `username:password`.

#### Example
For user `admin` with password `adminpass`:
1. Combine: `admin:adminpass`
2. Base64 encode: `YWRtaW46YWRtaW5wYXNz`
3. Header: `Authorization: Basic YWRtaW46YWRtaW5wYXNz`

### Endpoint Security

| HTTP Method | Endpoint           | Required Role |
|-------------|--------------------|---------------|
| GET         | /api/customers    | TESTER, ADMIN |
| POST        | /api/customers    | ADMIN         |
| Other       | Any other endpoint| Any authenticated user |

### Configuration

- **Security Configuration**: `com.ecommerce.customermanagementservice.config.SecurityConfig`
- **User Configuration**: `src/main/resources/application.properties`

### Notes
- CSRF protection is disabled as this is a stateless REST API.
- Passwords are stored encrypted using BCrypt.
- The application runs with context path: `/customer-service`

### Example cURL

```bash
# Get all customers (as tester)
curl -X GET \
  http://localhost:8080/customer-service/api/customers \
  -H 'Authorization: Basic dGVzdGVyOnBhc3N3b3Jk'

# Create customer (admin only)
curl -X POST \
  http://localhost:8080/customer-service/api/customers \
  -H 'Authorization: Basic YWRtaW46YWRtaW5wYXNz' \
  -H 'Content-Type: application/json' \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "gender": "MALE",
    "age": 30
  }'
```

## API Documentation

The application includes Swagger/OpenAPI documentation for all REST endpoints. Here's how to access and use it:

### Accessing Swagger UI

1. Start the application
2. Open your browser and navigate to:
   ```
   http://localhost:8080/customer-service/swagger-ui.html
   ```

### Available Documentation Endpoints

- **Swagger UI**: Interactive API documentation
  ```
  /swagger-ui.html
  ```
- **OpenAPI JSON**: Machine-readable API specification
  ```
  /v3/api-docs
  ```
- **API Docs (YAML)**: Alternative format
  ```
  /v3/api-docs.yaml
  ```

### Features

- **Interactive Testing**: Try out API endpoints directly from the browser
- **Request/Response Models**: View detailed request and response schemas
- **Authentication**: Use the "Authorize" button (🔓) to set your credentials
  - Enter: `Basic <base64-credentials>`
  - Example: `Basic YWRtaW46YWRtaW5wYXNz`

### Example Authentication in Swagger UI

1. Click the "Authorize" button (🔓) in the top-right corner
2. In the "Value" field, enter: `Basic YWRtaW46YWRtaW5wYXNz`
3. Click "Authorize"
4. Now you can test the endpoints that require authentication

### Note
- The API documentation reflects the current security configuration
- Only documented endpoints are accessible based on the authenticated user's roles
- Request/response models include validation annotations and descriptions
