package DemoCoding2.exception;

public class GameCustomException extends Exception {

	public GameCustomException() {
		super();
	}

	public GameCustomException(Throwable arg0) {
		super(arg0);
	}

	public GameCustomException(String arg0) {
		super(arg0);
	}

	public GameCustomException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
