package test;

import javax.swing.JFrame;

import model.GUImatrix;
import model.SolutionWithGUI;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {

		int[][] board = { 
				{4,0,2},
				{0,0,0},
				{0,0,6},
		};

		
		JFrame grid = new GUImatrix(board);
		SolutionWithGUI sg = new SolutionWithGUI();
		sg.solveMS(((GUImatrix) grid), 0, 0, 100);
		
	}

}
