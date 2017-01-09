package light.mvc.request;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.utils.HttpRequestInfo;

public class ProcedurePlanUpdateRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2343806370726662139L;
	private int id;
	private String name;
	private int procedureId;
	private int count;
	private int percentage;
	private Date startTime;
	private Date endTime;
	private int status;
	private Date actualTime;
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.id = info.getIntParameter("id", 0);
		this.name = info.getParameter("name", "");
		this.procedureId = info.getIntParameter("procedureId", 0);
		this.count = info.getIntParameter("count", 0);
		this.percentage = info.getIntParameter("percentage", 0);
		this.startTime = info.getDateParameter("startTime", "yyyy/MM/dd HH:mm:ss");
		this.endTime = info.getDateParameter("endTime", "yyyy/MM/dd HH:mm:ss");
		this.status = info.getIntParameter("status", -1);
		this.actualTime = info.getDateParameter("actualTime", "yyyy/MM/dd HH:mm:ss");
		if(id == 0){
			throw new RequestIllegalException("数据异常");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProcedureId() {
		return procedureId;
	}
	public void setProcedureId(int procedureId) {
		this.procedureId = procedureId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getActualTime() {
		return actualTime;
	}
	public void setActualTime(Date actualTime) {
		this.actualTime = actualTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
