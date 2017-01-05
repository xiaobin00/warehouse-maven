package light.mvc.request;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.utils.HttpRequestInfo;
import light.mvc.utils.StringUtil;

/**
* 生产计划添加
* @author zhenghaibin
* @date 2017年1月5日 上午11:03:43
*/
public class ProcedurePlanAddRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3716898723074419932L;
	private String name;
	private Integer count;
	private Integer percentage;
	private Date startTime;
	private Date endTime;
	private Integer procedureId;
	
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.name = info.getParameter("name", "");
		this.count = info.getIntParameter("count", 0);
		this.percentage = info.getIntParameter("percentage", 0);
		this.startTime = info.getDateParameter("startTime", "yyyy/MM/dd HH:mm:ss");
		System.out.println(request.getParameter("startTime"));
		System.out.println(startTime);
		this.endTime = info.getDateParameter("endTime", "yyyy/MM/dd HH:mm:ss");
		this.procedureId = info.getIntParameter("procedureId", 0);
		if(StringUtil.isEmpty(name)){
			throw new RequestIllegalException("错误参数 name："+name);
		}
		if(count == 0){
			throw new RequestIllegalException("错误参数 count："+count);
		}
		
		if(startTime == null){
			throw new RequestIllegalException("错误参数 startTime");
		}
		if(procedureId == 0){
			throw new RequestIllegalException("错误参数 procedureId");
		}
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

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
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

	public Integer getProcedureId() {
		return procedureId;
	}

	public void setProcedureId(Integer procedureId) {
		this.procedureId = procedureId;
	}

	
	
	

}
