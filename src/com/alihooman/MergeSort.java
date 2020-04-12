package com.alihooman;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility to merge sort a list of values in ascending order.
 */
public class MergeSort {

    /**
     * Public method for sorting a List in ascending order.
     * @param unsortedList The List to be sorted.
     * @return A sorted List.
     */
    public static List<Double> sort(List<Double> unsortedList) {
        List<Double> combinedList = new ArrayList<>();
        return sortList(unsortedList);
    }

    /**
     * Recursive method for sorting a List.
     * @param list The List that is being sorted.
     * @return A sorted List.
     */
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

        /* Recursively sort each list and merge them. */
        return mergeList(sortList(leftList), sortList(rightList));
    }

    /**
     * Merge two sorted lists' elements into a single list in ascending order.
     * @param leftList The sorted "left" half of the list.
     * @param rightList The sorted "right" half of the list.
     * @return A sorted list of all of the elements combined.
     */
    private static List<Double> mergeList(List<Double> leftList, List<Double> rightList) {
        /* List of sorted elements to be returned. */
        List<Double> combinedList = new ArrayList<>();

        /* List size of each half of the list. */
        int leftSize = leftList.size();
        int rightSize = rightList.size();

        /* Starting indexes for each half of the List. */
        int leftIndex = 0;
        int rightIndex = 0;

        /* Compare the next remaining element of each List and add the least element to the combined list. */
        while(leftIndex < leftSize && rightIndex < rightSize) {
            if(leftList.get(leftIndex) <= rightList.get(rightIndex)) {
                combinedList.add(leftList.get(leftIndex++));
            } else {
                combinedList.add(rightList.get(rightIndex++));
            }
        }

        /*
         * Handle the remaining list's elements. Only one of the below while loops will run since leftIndex
         * or rightIndex has reached the end of its list at this point.
         */
        while(leftIndex < leftSize) {
            combinedList.add(leftList.get(leftIndex++));
        }
        while(rightIndex < rightSize) {
            combinedList.add(rightList.get(rightIndex++));
        }

        /* Return the combinedList. */
        return combinedList;
    }
}
