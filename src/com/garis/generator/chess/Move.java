package com.garis.generator.chess;

public class Move {
	private static final long serialVersionUID = -261316052593068746L;
	private int moveRow;
	private int moveColumn;
	private boolean infinite;
	
	public Move(int moveRow, int moveColumn) {
		super();
		this.moveRow = moveRow;
		this.moveColumn = moveColumn;
	}
	
	
	public Move(int moveRow, int moveColumn, boolean infinite) {
		super();
		this.moveRow = moveRow;
		this.moveColumn = moveColumn;
		this.infinite = infinite;
	}

	public boolean isInfinite() {
		return infinite;
	}


	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}

	public void increment(int row, int column) {
		this.moveColumn = column;
		this.moveRow = row;
	}

	public int getMoveRow() {
		return moveRow;
	}
	public void setMoveRow(int moveRow) {
		this.moveRow = moveRow;
	}
	public int getMoveColumn() {
		return moveColumn;
	}
	public void setMoveColumn(int moveColumn) {
		this.moveColumn = moveColumn;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + moveColumn;
		result = prime * result + moveRow;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (moveColumn != other.moveColumn)
			return false;
		if (moveRow != other.moveRow)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Move [moveRow=" + moveRow + ", moveColumn=" + moveColumn
				+ ", infinite=" + infinite + "]";
	}
	
	
}
