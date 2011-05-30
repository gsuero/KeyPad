package com.garis.generator;

import java.util.List;

import com.garis.generator.chess.Cell;

public class Util {

	public static boolean isOverLimits(Cell cell, int maxRow, int maxColumn, List<Cell> invalidKeys) {
		return (cell.getRow() < 0) || (cell.getColumn() < 0) ||
        (cell.getRow() > maxRow-1) || (cell.getColumn() > maxColumn-1) ||
        (invalidKeys.contains(cell));
	}
}
