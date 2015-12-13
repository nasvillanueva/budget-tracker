package com.nasvillanueva.budgettracker.util;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NazIsEvil on 13/12/2015.
 *
 * This was copied from Federico Peralta Schaffner from Stackoverflow
 * http://stackoverflow.com/a/28370899
 *
 */
public class PropertySplitter {
    /**
     * Example: one.example.property = KEY1:VALUE1,KEY2:VALUE2
     */
    public static Map<String, String> map(String property) {
        return map(property, ",");
    }

    /**
     * Example: one.example.property = KEY1:VALUE1.1,VALUE1.2;KEY2:VALUE2.1,VALUE2.2
     */
    public static Map<String, List<String>> mapOfList(String property) {
        Map<String, String> map = map(property, ";");

        Map<String, List<String>> mapOfList = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            mapOfList.put(entry.getKey(), list(entry.getValue()));
        }

        return mapOfList;
    }

    /**
     * Example: one.example.property = VALUE1,VALUE2,VALUE3,VALUE4
     */
    public static List<String> list(String property) {
        return list(property, ",");
    }

    /**
     * Example: one.example.property = VALUE1.1,VALUE1.2;VALUE2.1,VALUE2.2
     */
    public static List<List<String>> groupedList(String property) {
        List<String> unGroupedList = list(property, ";");

        List<List<String>> groupedList = new ArrayList<>();
        for (String group : unGroupedList) {
            groupedList.add(list(group));
        }

        return groupedList;

    }

    private static List<String> list(String property, String splitter) {
        return Splitter.on(splitter).omitEmptyStrings().trimResults().splitToList(property);
    }

    private static Map<String, String> map(String property, String splitter) {
        return Splitter.on(splitter).omitEmptyStrings().trimResults().withKeyValueSeparator(":").split(property);
    }
}
