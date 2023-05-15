package DSA.Algorithms.Searching;

public class LinearSearch {

    // Function to determine if a `target` exists in the unsorted array `nums` or not using Linear Search Algorithm
    public static int linearSearch(int[] nums, int target) {

        // loop over the entire search space
        for (int i = 0; i < nums.length; i++) {

            // `target` is found
            if (target == nums[i]) {
                return i;
            }
        }

        // `target` doesn't exist in the array
        return -1;
    }

    // Function to determine if a `target` exists in the sorted array `nums` or not using Linear Search Algorithm
    public static int linearSearchSorted(int[] nums, int target) {

        // loop over the entire search space
        for (int i = 0; nums[i] <= target; i++) {

            // `target` is found
            if (target == nums[i]) {
                return i;
            }
        }

        // `target` doesn't exist in the array
        return -1;
    }
}
