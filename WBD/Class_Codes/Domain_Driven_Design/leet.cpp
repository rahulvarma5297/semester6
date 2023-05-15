#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
    long long distinctNames(vector<string>& ideas) {
        long long ans = 0;
        unordered_map<string, int> m;
        for(auto i: ideas){
            m[i]++;
        }

        for(int i = 0; i < ideas.size(); i++){
            for(int j = i + 1; j < ideas.size(); j++){
                string first = ideas[i];
                string second = ideas[j];

                char t = first[0];
                first[0] = second[0];
                second[0] = t;

                if(m.find(first) == m.end() && m.find(second) == m.end()){
                    ans += 2;
                }
            }
        }
        return ans;
    }
};
