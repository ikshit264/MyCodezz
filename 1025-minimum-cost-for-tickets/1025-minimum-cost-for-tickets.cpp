class Solution {
public:
    int dp[370][400];
    int f(vector<int>&days,vector<int>&costs,int i,int curr){
        if(i>=days.size()) return 0;
        if(dp[i][curr]!=-1) return dp[i][curr];
        int ans = 1e9;
        if(curr>=days[i]) ans = min(ans,f(days,costs,i+1,curr));
        ans = min(ans,costs[0]+f(days,costs,i+1,days[i]+1-1));
        ans = min(ans,costs[1]+f(days,costs,i+1,days[i]+7-1));
        ans = min(ans,costs[2]+f(days,costs,i+1,days[i]+30-1));
        return dp[i][curr] = ans;
    }
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        memset(dp,-1,sizeof(dp));
        return f(days,costs,0,0);
    }
};