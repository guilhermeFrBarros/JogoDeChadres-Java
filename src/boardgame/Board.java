package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if ( rows < 1 || columns < 1 ) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];     // instancia uma matriz de  Piece com o numero de linhas(row)  e colunas (column)
	}


	public int getRows() { 
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {								// metodo para pegar as peças no board
		if (!positionExists(row, column) ) {
			throw new BoardException("Position not the board");
		}
		return pieces[row][column];
	}
	
	
	public Piece piece(Position position) {
		if (!positionExists(position) ) {
			throw new BoardException("Position not the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece ( Piece piece, Position position ) {				// é um metodo que ser para colocar a peça no tabuleiro
		if( thereIsPiece(position) ) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;			// passando a peça para a matriz
		piece.position = position;											// passando a posição para a peça
	}
	
	public Piece removePiece ( Position position) {
		if ( !positionExists(position) ) {
			throw new BoardException("Position not on the board");
		}
		if ( piece(position) == null ) {
			return null;
		}
		Piece aux  = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists ( int row, int column ) {				// o metodo testa se a posição existe
		return row >= 0 && row < rows && column >= 0 && column < columns;	// Testando se a position existe
	}
	
	public boolean positionExists (Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsPiece( Position position) {						// testa se tem uma piece na posição
		if (!positionExists(position) ) {
			throw new BoardException("Position not the board");
		}
		return piece(position) != null;										// chama o metodo acima na linha 40 que retorna uma peça
	}
}


