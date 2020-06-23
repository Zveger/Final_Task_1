/*
 * Main
 *
 * Version 1
 *
 * @author Herman Zviertseva, KhPI
 * 1.1. Download a text about Harry Potter.
 * 1.2. For each distinct word in the text calculate the number of occurrence.
 * 1.3. Use RegEx..
 * 1.4. Sort in the DESC mode by the number of occurrence..
 * 1.5. Find  the first 20 pairs.
 * 1.6  Find all the proper names
 * 1.7. Count them and arrange in alphabetic order.
 * 1.8. First 20 pairs and names write into to a file test.txt
 * 1.9. Create a fine header for the file
 * 1.10 Use Java Collections to demonstrate your experience (Map, List)
 */

package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1.1. Download a text about Harry Potter.

        String text = new String(Files.readAllBytes(Paths.get("D:\\Harry.txt")));

        // 1.3 Use ReGex

        String cleanedText = text.replaceAll("[\\P{L}]+", " ");

        // Put string into Array list

        List<String> harryList = new ArrayList<String>(Arrays.asList(cleanedText.split(" ")));

        // 1.2. For each distinct word in the text calculate the number of occurrence

        Set<String> uniqueWords = new HashSet<String>(harryList);
        Map<String, Integer> frequencyMap = new HashMap<>();
        System.out.println("Unique words and their occurrence number: ");
        for (String s : harryList) {
            Integer count = frequencyMap.get(s);
            if (count == null)
                count = 0;
            frequencyMap.put(s, count + 1);
        }
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Clear Array list from duplicates

        Set<String> set = new HashSet<>(harryList);
        harryList.clear();
        harryList.addAll(set);

        // 1.6  Find all the proper names

        List<String> filteredList = harryList.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());

        // Arrange proper names in alphabetic order

        Collections.sort(filteredList);
        System.out.println("Sorted in alphabetic order proper names:");
        for (String temp : filteredList) {
            System.out.println(temp);
        }

        // Count proper names

        String[] array = new String[filteredList.size()];
        filteredList.toArray(array);
        for(int i = 0; i< array.length; i++) {
        }
        System.out.println("The number of proper names is " + array.length);

    }
}