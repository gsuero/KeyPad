import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.garis.generator.chess.Cell;
import com.garis.generator.chess.Move;


public class Pruebas {
	private static LinkedList<Move> moves = new LinkedList<Move>();
	static {
		moves.add(new Move(1,1,true));
		moves.add(new Move(1,-1,true));
		moves.add(new Move(-1,1,true));
		moves.add(new Move(1,-1,true));
	}
	public static boolean isOverLimits(Cell cell) {
		boolean retorno = false;
		if (cell.getRow() < 0)
			return true;
		if (cell.getColumn() < 0)
			return true;
		if (cell.getRow() > 3)
			return true;
		if (cell.getColumn() > 2)
			return true;
		
		return retorno;
		
	}
	
	public static void main(String[] argvs) {
		
	}
}
