package test;

import model.Solution;
import model.Square;

public class Test {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Square solutionSquare = new Square();
		int[][] board = { 
				{2,0,6},
				{0,0,0},
				{0,0,8} 
		};
		solutionSquare.setMatrix(board);
		s.drawSquare(solutionSquare);
		s.solveMS(solutionSquare, 0, 0);
	}

}
