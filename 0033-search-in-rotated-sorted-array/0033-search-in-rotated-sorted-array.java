class Solution {
public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // Continue the loop as long as the search space is valid
    while (left <= right) {
        // Calculate mid to prevent potential integer overflow
        int mid = left + (right - left) / 2;

        // Case 1: Target found at mid
        if (nums[mid] == target) {
            return mid;
        }

        // Case 2: The left subarray [left...mid] is sorted
        if (nums[left] <= nums[mid]) {
            // Check if the target is within the sorted left subarray
            if (target >= nums[left] && target < nums[mid]) {
                // If so, discard the right half
                right = mid - 1;
            } else {
                // Otherwise, the target must be in the right half
                left = mid + 1;
            }
        } 
        
        // Case 3: The right subarray [mid...right] is sorted
        else {
            // Check if the target is within the sorted right subarray
            if (target > nums[mid] && target <= nums[right]) {
                // If so, discard the left half
                left = mid + 1;
            } else {
                // Otherwise, the target must be in the left half
                right = mid - 1;
            }
        }
    }

    // Target was not found in the array
    return -1;
}
}