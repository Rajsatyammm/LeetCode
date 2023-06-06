class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int Lp = 0, Rp = numbers.length - 1;
        while(Lp <= Rp) {
            if(numbers[Lp] + numbers[Rp] == target) return new int[] {Lp+1, Rp+1};
            else if(numbers[Lp] + numbers[Rp] < target) Lp++;
            else Rp--;
        }
        return new int[] {-1};
    }
}