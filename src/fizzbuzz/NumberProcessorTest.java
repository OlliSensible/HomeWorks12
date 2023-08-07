package fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberProcessorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for n: ");
        int n = scanner.nextInt();
        scanner.close();

        NumberProcessor npFizz = new NumberProcessor((num) -> {
            if (num % 3 == 0 && num % 5 != 0) {
                System.out.print("fizz");
            }
        });
        NumberProcessor npBuzz = new NumberProcessor((num) -> {
            if (num % 3 != 0 && num % 5 == 0) {
                System.out.print("buzz");
            }
        });
        NumberProcessor npFizzBuzz = new NumberProcessor((num) -> {
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.print("fizzbuzz");
            }
        });
        NumberProcessor npNotFizzBuzz = new NumberProcessor((num) -> {
            if (num % 3 != 0 && num % 5 != 0) {
                System.out.print(num);
            }
        });


        List<NumberProcessor> threads = new ArrayList<>();
        threads.add(npFizz);
        threads.add(npBuzz);
        threads.add(npFizzBuzz);
        threads.add(npNotFizzBuzz);

        for (NumberProcessor t : threads) {
            t.start();
        }

        for (int i = 1; i <= n; i++) {
            for (NumberProcessor t : threads) {
                t.process(i);
            }
            while (true) {
                int processed = 0;
                for (NumberProcessor t : threads) {
                    if (t.isNProcessed()) {
                        processed++;
                    }
                }
                if (processed == 4) {
                    break;
                }
            }
            if (i != n) {
                System.out.print(", ");
            }
        }
    }
}
