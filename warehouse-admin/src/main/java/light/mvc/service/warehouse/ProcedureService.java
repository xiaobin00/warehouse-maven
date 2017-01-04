package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;

public interface ProcedureService {
	
	/**     
	* 获取流程列表
	* @author：zhenghaibin 
	* @date：2017年1月4日 下午1:44:25 
	* @param companyId
	* @return
	*/
	public List<Procedure> getProcedures(int companyId);
	
	/**     
	* 获取物品列表
	* @author：zhenghaibin 
	* @date：2017年1月4日 下午4:38:13 
	* @param companyId
	* @return
	*/
	public List<BaseGoodsInfo> getGoodsInfo(int companyId);
}
