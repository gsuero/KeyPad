package com.garis.generator.chess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.garis.generator.InvalidPositionException;
import com.garis.generator.chess.pieces.King;
import com.garis.generator.chess.pieces.Piece;

public class KeyPad {
	
	private int[][] cellsArray = {  { 1, 2, 3}, 
									{ 4, 5, 6},
									{ 7, 8, 9}, 
									{ 11, 0, 12} 
 								 };
	
	private int maxRow;
	private int maxColumn;
	private Cell startingCell = new Cell(0,0);
	private Cell currentPosition = new Cell(0,0);
	private Piece piece = new King();
	private int deepness = 7;
	private boolean printDigits = false;
	
	private List<Cell> invalidKeys = new ArrayList<Cell>();
	private List<Cell> invalidStartingKeys = new ArrayList<Cell>();
	
	private StringBuilder digits = null; 
	private long maxDigits = 0;
	
	
	public KeyPad(int[][] cellsArray) {
		super();
		this.cellsArray = cellsArray;
	}


	public KeyPad(int[][] cellsValues, int maxRow, int maxColumn) {
		super();
		this.cellsArray = cellsValues;
		this.maxRow = maxRow;
		this.maxColumn = maxColumn;
	}


	public KeyPad(int maxRow, int maxColumn) {
		super();
		this.maxRow = maxRow;
		this.maxColumn = maxColumn;
	}
	
	
	public List<Cell> getInvalidKeys() {
		return invalidKeys;
	}


	public void setInvalidKeys(List<Cell> invalidKeys) {
		this.invalidKeys = invalidKeys;
	}


	public int[][] getCellsArray() {
		return cellsArray;
	}

	public void setCellsArray(int[][] cellsArray) {
		this.cellsArray = cellsArray;
	}


	public Cell getCurrentPosition() {
		return currentPosition;
	}


	public void setCurrentPosition(Cell currentPosition) {
		this.currentPosition = currentPosition;
	}


	public StringBuilder getDigits() {
		return digits;
	}


	public void setDigits(StringBuilder digits) {
		this.digits = digits;
	}


	public long getMaxDigits() {
		return maxDigits;
	}


	public void setMaxDigits(long maxDigits) {
		this.maxDigits = maxDigits;
	}


	public int getMaxRow() {
		return maxRow;
	}
	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
	}
	public int getMaxColumn() {
		return maxColumn;
	}
	public void setMaxColumn(int maxColumn) {
		this.maxColumn = maxColumn;
	}
	
	public Cell getStartingCell() {
		return startingCell;
	}


	public void setStartingCell(Cell startingCell) throws InvalidPositionException {
		
		if (invalidStartingKeys.contains(startingCell)) 
			throw new InvalidPositionException("Invalid starting point...");

		this.startingCell = startingCell;
	}


	public Piece getPiece() {
		return piece;
	}


	public void setPiece(Piece piece) {
		this.piece = piece;
	}


	public int getDeepness() {
		return deepness;
	}


	public void setDeepness(int deepness) {
		this.deepness = deepness;
	}


	public boolean isPrintDigits() {
		return printDigits;
	}


	public void setPrintDigits(boolean printDigits) {
		this.printDigits = printDigits;
	}


	public List<Cell> getInvalidStartingKeys() {
		return invalidStartingKeys;
	}


	public void setInvalidStartingKeys(List<Cell> invalidStartingKeys) {
		this.invalidStartingKeys = invalidStartingKeys;
	}


	public boolean isOverLimits(Cell cell) {
		return (cell.getRow() < 0) || (cell.getColumn() < 0) ||
        (cell.getRow() >= this.maxRow) || (cell.getColumn() >= this.maxColumn) ||
        (invalidKeys.contains(cell));
	}
	
	public void getWiredCells() {
		digits = new StringBuilder();
		getWiredCells(getValueFromCell(startingCell)+"", startingCell,this.deepness);
	}
	private void getWiredCells(String collect, Cell cell, int deepness) {
		if (deepness > 0) {
			LinkedList<Move> moves = piece.getMoves();
			LinkedList<Cell> validCells = new LinkedList<Cell>();
			
			int currentRow = cell.getRow();
			int currentColumn = cell.getColumn();
			for (int digitCount=0; digitCount<moves.size(); digitCount++){
				Move movedTo = moves.get(digitCount);
				if (movedTo.isInfinite()) {
					
				}
				Cell movedCell = new Cell(currentRow, currentColumn);
				movedCell.moveCell(movedTo); 
				if (isOverLimits(movedCell)) {
					continue;
				} else {
					validCells.add(movedCell);
				}
				if (piece.isEndReacher() && movedTo.isInfinite())
					validCells.addAll(reachEnd(movedTo,cell));
			}
			
			for (int c=0; c<validCells.size();c++) {
				Cell validCell = validCells.get(c);
				String cellValue = getValueFromCell(validCell)+"";
				getWiredCells(collect + "" +cellValue, validCell, (deepness-1));	
			}
		} else {
			if (printDigits)
				digits.append(collect + " \n");
			maxDigits++;
		}
	}
	private int getValueFromCell(Cell cell) {
		return cellsArray[cell.getRow()][cell.getColumn()];
	}
	
	public LinkedList<Cell> reachEnd(Move move, Cell current) {
		LinkedList<Cell> tempList = new LinkedList<Cell>();
		Cell newCell = new Cell(current.getRow(), current.getColumn());
		Move newMove =new Move(move.getMoveRow(), move.getMoveColumn(), true);
		boolean secureArea = true;
		while (secureArea) {
			newMove.increment(move.getMoveRow(), move.getMoveColumn());
			newCell.moveCell(newMove);
			if (isOverLimits(newCell)) {
				secureArea = false;
			} else {
				tempList.add(new Cell(newCell.getRow(),newCell.getColumn()));
			}
		}
		return tempList;
	}
}