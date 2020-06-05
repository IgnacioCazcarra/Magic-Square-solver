package model;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class GUImatrix extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel[][] m;
	private GridLayout layoutG;
	
	
	public GUImatrix(int[][] board) {
		this.setLayout(new GridLayout(board.length,board.length));
		this.setM(m,board.length);
		for(int i = 0 ; i < board.length ; i++) {
			for(int j = 0 ; j < board.length ; j++) {
				this.m[i][j]= new JLabel(String.valueOf(board[i][j]),SwingConstants.CENTER);
				m[i][j].setFont(new Font("Serif", Font.PLAIN, 70));
				this.add(m[i][j]);
			}
		}
	}

	public JLabel[][] getM() {
		return m;
	}

	public void setM(JLabel[][] m, int n) {
		this.m = new JLabel[n][n];
	}

	public GridLayout getLayoutG() {
		return layoutG;
	}

	public void setLayoutG(GridLayout layoutG) {
		this.layoutG = layoutG;
	}
	
	
	
	
}
