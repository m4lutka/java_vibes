// Kibitkin Ilya IT3-2307
import java.util.Arrays;

class BinarySearch {
    public int search(int[] arr, int target) {
        long startTime = System.nanoTime();
        int result = binarySearch(arr, target, 0, arr.length - 1);
        long endTime = System.nanoTime();

        System.out.println("BS Time: " + (endTime - startTime));
        return result;
    }

    private int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class LinearSearch {
    public int search(int[] arr, int target) {
        long startTime = System.nanoTime();
        int result = linearSearch(arr, target);
        long endTime = System.nanoTime();

        System.out.println("LS Time: " + (endTime - startTime));
        return result;
    }

    private int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

public class App {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int target = 9;


        BinarySearch binarySearch = new BinarySearch();
        Arrays.sort(arr);
        int binaryResult = binarySearch.search(arr, target);
        System.out.println("BS Index: " + binaryResult);


        LinearSearch linearSearch = new LinearSearch();
        int linearResult = linearSearch.search(arr, target);
        System.out.println("LS Index: " + linearResult);
    }
}