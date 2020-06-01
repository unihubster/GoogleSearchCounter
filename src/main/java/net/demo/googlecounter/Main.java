package net.demo.googlecounter;

import net.demo.googlecounter.utils.SearchRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SearchRunner searchRunner = new SearchRunner();

        // interactive mode
//        searchRunner.runAppWithView();

        // auto mode
        List<String> queries = new LinkedList<>();
        queries.add("google");
        queries.add("java jsoup");
        queries.add("java");
        queries.add("jsoup");
        queries.add("java jsoup test");
        queries.add("selenium");
        queries.add("cucumber");

        Map<String, Long> queriesSearchResultCounts = searchRunner.runAppInAutoMode(queries);
        queriesSearchResultCounts.forEach((query, count) -> System.out.println(query + "=" + count));
    }

}
