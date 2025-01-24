class Solution {
public:
    int compareVersion(string v1, string v2) {
            istringstream stream1(v1), stream2(v2);
    vector<int> store1, store2;
    string token;
    while (getline(stream1, token, '.'))
    {
        store1.push_back(stoi(token));
    }

    while (getline(stream2, token, '.'))
    {
        store2.push_back(stoi(token));
    }

    int i = 0, j = 0, n = store1.size(), m = store2.size();

    while (i < n || j < m)
    {
        int val1 = (i < n) ? store1[i] : 0;
        int val2 = (j < m) ? store2[j] : 0;

        if (val1 > val2)
            return 1;
        else if (val1 < val2)
            return -1;

        i++;
        j++;
    }
    return 0;
    }
};