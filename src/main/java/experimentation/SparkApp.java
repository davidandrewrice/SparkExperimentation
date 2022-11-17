package experimentation;

import lombok.extern.slf4j.Slf4j;

import static spark.Spark.*;

@Slf4j
public class SparkApp {
    public static void main(String[] args) {
        log.info("Starting server...");

        get("/hello", (req, res) -> "Hello world!");

        awaitStop();

        log.info("Server finishing...");
    }
}