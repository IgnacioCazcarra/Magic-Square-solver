package model;

public class Solution {

	public Solution() {
	}

	public void drawSquare(Square square) {

		for (int i = 0; i < square.getMatrix().length; i++) {
			for (int j = 0; j < square.getMatrix().length; j++) {

				if (j != square.getMatrix().length - 1) {
					System.out.print(square.getMatrix()[i][j] + " | ");
				} else {
					System.out.print(square.getMatrix()[i][j]);
					System.out.println();
				}
			}
			if (i != square.getMatrix().length - 1) {
				System.out.println("---------");
			}
		}
	}

	public void solveMS(Square square, int row, int col) {

		for (int n = 1; n <= 9; n++) {

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
		boolean found = false;
		while (i < square.getMatrix().length && !found) {

			while (j < square.getMatrix().length && !found) {
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

		while (i < square.getMatrix().length && valid) {
			while (j < square.getMatrix().length && valid) {

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
		int diagonalSum[] = new int[2];
		int horizontalSum[] = new int[3];
		int verticalSum[] = new int[3];

		for (int i = 0; i < square.getMatrix().length; i++) {
			for (int j = 0; j < square.getMatrix().length; j++) {
				if (i == 0) {
					verticalSum[0] += square.getMatrix()[i][j];
				} else if (i == 1) {
					verticalSum[1] += square.getMatrix()[i][j];
				} else {
					verticalSum[2] += square.getMatrix()[i][j];
				}

				if (j == 0) {
					horizontalSum[0] += square.getMatrix()[i][j];
				} else if (j == 1) {
					horizontalSum[1] += square.getMatrix()[i][j];
				} else {
					horizontalSum[2] += square.getMatrix()[i][j];
				}

				if (i == j) {
					diagonalSum[0] += square.getMatrix()[i][j];
				}
				if (j + i == 2) {
					diagonalSum[1] += square.getMatrix()[i][j];
				}

			}
		}

		boolean eq = true;
		int i = 0;
		int comparator = 15;

		while (i < 3 && eq) {

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
