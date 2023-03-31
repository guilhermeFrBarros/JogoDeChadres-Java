package chess;

import boardgame.Board;
import boardgame.Piece;

/*
 * Essa classe é como se fosse o coração do jogo de xadrez, é onde fica as regras
 */
public class ChessMatch {  // é a partida   chess match = jogo de xadres
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][ board.getColumns()];
		for ( int i = 0; i < board.getRows(); i++ ) {
			for ( int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		
		return mat;
	}
	
	
	
}
