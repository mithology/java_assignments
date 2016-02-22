import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MatrixTest {
    @Test
    public void fill_fills_the_matrix_with_the_given_value() {
        Matrix matrix = new Matrix(3,3);
        int[][] expected = new int[][]{
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        assertTrue (matrix.hold(0).isEqual(expected));
    }
    @Test
    public void fill_fills_the_matrix_with_the_given_value_that_is_not_given() {
        Matrix matrix = new Matrix(3,3);
        int[][] expected = new int[][]{
            {1,2,3},
            {3,0,5},
            {2,4,8}
        };
        assertFalse (matrix.hold(0).isEqual(expected));
    }
    @Test
    public void setValues_sets_the_matrix_with_given_matrix_values() {
        Matrix matrix = new Matrix(3,4);
        int[][] actual = new int[][]{
            {0,3,0,8},
            {0,0,5,1},
            {2,0,0,6}
        };
        assertTrue(matrix.setValues(actual).isEqual(actual));
    }

   @Test
   public void add_adds_two_matricies_and_return_a_new_matrix(){
      Matrix first_matrix  = new Matrix(3,3);
      Matrix second_matrix = new Matrix(3,3);

      first_matrix.hold(2);
      second_matrix.hold(3);

      int[][]first_matrix_value = new int[][]{
            {2,2,2},
            {2,2,2},
            {2,2,2}
        };
        int[][] second_matrix_value = new int[][]{
            {3,3,3},
            {3,3,3},
            {3,3,3}
        };

        Matrix sum1 = first_matrix.add(second_matrix);
        int[][] expected1 = new int[][]{
            {5,5,5},
            {5,5,5},
            {5,5,5}
        };

        assertTrue(sum1.isEqual(expected1));
        assertTrue(first_matrix.isEqual(first_matrix_value));
        assertTrue(second_matrix.isEqual(second_matrix_value));
   }
   @Test
   public void add_adds_two_matricies_with_diffrent_values_and_return_a_new_matrix(){
      Matrix third_matrix  = new Matrix(3,3);
      Matrix fourth_matrix = new Matrix(3,3);

      int[][]third_matrix_value = new int[][]{
          {2,3,4},
          {0,1,5},
          {8,9,7}
      };
      int[][] fourth_matrix_value = new int[][]{
          {4,5,6},
          {9,8,8},
          {3,2,1}
      };
      Matrix sum2 = third_matrix.add(fourth_matrix);
      int[][] expected2 = new int[][]{
          {6,8,10},
          {9,9,13},
          {11,11,8}
      };
      // // System.out.println(third_matrix.toString());
      // // System.out.println(Matrix sum2);
      //
      // //   assertTrue("__________",sum2.isEqual(expected2));
      //   assertTrue(third_matrix.isEqual(third_matrix_value));
      // //   assertTrue(fourth_matrix.isEqual(fourth_matrix_value));

}
}
