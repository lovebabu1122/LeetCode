//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    int celebrity(vector<vector<int>>& mat) {
        int n = mat.size();
        int candidate = 0;

        // Step 1: Find a potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                // Candidate knows i, so candidate cannot be a celebrity
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate must NOT know anyone (mat[candidate][i] == 0)
                // Everyone must know the candidate (mat[i][candidate] == 1)
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;  // No celebrity exists
                }
            }
        }

        return candidate;  // Return celebrity index
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int> > M(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> M[i][j];
            }
        }
        Solution ob;
        cout << ob.celebrity(M) << endl;
        cout << "~" << endl;
    }
}

// } Driver Code Ends