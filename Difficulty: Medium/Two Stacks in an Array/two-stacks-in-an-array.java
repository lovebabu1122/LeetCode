//{ Driver Code Starts
import java.util.*;

class TwoStack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            twoStacks g = new twoStacks();
            int Q = sc.nextInt();
            while (Q > 0) {
                int stack_no = sc.nextInt();
                int QueryType = sc.nextInt();

                if (QueryType == 1) {
                    int a = sc.nextInt();
                    if (stack_no == 1)
                        g.push1(a);
                    else if (stack_no == 2)
                        g.push2(a);
                } else if (QueryType == 2) {
                    if (stack_no == 1)
                        System.out.print(g.pop1() + " ");
                    else if (stack_no == 2)
                        System.out.print(g.pop2() + " ");
                }

                Q--;
            }
            System.out.println();
            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class twoStacks {
    int top1, top2;
    int size = 100; // Fixed size since we can't modify the main function
    int[] arr;

    twoStacks() {
        top1 = -1;
        top2 = size;
        arr = new int[size];
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        if(top2-top1>1){
            top1++;
            arr[top1]=x;
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        if(top2-top1>1){
            top2--;
            arr[top2]=x;
        }
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(top1>=0){
            int ans=arr[top1];
            top1--;
            return ans;
        }else{
            return -1;
        }
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(top2<size){
            int ans2=arr[top2];
            top2++;
            return ans2;
        }else{
            return -1;
        }
    }
}
