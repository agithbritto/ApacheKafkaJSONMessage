# ApacheKafkaJSONMessage
Springboot Apache Kafka Application to send JSON input

Hit this API in POSTMAN
http://localhost:8080/api/v1/kafka/publish

With raw json data

{
    "id":1, 
    "name":"britto"
}

Producer will be invoked which will send User DTO to the broker .
Consumer consumes the USER DTO message from broker and writes a log .

To start zookeeper in windows
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
To start kafka in windows
.\bin\windows\kafka-server-start.bat .\config\server.properties
