package light.mvc.model.basic;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "notice_info", catalog = "bsale")
public class NoticeInfo implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6205390287677783462L;
	private Integer id;
	private Integer userId;
	private String content;
	private Integer type;
	private Integer status;
	private Date createTime;
	
	public NoticeInfo(Integer id, Integer userId, String content, Integer type, Integer status, Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.type = type;
		this.status = status;
		this.createTime = createTime;
	}
	
	
	public NoticeInfo() {
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
	@Column(name = "content",length=250)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
