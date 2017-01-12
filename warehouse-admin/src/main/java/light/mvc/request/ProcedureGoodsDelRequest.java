package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.utils.HttpRequestInfo;

/**
* 生产计划原料删除
* @author zhenghaibin
* @date 2017年1月12日 下午4:30:55
*/
public class ProcedureGoodsDelRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3577615749617941999L;
	private int id;
	private int planId;
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.id = info.getIntParameter("id", 0);
		this.planId = info.getIntParameter("planId", 0);
		if(id == 0 || planId == 0){
			throw new RequestIllegalException("参数异常");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	

}
