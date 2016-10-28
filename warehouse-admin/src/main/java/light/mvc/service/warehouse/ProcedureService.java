package light.mvc.service.warehouse;

import java.util.List;

import light.mvc.model.basic.Procedure;

public interface ProcedureService {
	
	public List<Procedure> getList();

	public void save(Procedure department);

	public Procedure getProcedureById(int id);

	public void updateProcedure(Procedure department);

	public void deleteProcedure(int id);
}
