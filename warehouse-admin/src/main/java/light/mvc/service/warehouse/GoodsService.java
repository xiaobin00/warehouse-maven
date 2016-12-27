package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.GoodsRecordInfo;
import light.mvc.request.Request;

public interface GoodsService {
	
	/**     
	* 获取物品名称
	* @author：zhenghaibin 
	* @date：2016年12月23日 下午2:20:30 
	* @param companyId
	* @return
	*/
	public List<BaseGoodsInfo> getBaseGoodsInfos(int companyId);
	
	/**     
	* 添加收货记录
	* @author：zhenghaibin 
	* @date：2016年12月27日 下午2:49:25 
	* @param request
	*/
	public void saveGoodsRecordInfos(Request request) throws Exception;
	
	/**     
	* 查询货品记录
	* @author：zhenghaibin 
	* @date：2016年12月27日 下午3:41:16 
	* @param request
	* @return
	* @throws Exception
	*/
	public List<GoodsRecordInfo> getGoodsRecordInfos(Request request) throws Exception;
	
}
