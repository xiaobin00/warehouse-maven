package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.utils.HttpRequestInfo;

public class ProcedurePlanGetListRequest extends Request {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1296631607672506328L;
	private String name;
	private Integer procedureId;
	private Integer status;
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.name = info.getParameter("name", "");
		this.procedureId = info.getIntParameter("procedureId", 0);
		this.status = info.getIntParameter("status", -1);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProcedureId() {
		return procedureId;
	}
	public void setProcedureId(Integer procedureId) {
		this.procedureId = procedureId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
