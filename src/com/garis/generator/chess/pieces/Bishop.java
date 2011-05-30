package com.garis.generator.chess.pieces;

import java.util.LinkedList;
import com.garis.generator.chess.Move;

public class Knight extends Piece {
	private static LinkedList<Move> moves = new LinkedList<Move>();
	static {
		moves.add(new Move(-2,-1));
		moves.add(new Move(-2,1));
		moves.add(new Move(-1,2));
		moves.add(new Move(1,2));
		moves.add(new Move(2,1));
		moves.add(new Move(2,-1));
		moves.add(new Move(-1,-2));
		moves.add(new Move(1,-2));
	}
	@Override
	public LinkedList<Move> getMoves() {
	//  (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (-1, -2), (1, -2)
		return moves;
	}

	@Override
	public boolean isEndReacher() {
		return false;
	}


}
