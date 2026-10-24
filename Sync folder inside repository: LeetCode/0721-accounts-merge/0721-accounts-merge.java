class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i; // Array inline initialize kiya

        HashMap<String, Integer> mailToId = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailToId.containsKey(mail)) {
                    // Find roots & Union inline
                    int root1 = find(i, parent);
                    int root2 = find(mailToId.get(mail), parent);
                    if (root1 != root2) parent[root1] = root2;
                } else {
                    mailToId.put(mail, i);
                }
            }
        }

        // 2. Group & Sort emails automatically using TreeSet
        HashMap<Integer, TreeSet<String>> groups = new HashMap<>();
        for (String mail : mailToId.keySet()) {
            int root = find(mailToId.get(mail), parent);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(mail);
        }

        // 3. Format final result
        List<List<String>> res = new ArrayList<>();
        for (int root : groups.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(root).get(0)); // Name add kiya
            list.addAll(groups.get(root));       // Sorted emails add kiye
            res.add(list);
        }
        return res;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }
}