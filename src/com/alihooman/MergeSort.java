package com.alihooman;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility to merge sort a list of values.
 */
public class MergeSort {

    /**
     * Public method for sorting a List.
     * @param unsortedList The List to be sorted.
     * @return A sorted List.
     */
    public static List<Double> sort(List<Double> unsortedList) {
        List<Double> combinedList = new ArrayList<>();
        return sortList(unsortedList);
    }

    private static List<Double> sortList(List<Double> list) {
        /* Base case, if the List has one element, it is sorted, return. */
        if(list.size() < 2) {
            return list;
        }

        /* Get the mid point of the List. */
        int middleIndex = list.size() / 2;

        /* Setup left and right Lists based on midpoint. */
        List<Double> leftList = list.subList(0, middleIndex);
        List<Double> rightList = list.subList(middleIndex, list.size());

        /* Recursively sort each list. */
        /* Merge the lists. */
        return mergeList(sortList(leftList), sortList(rightList));
    }

    private static List<Double> mergeList(List<Double> leftList, List<Double> rightList) {
        List<Double> combinedList = new ArrayList<>();
        int leftSize = leftList.size();
        int rightSize = rightList.size();
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < leftSize && rightIndex < rightSize) {
            if(leftList.get(leftIndex) <= rightList.get(rightIndex)) {
                // list.set(index++, leftList.get(leftIndex++));
                combinedList.add(leftList.get(leftIndex++));
            } else {
                combinedList.add(rightList.get(rightIndex++));
                // list.set(index++, rightList.get(rightIndex++));
            }
        }

        while(leftIndex < leftSize) {
            combinedList.add(leftList.get(leftIndex++));
        }

        while(rightIndex < rightSize) {
            combinedList.add(rightList.get(rightIndex++));
        }

        return combinedList;
    }
}
