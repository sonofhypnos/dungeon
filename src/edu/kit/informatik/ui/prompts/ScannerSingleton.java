package edu.kit.informatik.ui.prompts;

import java.util.Scanner;

/**
 * @author upkim
 * @version 1.0.0 2022-03-15
 */
public class ScannerSingleton {
    private static Scanner scanner = null;

    public static Scanner getInstance(){
        if (scanner == null) {
            scanner = new Scanner(System.in);
            return scanner;
        }
        else {
            return scanner;
        }
    }
}
