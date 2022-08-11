package node.search;

/**
 * @author shenWenWen 2022/4/23 下午11:51
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] array, int target) {
        int i = array.length - 1, j = 0;
        while (i >= 0 && j < array[0].length) {
            int flag = array[i][j];
            if (flag > target) {
                i--;
            } else if (flag < target) {
                j++;
            } else if (flag == target) {
                return true;
            }
        }
        return false;
    }
}
