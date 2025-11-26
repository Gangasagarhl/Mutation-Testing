package org.example.Backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class Combination {

    // Private constructor ensures this class acts like a utility helper
    private Combination() {
    }

    /**
     * Generates all unique combinations of size 'n' from the given array.
     * The elements in each combination are stored in a TreeSet to keep them sorted
     * and to avoid duplicates when values repeat.
     */
    public static <T> List<TreeSet<T>> combination(T[] arr, int n) {

        // A negative size doesn't make sense for combination length
        if (n < 0) {
            throw new IllegalArgumentException("The combination length cannot be negative.");
        }

        // Requesting combinations of size zero yields no meaningful results
        if (n == 0) {
            return Collections.emptyList();
        }

        // Sort and clone the array so original content isn't disturbed
        T[] array = arr.clone();
        Arrays.sort(array);

        // Will hold all valid groups of size 'n'
        List<TreeSet<T>> result = new LinkedList<>();

        // Start the recursive exploration
        backtracking(array, n, 0, new TreeSet<T>(), result);
        return result;
    }

    /**
     * Recursive function that constructs combinations depth-first.
     * - arr      : input array (sorted)
     * - n        : required combination size
     * - index    : current position from where to pick elements
     * - currSet  : the partially built combination
     * - result   : stores fully built combinations
     */
    private static <T> void backtracking(T[] arr, int n, int index,
                                         TreeSet<T> currSet,
                                         List<TreeSet<T>> result) {

        // Early exit: if even by picking every remaining element,
        // we cannot reach the desired 'n' size, stop here.
        if (index + n - currSet.size() > arr.length) {
            return;
        }

        // If we only need one more element to complete a combination,
        // we can directly append each remaining element one by one.
        if (currSet.size() == n - 1) {
            for (int i = index; i < arr.length; i++) {
                currSet.add(arr[i]);
                result.add(new TreeSet<>(currSet)); // Store the finished combination
                currSet.remove(arr[i]);             // Undo and try next item
            }
            return;
        }

        // Otherwise, keep exploring deeper by choosing elements one at a time
        for (int i = index; i < arr.length; i++) {
            currSet.add(arr[i]);
            backtracking(arr, n, i + 1, currSet, result);
            currSet.remove(arr[i]); // Backtrack to try alternative paths
        }
    }
}
