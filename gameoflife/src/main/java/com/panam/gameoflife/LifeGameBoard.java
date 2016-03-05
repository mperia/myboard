/**
 * 
 */
package com.panam.gameoflife;

/**
 * @author simile
 *
 */
public class LifeGameBoard {
	private int noOfRows;
	private int noOfCols;
	private boolean[][] gameBoard;
	
	/*
	 * Initialize the game board
	 */
	public LifeGameBoard(int rows, int cols) {
		noOfRows = rows;
		noOfCols = cols;
		gameBoard = new boolean[noOfRows][noOfCols];
		for (int row = 0; row < noOfRows; row++) {
			for (int col = 0; col < noOfCols; col++) {
				gameBoard[row][col] = false;
			}
		}

	}

	/*
	 * Copy board
	 */
	public LifeGameBoard copyBoard() {
		LifeGameBoard targetBoard = new LifeGameBoard(noOfRows, noOfCols);
		boolean[][] targetPattern = new boolean[noOfRows][noOfCols];
		for (int row = 0; row < noOfRows; row++) {
			for (int col = 0; col < noOfCols; col++) {
				targetPattern[row][col] = gameBoard[row][col];
			}
		}
		targetBoard.setGameBoard(targetPattern);
		return targetBoard;
	}

	// count the number of live neighbors for a given cell
	public int aliveNeighbors(boolean[][] sourceBoard, int i, int j) {
		// there are only a maximum of eight neighbors. cells on the edges have
		// less neighbors
		int count = 0;
		int minRow = i == 0 ? 0 : i - 1;
		int maxRow = i == (noOfRows - 1) ? (noOfRows - 1) : i + 1;

		int minCol = j == 0 ? 0 : j - 1;
		int maxCol = j == (noOfCols - 1) ? (noOfCols - 1) : j + 1;

		// without counting me, how many are alive around me
		for (int rowIndex = minRow; rowIndex <= maxRow; rowIndex++) {
			for (int colIndex = minCol; colIndex <= maxCol; colIndex++) {
				if (gameBoard[rowIndex][colIndex]
						&& !(rowIndex == i && colIndex == j)) {
					count++;
				}
			}
		}
		// System.out.print((i+1) + ":" + (j+1) + " = " + count);
		// System.out.println();
		return count;
	}

	// print board
	public void printBoard() {
		for (boolean row[] : gameBoard) {
			for (boolean cell : row) {
				System.out.print(cell ? Constants.aliveDisplay
						: Constants.deadDisplay);
				// System.out.print( cell ? "alive " : "false ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/*
	 * Rules logic should be really separate from the board 
	 */
	public void applyRules(boolean[][] sourceBoard, boolean[][] targetBoard) {
		for (int i = 0; i < sourceBoard.length; i++) {
			for (int j = 0; j < sourceBoard[i].length; j++) {
				// if I am alive AND (if I have less two alive neighbors or more
				// than three alive neighbors), I die
				if (sourceBoard[i][j]
						&& (aliveNeighbors(sourceBoard, i, j) < 2 || aliveNeighbors(
								sourceBoard, i, j) > 3)) {
					targetBoard[i][j] = false;
					// if I am alive AND (if I have exactly two or exactly three
					// alive neighbors), I live
				} else if (sourceBoard[i][j]
						&& (aliveNeighbors(sourceBoard, i, j) == 2 || aliveNeighbors(
								sourceBoard, i, j) == 3)) {
					targetBoard[i][j] = true;
					// if I am dead but have exactly three alive neighbors, I
					// live
				} else if (!sourceBoard[i][j]
						&& aliveNeighbors(sourceBoard, i, j) == 3) {
					targetBoard[i][j] = true;
				}
			}
		}
	}

	public int getNoOfRows() {
		return noOfRows;
	}

	public void setNoOfRows(int noOfRows) {
		this.noOfRows = noOfRows;
	}

	public int getNoOfCols() {
		return noOfCols;
	}

	public void setNoOfCols(int noOfCols) {
		this.noOfCols = noOfCols;
	}

	public boolean[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(boolean[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public boolean getCellValue(int i, int j) {
		return gameBoard[i][j];
	}

	public void setCellValue(int i, int j, boolean cellValue) {
		gameBoard[i][j] = cellValue;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (boolean row[] : gameBoard) {
			for (boolean cell : row) {
				str.append(cell ? Constants.aliveDisplay
						: Constants.deadDisplay);
				// System.out.print( cell ? "alive " : "false ");
			}
			str.append("\n");
		}
		return str.toString();
	}
}
