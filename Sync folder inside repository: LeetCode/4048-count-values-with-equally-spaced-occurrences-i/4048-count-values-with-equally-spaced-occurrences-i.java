class Solution {
    public int countSpecialIntegers(int[] nums) {
       
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        int count = 0;

        for (int key : map.keySet()) {

            List<Integer> list = map.get(key);

            if (list.size() == 3) {

                int i1 = list.get(0);
                int i2 = list.get(1);
                int i3 = list.get(2);

                if (i2 - i1 == i3 - i2) {
                    count++;
                }
            }
        }

        return count;
    }
}