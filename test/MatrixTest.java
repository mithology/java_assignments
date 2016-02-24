import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void generateMatrix_generate_matrix_with_given_size_and_insert_given_values(){
		int[] a = {1,2,3,4,5,6};
    Matrix matrix1 = Matrix.generateMatrix(2,3,a);

		for(int i = 0, count=0; i<2; i++){
			for (int j=0; j<3 ; j++,count++){
				assertEquals(matrix1.getValueAt(i,j),a[count]);
			}
		}
	}

    @Test
    public void add_adds_the_given_matrix_with_the_matrix(){
    	int[] a = {1,2,3,4,5,6};
    	int[] b = {6,5,4,3,2,1};
        Matrix matrix1 = Matrix.generateMatrix(2,3,a);
        Matrix matrix2 = Matrix.generateMatrix(2,3,b);

        int[] expectedArray = {7,7,7,7,7,7,7};
        Matrix expected = Matrix.generateMatrix(2,3,expectedArray);

        Matrix result = matrix1.addMatrices(matrix2);

        assertEquals(expected,result);
    }

    @Test
    public void multiply_returns_null_if_the_two_matrices_cant_be_multiplied(){
    	int[] a = {1,2,3,4,5,6};
    	int[] b = {6,5,4,3,2,1};
        Matrix matrix1 = Matrix.generateMatrix(2,3,a);
        Matrix matrix2 = Matrix.generateMatrix(2,3,b);

    	assertNull(matrix1.multiplyMatrices(matrix2));
    }

    @Test
    public void multiply_returns_the_product_of_two_matrix_of_same_sizes(){
    	int[] a = {1,2};
    	int[] b = {1,2};
        Matrix matrix1 = Matrix.generateMatrix(1,2,a);
        Matrix matrix2 = Matrix.generateMatrix(2,1,b);

        int[] expectedArray = {5};
        Matrix expected = Matrix.generateMatrix(1,1,expectedArray);

    	Matrix resultant = matrix1.multiplyMatrices(matrix2);

    	assertEquals(expected,resultant);
    }

    @Test
    public void multiply_returns_the_product_of_two_matrix_of_different_sizes(){
    	int[] a = {1,2,3,4,5,6};
    	int[] b = {1,2,3,4,5,6};
      Matrix matrix1 = Matrix.generateMatrix(2,3,a);
      Matrix matrix2 = Matrix.generateMatrix(3,2,b);

      int[] expectedArray = {22,28,49,64};
      Matrix expected = Matrix.generateMatrix(2,2,expectedArray);

    	Matrix resultant = matrix1.multiplyMatrices(matrix2);

    	assertEquals(expected,resultant);
    }

    @Test
    public void determinant_returns_zero_if_the_matrix_have_no_determinant_like_2x3(){
    	int[] a = {1,2,3,4,5,6};
      Matrix matrix1 = Matrix.generateMatrix(2,3,a);

    	assertEquals(matrix1.determinant(),0);
    }

    @Test
    public void determinant_returns_the_determinant_of_simple_2X2_matrix_with_value_negative_2(){
    	int[] a = {1,2,3,4};
      Matrix matrix1 = Matrix.generateMatrix(2,2,a);

    	assertEquals(-2,matrix1.determinant());
    }

    @Test
    public void determinant_returns_the_determinant_of_the_given_3x3_matrix_with_value_0(){
    	int[] a = {1,2,3,4,5,6,7,8,9};
      Matrix matrix1 = Matrix.generateMatrix(3,3,a);

    	assertEquals(0,matrix1.determinant());
    }

    @Test
    public void determinant_returns_the_determinant_of_the_given_3x3_matrix_with_value_3(){
    	int[] a = {3,2,1,2,4,3,1,1,1};
      Matrix matrix1 = Matrix.generateMatrix(3,3,a);

    	assertEquals(3,matrix1.determinant());
    }
}