package com.garis.generator.chess;

public class Cell {
	private int column;
	private int row;
	
	public Cell(int row, int column) {
		super();
		this.column = column;
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	public void moveCell(Move movement) {
		//System.out.println("movement: "+movement.toString());
		this.column += movement.getMoveColumn();
		this.row += movement.getMoveRow();
		//System.out.println("cell now: "+this.toString());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
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
		Cell other = (Cell) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [row=" + row + ",column=" + column +"]";
	}
	
	
}
