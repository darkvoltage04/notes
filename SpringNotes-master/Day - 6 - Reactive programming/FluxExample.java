package core.rective;
import reactor.core.publisher.Flux;

public class FluxExample {
    public static void main(String[] args) {
        // Creating a Flux that emits a sequence of names
    	//Here Prgramaticcaly Flux is abstract class which represing String data
    	/*
    	 * 
    	 * Flux<T> represents a reactive stream of 0..N elements.
    	 * 
    	 * It emits data over time (asynchronously).
    	 * 
    	 * t's part of the Reactive Streams specification (
    	 * 
    	 */
    	
    	
    	//  String just<String... data)
        Flux<String> nameFlux = Flux.just("Alice", "", "Charlie", "David");

        // Subscribing to the Flux and printing each element'
        /*
         * internally, a CoreSubscriber is created that implements:

                                  onNext(T item)

                                   onError(Throwable error)

                                       onComplete()

                          Your lambdas are used as the implementation of these methods.
         * 
         * 
         * 
         * 
         */
        
        
        nameFlux.subscribe(
            name -> System.out.println("Received: " + name), // onNext
            error -> System.err.println("Error: " + error),  // onError
            () -> System.out.println("Completed!")           // onComplete
        );
    }
}
