package chess;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/*
 * Essa classe é como se fosse o coração do jogo de xadrez, é onde fica as regras
 */
public class ChessMatch {  // é a partida   chess match = jogo de xadres
	
	private Integer turn;
	private Color currentPlayer;
	private Board board;

	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	
	public Integer getTurn() {
		return this.turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
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
	

	// retorna as posibilidades  para peça se mover, a peça selecionada de acordo com posiçao
	public boolean[][] possibleMoves( ChessPosition sourcePosition)  {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}

	public ChessPiece performChessMove ( ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition (source);
		validateSourceTargetPosition(source, target);
		Piece capturedPiece = makeMove( source, target );
		nextTurn();
		return (ChessPiece) capturedPiece;
	}

	private Piece makeMove( Position source, Position target ) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);

		if ( capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		return capturedPiece;
	}

	private void validateSourcePosition(Position position) {
		if ( !board.thereIsPiece(position) ) {
			throw new ChessException("there is no piece on source position");
		}

		if ( currentPlayer != ( (ChessPiece) board.piece(position) ).getColor() ) {
			throw new ChessException("There chosen piece is not yours ");
		}

		if ( !board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece ");
		}
	}

	private void validateSourceTargetPosition(Position source, Position target) {
		if ( !board.piece(source).possibleMove(target)) {
			throw  new ChessException("the chosen piece can't move to target position");
		}
	}

	private void nextTurn () {
		turn++;
		currentPlayer = ( currentPlayer == Color.WHITE ) ? Color.BLACK : Color.WHITE;
	}

	private void placeNewPiece( char column, int row, ChessPiece piece ) {			// coloca a peça em um novo lugar
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {													// metodo que inicia a peça no game / configuração inicial
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
	
}
