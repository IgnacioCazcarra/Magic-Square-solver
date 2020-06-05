package test;

import javax.swing.JFrame;

import model.GUImatrix;
import model.SolutionWithGUI;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {

		int[][] board = { 
				{7,14,0,9},
				{15,6,12,0},
				{0,0,13,0},
				{10,11,0,8},
		};
		
		JFrame frame2 = new GUImatrix(board);
		SolutionWithGUI sg = new SolutionWithGUI();
		sg.solveMS(((GUImatrix) frame2), 0, 0);
		
	}

}
