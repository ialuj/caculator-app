# caculator-app
WIT Java Challenge With Spring Boot and RabbitMQ

Follow the steps below to run the project on a local machine:

 - First you might guarantee that the local machine as JRE or JDK 1.8 and Apache Maven.

1. Clone the project using the following GitHu URL - https://github.com/ialuj/caculator-app.git
2. Enter the root project via CMD (Windows) or terminal (Linux) and run:
 - mvn clean install
3. Then "cd calculator-api/target"
4. Run "java -jar calculator-api-0.0.1-SNAPSHOT.jar"
5. Open a browswer and enter the urls for tests: 
 i. "localhost:8080/api/v1/calculator/sum?a=2&b=4"
 ii. "localhost:8080/api/v1/calculator/subtract?a=2&b=4"
 iii. "localhost:8080/api/v1/calculator/multiply?a=2&b=4"
 iv. "localhost:8080/api/v1/calculator/divide?a=2&b=4"
 

6. To test it on Heroku, open the browser and enter the following urls:

 i. "http://calculator-api.herokuapp.com/api/v1/calculator/sum?a=2&b=4"
 ii. "http://calculator-api.herokuapp.com/api/v1/calculator/subtract?a=2&b=4"
 iii. "http://calculator-api.herokuapp.com/api/v1/calculator/multiply?a=2&b=4"
 iv. "http://calculator-api.herokuapp.com/api/v1/calculator/divide?a=2&b=4"


7. The application.properties on calculator-publisher and calculator-consumer contains 
RabbitMQ configurations.
There are 2 options, local RabbitMQ queues or CloudAMQP queues.
Currently the project is set to use CloudAMQP queues.
If you want to use your local RabbitMQ, then go to application.properties on both projects (publisher and consumer) and
comment CloudAMQP settings and uncomment local configurations.

