class Solution {
public:
    int numTilings(int n) {
        const int mod = 1e9 + 7;

        if( n == 1) return 1;
        if( n == 2) return 2;
        if( n == 3) return 5;
        
        long long* store = new long long[n];
        memset(store, 0, sizeof(long long)*n);
        store[0] = 1;
        store[1] = 2;
        store[2] = 5;

        for (int i = 3; i < n; i++){
            store[i] = ((store[i-1] * 2) + store[i-3]) % mod;
        }
        return store[n-1];
    }
};
