# 🚆 Train Scheduling System (Spring Boot API)

A Spring Boot REST API for managing train schedules — supports adding, updating, deleting, and searching trains via MySQL. Built with Java and tested using Postman.

---

## 🛠 Tech Stack

- Java 17+  
- Spring Boot  
- Maven  
- MySQL  
- Postman  

---

## ⚙️ Setup Instructions

### 1. Database Tables

```sql
CREATE TABLE train (
  id BIGINT NOT NULL,
  train_name VARCHAR(255),
  train_number BIGINT,
  next_station_id VARCHAR(255),
  station_id VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE train_dto (
  number BIGINT NOT NULL,
  name VARCHAR(255),
  list_of_trains VARBINARY(255),
  PRIMARY KEY (number)
);
```

### 2. Configure application.properties

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
server.port=9090
```

### 3. Free Up Port 9090

```bash
sudo lsof -t -i:9090 | xargs kill -9
```


### Run Application

```bash
com.springrest.springrest.SpringrestApplication
```

### 📬 API Endpoints
| Method | Endpoint               | Function                         |
| ------ | ---------------------- | -------------------------------- |
| POST   | `/home/addTrain`       | Add a new train                  |
| POST   | `/home/trainByNumber`  | Search train by number           |
| POST   | `/home/removeByNumber` | Remove train by number           |
| POST   | `/home/updateTrain`    | Update train details             |
| GET    | `/home/srcDstnTrains`  | Find trains between two stations |


### Sample JSON (Postman)
```json
{
  "number": 20220,
  "name": "SBC VANDE BHARAT EXPRESS",
  "stations": ["Gwalior", "Agra", "Mathura", "Delhi"]
}

{
  "source": "Gwalior",
  "destination": "Delhi"
}

{
  "number": 20220
}
```
