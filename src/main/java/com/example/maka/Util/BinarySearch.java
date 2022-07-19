package com.example.maka.Util;

public class BinarySearch {
    static int[] arry = {10, 15, 24, 47, 56, 78, 90, 156, 167};

    public static void main(String[] args) {
        int index = binarySearch(arry, 90);
    }

    public static int binarySearch(int[] a, int t) {
        int l = 0;
        int r = a.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                r = m - 1;
            } else {
                l = m - 1;
            }
        }
        return -1;
    }

}
