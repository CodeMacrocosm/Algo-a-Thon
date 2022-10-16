#include<bits/stdc++.h>
using namespace std;

void topologicalSort(vector< vector<int> > graph, int n) {
    vector<int> indegree(n, 0);

    stack<int> st;

    for(int i=0; i<n; i++) {
        for(auto &edge: graph[i]) {
            indegree[edge]++; 
        }
    }

    for(int i=0; i<n; i++)
        if(indegree[i] == 0) st.push(i);

    int node = 0;

    while(!st.empty()) {
        node = st.top();
        st.pop();

        cout<<node<<" ";

        for(auto &edge: graph[node]) {
            indegree[edge]--;
            if(indegree[edge] == 0)
                st.push(edge);
        }
    }
}

int main() {
    int n = 6;
    vector< vector<int> > graph(n);

    graph[2] = {3};
    graph[3] = {1};
    graph[4] = {0, 1};
    graph[5] = {0, 2};

    cout<<"Topological Sorted DAG: ";
    topologicalSort(graph, n);

    return 0;
}
