//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    public static Node modifyTheList(Node head)
    {
        int len=0;
        Node temp=head, prevv=null;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(len%2==1)len++;
        len=len/2;
        len++;
        int c=1;
        temp=head;
        while(c!=len){
            prevv=temp;
            temp=temp.next;
            c++;
        }
        Node curr=temp,prev=null,nextP;
        while(curr!=null){
            nextP=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextP;
        }
        prevv.next=prev;
        Node first=head,second=prev;
        while(second!=null){
            int t = first.data;
            first.data=second.data-first.data;
            second.data=t;
            second=second.next;
            first=first.next;
        }
        curr=prevv.next;
        prev=null;
        while(curr!=null){
            nextP=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextP;
        }
        prevv.next=prev;
        return head;
    }
}