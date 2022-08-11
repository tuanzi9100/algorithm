package recur;

import node.list.SortListNode;

import java.util.*;

/**
 * @author shenWenWen 2022/5/6 下午6:02
 */
public class Permute {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (num.length <= 0) {
            return ret;
        }
        boolean[] isUsed = new boolean[num.length];
        ArrayDeque<Integer> list = new ArrayDeque<>();

        ret(isUsed, num.length, 0, ret, list, num);
        Collections.sort(ret, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

                for(int i=0;i<o1.size();i++){
                    if(o1.get(i)>o2.get(i)){
                        return 1;
                    }else if(o1.get(i)<o2.get(i)){
                        return -1;
                    }
                }
                return 0;
            }
        });
        return ret;
    }

    private static void ret(boolean[] isUsed, int length, int deep, ArrayList<ArrayList<Integer>> ret, ArrayDeque<Integer> list, int[] number) {
        if (deep == length) {
            ret.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < length; i++) {
                /*if (i != 0 && number[i] == number[i - 1]) {
                    continue;
                }*/
            if (isUsed[i] == true || (i > 0 && isUsed[i - 1] == false && number[i] == number[i - 1])){
                continue;
            }
            int a = number[i];
            list.addLast(a);

            isUsed[i] = true;
            ret(isUsed, length, deep + 1, ret, list, number);
            isUsed[i] = false;
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 2};
        ArrayList<ArrayList<Integer>> permute = permute(num);
        System.out.println(permute);
    }
}
