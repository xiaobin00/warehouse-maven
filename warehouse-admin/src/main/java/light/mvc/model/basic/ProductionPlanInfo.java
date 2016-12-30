package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "production_plan_info", catalog = "bsale")
public class ProductionPlanInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6825977839577760307L;
	private Integer id;
	private Integer userId;
	private Integer companyId;
	private String name;
	private Integer count;
	private Integer percentage;
	private Integer status;
	private Date startTime;
	private Date endTime;
	private Date actualTime;
	private Date createTime;
	
	
	public ProductionPlanInfo(Integer id, Integer userId, Integer companyId, String name, Integer count,
			Integer percentage, Integer status, Date startTime, Date endTime, Date actualTime, Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyId = companyId;
		this.name = name;
		this.count = count;
		this.percentage = percentage;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.actualTime = actualTime;
		this.createTime = createTime;
	}
	
	
	public ProductionPlanInfo() {
		super();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "company_id")
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	@Column(name = "name",length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "count")
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Column(name = "percentage")
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "start_time", nullable = false, length = 19)
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@Column(name = "end_time", nullable = false, length = 19)
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Column(name = "actual_time", nullable = false, length = 19)
	public Date getActualTime() {
		return actualTime;
	}
	public void setActualTime(Date actualTime) {
		this.actualTime = actualTime;
	}
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
