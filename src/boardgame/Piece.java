package boardgame;

public class Piece {
	
	protected Position position;			// é pq eu não quero que essa position seja visivel na camada de chadres, ela é so uma psition intermediaria da matrix
	private Board board;
	
	public Piece( Board board) {
		this.position = null;
		this.board = board;
	}
	
	protected Board getBoard() {			// para so ser visivel para camada do tabuleiro
		return board;
	}
}
