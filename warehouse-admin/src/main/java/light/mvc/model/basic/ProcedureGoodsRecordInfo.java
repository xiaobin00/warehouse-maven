package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "procedure_goods_record_info", catalog = "bsale")
public class ProcedureGoodsRecordInfo implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -151821015287918300L;
	private Integer id;
	private Integer userId;
	private Integer goodsId;
	private String name;
	private Integer count;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	
	

	public ProcedureGoodsRecordInfo(Integer id, Integer userId, Integer goodsId, String name, Integer count,
			Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.name = name;
		this.count = count;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public ProcedureGoodsRecordInfo() {
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
	@Column(name = "name",length=50)
	public String getName() {
		return name;
	}
	@Column(name = "goods_id")
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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
