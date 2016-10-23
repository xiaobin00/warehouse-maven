package light.mvc.model.basic;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProcedureDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "procedure_department", catalog = "bsale")
public class ProcedureDepartment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String charge;
	private Integer companyId;
	private Integer status;
	private Date createTime;

	// Constructors

	/** default constructor */
	public ProcedureDepartment() {
	}

	/** minimal constructor */
	public ProcedureDepartment(Integer companyId, Integer status,
			Date createTime) {
		this.companyId = companyId;
		this.status = status;
		this.createTime = createTime;
	}

	/** full constructor */
	public ProcedureDepartment(String name, String charge, Integer companyId,
			Integer status, Date createTime) {
		this.name = name;
		this.charge = charge;
		this.companyId = companyId;
		this.status = status;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "charge", length = 50)
	public String getCharge() {
		return this.charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	@Column(name = "company_id", nullable = false)
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}