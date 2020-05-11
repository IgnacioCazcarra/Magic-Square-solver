package model;

public class Square {
	private int[][] matrix = new int[3][3];
	
	public Square() {}
	
	
	public Square(int[][] matrix) {
		this.matrix = matrix;
	}
	
	
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	
}
