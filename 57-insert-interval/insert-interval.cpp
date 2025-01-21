class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        intervals.push_back(newInterval);

        sort(intervals.begin(), intervals.end());

        vector<vector<int>> store;

        for (const auto& interval : intervals){
            if (store.empty() || store.back()[1] < interval[0]){
                store.push_back(interval);
            }
            else{
                store.back()[1] = max(interval[1], store.back()[1]);
            }
        }
        return store;
    }
};