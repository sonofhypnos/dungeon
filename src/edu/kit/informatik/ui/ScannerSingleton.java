package edu.kit.informatik.ui;

import java.util.Scanner;

/**
 * Scanner Singleton. Makes sure prompts use the same scanner Instance.
 *
 * @author upkim
 * @version 1.0.0 2022-03-15
 */
public final class ScannerSingleton {
    private static Scanner scanner = null;

    private ScannerSingleton() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    /**
     * Close instance.
     */
    public static void closeInstance() {
        scanner.close();
    }
}
