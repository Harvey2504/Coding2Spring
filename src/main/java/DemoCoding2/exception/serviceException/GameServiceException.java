package DemoCoding2.exception.serviceException;

public class GameServiceException extends Exception {
	public GameServiceException() {
		super();
	}

	public GameServiceException(Throwable arg0) {
		super(arg0);
	}

	public GameServiceException(String arg0) {
		super(arg0);
	}

	public GameServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
