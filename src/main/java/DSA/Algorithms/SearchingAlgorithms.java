package DSA.Algorithms;

public class SearchingAlgorithms {

    /**
     * Function to determine if an element exists in a sorted array or not using Iterative Binary Search Algorithm
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchItr(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;

        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and compare it with the target
            int mid = (left + right) / 2;

            // `target` is found
            if (target == nums[mid]) {
                return mid;
            }

            // discard all elements in the right search space, including the middle element
            else if (target < nums[mid]) {
                right = mid - 1;
            }

            // discard all elements in the left search space, including the middle element
            else {
                left = mid + 1;
            }
        }

        // `target` doesn't exist in the array
        return -1;
    }


    /**
     * Function to determine if an element exists in a sorted array or not using a recursive implementation of the Binary Search Algorithm
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearchRec(int[] nums, int left, int right, int target)
    {
        // Base condition (search space is exhausted)
        if (left > right) {
            return -1;
        }

        // find the mid-value in the search space and compare it with the target
        int mid = (left + right) / 2;

        // Base condition (a target is found)
        if (target == nums[mid]) {
            return mid;
        }

        // discard all elements in the right search space, including the middle element
        else if (target < nums[mid]) {
            return binarySearchRec(nums, left, mid - 1, target);
        }

        // discard all elements in the left search space, including the middle element
        else {
            return binarySearchRec(nums, mid + 1, right, target);
        }
    }


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
