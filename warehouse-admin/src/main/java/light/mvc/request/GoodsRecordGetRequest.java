package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.utils.HttpRequestInfo;

public class GoodsRecordGetRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2817731436526176093L;
	private String name;
	private int  type;
	
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.name = info.getParameter("name","");
		this.type = info.getIntParameter("type", 0);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
