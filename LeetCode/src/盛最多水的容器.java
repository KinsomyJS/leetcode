public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            }
        }

        return max;
    }
}
