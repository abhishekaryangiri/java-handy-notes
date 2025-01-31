# **Apache Flink – A Detailed Guide**  

**Apache Flink** is an **open-source, stream-processing framework** designed for **Big Data and Real-time Data Processing**. It supports both **batch processing** and **stream processing**, but its main strength lies in **stream processing**.  

---

## **1. What is Apache Flink?**  
Apache Flink is a **distributed processing engine** that enables **high-performance, low-latency, and fault-tolerant** data processing. It supports **stateful computations** and provides an **exactly-once processing guarantee**.  

### **Key Features**  
✅ **Stream and Batch Processing** – Can handle both real-time and historical data.  
✅ **Distributed Computing** – Processes large-scale data across clusters.  
✅ **Fault-Tolerance** – Uses **checkpointing** and **state recovery** to prevent data loss.  
✅ **Low Latency** – Processes data within milliseconds.  
✅ **Scalability** – Easily scales large systems.  
✅ **Multiple APIs** – Supports APIs in Java, Scala, Python, and SQL.  
✅ **Integration with Big Data Tools** – Works with Kafka, Hadoop, Cassandra, Elasticsearch, and cloud services like AWS, GCP, and Azure.  

---

## **2. Apache Flink Architecture**  

Apache Flink follows a **Master-Slave Architecture**.  

### **Key Components**  
1. **JobManager** –  
   - Controls the entire cluster.  
   - Distributes tasks among **TaskManagers**.  
   - Manages fault tolerance.  
     
2. **TaskManager (Workers)** –  
   - Executes tasks assigned by the JobManager.  
   - Processes tasks in **multiple slots**.  

3. **Dispatcher** –  
   - Manages job submission via Web UI and REST API.  

4. **ResourceManager** –  
   - Manages cluster resources (CPU, Memory).  

---

## **3. Data Processing Modes in Apache Flink**  

1️⃣ **Stream Processing** –  
   - Processes **unbounded (unlimited) data streams**.  
   - Continuously processes incoming data.  
   - Examples: **IoT, Stock Market, Fraud Detection, Log Analysis**.  

2️⃣ **Batch Processing** –  
   - Works on fixed data sets.  
   - Examples: **ETL (Extract, Transform, Load) processes, Data Analytics**.  

---

## **4. Apache Flink vs Other Stream Processing Frameworks**  

| Feature | **Apache Flink** | Apache Spark Streaming | Apache Storm |
|---------|----------------|-----------------|------------|
| **Processing Type** | Real-time & Batch | Micro-batching | Real-time |
| **Latency** | Low (Milliseconds) | High (Seconds) | Low (Milliseconds) |
| **Fault-Tolerance** | Exactly-once | At-least-once | At-least-once |
| **Scalability** | High | High | Medium |
| **Ease of Use** | Moderate | Easy | Complex |

---

## **5. How Apache Flink Works? (Workflow)**  

### **Data Processing Pipeline**  
1️⃣ **Source** → Data is received from Kafka, Filesystem, or a Database.  
2️⃣ **Transformation** → Data operations are performed (Filter, Map, Reduce).  
3️⃣ **Sink** → Processed data is stored in a database, file, or Kafka.  

```java
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkExample {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        
        DataStream<String> dataStream = env.fromElements("Apple", "Banana", "Cherry");
        
        DataStream<Integer> lengthStream = dataStream.map(new MapFunction<String, Integer>() {
            @Override
            public Integer map(String value) {
                return value.length();
            }
        });

        lengthStream.print();
        env.execute("Flink Example");
    }
}
```

---

## **6. Where is Apache Flink Used? (Use Cases)**  
✅ **Fraud Detection** – Monitors financial transactions in real-time.  
✅ **IoT & Sensor Data Processing** – Processes live IoT data.  
✅ **Real-time Analytics** – Analyzes e-commerce, social media, and web traffic data.  
✅ **Stock Market & Trading** – Processes stock and market data live.  
✅ **Machine Learning & AI** – Runs predictive models on live data.  

---

## **7. How to Install Apache Flink?**  

### **Prerequisites**  
✅ Java 8+  
✅ Apache Maven  
✅ Hadoop (Optional, if using HDFS)  

### **Installation Steps**  
```sh
wget https://downloads.apache.org/flink/flink-1.16.0-bin-scala_2.12.tgz
tar -xvzf flink-1.16.0-bin-scala_2.12.tgz
cd flink-1.16.0
bin/start-cluster.sh
```
  
Flink UI: **http://localhost:8081**

---

## **8. Apache Flink vs Apache Kafka**  
Flink and Kafka are often used for stream processing, but their purposes are different.  

| Feature | **Apache Flink** | **Apache Kafka** |
|---------|---------------|---------------|
| **Purpose** | Stream Processing Engine | Message Broker |
| **Data Handling** | Stateful Processing | Stateless Messaging |
| **Use Case** | Real-time Analytics, ML | Event-driven Systems, Logging |

---

## **Conclusion**  
Apache Flink is a **powerful and scalable stream processing framework** that processes large-scale data **quickly and efficiently**. It is considered one of the **best choices for stream processing** and is used by major companies like **Uber, Alibaba, Netflix, and AWS**.

Best for working on **Big Data, AI, or Real-time Processing** 🚀

---

