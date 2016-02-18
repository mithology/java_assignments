import matrix.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixTest {
  @Test
  public void evaluatesExpression() {
    int t1[][]={{1,2},{1,2}};
    int t2[][]={{1,2},{1,2}};
    int expected[][] = {{2,4},{2,4}};
    Matrix matrix = new Matrix();
    int actual[][] = matrix.addMatricies(t1,t2);
    assertArrayEquals(actual, expected);
  }
}
