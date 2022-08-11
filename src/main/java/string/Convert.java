package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenWenWen 2021/7/4 下午9:23
 */
public class Convert {
    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * 按行排序
     * p   A   H   N
     * A P L S I I G
     * Y   I   R
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {

        //极端范围处理
        if (numRows == 1) {
            return s;
        }
        //第一步 变成z形
        //初始化numRows个list的字符串
        List<StringBuilder> low = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            low.add(new StringBuilder());
        }
        //for循环字符串，用curRow记录当前行，当curRow等于numRows-1的时候，当前行号开始递减，当curRow等于0的时候，当前行号需要递加。
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            low.get(curRow).append(c);
            //计算新的curRow
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        //第二步 拼接转换后的数据
        StringBuilder ret = new StringBuilder();
        for (StringBuilder str: low) {
            ret.append(str);
        }
        /*for (int i = 0; i < numRows; i++) {
            ret.append(low.get(i));
        }*/
        return ret.toString();
    }

    public static void main(String[] args) {
        String a = convert("PAYPALISHIRING", 2);
        System.out.println(a);
    }
}

