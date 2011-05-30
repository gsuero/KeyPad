import com.garis.generator.InvalidPositionException;
import com.garis.generator.chess.Cell;
import com.garis.generator.chess.KeyPad;
import com.garis.generator.chess.pieces.Queen;

public class Test {
	public static void main(String[] argvs) {
		int[][] cellsArray = {  { 1, 2, 3}, 
								{ 4, 5, 6},
								{ 7, 8, 9}, 
								{ 11, 0, 12} 
								 };
		KeyPad pad = new KeyPad(cellsArray);
		pad.setDeepness(7);
		pad.setMaxColumn(3);
		pad.setMaxRow(4);
		pad.setPrintDigits(false);
		pad.setPiece(new Queen());
		pad.setPrintDigits(false);
		try {
			pad.setStartingCell(new Cell(0,2));
			pad.getWiredCells();
			System.out.println("Phone numbers that can be generated with the selected piece: " + pad.getMaxDigits());
			System.out.println(pad.getDigits());
		} catch (InvalidPositionException e) {
			e.printStackTrace();
		}
	}
}
