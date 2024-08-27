#include <iostream>
#include <numeric>
using namespace std;

class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int n = cardPoints.size();
        int lsum = accumulate(cardPoints.begin(), cardPoints.begin() + k, 0);
        int rsum = 0;
        int maximum = lsum;
        for(int i = 0; i < k; i++){
            lsum -= cardPoints[k - i - 1];
            rsum += cardPoints[n - i - 1];
            maximum = max(maximum, lsum + rsum);
        }
        return maximum;
    }
};