class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        Comparator<int[]> shiftsComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                  return 1;  
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        };
        Arrays.sort(shifts, shiftsComparator);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < shifts.length; i++) {
            int[] shift = shifts[i];
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            if (direction == 0) {
                direction = -1;
            }
            map.put(start, map.getOrDefault(start, 0) + direction);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - direction);            
        }
        List<List<Integer>> lists = new ArrayList<>();
        int prev = 0;
        int sum = 0;
        for (int key : map.keySet()) {
            if (sum != 0) {
                lists.add(Arrays.asList(prev, key, sum));
            }
            sum = sum + map.get(key);
            prev = key;
        }
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            int start = list.get(0);
            int end = list.get(1);
            int direction = list.get(2);
            for (int j = start; j < end; j++) {
                int newChar = (((result.charAt(j) - 'a' + direction) % 26));
                if (newChar < 0) {
                    newChar = newChar + 26;
                }
                result.setCharAt(j, (char) (newChar + 'a'));
            }
        }        
        return result.toString();
    }
}