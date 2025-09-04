package LeetCode;

public class lt_11_ContainerWith MostWater {
    
}
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // 使用雙指針方法來解決問題
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // 當左指針小於右指針時，不斷計算容器的面積
        while (left < right) {
            // 計算當前容器的面積
            int width = right - left;
            int h = Math.min(height[left], height[right]);  // 容器的高度是最小的那一邊
            maxArea = Math.max(maxArea, width * h);  // 更新最大面積

            // 移動較短的那一邊的指針
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Example 1
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Example 1: " + solution.maxArea(height1));  // Output: 49

        // Example 2
        int[] height2 = {1,1};
        System.out.println("Example 2: " + solution.maxArea(height2));  // Output: 1
    }
}

/*
解題思路：
1. 我們可以使用雙指針的方法來解這個問題。初始化左指針`left`和右指針`right`，分別指向高度數組的兩端。
2. 計算當前兩個指針所形成的容器面積。面積是由兩個指針之間的距離和兩個指針所指的高度中較小的那個決定的。
3. 然後，我們移動較短的那一邊的指針（因為面積是由短邊決定的），從而希望找到更大的面積。
4. 重複這個過程直到左右指針相遇，最終的`maxArea`即為最大容器面積。
5. 時間複雜度是 O(n)，其中 n 是數組的長度，因為我們只需遍歷數組一次。
6. 空間複雜度是 O(1)，因為只使用了常數空間來存儲指針和最大面積。
*/
