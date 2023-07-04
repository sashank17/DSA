package DSA.Algorithms;

public class SearchingAlgorithms {

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


    // Function to determine if an element exists in an array or not using the Sentinel Linear Search Algorithm
    public static int sentinelLinearSearch(int nums[], int target)
    {
        int n = nums.length;

        // Last element of the array
        int last = nums[n - 1];

        // Element to be searched is placed at the last index
        nums[n - 1] = target;
        int i = 0;

        while (nums[i] != target) {
            i++;
        }

        // Put the last element back
        nums[n - 1] = last;

        // `target` is found
        if ((i < n - 1) || (nums[n - 1] == target))
            return i;

        // `target` doesn't exist in the array
        return -1;
    }


    // Function to determine if a `target` exists in the sorted array `nums` or not using Linear Search Algorithm
    public static int sortedLinearSearch(int[] nums, int target) {

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


    // Function to determine if an element exists in a sorted array or not using Iterative Binary Search Algorithm
    public static int iterativeBinarySearch(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;

        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and compare it with the target
            int mid = left + (right - left) / 2;

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


    // Function to determine if an element exists in a sorted array or not using a recursive implementation of the Binary Search Algorithm
    public static int recursiveBinarySearch(int[] nums, int left, int right, int target)
    {
        // Base condition (search space is exhausted)
        if (left > right) {
            return -1;
        }

        // find the mid-value in the search space and compare it with the target
        int mid = left + (right - left) / 2;

        // Base condition (a target is found)
        if (target == nums[mid]) {
            return mid;
        }

        // discard all elements in the right search space, including the middle element
        else if (target < nums[mid]) {
            return recursiveBinarySearch(nums, left, mid - 1, target);
        }

        // discard all elements in the left search space, including the middle element
        else {
            return recursiveBinarySearch(nums, mid + 1, right, target);
        }
    }


    public static int ternarySearch(int[] nums, int left, int right, int target)
    {
        if (right >= left) {

            // Find the mid1 and mid2
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            // Check if target is present at any mid
            if (nums[mid1] == target) {
                return mid1;
            }
            if (nums[mid2] == target) {
                return mid2;
            }

            // The target lies in between left and mid1
            if (target < nums[mid1]) {
                return ternarySearch(nums, left, mid1 - 1, target);
            }
            // The target lies in between mid2 and right
            else if (target > nums[mid2]) {
                return ternarySearch(nums, mid2 + 1, right, target);
            }
            // The target lies in between mid1 and mid2
            else {
                return ternarySearch(nums, mid1 + 1, mid2 - 1, target);
            }
        }

        // target doesn't exist in the array
        return -1;
    }
    

}
