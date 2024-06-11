class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            int x = map.getOrDefault(a, Integer.MAX_VALUE);
            int y = map.getOrDefault(b, Integer.MAX_VALUE);

            return (x == y) ? a - b : x - y;
        });

        for (int n : arr1) {
            heap.offer(n);
        }

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] =  heap.poll();
        }

        return arr1;
    }
}