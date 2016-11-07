package light.mvc.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.ProcedureService;
@Service
public class ProcedureServiceImpl implements ProcedureService {
	
	@Autowired
	private BaseDaoI<Procedure> procedureDao;
	@Autowired
	private BaseDaoI<ProcedureDepartment> procedureDepartmentDao;
	@Override
	public List<Procedure> getList() {
		return procedureDao.find("from Procedure");
	}

	@Override
	public void save(Procedure department) {
		procedureDao.save(department);
		
	}

	@Override
	public Procedure getProcedureById(int id) {
		return procedureDao.get(Procedure.class, id);
	}

	@Override
	public void updateProcedure(Procedure department) {
		procedureDao.update(department);
	}

	@Override
	public void deleteProcedure(int id) {
		Procedure department = procedureDao.get(Procedure.class, id);
		procedureDao.delete(department);
	}

	@Override
	public List<ProcedureDepartment> getProcedureDepartmentList(int companyId) {
		return procedureDepartmentDao.find("from Procedure where companyId="+companyId);
	}

}