# **📌 Project Overview: Real-time Temperature Monitoring System**
### **🔹 Tech Stack:**
- **Java 8** → Functional programming and Stream API  
- **Spring Boot** → REST API for sensor data input  
- **Apache Flink** → Real-time data processing  
- **MySQL** → Store processed temperature data  
- **Maven** → Build management tool  

### **🔹 Features:**
✅ Receive temperature data from IoT sensors via REST API  
✅ Store data in **MySQL** database  
✅ Process data in real-time using **Apache Flink**  
✅ Filter high-temperature readings (>75°C)  
✅ Display filtered data in logs  

---

## **🔹 Step 1: Create a Spring Boot Project**
Use [Spring Initializr](https://start.spring.io/) or create manually:  

### **Maven Project Structure**
```
temperature-monitoring/
│── src/main/java/com/example/flinkdemo/
│   ├── FlinkDemoApplication.java
│   ├── model/TemperatureReading.java
│   ├── repository/TemperatureRepository.java
│   ├── controller/TemperatureController.java
│   ├── flink/TemperatureFlinkProcessor.java
│── src/main/resources/application.properties
│── pom.xml
```

---

## **🔹 Step 2: Add Dependencies (`pom.xml`)**
```xml
<properties>
    <java.version>1.8</java.version>
</properties>

<dependencies>
    <!-- Spring Boot Web (for REST API) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot JPA (for MySQL integration) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Apache Flink -->
    <dependency>
        <groupId>org.apache.flink</groupId>
        <artifactId>flink-streaming-java_2.12</artifactId>
        <version>1.16.0</version>
    </dependency>
</dependencies>
```

---

## **🔹 Step 3: Configure MySQL Database (`application.properties`)**
```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/flinkdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Settings
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
📌 **Make sure you create the `flinkdb` database in MySQL:**  
```sql
CREATE DATABASE flinkdb;
```

---

## **🔹 Step 4: Define Entity Class (`TemperatureReading.java`)**
```java
package com.example.flinkdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "temperature_readings")
public class TemperatureReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private double temperature;

    public TemperatureReading() {}

    public TemperatureReading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }

    public Long getId() { return id; }
    public String getSensorId() { return sensorId; }
    public double getTemperature() { return temperature; }
}
```

---

## **🔹 Step 5: Create Repository Interface (`TemperatureRepository.java`)**
```java
package com.example.flinkdemo.repository;

import com.example.flinkdemo.model.TemperatureReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<TemperatureReading, Long> {
}
```

---

## **🔹 Step 6: Create REST API Controller (`TemperatureController.java`)**
```java
package com.example.flinkdemo.controller;

import com.example.flinkdemo.model.TemperatureReading;
import com.example.flinkdemo.repository.TemperatureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private final TemperatureRepository repository;

    public TemperatureController(TemperatureRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public String addTemperature(@RequestBody TemperatureReading reading) {
        repository.save(reading);
        return "Temperature recorded!";
    }

    @GetMapping("/all")
    public List<TemperatureReading> getAllReadings() {
        return repository.findAll();
    }
}
```

---

## **🔹 Step 7: Process Data Using Apache Flink (`TemperatureFlinkProcessor.java`)**
```java
package com.example.flinkdemo.flink;

import com.example.flinkdemo.model.TemperatureReading;
import com.example.flinkdemo.repository.TemperatureRepository;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureFlinkProcessor {

    private final TemperatureRepository repository;

    public TemperatureFlinkProcessor(TemperatureRepository repository) {
        this.repository = repository;
        processTemperatureData();
    }

    public void processTemperatureData() {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        List<TemperatureReading> readings = repository.findAll();
        DataStream<TemperatureReading> dataStream = env.fromCollection(readings);

        // Filter temperatures greater than 75°C
        DataStream<TemperatureReading> highTempStream = dataStream.filter(new FilterFunction<TemperatureReading>() {
            @Override
            public boolean filter(TemperatureReading reading) {
                return reading.getTemperature() > 75;
            }
        });

        highTempStream.print();

        try {
            env.execute("High Temperature Filtering");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## **🔹 Step 8: Run & Test the Application**

### **1️⃣ Start MySQL Server**
```sh
sudo systemctl start mysql
```

### **2️⃣ Start Spring Boot Application**
```sh
mvn spring-boot:run
```

### **3️⃣ Test API Using Postman or cURL**  
#### **Add Temperature Data**
```sh
curl -X POST http://localhost:8080/temperature/add -H "Content-Type: application/json" -d '{"sensorId": "Sensor_1", "temperature": 80}'
```

#### **Get All Data**
```sh
curl -X GET http://localhost:8080/temperature/all
```

---

## **🔹 How It Works?**
1️⃣ **User sends temperature readings via REST API**  
2️⃣ **Spring Boot stores data in MySQL Database**  
3️⃣ **Apache Flink processes the data in real-time and filters temperatures above 75°C**  
4️⃣ **Filtered data is displayed in logs**  

---

## **🔹 Conclusion**
✅ This **Spring Boot + Apache Flink + MySQL** project demonstrates **real-time temperature monitoring**.  
✅ Can be extended with **Kafka for real-time message streaming**.  
✅ Useful for **IoT, weather monitoring, and industrial automation**. 🚀  

😊
