package light.mvc.request;


import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

/**
 * @author hongyuhao
 */
public abstract class Request implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8345106786789120936L;

	/**
	 * 解析参数
	 * @param request
	 */
	public abstract void parse(HttpServletRequest request);

	protected void parseFixedParams(HttpServletRequest request) {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSON.toJSONString(this);
	} 
}
