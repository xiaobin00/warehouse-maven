package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "plan_schedule_info", catalog = "bsale")
public class PlanScheduleInfo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -986793423407647023L;
	private Integer id;
	private Integer planId;
	private Integer pDepartmentId;
	private Integer userId;
	private Integer count;
	private Integer percentage;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	
	
	
	public PlanScheduleInfo(Integer id, Integer planId, Integer pDepartmentId, Integer userId, Integer count,
			Integer percentage, Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.planId = planId;
		this.pDepartmentId = pDepartmentId;
		this.userId = userId;
		this.count = count;
		this.percentage = percentage;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public PlanScheduleInfo() {
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
	@Column(name = "plan_id")
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	@Column(name = "p_department_id")
	public Integer getpDepartmentId() {
		return pDepartmentId;
	}
	public void setpDepartmentId(Integer pDepartmentId) {
		this.pDepartmentId = pDepartmentId;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "update_time", nullable = false, length = 19)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
