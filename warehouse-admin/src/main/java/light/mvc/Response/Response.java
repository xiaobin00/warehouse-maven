package light.mvc.Response;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import light.mvc.model._enum.ApiResultEnum;


/**
 * @author tangjun@mail.39.net
 */
public  class Response implements Serializable {
	
	private static final long serialVersionUID = -3992480069790912326L;
	
	/** 信息 */
	protected String tip = ApiResultEnum.SUCCESS.getName();
	/** 状态码 */
	protected int code = ApiResultEnum.SUCCESS.getId();

	/**
	 * @return the tip
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * @param tip
	 *            the tip to set
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	public enum ResultParamEnum{
		code("code"),
		tip("tip");
		
		private String paramName;
		
		ResultParamEnum(String name){
			this.paramName = name;
		}

		public String getParamName() {
			return paramName;
		}

		public void setParamName(String paramName) {
			this.paramName = paramName;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSON.toJSONString(this);
	}
	
	public static Response getSeccess(){
		Response response = new Response();
		response.code = ApiResultEnum.SUCCESS.getId();
		response.tip = ApiResultEnum.SUCCESS.getName();
		return response;
	}
	
	public static Response getError(){
		Response response = new Response();
		response.code = ApiResultEnum.FAIL.getId();
		response.tip = ApiResultEnum.FAIL.getName();
		return response;
	}
}
