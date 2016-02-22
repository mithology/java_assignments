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

}
