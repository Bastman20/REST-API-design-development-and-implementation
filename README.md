# REST-API-design-development-and-implementation
API OVERVIEW
This project is a REST API built using JAX-RS and Jersey. It manages rooms, sensors, and sensor readings for a campus system.

The API supports:
- Room creation, retrieval, and deletion
- Sensor creation with validation
- Sensor filtering by type
- Sensor reading history using sub-resources
- Custom error handling and logging

The system uses in-memory data structures such as ConcurrentHashMap instead of a database.

HOW TO RUN
1. Open the project in IntelliJ IDEA Or any executor 
2. Allow Maven to download dependencies
3. Run Main.java
4. The server will start at http://localhost:8080/api/v1
5. Use Postman or curl to test the endpoints

Curl commands
curl -X GET http://localhost:8080/api/v1

curl -X POST http://localhost:8080/api/v1/rooms -H "Content-Type: application/json" -d "{\"roomId\":\"R101\",\"name\":\"Lab 1\",\"building\":\"Engineering\",\"floor\":1}"

curl -X GET http://localhost:8080/api/v1/rooms

curl -X POST http://localhost:8080/api/v1/sensors -H "Content-Type: application/json" -d "{\"sensorId\":\"S1\",\"name\":\"CO2 Sensor\",\"type\":\"CO2\",\"roomId\":\"R101\",\"status\":\"ACTIVE\",\"currentValue\":400.0}"

curl -X GET "http://localhost:8080/api/v1/sensors?type=CO2"

Report answer
### Part 1 – JAX-RS Lifecycle

In JAX-RS, resource classes are created per request by default. This means a new instance is created for each incoming request. Because of this, we use shared data structures like ConcurrentHashMap to store data safely. This helps avoid data loss and race conditions.

---

### Part 1 – HATEOAS

Hypermedia allows clients to navigate the API using links in responses instead of hardcoding URLs. This makes the API easier to use and more flexible because clients do not need to rely on static documentation.

---

### Part 2 – Returning IDs vs full objects

Returning only IDs uses less network bandwidth, but the client must make more requests to get details. Returning full objects uses more data but makes it easier for the client to process everything in one request.

---

### Part 2 – DELETE idempotency

Yes, DELETE is idempotent. If the same DELETE request is sent multiple times, the final state does not change. The first request deletes the room, and further requests return 404, but the system state remains the same.

---

### Part 3 – @Consumes JSON

If a client sends a different format like text/plain, JAX-RS will return a 415 Unsupported Media Type error because it does not match the expected JSON format.

---

### Part 3 – QueryParam vs Path

Query parameters are better for filtering because they are optional and flexible. Path parameters are better for identifying specific resources.

---

### Part 4 – Sub-resource locator

Sub-resource locators help organise code by separating logic into different classes. This makes the API easier to manage and avoids large, complex classes.

---

### Part 5 – HTTP 422 vs 404

HTTP 422 is more accurate because the request format is correct, but the data inside it is invalid. A 404 usually means the resource itself does not exist.

---

### Part 5 – Stack trace security

Exposing stack traces can reveal internal code structure, file paths, and system details. Attackers can use this information to find vulnerabilities.
