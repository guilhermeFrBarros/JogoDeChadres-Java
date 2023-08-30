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

	// está sendo implementado nas classes ex: king, rook, pois cada peça tem suas possibilidades de movimentos, ou seja regras   
	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];  // retorna uma possição da matriz de posibilidades
	}

	public boolean isThereAnyPossibleMove() {   
		boolean[][] mat = possibleMoves();    				// pega  a matriz de possibilidade
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
