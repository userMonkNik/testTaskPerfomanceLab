package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {

        try (BufferedReader buf1 = new BufferedReader(new FileReader(args[0]));
             BufferedReader buf2 = new BufferedReader(new FileReader(args[1]))) {

            String[] center = buf1.readLine().split("\\s+");

            double xCenter = Double.parseDouble(center[0]);
            double yCenter = Double.parseDouble(center[1]);
            double radius = Double.parseDouble(buf1.readLine());

            String dots;

            while ((dots = buf2.readLine()) != null) {

                String[] dotsArr = dots.split("\\s+");

                System.out.println(
                        dotInCircle(xCenter,
                                yCenter,
                                radius,
                                Double.parseDouble(dotsArr[0]),
                                Double.parseDouble(dotsArr[1]))
                );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static int dotInCircle(double xCenter, double yCenter, double radius, double xDot, double yDot) {

        double squareSumDots = Math.pow(xDot - xCenter, 2) + Math.pow(yDot - yCenter, 2);
        double squareRadius = Math.pow(radius, 2);

        if (squareSumDots > squareRadius) {
            return 2;

        } else if (squareSumDots < squareRadius) {
            return 1;

        } else if (squareSumDots == squareRadius) {
            return 0;

        } else {
            throw new RuntimeException("Wrong arguments");
        }
    }
}
