package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "client_user", catalog = "bsale")
public class ClientUser implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8496995196869903851L;
	private Integer id;
	private String name;
	private String phone;
	private String password;
	private Integer status;
	private String account;
	private Integer roleId;
	private Integer levelId;
	private Date createTime;
	private String salt;
		
	
	public ClientUser() {
		super();
	}
	public ClientUser(Integer id, String name, String phone, String password, Integer status, String account,
			Integer roleId, Integer levelId, Date createTime, String salt) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.account = account;
		this.roleId = roleId;
		this.levelId = levelId;
		this.createTime = createTime;
		this.salt = salt;
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
	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "phone", length = 50)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "password", length = 250)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "account", length = 50)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name = "role_id")
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Column(name = "level_id")
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "salt", length = 50)
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}
