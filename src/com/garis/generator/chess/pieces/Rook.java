package com.garis.generator.chess.pieces;

import java.util.LinkedList;
import com.garis.generator.chess.Move;

public class Rook extends Piece {
	private static LinkedList<Move> moves = new LinkedList<Move>();
	static {
		moves.add(new Move(-1,0,true));
		moves.add(new Move(0,-1,true));
		moves.add(new Move(1,0,true));
		moves.add(new Move(0,1,true));
	}
	@Override
	public LinkedList<Move> getMoves() {
		return moves;
	}

	@Override
	public boolean isEndReacher() {
		// TODO Auto-generated method stub
		return true;
	}
}