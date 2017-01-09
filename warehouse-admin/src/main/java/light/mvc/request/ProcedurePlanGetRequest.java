package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.utils.HttpRequestInfo;

/**
* 获取单个生产计划
* @author zhenghaibin
* @date 2017年1月9日 下午1:47:46
*/
public class ProcedurePlanGetRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7865352089231223913L;
	private int planId;
	
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.planId = info.getIntParameter("planId", 0);
		if(planId == 0){
			throw new RequestIllegalException("数据异常");
		}
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
	
	
}
