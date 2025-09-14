class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1, left = -1, right = -1, ans = -1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (target <= nums[mid]){
                end = mid-1;
            }
            else start = mid+1;

            if (nums[mid] == target){
                ans = mid;
            }
        }

        left = ans;

        start = 0; 
        end = nums.length-1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (target < nums[mid]){
                end = mid-1;
            }
            else start = mid+1;

            if (nums[mid] == target){
                ans = mid;
            }
        }

        right = ans;

        return new int[] {left, right};
    }
}