package net.demo.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class OnlineSearchProcessor {
    // https://www.google.com/search?q=java+jsoup
    private final String GOOGLE_SEARCH_LINK = "https://www.google.com/search?q=";
    private final String GOOGLE_SEARCH_CONCAT_CHAR = "+";

    protected Document getPage(String link) throws IOException {
        return Jsoup.connect(link).get();
    }

    protected String prepareGoggleLink(String words) {
        return GOOGLE_SEARCH_LINK + words.replace(" ", GOOGLE_SEARCH_CONCAT_CHAR);
    }

    protected int parseGoogleSearchResultsCount(Document document) {
        String resultStats = document.getElementById("result-stats").text();
        return Integer.parseInt(
                resultStats
                        .substring(resultStats.indexOf(':') + 1, resultStats.indexOf('(') - 1)
                        .trim()
                        .replace(" ", "")
        );
    }
}
