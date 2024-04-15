package dev.jacekorjason.mathcalc;

import dev.jacekorjason.consoleapi.ConsoleAPI;

public class Main {
    public static void main(String[] args) {
        int consoleIndent = 4;
        ConsoleAPI consoleAPI = new ConsoleAPI(consoleIndent);
        MathCalc mathCalc = new MathCalc(consoleAPI);
        mathCalc.run();
    }
}