package net.demo;

import net.demo.utils.SearchRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        new SearchRunner().runAppWithView();

        List<String> queries = new LinkedList<>();
        queries.add("java jsoup");
        queries.add("java");
        queries.add("jsoup");
        queries.add("java jsoup test");
        queries.add("selenium");
        queries.add("cucumber");

        Map<String, Integer> queriesSearchResultCounts = new SearchRunner().runAppInAutoMode(queries);
        queriesSearchResultCounts.forEach((query, count) -> System.out.println(query + "=" + count));
    }

}
