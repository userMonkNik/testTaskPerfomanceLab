package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    private static final List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {

        try (BufferedReader numbersReader = new BufferedReader(new FileReader(args[0]))) {
            String tempNumber;

            while ((tempNumber = numbersReader.readLine()) != null) {
                tempNumber = tempNumber.trim();

                numbers.add(Integer.parseInt(tempNumber));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        numbers.sort(Comparator.naturalOrder());

        int medium = findMediumNumber();

        System.out.println(countIterations(medium));

    }

    private static int countIterations(int medium) {
        int sum = 0;

        for (Integer number : Task4.numbers) {
            sum += Math.abs(number - medium);
        }

        return sum;
    }

    private static int findMediumNumber() {

        if (Task4.numbers.size() % 2 != 0) {

            return Task4.numbers.get((Task4.numbers.size() / 2));
        } else {

            return (Task4.numbers.get((Task4.numbers.size() / 2) - 1) + Task4.numbers.get(Task4.numbers.size() / 2)) / 2;
        }
    }
}
