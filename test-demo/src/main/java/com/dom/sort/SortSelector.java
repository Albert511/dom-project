package com.dom.sort;

/**
 * @description: 排序算法
 * @author: Dom Frank
 * @create: 2021/09/01 10:56
 */
public class SortSelector {

    public static void main(String[] args) {
        int[] arr = new int[]{56, 43, 99, 76, 87, 45, 88};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = 0; y < arr.length - 1 - x; y++) {
                if (arr[y] > arr[y + 1]) {
                    int tmp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = tmp;
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    int tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
            }
        }
    }
}
