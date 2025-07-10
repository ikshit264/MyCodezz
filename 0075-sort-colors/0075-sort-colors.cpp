class Solution {
public:
    void sortColors(vector<int>& nums) {
        int count0=0, count1=0, count2=0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0)
                count0++;
            if(nums[i] == 1)
                count1++;
            if(nums[i] == 2)
                count2++;
        }
        cout<<"[";
        int j=0;
        for (int i = 0; i < count0; i++) {
            nums[j]=0;
            j++;
            cout << 0 << ",";
        }

        for (int i = 0; i < count1; i++) {
            nums[j]=1;
            j++;
            cout << 1 << ",";
        }

        for (int i = 0; i < count2; i++) {
            nums[j]=2;
            j++;
            cout << 2;
            if(i!=count2-1)
                cout << ",";
        }
        cout << "]";
    }
};