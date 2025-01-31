import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = calculate(arr1, arr2);
        return answer;
    }

    private int[][] calculate(int[][] arr1, int[][] arr2) {
        int arr1Row = arr1.length;
        int arr1Col = arr1[0].length;
        int arr2Row = arr2.length;
        int arr2Col = arr2[0].length;
        int[][] ret = new int[arr1Row][arr2Col];

        int rowIdx = 0;
        int colIdx = 0;

        for (int i = 0; i < arr1Row; i++) {
            for (int j = 0; j < arr2Col; j++) {
                for (int k = 0; k < arr2Row; k++) {
                    ret[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return ret;
    }
}