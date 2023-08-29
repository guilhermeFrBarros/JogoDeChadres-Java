package boardgame;

public abstract class  Piece {
	
	protected Position position;			// é pq, eu não quero que essa position seja visivel na camada de chadres, ela é so uma psition intermediaria da matrix
	private Board board;					// serve para conhecer o taboleiro onde ela esta.
	
	public Piece( Board board) {
		this.position = null;
		this.board = board;					// quando eu crio uma peça, essa peça tem de saber qual é o tabuleiro que ela pertence 
	}
	
	protected Board getBoard() {			// para so ser visivel para camada de mesmo pacotes, o pacote taboleiro e pela subclasses de peça
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public boolean possibleMoves(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossible() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if ( mat[i][j] ) {
					return true;
				}
			}
		}
		return false;
	}

}
