package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.ProcedureDepartment;

public interface ProcedureDepartmentService {
	
	public List<ProcedureDepartment> getList();
	
	public void save(ProcedureDepartment department);
	
	public ProcedureDepartment getProcedureDepartmentById(int id);
	
	public void updateProcedureDepartment(ProcedureDepartment department);
	
	public void deleteProcedureDepartment(int id);
	
}
