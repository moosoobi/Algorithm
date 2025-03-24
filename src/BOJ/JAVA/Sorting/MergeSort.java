package BOJ.JAVA.Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 5, 4, 2};

        mergeSort(arr, 0, arr.length - 1);

        // 정렬된 배열 출력
        System.out.println(Arrays.toString(arr));
    }

    // 병합 정렬 함수
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid); // 왼쪽 부분 정렬
            mergeSort(arr, mid + 1, right); // 오른쪽 부분 정렬

            merge(arr, left, mid, right); // 병합
        }
    }

    // 병합(Merge) 함수
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열 생성
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // 데이터 복사
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        // 병합 과정
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // 남은 요소들 복사
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}

