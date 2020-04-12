package com.alihooman;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        List<Double> unsortedList = new ArrayList<>();
        unsortedList.add(0.5);
        unsortedList.add(-653.6);
        unsortedList.add(+043.5);
        unsortedList.add(-4343.6);
        unsortedList.add(4.0);
        unsortedList.add(76463.0);
        unsortedList.add(-34534.543);
        unsortedList.add(69.420);

        List<Double> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);

        assertEquals(sortedList, MergeSort.sort(unsortedList));
    }
}