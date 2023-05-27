//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        double profit = 0;
        double[][] ratio = new double[n][4];
        for(int i=0; i<n; i++) {
            Item curr = arr[i];
            ratio[i][0] = i;
            ratio[i][1] = curr.value;
            ratio[i][2] = curr.weight;
            ratio[i][3] = curr.value / (double) curr.weight;
        }
        
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[3]));
        for(int i=n-1; i>=0; i--) {
            int wt = (int) ratio[i][2];
            int p = (int) ratio[i][1];
            if(wt <= W) {
                // include total
                W = W - wt;
                profit += p;
            } else { //include fractional
                profit += (double)ratio[i][3] * W;
                // W = 0;
                break;
            }
        }
        return profit;
    }
}