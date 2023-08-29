package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/* chess piece = peça de Xadrez
 * Peça do jogo de jadres
 * Essa classe seria como se fosse um intermediario entre os pacotes chess e board,
 * essa peça é uma classe que o chess pode acessar.
 */


public abstract class ChessPiece extends Piece {
	private Color color;
	
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOpponentPiece( Position position ) {
		ChessPiece p = (ChessPiece)  getBoard().piece(position);
		return p != null && p.getColor() != color;
	}//3:30    6:15    9:50
}
