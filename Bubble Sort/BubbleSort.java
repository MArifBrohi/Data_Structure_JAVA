import java.util.Arrays;
class BubbleSort {
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
   Sort(arr);
    System.out.println(Arrays.toString(arr));
}

public static void Sort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = i+1; j < n ; j++) {
            if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swapped = true;
            }
        }
        if (swapped == false) {
            System.out.println(swapped+": Array already sorted");
            break;
        }
    }
}
}
