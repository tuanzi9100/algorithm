package node.search;

/**
 * @author shenWenWen 2022/4/24 下午3:35
 */
public class MinArray {
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid]> numbers[right]){
                left = mid+1;
            }else if (numbers[mid]< numbers[right]){
                right = mid;
            }else {
                return -1;
            }
        }
        return numbers[left];
    }
    public static int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = {1,0,1,2,3};
        int i = minArray2(numbers);
    }
}
