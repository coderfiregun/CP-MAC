#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n;
    cin>>n;
    string s;
    cin>>s;
    vector<int> v(26);

    int ans = 0;

    for(int i=0; i<n; ++i){
        if(v[s[i]-'a'] == 0)
            ans += n-i;
            v[s[i]-'a'] = 1;
    }

    cout<<ans<<"\n";
}

int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }
}