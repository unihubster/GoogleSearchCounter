package net.demo.utils;

import org.jsoup.nodes.Document;

import java.io.IOException;

public class SearchRunner {
    private final ConsoleView view = new ConsoleView();
    private final OnlineSearchProcessor onlineSearchProcessor = new OnlineSearchProcessor();

    public void runApp() {
        switch (view.getAppModeFromUser()) {
            case (2):
                runLinkGoogleSearch();
                break;
            default:
                runWordsGoogleSearch();
        }
    }

    public void runLinkGoogleSearch() {
        try {
            Document document = onlineSearchProcessor.getPage(view.getLinkFromUser());
            view.displaySearchCount(onlineSearchProcessor.parseGoogleSearchResultsCount(document));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runWordsGoogleSearch() {
        try {
            String link = onlineSearchProcessor.prepareGoggleLink(view.getWordsToSearchFromUser());
            view.displayText(link);
            Document document = onlineSearchProcessor.getPage(link);
            view.displaySearchCount(onlineSearchProcessor.parseGoogleSearchResultsCount(document));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
