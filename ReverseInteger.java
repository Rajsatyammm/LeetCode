class Solution {
    public int reverse(int x) {
        int data = 0;
        while(x != 0) {
            int val = x % 10;
            int newRes = (data * 10) + val;
            if((newRes - val)/10 != data) 
                return 0;
            data = newRes;
            x = x / 10;
        }
        return data;
    }
}
