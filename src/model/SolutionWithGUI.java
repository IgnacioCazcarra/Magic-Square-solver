package model;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SolutionWithGUI {
	
	public SolutionWithGUI() {}
	public void solveMS(GUImatrix gui, int row, int col) throws InterruptedException {

		int matrixSize = gui.getM().length;
		gui.setSize(300,300);
	    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		for (int n = 1; n <= Math.pow(matrixSize, 2); n++) {

		    gui.setVisible(true);
			if (!checkEmpty(gui.getM()).isEmpty()) {
				int empty_i = Character.getNumericValue(checkEmpty(gui.getM()).charAt(0));
				int empty_j = Character.getNumericValue(checkEmpty(gui.getM()).charAt(1));
				row = empty_i;
				col = empty_j;
				if (validNumber(n, empty_i, empty_j, gui)) {
					gui.getM()[empty_i][empty_j].setText(String.valueOf(n));
					//setear
					if (checkEmpty(gui.getM()).isEmpty()) {

						if (checkWin(gui)) {
							gui.setVisible(true);
							TimeUnit.SECONDS.sleep(30);
//							this.drawSquare(square);
							
						}
						
						
					} else {
						int new_empty_i = Character.getNumericValue(checkEmpty(gui.getM()).charAt(0));
						int new_empty_j = Character.getNumericValue(checkEmpty(gui.getM()).charAt(1));
						solveMS(gui, new_empty_i, new_empty_j);
					}
					gui.getM()[row][col].setText(String.valueOf(0));

				}
			}

		}
	}
	
	public void draw(GUImatrix gui) {
		gui.setVisible(true);
		
	}
	
	public String checkEmpty(JLabel[][] jlabel) {
		int i = 0;
		int j = 0;
		int empty_i = 0;
		int empty_j = 0;
		int matrixSize = jlabel.length;
		
		boolean found = false;
		
		while (i < matrixSize && !found) {

			while (j < matrixSize && !found) {
				
				if (Integer.parseInt(jlabel[i][j].getText()) == 0) {
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

	public boolean validNumber(int target, int row, int col, GUImatrix gui ) {

		int i = 0, j = 0;
		boolean valid = true;
		int matrixSize = gui.getM().length;

		while (i < matrixSize && valid) {
			while (j < matrixSize && valid) {

				if (Integer.parseInt(gui.getM()[i][j].getText()) == target && i != row) {
					valid = false;
				} else if (Integer.parseInt(gui.getM()[i][j].getText()) == target && j != col) {
					valid = false;
				}

				j++;
			}

			i++;
			j = 0;
		}

		return valid;
	}

	public boolean checkWin(GUImatrix gui) {
		
		int matrixSize = gui.getM().length;
		
		int diagonalSum[] = new int[2];
		int horizontalSum[] = new int[matrixSize];
		int verticalSum[] = new int[matrixSize];

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				
				verticalSum[i] += Integer.parseInt(gui.getM()[i][j].getText());
				horizontalSum[j] += Integer.parseInt(gui.getM()[i][j].getText());
				if (i == j) {
					diagonalSum[0] += Integer.parseInt(gui.getM()[i][j].getText());
				}
				if (j + i == matrixSize-1) {
					diagonalSum[1] += Integer.parseInt(gui.getM()[i][j].getText());
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
