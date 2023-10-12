#include <bits/stdc++.h>
using namespace std;

void DFS(int node, vector<int> adj[], vector<bool>& visited, stack<int>& Stack){
    visited[node]=true;
    for(auto neigh : adj[node])
        if(!visited[neigh])
            DFS(neigh, adj, visited, Stack);
    Stack.push(node);
}
    
int KosarajuAlgo(int V, vector<int> adj[]){
    int ans = 0;
    vector<bool> visited(V, false);
    stack<int> Stack;
    for(int node=0; node<V; node++){
        if(!visited[node])
            DFS(node, adj, visited, Stack);
    }
    vector<int> adjTranspose[V];
    for(int node=0; node<V; node++){
        for(auto neigh : adj[node])
            adjTranspose[neigh].push_back(node);
    }
    vector<bool> visited1(V, false);
    stack<int> Stack1;
    while(!Stack.empty()){
        int node = Stack.top();
        if(!visited1[node]){
            DFS(node, adjTranspose, visited1, Stack1);
            ans++;
        }
        Stack.pop();
    }
    return ans;
}

int main(){
    int V, E;
    cin >> V >> E;
    vector<int> adj[V];
    for(int i=0; i<E; i++){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
    }
    cout << KosarajuAlgo(V, adj);
    return 0;
}