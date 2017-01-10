package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureGoodsRecordInfo;
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
	
	/**     
	* 获取单个计划
	* @author：zhenghaibin 
	* @date：2017年1月9日 下午1:53:42 
	* @param request
	* @return
	*/
	public ProcedurePlanInfo getProcedurePlanInfo(Request request);
	
	/**     
	* 修改生产计划信息
	* @author：zhenghaibin 
	* @date：2017年1月9日 下午3:56:29 
	* @param request
	*/
	public void updateProcedurePlanInfo(Request request) throws Exception;
	
	/**     
	* 获取生产计划原料配置
	* @author：zhenghaibin 
	* @date：2017年1月10日 下午1:53:40 
	* @param request
	* @throws Exception
	*/
	public List<ProcedureGoodsRecordInfo> getProcedureGoods(Request request) throws Exception;
	
	/**     
	* 添加出库货品
	* @author：zhenghaibin 
	* @date：2017年1月10日 下午4:52:25 
	* @param request
	* @throws Exception
	*/
	public void addGoods(Request request,int userId) throws Exception;
}
