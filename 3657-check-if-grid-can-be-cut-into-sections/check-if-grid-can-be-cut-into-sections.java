class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        
        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];

        int index = 0;
        for (int[] rect : rectangles) {
            int startX = rect[0];
            int startY = rect[1];
            int endX = rect[2];
            int endY = rect[3];
            xIntervals[index] = (new int[]{startX, endX});
            yIntervals[index] = (new int[]{startY, endY});
            index++;
        }

        Arrays.sort(xIntervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(yIntervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> listX = new ArrayList<>();
        listX.add(xIntervals[0]);
        int currXIndex = 0, size = xIntervals.length;
        for (int i = 1; i < size; i++) {
            int[] interval = xIntervals[i];
            int[] currX = listX.get(currXIndex);
            if (interval[0] < currX[1]) {
                listX.get(currXIndex)[1] = Math.max(interval[1], currX[1]);
            } else {
                listX.add(interval);
                currXIndex++;
            }
        }
        List<int[]> listY = new ArrayList<>();
        listY.add(yIntervals[0]);
        int currYIndex = 0;
        size = yIntervals.length;
        for (int i = 1; i < size; i++) {
            int[] interval = yIntervals[i];
            int[] currY = listY.get(currYIndex);
            if (interval[0] < currY[1]) {
                listY.get(currYIndex)[1] = Math.max(interval[1], currY[1]);
            } else {
                listY.add(interval);
                currYIndex++;
            }
        }
        return (listX.size() >= 3 || listY.size() >= 3);
    }
}