package com.panam.gameoflife;

class GameOfLife {

	private static boolean alive = Constants.alive;
	static int noOfIterations = 10;

	public static void main(String[] args) {

		runGameOfLife();

	}

	public static void runGameOfLife() {
		// first make a copy, so we can save the target
		LifeGameBoard thisBoard = new LifeGameBoard(6, 8);
		// this particular matrix repeats itself
		thisBoard.setCellValue(0, 6, alive);
		thisBoard.setCellValue(1, 0, alive);
		thisBoard.setCellValue(1, 1, alive);
		thisBoard.setCellValue(1, 2, alive);
		thisBoard.setCellValue(1, 6, alive);
		thisBoard.setCellValue(2, 6, alive);
		thisBoard.setCellValue(4, 3, alive);
		thisBoard.setCellValue(4, 4, alive);
		thisBoard.setCellValue(5, 3, alive);
		thisBoard.setCellValue(5, 4, alive);
		thisBoard.printBoard();

		for (int iter = 0; iter < noOfIterations; iter++) {
			LifeGameBoard targetBoard = thisBoard.copyBoard();
			thisBoard.applyRules(thisBoard.getGameBoard(),
					targetBoard.getGameBoard());
			targetBoard.printBoard();
			thisBoard = targetBoard;
		}

	}

}
