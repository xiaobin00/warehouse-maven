package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "goods_record_info", catalog = "bsale")
public class GoodsRecordInfo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -251423853610430579L;
	private Integer id;
	private Integer companyId;
	private String name;
	private Integer count;
	private Integer price;
	//规格
	private String specifications;
	
	private Integer type;
	private Integer status;
	private Integer tatolPrice;
	private String describe;
	private Date createTime;
	
	private Integer parentId;
	
	public GoodsRecordInfo() {
		super();
	}
	public GoodsRecordInfo(Integer id, Integer companyId, String name, Integer count, Integer price,
			String specifications, Integer type, Integer status, Integer tatolPrice, String describe, Date createTime) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.name = name;
		this.count = count;
		this.price = price;
		this.specifications = specifications;
		this.type = type;
		this.status = status;
		this.tatolPrice = tatolPrice;
		this.describe = describe;
		this.createTime = createTime;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "company_id")
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	@Column(name = "name", length = 50)
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
	@Column(name = "price")
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Column(name = "specifications", length = 50)
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Column(name = "type")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "tatol_price")
	public Integer getTatolPrice() {
		return tatolPrice;
	}
	public void setTatolPrice(Integer tatolPrice) {
		this.tatolPrice = tatolPrice;
	}
	@Column(name = "`describe`", length = 255)
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
	

}
