package num;

/**
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * @author shenWenWen 2021/4/22 上午9:50
 */
public class Rotate {
    public static int rotate(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end -start)/2;
            if (nums[mid] == target){
                return mid;
            }
            //后半部分有序
            if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(nums[mid] > target && target >= nums[start]){
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 1 2 3          7 8 9       7 4 1
     * 4 5 6          4 5 6       8 5 2
     * 7 8 9          1 2 3       9 6 3
     *
     * 5  1  9  1    15 14 12 16  15 13  2  5
     * 2  4  8  10   13 3  6  7   14  3  6  1
     * 13 3  6  7    2  4  8  1   12  4  8  9
     * 15 14 12 16   5  1  9  1   16  7  1  1
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate2(arr);
        //System.out.println(rotate);
    }


    /**
     * 2020.4.10
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        if (matrix.length<=1){
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = matrix.length-1; i >0; i--) {
            int[] hen = matrix[i];
            for (int j = 0; j < matrix[i].length - 1; j++) {
                builder.append(hen[j]);
            }
        }
    }
}
