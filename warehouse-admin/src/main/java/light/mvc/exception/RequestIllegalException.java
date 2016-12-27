package light.mvc.exception;


/**
 * 请求异常类
 * @author tangjun
 */
public class RequestIllegalException extends AppBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 508756173313949529L;

	/** */
	public RequestIllegalException() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 */
	public RequestIllegalException(String message) {
		super(0, message);
	}

}
