package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户登录信息表
 * @author admin
 *
 */
@Entity
@Table(name = "user_login_info", catalog = "bsale")
public class UserLoginInfo implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1159117575085293608L;
	private int id;
	private String account;
	private String password;
	private String salt;
	private int status;
	private Date createTime;
	private int companyId;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "account",length=50)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name = "password",length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "salt",length=20)
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "company_id")
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public UserLoginInfo(int id, String account, String password, String salt, int status, Date createTime,
			int companyId) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.salt = salt;
		this.status = status;
		this.createTime = createTime;
		this.companyId = companyId;
	}
	
	
	
	
}
