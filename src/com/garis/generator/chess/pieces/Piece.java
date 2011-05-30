package com.garis.generator.chess.pieces;

import java.util.LinkedList;
import com.garis.generator.chess.Move;

public abstract class Piece {
	public abstract LinkedList<Move> getMoves();
	public abstract boolean isEndReacher();
}
