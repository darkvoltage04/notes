package core.rective;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFluxFromUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();

        System.out.println("Enter 3 names:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name #" + (i + 1) + ": ");
            String input = scanner.nextLine();
            inputList.add(input);
        }

        // Create a Flux from the user input list
        Flux<String> userInputFlux = Flux.fromIterable(inputList);

        System.out.println("User input as Flux:");
        userInputFlux.subscribe(System.out::println);
    }
}
