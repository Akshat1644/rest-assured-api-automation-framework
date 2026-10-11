# 🚀 REST Assured API Automation Framework

[![Build Status](http://localhost:8080/job/RestAssuredFramework-Pipeline/badge/icon)](http://localhost:8080/job/RestAssuredFramework-Pipeline/)

A scalable and reusable REST API Automation Framework built using **Java, Rest Assured, TestNG, Maven and CI/CD**. The framework follows industry-standard design principles with a Service Layer, POJO-based request/response handling, reusable specifications, configuration management, and advanced API validations.

---

## 📌 Features

- ✅ CRUD API Automation (Create, Read, Update, Patch, Delete)
- ✅ Token-Based Authentication
- ✅ Service Layer Design
- ✅ Request & Response Specifications
- ✅ POJO-Based Serialization & Deserialization
- ✅ Centralized API Endpoints
- ✅ Configuration Management using `config.properties`
- ✅ Test Data Builder for reusable test data
- ✅ JSONPath Response Extraction
- ✅ Path Parameters & Query Parameters
- ✅ Response Header Validation
- ✅ Response Time Validation
- ✅ Hamcrest Matchers Assertions
- ✅ Automatic Request & Response Logging
- ✅ Maven Project Structure
- ✅ TestNG Integration

---

# 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Rest Assured | API Automation |
| TestNG | Test Framework |
| Maven | Build & Dependency Management |
| Jackson | Serialization & Deserialization |
| Hamcrest | Assertions |
| Eclipse | IDE |
| Git & GitHub | Version Control |

---

# 📂 Project Structure

```
RestAssuredFramework
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       │     └── BaseTest.java
│   │       │
│   │       ├── endpoints
│   │       │     └── Routes.java
│   │       │
│   │       ├── models
│   │       │     ├── Booking.java
│   │       │     └── BookingDates.java
│   │       │
│   │       ├── services
│   │       │     ├── AuthService.java
│   │       │     └── BookingService.java
│   │       │
│   │       ├── specifications
│   │       │     ├── RequestSpec.java
│   │       │     └── ResponseSpec.java
│   │       │
│   │       └── utils
│   │             ├── ConfigReader.java
│   │             └── TestDataBuilder.java
│   │
│   └── test
│       ├── java
│       │     └── tests
│       │           ├── GenerateTokenTest.java
│       │           ├── CreateBookingTest.java
│       │           ├── GetBookingTest.java
│       │           ├── CRUDBookingTest.java
│       │           └── AdvancedRestAssuredTest.java
│       │
│       └── resources
│             └── config.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# ⚙️ Framework Design

The framework is divided into reusable components for better maintainability.

### BaseTest
- Initializes the Base URI before test execution.

### Routes
- Stores all API endpoints in one place.
- Eliminates hardcoded URLs.

### Request Specification
- Stores common request configuration.
- Content-Type
- Logging Filters
- Common headers

### Response Specification
- Stores common response validations.
- Expected status codes
- Response content type

### POJO Classes
- Booking
- BookingDates

Used for Serialization and Deserialization.

### Service Layer

#### AuthService
- Generates Authentication Token

#### BookingService
- Create Booking
- Get Booking
- Update Booking
- Partial Update Booking
- Delete Booking

The Service Layer separates API operations from test classes, making the framework more reusable and maintainable.

### ConfigReader
Reads configuration values from:

```
config.properties
```

Example:

```
base.url=https://restful-booker.herokuapp.com
username=admin
password=password123
```

### TestDataBuilder

Generates reusable request bodies instead of hardcoding data in every test.

---

# 📖 API Scenarios Covered

### Authentication

- Generate Authentication Token

### Booking APIs

- Create Booking
- Get Booking
- Get All Bookings
- Update Booking
- Partial Update Booking
- Delete Booking
- Verify Deleted Booking

---

# 📚 Advanced REST Assured Concepts

This framework also demonstrates:

- Serialization
- Deserialization
- JSONPath
- Response Extraction
- Path Parameters
- Query Parameters
- Header Validation
- Response Time Validation
- Hamcrest Matchers
- Automatic Logging Filters

---

# ▶️ How to Run the Project

### Clone Repository

```bash
git clone https://github.com/<your-username>/<repository-name>.git
```

### Navigate to Project

```bash
cd RestAssuredFramework
```

### Install Dependencies

```bash
mvn clean install
```

### Execute Tests

```bash
mvn test
```

Or run individual TestNG classes directly from Eclipse.

---

# 📸 Sample Test Flow

```
Generate Token
        │
        ▼
Create Booking
        │
        ▼
Get Booking
        │
        ▼
Update Booking
        │
        ▼
Partial Update Booking
        │
        ▼
Delete Booking
        │
        ▼
Verify Booking Deleted
```

---

# 💡 Key REST Assured Concepts Demonstrated

- Request Specification
- Response Specification
- Path Parameters
- Query Parameters
- JSONPath
- Serialization
- Deserialization
- Hamcrest Assertions
- Response Extraction
- Service Layer Design
- POJO Mapping
- Configuration Management

---

# 🚀 Future Enhancements

- Extent Reports
- Allure Reports
- Data-Driven Testing using Excel
- JSON Schema Validation
- Jenkins CI/CD Integration
- GitHub Actions
- Parallel Test Execution
- Environment Switching (QA/UAT/Production)

---

# 🎯 Learning Outcomes

Through this project, I gained practical experience in:

- REST API Automation
- Framework Design
- Java Object-Oriented Programming
- REST Assured
- TestNG
- Maven
- API Authentication
- JSON Parsing
- Serialization & Deserialization
- Reusable Test Framework Design
- API Validation Techniques
- Git & GitHub Version Control

---

# 👨‍💻 Author

**Akshat Dahalwar**

If you found this project helpful, feel free to ⭐ the repository.

---