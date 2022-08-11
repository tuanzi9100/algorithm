package num;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shenWenWen 2021/4/5 下午3:37
 */
public class Reverse {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
    public static int reverse2(int num) {

        int ans = 0;

        while (num != 0) {

            ans = ans * 10 + num % 10;

            num = num / 10;

        }

        return ans;

    }
    public static int numberOfOne2(int num) {
        //定义二进制二进制
        int count = 0;
        while (num != 0) {
            //利用count++计算出有多少个1
            count++;
            //利用位运算来实现；将n月n-1做位运算，会把最右边的1去掉，比如：1100 & 1011 = 1000
            num = num & (num - 1);
        }
        return count;
    }

    public static Map<String, Long> getShellContextByFilePath(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lineList = new ArrayList<>();
        String str = null;
        while ((str = bufferedReader.readLine()) !=null){
            lineList.add(str);
        }
        //System.out.printf("执行完cat命令输出: " + lineList);

        //grep Exception 相当于每行依次搜索Exception
        lineList = lineList.stream().filter(line -> line.contains("Exception")).collect(Collectors.toList());

        //sort 命名是按照字典从小到大排序：
        lineList = lineList.stream().sorted().collect(Collectors.toList());

        //uniq -c  统计相同元素的个数：
        Map<String,Long> map = lineList.stream().sorted().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        //head -n10 查看文件的前10行
        Map<String, Long> collect1 = map.entrySet().stream().limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        //sort -r 将数字当做字符进行排序
        LinkedHashMap<String, Long> sortR = collect1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap::new));

        return sortR;
    }
    public static void main(String[] args) throws IOException {
        /*Map<String, Long> shellContextByFilePath = getShellContextByFilePath("/course/Exception.txt");
        for (int i = 0; i < shellContextByFilePath.size(); i++) {
            System.out.println(shellContextByFilePath.get(i));
        }*/
        int i = reverse2(123456);
        System.out.println(i);
    }
}
