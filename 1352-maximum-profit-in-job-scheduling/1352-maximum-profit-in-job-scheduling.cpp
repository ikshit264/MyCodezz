class Solution {
public:
    // Binary search: first job whose start time ≥ current job's end time
    int findNextJob(int currEnd, const vector<vector<int>>& jobs) {
        int low = 0, high = jobs.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][0] < currEnd)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    int solve(int i, vector<vector<int>>& jobs, vector<int>& dp) {
        if (i >= jobs.size()) return 0;
        if (dp[i] != -1) return dp[i];

        // Option 1: Not take this job
        int notTake = solve(i + 1, jobs, dp);

        // Option 2: Take this job
        int nextIdx = findNextJob(jobs[i][1], jobs);
        int take = jobs[i][2] + solve(nextIdx, jobs, dp);

        return dp[i] = max(take, notTake);
    }

    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int n = startTime.size();
        vector<vector<int>> jobs;
        for (int i = 0; i < n; i++) {
            jobs.push_back({startTime[i], endTime[i], profit[i]});
        }

        // Sort jobs by start time
        sort(jobs.begin(), jobs.end());

        // Memoization array
        vector<int> dp(n, -1);

        return solve(0, jobs, dp);
    }
};
