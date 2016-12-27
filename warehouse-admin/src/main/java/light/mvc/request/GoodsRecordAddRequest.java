package light.mvc.request;

import javax.servlet.http.HttpServletRequest;

import light.mvc.exception.RequestIllegalException;
import light.mvc.utils.HttpRequestInfo;
import light.mvc.utils.StringUtil;

/**
* 货品记录添加
* @author zhenghaibin
* @date 2016年12月27日 下午2:36:06
*/
public class GoodsRecordAddRequest extends Request {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6241243105591469039L;
	
	private int companyId;
	
	private String name;
	
	private int count;
	
	private int price;
	
	private int tatolPrice;
	
	private int type;
	
	private String specifications;
	
	private String describe;
	@Override
	public void parse(HttpServletRequest request) {
		HttpRequestInfo info =new HttpRequestInfo(request);
		this.companyId = info.getIntParameter("companyId", 0);
		this.name = info.getParameter("name", "");
		this.count = info.getIntParameter("count", 0);
		this.price = info.getIntParameter("price", 0);
		this.tatolPrice = info.getIntParameter("tatolPrice", 0);
		this.type = info.getIntParameter("type", 0);
		this.specifications = info.getParameter("specifications", "");
		this.describe = info.getParameter("describe", "");
		if(StringUtil.isEmpty(name) || count < 1 || type < 0){
			throw new RequestIllegalException("数据异常");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTatolPrice() {
		return tatolPrice;
	}
	public void setTatolPrice(int tatolPrice) {
		this.tatolPrice = tatolPrice;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
	
}
