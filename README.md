# Inventory Manager
This project is a hobby project made with an idea of learning how to serialize and deserialize data between a Java program and a JSON file. I chose to make an **inventory manager** that should be able to save different products to a local JSON file.
## Technicalities
The project is written in Java 21, with the support of JavaFX and Maven. For serializing and deserializing I will use the GSON library.
## Project Structure
```text
.
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── products.json
├── src
│   └── main
│       ├── java
│       │   ├── module-info.java
│       │   └── no
│       │       └── ntnu
│       │           └── mathieno
│       │               └── inventorymanager
│       │                   ├── InvalidStringException.java
│       │                   ├── JsonHandler.java
│       │                   ├── MainApplication.java
│       │                   ├── Product.java
│       │                   └── Sandbox.java
│       └── resources
│           └── no
│               └── ntnu
│                   └── mathieno
│                       └── inventorymanager
│                           ├── hello-view.fxml
│                           └── products.json
└── target
    ├── classes
    │   ├── module-info.class
    │   └── no
    │       └── ntnu
    │           └── mathieno
    │               └── inventorymanager
    │                   ├── InvalidStringException.class
    │                   ├── JsonHandler.class
    │                   ├── MainApplication.class
    │                   ├── Product.class
    │                   ├── Sandbox.class
    │                   ├── hello-view.fxml
    │                   └── products.json
    └── generated-sources
        └── annotations

```
## How to run
```shell
mvn install
mvn clean
mvn compile
mvn javafx:run
```
