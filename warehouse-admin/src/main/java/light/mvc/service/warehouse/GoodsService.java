package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.BaseGoodsInfo;

public interface GoodsService {
	
	/**     
	* 获取物品名称
	* @author：zhenghaibin 
	* @date：2016年12月23日 下午2:20:30 
	* @param companyId
	* @return
	*/
	public List<BaseGoodsInfo> getBaseGoodsInfos(int companyId);
}
