//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public static void sortandinsert(Stack<Integer> s,int num){
        if(s.isEmpty()||(s.peek()<num)){
            s.push(num);
            return ;
        }
        int n=s.peek();
        s.pop();
        sortandinsert(s,num);
        s.push(n);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s;
        }
        int num=s.peek();
        s.pop();
        sort(s);
        sortandinsert(s,num);
        return s;
    }
}