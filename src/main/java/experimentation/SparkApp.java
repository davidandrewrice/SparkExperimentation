package experimentation;

import lombok.extern.slf4j.Slf4j;

import static spark.Spark.*;

@Slf4j
public class SparkApp {
    public static void main(String[] args) {
        log.info("Starting server...");

        port(8080);

        get("/ping", ((req, res) -> "healthy"));

        get("/hello", ((req, res) -> "hi there!!"));

        post("/echo", (req, res) -> {

                log.info("Processing request: " + req.body());
                return req.body();
                });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("Server finishing...");
            }
        }));


    }
}