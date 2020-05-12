package model;

public class Solution {

	public Solution() {
	}

	public void drawSquare(Square square) {
		
		int matrixSize = square.getMatrix().length;
		
		String line = "";
		for(int n = 0; n < 4*matrixSize; n++) {
			line+="-";
		}
		
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {

				if (j != matrixSize - 1) {
					if(square.getMatrix()[i][j]<10) {
						System.out.print(square.getMatrix()[i][j] + "  | ");
					}
					else System.out.print(square.getMatrix()[i][j] + " | ");
				} else {
					System.out.print(square.getMatrix()[i][j]);
					System.out.println();
				}
			}
			if (i != matrixSize - 1) {
				System.out.println(line);
			}
		}
	}

	public void solveMS(Square square, int row, int col) {

		int matrixSize = square.getMatrix().length;
		
		for (int n = 1; n <= Math.pow(matrixSize, 2); n++) {

			if (!checkEmpty(square).isEmpty()) {
				int empty_i = Character.getNumericValue(checkEmpty(square).charAt(0));
				int empty_j = Character.getNumericValue(checkEmpty(square).charAt(1));
				row = empty_i;
				col = empty_j;
				if (validNumber(n, empty_i, empty_j, square)) {
					square.getMatrix()[empty_i][empty_j] = n;

					if (checkEmpty(square).isEmpty()) {

						if (checkWin(square)) {
							System.out.println();
							System.out.println();
							this.drawSquare(square);
							System.out.println();
						}
					} else {
						int new_empty_i = Character.getNumericValue(checkEmpty(square).charAt(0));
						int new_empty_j = Character.getNumericValue(checkEmpty(square).charAt(1));
						solveMS(square, new_empty_i, new_empty_j);
					}
					square.getMatrix()[row][col] = 0;

				}
			}

		}
	}

	public String checkEmpty(Square square) {
		int i = 0;
		int j = 0;
		int empty_i = 0;
		int empty_j = 0;
		int matrixSize = square.getMatrix().length;
		
		boolean found = false;
		
		while (i < matrixSize && !found) {

			while (j < matrixSize && !found) {
				
				if (square.getMatrix()[i][j] == 0) {
					empty_i = i;
					empty_j = j;
					found = true;
				}
				j++;
			}
			i++;
			j = 0;
		}
		
		if (found) {
			return empty_i + "" + empty_j;
		} else
			return "";
	}

	public boolean validNumber(int target, int row, int col, Square square) {

		int i = 0, j = 0;
		boolean valid = true;
		int matrixSize = square.getMatrix().length;


		while (i < matrixSize && valid) {
			while (j < matrixSize && valid) {

				if (square.getMatrix()[i][j] == target && i != row) {
					valid = false;
				} else if (square.getMatrix()[i][j] == target && j != col) {
					valid = false;
				}

				j++;
			}

			i++;
			j = 0;
		}

		return valid;
	}

	public boolean checkWin(Square square) {
		
		int matrixSize = square.getMatrix().length;
		
		int diagonalSum[] = new int[2];
		int horizontalSum[] = new int[matrixSize];
		int verticalSum[] = new int[matrixSize];

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				
				verticalSum[i]+=square.getMatrix()[i][j];
				horizontalSum[j] += square.getMatrix()[i][j];
				if (i == j) {
					diagonalSum[0] += square.getMatrix()[i][j];
				}
				if (j + i == matrixSize-1) {
					diagonalSum[1] += square.getMatrix()[i][j];
				}

			}
		}

		boolean eq = true;
		int i = 0;
		double avgNum =  (Math.pow(matrixSize,2)+1)/2;
		int comparator = (int) (matrixSize*avgNum);
		
		while (i < matrixSize && eq) {

			if (horizontalSum[i] != comparator) {
				eq = false;
			} else if (verticalSum[i] != comparator) {
				eq = false;

			} else if (i < 2) {
				if (diagonalSum[i] != comparator) {
					eq = false;
				}
			}

			i++;
		}

		return eq;
	}

}
