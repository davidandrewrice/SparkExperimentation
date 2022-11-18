package experimentation;

import lombok.extern.slf4j.Slf4j;

import static spark.Spark.*;

@Slf4j
public class SparkApp {
    public static void main(String[] args) {
        log.info("Starting server...");

        port(8080);

        post("/hello", (req, res) -> {

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