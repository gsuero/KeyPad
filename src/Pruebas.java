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
		Cell current = new Cell(0,2);
		List<Move> tempList = new ArrayList<Move>();
		for(int m=0; m<moves.size();m++) {
			Move move = moves.get(m);
			Cell newCell = new Cell(current.getRow(), current.getColumn());
			Move newMove =new Move(move.getMoveRow(), move.getMoveColumn(), true);
			boolean secureArea = true;
			while (secureArea) {
				newCell.moveCell(newMove);
				if (!isOverLimits(newCell) && !tempList.contains(newMove)) {
					tempList.add(newMove);
					System.out.println(" move: " + newMove + " CELL : " + newCell);
				} else {
					secureArea = false;
					break;
				}
				newMove.increment(move.getMoveRow(), move.getMoveColumn());
			}
		}
		//moves.addAll(tempList);
		System.out.println(tempList);
	}
}
