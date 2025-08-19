class Solution {
    public int trap(int[] height) {
        int l = 1, r = height.length - 2;
        int maxl = height[l-1], maxr = height[r+1];
        int res = 0;

        while( l <= r ){
            if (maxr <= maxl){
                res += Math.max(0, maxr - height[r]);
                maxr = Math.max(maxr, height[r]);
                r--;
            } else {
                res += Math.max(0, maxl - height[l]);
                maxl = Math.max(maxl, height[l]);
                l++;
            }
        }
        return res;
    }
}