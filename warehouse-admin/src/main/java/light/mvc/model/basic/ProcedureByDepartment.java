package light.mvc.model.basic;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProcedureByDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "procedure_by_department", catalog = "bsale")
public class ProcedureByDepartment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer procedureId;
	private Integer PDepartmentId;
	private Integer sort;
	private Integer status;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public ProcedureByDepartment() {
	}

	/** minimal constructor */
	public ProcedureByDepartment(Integer status) {
		this.status = status;
	}

	/** full constructor */
	public ProcedureByDepartment(Integer procedureId, Integer PDepartmentId,
			Integer sort, Integer status, Timestamp createTime) {
		this.procedureId = procedureId;
		this.PDepartmentId = PDepartmentId;
		this.sort = sort;
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

	@Column(name = "procedure_id")
	public Integer getProcedureId() {
		return this.procedureId;
	}

	public void setProcedureId(Integer procedureId) {
		this.procedureId = procedureId;
	}

	@Column(name = "p_department_id")
	public Integer getPDepartmentId() {
		return this.PDepartmentId;
	}

	public void setPDepartmentId(Integer PDepartmentId) {
		this.PDepartmentId = PDepartmentId;
	}

	@Column(name = "sort")
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}