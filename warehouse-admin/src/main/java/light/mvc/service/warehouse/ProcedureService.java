package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedurePlanInfo;
import light.mvc.request.Request;

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
	
	/**     
	* 保存生产计划
	* @author：zhenghaibin 
	* @date：2017年1月5日 上午11:19:56 
	* @param request
	* @param companyId
	*/
	public void saveProcedurePlanInfo(Request request,int companyId,int userId);
	
	/**     
	* 获取生成计划列表
	* @author：zhenghaibin 
	* @date：2017年1月5日 下午3:13:44 
	* @param request
	* @param companyId
	*/
	public List<ProcedurePlanInfo> getProcedurePlanInfos(Request request,int companyId);
}
