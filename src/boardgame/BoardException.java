package boardgame;

public class BoardException extends RuntimeException {
	private static final long serialVersionUID = 1L;						// exceção opcional
	
	public BoardException(String msg) {
		super(msg);															// passando msg para construtor da RuntimeException
	}
}
