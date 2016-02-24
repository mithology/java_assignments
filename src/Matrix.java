public class Matrix {
	private int row;
	private int column;
	private int[][] matrix;

	private Matrix(int row, int column){
		this.row = row;
		this.column = column;
		this.matrix = new int[row][column];
	}

	private void initialise(int[] values){
		for(int i = 0, count=0; i<row; i++){
			for (int j=0; j<column ; j++,count++)
				this.matrix[i][j] = values[count];
		}
	}

	public int getValueAt(int row, int column){
		return this.matrix[row][column];
	}

  public static Matrix generateMatrix(int row, int column, int[] values){
    Matrix matrix = new Matrix(row, column);
    matrix.initialise(values);
    return matrix;
  }

	public Matrix addMatrices(Matrix other){
		int[] add = new int[this.row*this.column];
    int count = 0;
		for(int i = 0; i<this.row; i++){
			for (int j=0; j<this.column ; j++){
				add[count] = this.getValueAt(i,j)+other.getValueAt(i,j);
        count++;
      }
		}
		return generateMatrix(this.row, this.column, add);
	}

	@Override
	public boolean equals(Object other){
		if (this == other)
			return true;
		if(!(other instanceof Matrix))
			return false;
		return this.equals((Matrix) other);
	}

	public boolean equals(Matrix other){
    int count=0;
		for(int i = 0; i<this.row; i++){
			for (int j=0; j<this.column ; j++){
				if(this.getValueAt(i,j)!=other.getValueAt(i,j))
					return false;
        count++;
			}
		}
		return true;
	}

	public Matrix multiplyMatrices(Matrix other){
		if(this.column != other.row)
			return null;
		int[] result = new int[this.row*other.column];
		int count= 0;
		for (int i=0; i<this.row ; i++ ) {
			for (int j=0 ; j<other.column ;j++) {
				for (int k=0; k<this.column ; k++ )
					result[count] += this.matrix[i][k] * other.matrix[k][j];
				count++;
			}
		}
		return generateMatrix(this.row, other.column, result);
	}

	private int[] multiplyWithRow(int[] row, int[][] matrix){
		int[] result = new int[matrix.length];
		for(int i = 0; i<matrix[0].length; i++){
			int value = 0;
			for(int j=0; j<row.length; j++)
				value += row[j]*matrix[j][i];
			result[i] = value;
		}
		return result;
	}

	private boolean isSqaureMatrix(){
		return this.column == this.row;
	}

	public int determinant(){
		if(!this.isSqaureMatrix())
			return 0;
		if(matrix.length == 1){
			return matrix[0][0];
		}
		int value = 0;
		int sign = 1;
		for (int i=0; i<matrix[0].length; i++){
			Matrix subMatrix = generateMatrix(this.row-1, this.column-1, deleteElement(matrix, 0, i));
			value += matrix[0][i] * subMatrix.determinant() * sign;
			sign *= -1;
		}
		return value;
	}

	private int[] deleteElement(int[][] matrix, int row, int column){
		int[] resultantMatrix =  new int[(matrix.length-1) * (matrix[0].length-1)];
		for (int i=0,count=0 ;i<matrix.length; i++ ){
			if(i!=row){
				for (int j=0; j<matrix[0].length; j++){
					if(j!=column){
						resultantMatrix[count] = matrix[i][j];
						count++;
					}
				}
			}
		}
		return resultantMatrix;
	}
}