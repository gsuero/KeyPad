package com.garis.generator.chess;

import com.garis.generator.chess.pieces.Bishop;
import com.garis.generator.chess.pieces.King;
import com.garis.generator.chess.pieces.Knight;
import com.garis.generator.chess.pieces.Pawn;
import com.garis.generator.chess.pieces.Queen;
import com.garis.generator.chess.pieces.Rook;

public class PieceFactory {

	
	public static Rook buildRook(){
		return new Rook();
	}
	public static Bishop buildBishop(){
		return new Bishop();
	}
	
	public static King buildKing(){
		return new King();
	}
	
	public static Knight buildKnight(){
		return new Knight();
	}
	
	public static Pawn buildPawn(){
		return new Pawn();
	}
	
	public static Queen buildQueen(){
		return new Queen();
	}
}
