package net.demo.googlecounter.utils;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchRunner {
    private final ConsoleView view = new ConsoleView();
    private final OnlineSearchProcessor onlineSearchProcessor = new OnlineSearchProcessor();

    public void runAppWithView() {
        switch (view.getAppModeFromUser()) {
            case (1):
                runWordsGoogleSearch();
                break;
            case (2):
                runLinkGoogleSearch();
                break;
            default:
                runWordsGoogleSearch();
        }
    }

    public Map<String, Integer> runAppInAutoMode(List<String> queries) {
        Map<String, Integer> searchCounts = new TreeMap<>();
        for (String query : queries) {
            try {
                String link = onlineSearchProcessor.prepareGoggleLink(query);
                view.displayText(link);
                Document document = onlineSearchProcessor.getPage(link);
                searchCounts.put(query, onlineSearchProcessor.parseGoogleSearchResultsCount(document));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return searchCounts;
    }

    public int runAppInAutoMode(String query) throws IOException {
        String link = onlineSearchProcessor.prepareGoggleLink(query);
        view.displayText(link);
        Document document = onlineSearchProcessor.getPage(link);
        return onlineSearchProcessor.parseGoogleSearchResultsCount(document);
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
