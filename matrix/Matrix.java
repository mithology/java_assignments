package matrix;

import java.util.Arrays;

public class Matrix {
  public int[][] addMatricies(int[][] m1, int[][] m2) {
    int[][] result = new int[m1.length][m1[0].length];
    for (int row=0; row<m1.length; row++) {
      for (int col=0; col<m1[row].length; col++)
        result[row][col] = m1[row][col] + m2[row][col];
    }
    for (int i=0;i<result.length ;i++ ) {
        System.out.println(Arrays.toString(result[i]));
    }
    return result;
  }
}
