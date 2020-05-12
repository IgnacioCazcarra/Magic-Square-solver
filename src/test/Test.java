package test;

import model.Solution;
import model.Square;

public class Test {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		Square threeByThree = new Square();
		int[][] threeBoard = { 
				{4,9,0},
				{0,0,7},
				{0,0,6},

		};
		threeByThree.setMatrix(threeBoard);
		s.drawSquare(threeByThree);
		s.solveMS(threeByThree, 0, 0);
		
		System.out.println();
		System.out.println();
		
		Square fourByFour = new Square();
		int[][] fourBoard = { 
				{4,0,15,1},
				{0,7,6,0},
				{5,0,0,0},
				{0,0,0,13}
		};
		fourByFour.setMatrix(fourBoard);
		s.drawSquare(fourByFour);
		s.solveMS(fourByFour, 0, 0);
		
		System.out.println();
		System.out.println();
		
		Square fiveByFive = new Square();
		int[][] fiveBoard = {
				{17,23,0,10,11},
				{0,5,0,12,18},
				{1,7,0,0,0}, 
				{0,14,20,0,0},
				{15,16,22,3,9} 
		};
		fiveByFive.setMatrix(fiveBoard);
		s.drawSquare(fiveByFive);
		s.solveMS(fiveByFive, 0, 0);
	}

}
