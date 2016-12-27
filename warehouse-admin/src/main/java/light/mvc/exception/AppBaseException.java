package light.mvc.exception;


/**
 * api异常基类
 * @author tangjun
 */
public class AppBaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3728403084326926290L;
	
	//异常错误码，默认为0
	private int errCode = 0;

	/** */
	public AppBaseException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public AppBaseException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
    public AppBaseException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param errCode
     * @param message
     * @param cause
     */
    public AppBaseException(int errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }
    
    /**
     * 
     * @param errCode
     * @param message
     */
    public AppBaseException(int errCode, String message) {
    	super(message);
    	this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

}