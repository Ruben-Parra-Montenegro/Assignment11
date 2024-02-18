import java.util.Arrays;
import java.util.Random;

import sorts.Sorts;

public class App {
    public static void main(String[] args) {
        int Number = Integer.parseInt(args[0]);
        int length = Number;
        Integer[] numbers = generateRandomArray(length);
        String[] words = generateRandomWords(length);

        // Sort the numbers array using bubble sort
        long startTime = System.currentTimeMillis();
        Sorts.<Integer>bubbleSort(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by BubbleSort for numbers: " + (endTime - startTime) + "ms");

        // Sort the numbers array using merge sort
        startTime = System.currentTimeMillis();
        Sorts.<Integer>mergeSort(numbers, 0, numbers.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by MergeSort for numbers: " + (endTime - startTime) + "ms");

        // Sort the words array using bubble sort
        startTime = System.currentTimeMillis();
        Sorts.<String>bubbleSort(words);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by BubbleSort for words: " + (endTime - startTime) + "ms");

        // Sort the words array using merge sort
        startTime = System.currentTimeMillis();
        Sorts.<String>mergeSort(words, 0, words.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by MergeSort for words: " + (endTime - startTime) + "ms");

        // Print the sorted arrays
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        System.out.println("Sorted words: " + Arrays.toString(words));
    }

    public static Integer[] generateRandomArray(int length) {
        Random rand = new Random();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }

    public static String[] generateRandomWords(int length) {
        String[] words = new String[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            words[i] = generateRandomWord(rand, 3, 10); // Words of length 3 to 10 characters
        }
        return words;
    }

    public static String generateRandomWord(Random rand, int minLength, int maxLength) {
        int wordLength = rand.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            char letter = (char) ('a' + rand.nextInt(26)); // Generate a random lowercase letter
            word.append(letter);
        }
        return word.toString();
    }
}

// java --enable-preview -jar Assignment11.jar 1000