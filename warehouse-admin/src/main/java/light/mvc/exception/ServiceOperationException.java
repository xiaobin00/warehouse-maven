/**
 * 
 */
package light.mvc.exception;

/**
 * 业务逻辑类异常
 *
 * @author lijian
 * @version 2014年3月15日 - 下午1:26:51
 */
public class ServiceOperationException extends AppBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4618415364025173907L;

	/** */
	public ServiceOperationException() {
		super();
	}

	/**
	 * 
	 * @param message 错误信息
	 */
	public ServiceOperationException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param errCode 错误码
	 * @param message 错误信息
	 */
	public ServiceOperationException(int errCode, String message) {
		super(errCode, message);
	}

	/**
	 * 
	 * @param message 错误信息
	 * @param cause
	 */
    public ServiceOperationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param errCode 错误码
     * @param message 错误信息
     * @param cause 异常
     */
    public ServiceOperationException(int errCode, String message, Throwable cause) {
    	super(errCode, message, cause);
    }

}