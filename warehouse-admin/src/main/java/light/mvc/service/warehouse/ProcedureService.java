package light.mvc.service.warehouse;

import java.util.List;
import java.util.Map;

import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;

public interface ProcedureService {
	
	public List<Procedure> getList();

	public void save(Procedure department);

	public Procedure getProcedureById(int id);

	public void updateProcedure(Procedure department);

	public void deleteProcedure(int id);
	
	public List<ProcedureDepartment> getProcedureDepartmentList(int companyId);
	
	/**     
	* 保存详细流程
	* @author：zhenghaibin 
	* @date：2016年11月29日 下午4:20:07 
	* @param map
	*/
	public void saveProcedureDetail(Map<String,String[]> map,int procedureId);
	
	/**获取流程工序列表
	 * @param procedureId
	 */
	public List<ProcedureDepartment> getProcedureDepartmentByProcedureId(int procedureId);
}
