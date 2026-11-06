class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int targetIdx = 0;
        
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            if (targetIdx == target.length) {
                break;
            }
            
            operations.add("Push");
            
            if (currentNum == target[targetIdx]) {
                targetIdx++;
            } else {
                operations.add("Pop");
            }
        }
        
        return operations;
    }
}