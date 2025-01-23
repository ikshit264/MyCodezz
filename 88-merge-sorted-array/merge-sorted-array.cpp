class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int t = m - 1, b = n - 1;
        for (int i=m+n-1; i>=0; i--){
            if (b < 0 || (t > -1 && nums1[t] >= nums2[b])){
                nums1[i] = nums1[t];
                t--;
            }
            else{
                nums1[i] = nums2[b];
                b--;
            }
        }
    }
};