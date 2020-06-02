package net.demo.googlecounter.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    protected int getAppModeFromUser() {
        System.out.println("Please, choose application mode and enter corresponding number:\n\n" +
                "1 - (default mode) put words for Google Search query;\n" +
                "2 - put direct Google search link (ex. https://www.google.com/search?q=java+jsoup)\n"
        );

        try {
            int result = new Scanner(System.in).nextInt();
            if (result == 1) {
                return 1;
            } else if (result == 2) {
                return 2;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input value. Default mode running");
            return 1;
        }
    }

    protected String getLinkFromUser() {
        String link;
        do {
            System.out.println("Please, enter link what you what to test:");
            link = new Scanner(System.in).next();
        } while (link.isEmpty());
        return link;
    }

    protected String getWordsToSearchFromUser() {
        String words;
        do {
            System.out.println("Please, enter words which you what to google:");
            words = new Scanner(System.in).nextLine();
        } while (words.isEmpty());
        return words.trim();
    }

    protected void displaySearchCount(long count) {
        System.out.println("Google search results count is around " + count);
    }

    protected void displayText(String text) {
        System.out.println(text);
    }
}
