package dev.jacekorjason.mathcalc;

public class Calculations {
    public static double average(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public static double min(double[] values) {
        double minimum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minimum) minimum = values[i];
        }
        return minimum;
    }

    public static double[] closestToAverage(double[] values) {
        double average = average(values);
        double[] gap = new double[values.length];

        // calculate gaps and write them to gap[] //
        for (int i = 0; i < values.length; i++) {
            gap[i] = Math.abs(average - values[i]);
        }

        // find smallest gap //
        double smallestGap = Calculations.min(gap);

        // find numbers with the smallest gap //
        boolean foundFirst = false;
        int closestNrIndexFirst = -1;
        int closestNrIndexSecond = -1;
        for (int i = 0; i < values.length; i++) {
            if (gap[i] == smallestGap) {
                if (!foundFirst) {
                    closestNrIndexFirst = i;
                    foundFirst = true;
                }
                else if (values[i] != values[closestNrIndexFirst]) {
                    closestNrIndexSecond = i;
                }
            }
        }

        // result //
        if (closestNrIndexSecond == -1) {
            return new double[] {values[closestNrIndexFirst]};
        } else {
            return new double[] {values[closestNrIndexFirst], values[closestNrIndexSecond]};
        }
    }
}
