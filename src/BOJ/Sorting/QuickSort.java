package BOJ.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 5, 4, 2};

        quickSort(arr, 0, arr.length - 1);

        // 정렬된 배열 출력
        System.out.println(Arrays.toString(arr));
    }

    // 퀵 정렬 함수
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    // 분할(Partition) 과정: 피벗을 기준으로 배열을 나눔
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 마지막 요소를 피벗으로 설정
        int i = left - 1; // 작은 값들의 위치 추적

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); // 피벗을 제자리로 이동
        return i + 1;
    }

    // 배열 요소 교환 함수
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}