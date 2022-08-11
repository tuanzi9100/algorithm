package formula;

/**
 * @author shenWenWen 2022/4/10 下午2:52
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] men = new int[n];
        men[0] = 1;
        men[1] = 2;
        for (int i = 2; i < n; i++) {
            men[i] = men[i - 1] + men[i - 2];
        }
        return men[n - 1];
    }

    public static void main(String[] args) {
        climbStairs(3);
    }
}
