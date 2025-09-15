class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        int start = 0, end = nums.length - 1;

        while (start < end){
            int mid = start + (end - start)/2;
            // System.out.println(nums[mid] + " " + start + " " + end);
            // if (nums[mid] < nums[mid-1]) return nums[mid];
            if (nums[mid] > nums[end]) start = mid+1;
            else end = mid;
        }

        return nums[start];
    }
}