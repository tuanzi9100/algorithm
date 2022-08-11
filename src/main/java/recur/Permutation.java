package recur;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author shenWenWen 2022/5/7 下午5:51
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder list = new StringBuilder();
        char[] chars = str.toCharArray();
        int length = chars.length;
        if (length <= 0) {
            return res;
        }
        Arrays.sort(chars);
        boolean[] isUsed = new boolean[length];
        dfs(0, length, res, list, isUsed, chars);
        return res;
    }

    private void dfs(int deep, int size, ArrayList<String> res, StringBuilder list, boolean[] isUsed, char[] chars) {
        if (deep == size) {
            res.add(list.toString());
            return;
        }
        for (int i = 0; i < size; i++) {
            if (isUsed[i] || (i > 0 && !isUsed[i - 1] && chars[i - 1] == chars[i])) {
                continue;
            }
            char aChar = chars[i];
            list.append(aChar);
            isUsed[i] = true;
            dfs(deep + 1, size, res, list, isUsed, chars);
            isUsed[i] = false;
            list.deleteCharAt(list.length() - 1);
        }
    }
}
