// 299. Bulls and Cows

class Solution {
    public String getHint(String secret, String guess) {
        int arr[] = new int[10];
        int aaa[] = new int[10];
        int p=0;
        int q=0;
        for(int i=0;i<secret.length();i++){
            arr[(int)(secret.charAt(i))-48]++;
            if(secret.charAt(i)==guess.charAt(i)) p++;
        }for(int i=0;i<guess.length();i++){
            aaa[(int)(guess.charAt(i))-48]++;
        }for(int i=0;i<arr.length;i++){
            q+=Math.min(arr[i],aaa[i]);
        }return String.valueOf(p)+"A"+String.valueOf(q-p)+"B";
          
    }
}