package string;

/**
 * @author shenWenWen 2021/7/4 下午11:50
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        //处理极端边界情况
        if (strs == null || strs.length <= 0) {
            return "";
        }
        //获取数组中第一个串的长度
        int length = strs[0].length();
        int len = strs.length;
        //两层循环，第一层是数组中第一个串的长度，第二层是数组中的节点数量
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                //如果i == 当前节点的长度，表明已经到了当前节点的最长范围，需要截止了
                //如果第n层对应的字符不相等，则截取0到最外层的i值之间的数据返回。
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        longestCommonPrefix(strs);
    }
}
