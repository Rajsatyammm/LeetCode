//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int i=1, v=5, x=10, l=50, c=100, d=500, m=1000;
    char prev;
    int value = 0;
    int totalValue = 0;
    int prevalue = 0;
    public int romanToDecimal(String str) {
        int length = str.length();
        if(length == 0){
            return 0;
        }
        else if(length == 1){
            prev=str.charAt(0);
            return getValue(prev);
        }
        for(int i=0; i<length-1; i++){
            prev = str.charAt(i+1);
            prevalue = getValue(prev);
            
            value = getValue(str.charAt(i));
            if (value >= prevalue){
                totalValue += value;
            }
            else{
                totalValue -= value;
            }
            
        }
        totalValue += getValue(str.charAt(length-1));
        return totalValue;
    }
    
    int getValue(char a) {
        if(a == 'I') return 1;
        else if(a == 'V') return 5;
        else if(a == 'X') return 10;
        else if(a == 'L') return 50;
        else if(a == 'C') return 100;
        else if(a == 'D') return 500;
        else if(a == 'M') return 1000;
        else return -1;
    }
}