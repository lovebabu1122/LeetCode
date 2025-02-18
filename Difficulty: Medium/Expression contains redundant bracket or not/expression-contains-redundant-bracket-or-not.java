//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for (char ch : str) {
            if (ch == ')') {
                char top = st.peek();
                st.pop();
                boolean flag = true;
                while (top != '(') {
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }
                    top = st.peek();
                    st.pop();
                }
                if (flag) {
                    return 1;
                }
            } else {
                st.push(ch); 
            }              
        }
        return 0;
    }
}
        
