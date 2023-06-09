package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/*
 * Essa classe é como se fosse o coração do jogo de xadrez, é onde fica as regras
 */
public class ChessMatch {  // é a partida   chess match = jogo de xadres
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {    // retorna uma chess piece
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][ board.getColumns()];
		for ( int i = 0; i < board.getRows(); i++ ) {
			for ( int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);							// fazendo uma downcasting
			}
		}
		
		return mat;
	}
	
	private void placeNewPiece( char column, int row, ChessPiece piece ) {			// coloca a peça em um novo lugar
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {													// metodo que inicia a peça no game / configuração inicial
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
	
}
