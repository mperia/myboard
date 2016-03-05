package com.panam.gameoflife;

import static org.junit.Assert.*;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsAnything;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class GameOfLifeTest {
	private static LifeGameBoard board;

	@BeforeClass
	public static void setUp() throws Exception {
		board = new LifeGameBoard(10, 10);
		System.out.println("beforeClass");		
		board.setCellValue(0, 6, true);
		board.setCellValue(1, 0, true);
		board.setCellValue(1, 1, true);
		board.setCellValue(1, 2, true);
		board.setCellValue(1, 6, true);
		board.setCellValue(2, 6, true);
		board.setCellValue(4, 3, true);
		board.setCellValue(4, 4, true);
		board.setCellValue(5, 3, true);
		board.setCellValue(5, 4, true);
	}
	
	@Test
	public void testDefaultSettings() {
		System.out.println("testDefault");
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				assertNotNull (board.getGameBoard()[row][col]);
				assertTrue(board.aliveNeighbors(board.getGameBoard(), row, col) < 8);
			}
		}
	}
	
	@Test
	public void testAlive() {
		System.out.println("testAlive");
		assertTrue(board.getCellValue(0, 6));
		assertTrue(board.getCellValue(1, 0));
		assertTrue(board.getCellValue(1, 1));
		assertTrue(board.getCellValue(1, 2));
		assertTrue(board.getCellValue(2, 6));
		assertTrue(board.getCellValue(4, 3));
		assertTrue(board.getCellValue(4, 4));
		assertTrue(board.getCellValue(5, 3));
		assertTrue(board.getCellValue(5, 4));
	}
	
	@Test
	public void testDead() {
		System.out.println("testADead");
		assertFalse(board.getCellValue(0, 0));
		assertFalse(board.getCellValue(1, 4));
	}
	
	@Test
	public void testAliveCount() {
		System.out.println("testAliveCount");
		assertTrue(board.getCellValue(0, 6));
		assert(board.aliveNeighbors(board.getGameBoard(), 0, 0) == 2);
		assert(board.aliveNeighbors(board.getGameBoard(), 0, 1) == 3);
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("tearDown");
		board = null;
		assertNull(board);
	}
}
