/*
public class Solution {
    public String countAndSay(int n) {
        if(n < 1)
            return null;
        if(n ==1 ) return "1";
        
        
        StringBuffer sb = new StringBuffer("11");
        for(int i = 2; i < n; i++){
            StringBuffer c = new StringBuffer();
            int count = 1;
            for( int j = 1; j < sb.length();j++){
                if(sb.charAt(j-1) == sb.charAt(j)){
                    count++;
                }else{
                    c.append(count);
                    c.append(sb.charAt(j-1));
                    count = 1;
                }
            }
            c.append(count);
            c.append(sb.charAt(sb.length()-1));
            sb = c;
        }
        return sb.toString();
    }
}
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // int[] temp = new int[candies.length];
        int Max = 0;
        for(int i = 0; i<candies.length; i++) {
            Max = Math.max(candies[i], Max);
        }
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i<candies.length; i++) {
            int curr = candies[i] + extraCandies;
            if(curr >= Max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
