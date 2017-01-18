package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.model._enum.ApiUrlParamEnum;
import light.mvc.utils.HttpRequestInfo;
import light.mvc.utils.StringUtil;

public class LoginRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 267850938426386704L;
	private String name;
	private String password;
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.name = info.getParameter(ApiUrlParamEnum.name.getParamName(), "");
		this.password = info.getParameter(ApiUrlParamEnum.password.getParamName(), "");
		if(StringUtil.isEmpty(name) || StringUtil.isEmpty(password)){
			new RequestIllegalException("参数错误");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
