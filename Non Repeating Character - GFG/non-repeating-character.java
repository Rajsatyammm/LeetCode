//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to find the first non-repeating character in a string.
    // Approach 1 :
    // static char nonrepeatingCharacter(String S) {
    //     //Your code here
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(char ch : S.toCharArray()) {
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     }
        
    //     for(char ch : S.toCharArray()) {
    //         if(map.get(ch) == 1) {
    //             return ch;
    //         }
    //     }
    //     return '$';
    // }
    
    // Appraoch 2 : 
    static char nonrepeatingCharacter(String S) {
        int[] a = new int[26];
        for(char ch : S.toCharArray()) {
            a[ch - 'a']++;
        }
        
        for(char ch : S.toCharArray()) {
            if(a[ch - 'a'] == 1) {
                return ch;
            }
        }
        
        return '$';
    }
}

