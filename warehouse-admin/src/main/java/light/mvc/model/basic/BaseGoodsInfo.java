package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_goods", catalog = "bsale")
public class BaseGoodsInfo implements java.io.Serializable {
	
	// Fields

		private Integer id;
		private String name;
		private Integer companyId;
		private Integer status;
		private Date createTime;

		// Constructors

		/** default constructor */
		public BaseGoodsInfo() {
		}

		/** minimal constructor */
		public BaseGoodsInfo(Integer status, Timestamp createTime) {
			this.status = status;
			this.createTime = createTime;
		}

		/** full constructor */
		public BaseGoodsInfo(String name, Integer companyId, Integer status,
				Timestamp createTime) {
			this.name = name;
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

		@Column(name = "company_id")
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
