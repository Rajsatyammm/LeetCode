//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    //Function to sort a linked list of 0s, 1s and 2s.
    
    // Approach 1 :
    // static Node segregate(Node head) {
    //     // add your code here
    //     Node curr = head;
    //     List<Integer> al = new ArrayList<>();
    //     while(curr != null) {
    //         al.add(curr.data);
    //         curr = curr.next;
    //     }
        
    //     Collections.sort(al);
    //     Node dummy = new Node(0);
    //     curr = dummy;
    //     for(int i : al) {
    //         curr.next = new Node(i);
    //         curr = curr.next;
    //     }
    //     curr.next = null;
    //     return dummy.next;
    // }
    
    // Approach 2 :
    static Node segregate(Node head) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Node curr = head;
    
        Node dummy = new Node(0);
        while(curr != null) {
            map.put(curr.data, map.getOrDefault(curr.data, 0) + 1);
            curr = curr.next;
        }
        
        curr = dummy;
        for(int i=0; i<=2; i++) {
            int freq = map.getOrDefault(i, 0);
            
            while(freq != 0) {
                Node newNode = new Node(i);
                curr.next = newNode;
                curr = curr.next;
                freq--;
            }
        }
        return dummy.next;
    }
}


