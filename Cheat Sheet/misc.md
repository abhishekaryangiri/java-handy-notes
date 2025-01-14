In Spring Boot, two microservices typically connect and communicate using REST APIs or message queues. Here's an overview of the process:


---

1. REST API Communication

One microservice makes an HTTP request to another microservice's exposed REST endpoint.

Steps:

Expose REST Endpoint in Microservice A:

@RestController
@RequestMapping("/service-a")
public class ServiceAController {
    @GetMapping("/data")
    public String getData() {
        return "Response from Service A";
    }
}

Consume REST API in Microservice B using RestTemplate or WebClient:

@Service
public class ServiceB {
    private final RestTemplate restTemplate;

    public ServiceB(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callServiceA() {
        return restTemplate.getForObject("http://SERVICE-A/service-a/data", String.class);
    }
}

@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

Service Discovery (Optional): Use tools like Eureka for service discovery and load balancing.



---

2. Message Queue Communication

Two microservices communicate asynchronously via message queues (e.g., RabbitMQ, Kafka).

Steps:

Microservice A (Publisher):

@RestController
@RequestMapping("/publisher")
public class Publisher {
    private final RabbitTemplate rabbitTemplate;

    public Publisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        rabbitTemplate.convertAndSend("queue-name", message);
    }
}

Microservice B (Consumer):

@Service
public class Consumer {
    @RabbitListener(queues = "queue-name")
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
    }
}

Configuration:

@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() {
        return new Queue("queue-name", false);
    }
}



---

Tools Commonly Used:

1. Service Discovery: Eureka, Consul


2. Load Balancing: Ribbon, Spring Cloud LoadBalancer


3. API Gateway: Spring Cloud Gateway, Zuul


4. Message Brokers: RabbitMQ, Apache Kafka


