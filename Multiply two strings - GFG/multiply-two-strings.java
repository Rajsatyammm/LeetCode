//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String multiplyStrings(String s1,String s2) {
        boolean neg1 = false ,neg2 = false;
        if(s1.charAt(0)=='-'){
            s1 = s1.substring(1);
            neg1 = true;
        }
        if(s2.charAt(0)=='-'){
            s2 = s2.substring(1);
            neg2 = true;
        }
        while(s1.length() > 1 && s1.charAt(0) == '0') s1 = s1.substring(1);
        while(s2.length() > 1 && s2.charAt(0) == '0') s2 = s2.substring(1);
        if(s1.charAt(0) == '0' || s2.charAt(0) == '0') return "0";
        int dp[] = new int[s1.length() + s2.length()];
        for(int i=s1.length()-1; i>=0; i--){
            int carry = 0;
            for(int j=s2.length()-1; j>=0; j--){
                int pos = i+j+1;
                int num1 = s1.charAt(i)-'0';
                int num2 = s2.charAt(j)-'0';
                int mul = num1*num2+carry + dp[pos];
                dp[pos] = mul%10;
                carry = mul/10;
            }
            int idx = i;
            if(carry > 0){
                int mul = dp[idx] + carry;
                dp[idx--] = mul%10;
                carry = mul/10;
            }
        }
        boolean flag = false;
        String ans = "";
        for(int i=0;i<dp.length;i++){
            if(dp[i]!=0)flag = true;
            if(flag)ans+=dp[i];
        }
        if(neg1 ^ neg2)ans = "-"+ans;
        return ans;
    }
}