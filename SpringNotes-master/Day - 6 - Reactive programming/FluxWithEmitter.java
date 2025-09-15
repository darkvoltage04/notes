package core.rective;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Scanner;

public class FluxWithEmitter {
    public static void main(String[] args) {

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create a Flux that uses FluxSink to emit data dynamically
        Flux<String> userInputFlux = Flux.create((FluxSink<String> emitter) -> {
            System.out.println("Enter input values (type 'exit' to stop):");

            while (true) {
                String input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    emitter.complete(); // End the Flux
                    break;
                }

                emitter.next(input); // Push value into the stream
            }
        });

        // Subscribe to the flux to print each value
        userInputFlux.subscribe(
                data -> System.out.println("Received: " + data),    // onNext
                error -> System.err.println("Error: " + error),     // onError
                () -> System.out.println("All data received. Stream complete.") // onComplete
        );
    }
}
