import java.util.*;

public class main {
    public static void merge(int[] arr, int start, int mid, int end) {
        int sz1 = mid - start + 1;
        int sz2 = end - mid;
        int[] L = new int[sz1];
        int[] R = new int[sz2];

        for (int i = 0; i < sz1; i++) {
            L[i] = arr[i + start];
        }
        for (int i = 0; i < sz2; i++) {
            R[i] = arr[i + mid + 1];
        }

        int l = 0, r = 0, a = start;
        while (l < sz1 && r < sz2) {
            if (L[l] < R[r]) {
                arr[a++] = L[l++];
            } else {
                arr[a++] = R[r++];
            }
        }

        while (l < sz1) {
            arr[a++] = L[l++];
        }
        while (r < sz2) {
            arr[a++] = R[r++];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int N = 8;
        int[] arr = {6, 3, 5, 1, 4, 8, 2, 7};

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        mergeSort(arr, 0, N - 1);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
