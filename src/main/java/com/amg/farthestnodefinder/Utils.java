package com.amg.graphvisualizer;

public class Utils {
    //finding maximum value and its frequency in given array.
    public static int[] maxFrequencyFinder(int[] array) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != Integer.MAX_VALUE && array[i] > max) max = array[i];
        }
        int counter = 0;
        if(max!=Integer.MIN_VALUE) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == max) counter++;
            }
        }

        result[0] = max;
        result[1] = counter;
        return result;
    }
}
