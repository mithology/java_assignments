import java.util.Arrays;

class Matrix {
     private int rows;

     private int columns;

     private int [][] matrix;

    public Matrix(int rows ,int columns){
       this.rows = rows;
       this.columns = columns;
       this.matrix = new int[rows][columns];
     }
   public boolean isEqual(int[][] otherMatrix){
        return  Arrays.deepEquals(this.matrix, otherMatrix);
    }
       Matrix insertIn(int row, int column,int values){
       matrix[row][column] = values;
       return this;
     }
   
     private int valueAt(int row, int column) {
           return matrix[row][column];
    }
   
    public Matrix hold(int value){
        for(int row = 0; row < rows; row++)
            Arrays.fill(matrix[row], value);
         return this;
   }
   
   public Matrix setValues(int[][] matrix){
           for(int row = 0; row < rows; row++)
               for(int column = 0; column < columns; column++)
                   this.matrix[row][column] = matrix[row][column];
           return this;
       }
   
    public Matrix add(Matrix addendMatrix){
        Matrix resultMatrix = new Matrix(rows, columns);
        for (int row = 0; row < rows ; row++){
            for (int column = 0; column < columns ; column++){
                int addedValue = this.valueAt(row,column) + addendMatrix.valueAt(row,column);
                resultMatrix.insertIn(row, column, addedValue);
            }
        }
        return resultMatrix;
    }
  

}
