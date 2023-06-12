class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int start = nums[0], end = nums[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (start == end) {
                    sb.append(start);
                    list.add(sb.toString());
                } 
                else {
                    sb.append(start).append("->").append(end);
                    list.add(sb.toString());
                }
                sb.setLength(0);
                start = nums[i + 1];
                end = nums[i + 1];
            } 
            else {
                end = nums[i + 1];
            }
        }
        if (start == end) {
            sb.append(start);
            list.add(sb.toString());
        } 
        else {
            sb.append(start).append("->").append(end);
            list.add(sb.toString());
        }
        return list;
    }
}