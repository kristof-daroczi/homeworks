package xyz.codingmentor.javase3dk.littletasks;

/**
 *
 * @author Krisz
 */
public class QuickSort {

    private QuickSort() {
        //empty for sonar
    }

    private static void exChange(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static int collate(Integer[] array, int first, int last) {
        int f = first;
        int l = last;
        int pivot = array[first];
        while (f < l) {
            while (array[f] < pivot) {
                f++;
            }
            while (array[l] > pivot) {
                l--;
            }
            exChange(array, f, l);
        }
        return first;
    }

    public static void quickSort(Integer[] array, int first, int last) {
        if (first >= last) {
            return;
        }
        int pivot = collate(array, first, last);
        quickSort(array, first, pivot);
        quickSort(array, pivot + 1, last);
    }
}
