package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.utils.HttpRequestInfo;
import light.mvc.utils.StringUtil;

public class ProcedureGoodsAddRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4971832013812453743L;
	private int id;
	private String name;
	private Integer count;
	private int planId;
	
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		String goodsInfo = info.getParameter("goodsInfo", "");
		this.count = info.getIntParameter("count", 0);
		this.planId = info.getIntParameter("planId", 0);
		String[] infos= goodsInfo.split("-");
		this.id = Integer.parseInt(infos[0]);
		this.name = infos[1];
		if(StringUtil.isEmpty(name) || count == 0 || this.id == 0){
			throw new RequestIllegalException("参数异常");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
	
	
}
