package dev.jacekorjason.mathcalc;

import dev.jacekorjason.consoleapi.ConsoleAPI;

import java.util.Scanner;

public class MathCalc {
    private final String[] positionCursor;

    public MathCalc(ConsoleAPI consoleAPI) {
        positionCursor = new String[3];
        for (int i = 0; i < positionCursor.length; i++) {
            positionCursor[i] = consoleAPI.positionCursor(i);
        }
    }

    public void run() {
        //int place = 0;
        String input;
        Scanner scanner = new Scanner(System.in);

        String outputWelcome =
            positionCursor[1] +
            "Welcome to a program that performs calculations " +
            "based on the values entered!" + positionCursor[1] +
            "If you want to calculate the average of the given values " +
            "and find the value closest to that average, type '1'" + positionCursor[1] +
            "If you want to quit, type '0'" + "%n"
        ;

        String outputMenu =
            positionCursor[1] +
            "1. Average and closest value" + positionCursor[1] +
            "0. Quit" + "%n"
        ;

        String errorIncorrectInput =
            positionCursor[0] + "Incorrect input! Try again" + "%n"
        ;

        // display welcome  //
        System.out.printf(outputWelcome);

        // main section //
        while(true) {
            // get number for input //
            while(true) {
                System.out.printf(positionCursor[0]);
                input = scanner.nextLine();
                if(input.equals("0") || input.equals("1")) {
                    break;
                } else {
                    System.out.printf(errorIncorrectInput);
                }
            }

            // redirect to the right place //
            if(input.equals("0")) break;
            //else if(input.equals("1")) place = 1;

            // section 1 //
            //if(place == 1) {
            while(true) {
                if(!averageAndClosestNumber()) break;
            }

            // display menu //
            System.out.printf(outputMenu);
        }
        System.out.printf(positionCursor[0] + "Bye!" + "%n");
    }

    public boolean averageAndClosestNumber() {
        boolean active = true;
        String input;
        Scanner scanner = new Scanner(System.in);
        int valueCount;

        String outputHowManyValues =
            positionCursor[1] +
            "How many values would you like to enter?" + "%n"
        ;

        String outputRepeat =
            positionCursor[2] +
            "To repeat, type 'R'" + positionCursor[1] +
            "To quit, type 'Q'" + "%n"
        ;

        String errorIncorrectFormat =
            positionCursor[0] +
            "Incorrect format! Try again" + "%n"
        ;

        String errorGreaterThanZero =
            positionCursor[0] +
            "Number must be greater than zero!" + "%n"
        ;

        String errorIncorrectInput =
            positionCursor[0] +
            "Incorrect input! Try again" + "%n"
        ;

        // get value for valueCount //
        System.out.printf(outputHowManyValues);
        while(true) {
            System.out.printf(positionCursor[0]);
            input = scanner.nextLine();
            try {
                valueCount = Integer.parseInt(input);
            } catch(NumberFormatException e) {
                System.out.printf(errorIncorrectFormat);
                continue;
            }
            if(valueCount <= 0) {
                System.out.printf(errorGreaterThanZero);
                continue;
            }
            break;
        }

//        ArrayList<Double> val = new ArrayList<>(valueCount);
        double[] values = new double[valueCount];

        // load values and write them to values[] //
        for(int i = 0; i < valueCount; i++) {
            while(true) {
                System.out.printf(positionCursor[0] +"Enter value %d" + positionCursor[1], i+1);
                input = scanner.nextLine();
                try {
                    values[i] = Double.parseDouble(input);
//                    val.add(i, Double.parseDouble(input));
                } catch(NumberFormatException e) {
                    System.out.printf(errorIncorrectFormat);
                    continue;
                }
                break;
            }
        }

//        var valuesArray = val.toArray(new Double[0]);

        // calculate average //
        double average = Calculations.average(values);

        // calculate closest to average //
        double[] closestToAverage = Calculations.closestToAverage(values);

        // show results //
        System.out.printf(
            positionCursor[1] +
            "Average equals " + average + positionCursor[1] +
            "Value closest to average is " + closestToAverage[0]
        );
        if(closestToAverage.length > 1) {
            System.out.print(" and " + closestToAverage[1]);
        }

        // suggest a repeat //
        System.out.printf(outputRepeat);
        while(true) {
            System.out.printf(positionCursor[0]);
            input = scanner.nextLine();
            if("Qq".contains(input) && !input.isEmpty()) {
                active = false;
                break;
            } else if ("Rr".contains(input) && !input.isEmpty()) {
                break;
            } else {
                System.out.printf(errorIncorrectInput);
            }
        }

        return active;
    }
}
