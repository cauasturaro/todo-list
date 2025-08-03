# ✅ To-Do List API

This is a **RESTful API** project developed with **Spring Boot** for managing a to-do list. It serves as an educational and practical example, providing a foundation for an explanatory article on building APIs with Java and Spring Boot.

📘 Read the full article about creating this API (portuguese): [How to Build a REST API with Spring Boot](https://www.linkedin.com/pulse/sua-primeira-api-rest-com-spring-boot-3-um-guia-passo-cau%C3%A3-sturaro-yaa2e/?trackingId=DPOkigKcqb0pqHBYtoKMFA%3D%3D)

---

## 🚀 Technologies Used

* **Java 17**
* **Spring Boot**
* **PostgreSQL** (database persistence)
* **Maven** (dependency management)
* **Postman** (API testing)
* **HTML + CSS + Vanilla JavaScript** (frontend)
* **Fetch API** (for consuming the API in the frontend)

---

## 📦 API Features

* ✅ Create a new task (`POST /api/tasks`)
* 📄 List all tasks (`GET /api/tasks`)
* 🔍 Get a task by ID (`GET /api/tasks/{id}`)
* ✏️ Update a task (`PUT /api/tasks/{id}`)
* 🗑️ Delete a task (`DELETE /api/tasks/{id}`)
* ☑️ Toggle task completion status (`PATCH /api/tasks/{id}`)

---

## 💎 Frontend Integration

The frontend was built with **pure HTML and CSS**, and consumes the API using **JavaScript with the Fetch API**, allowing:

* Adding tasks via form input
* Dynamically listing all tasks
* Marking tasks as completed
* Removing tasks from the list

---

## ⚙️ Setup

### 🔧 Requirements

Make sure you have the following installed:

* [Java 17+](https://adoptium.net/)
* [Maven](https://maven.apache.org/download.cgi)
* [PostgreSQL](https://www.postgresql.org/download/)

---

### 🚀 How to Run the Project

1. **Clone the repository**

```bash
git clone https://github.com/cauasturaro/to-do-list.git
cd to-do-list
```

---

2. **Set up the PostgreSQL database**

Create a database named `TodoList` and configure a user with access:

```sql
CREATE DATABASE TodoList;
```

Then, configure `application.properties` file inside `src/main/resources/` with your database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_list
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

3. **Build and run the application**

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

4. **Access the API**

Once the application is running, the API will be available at:
`http://localhost:8080/api/tasks`

You can interact with it using tools like Postman, Insomnia, or the provided front-end.

---

5. **Run the front-end (HTML/JS/CSS)**

Open the `index.html` file from the front-end directory in your browser.
It uses the Fetch API to make real-time requests to the backend.


