package light.mvc.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.ProcedureDepartmentService;

@Service
public class ProcedureDepartmentServiceImpl implements ProcedureDepartmentService {
	
	@Autowired
	private BaseDaoI<ProcedureDepartment> procedureDepartmentDao;
	@Override
	public List<ProcedureDepartment> getList() {
		procedureDepartmentDao.find("from ProcedureDepartment");
		return procedureDepartmentDao.find("from ProcedureDepartment");
	}
	@Override
	public void save(ProcedureDepartment department) {
		procedureDepartmentDao.save(department);
		
	}
	@Override
	public ProcedureDepartment getProcedureDepartmentById(int id) {
		
		return procedureDepartmentDao.get(ProcedureDepartment.class, id);
	}
	@Override
	public void updateProcedureDepartment(ProcedureDepartment department) {
		procedureDepartmentDao.update(department);
		
	}
	
	@Override
	public void deleteProcedureDepartment(int id) {
		ProcedureDepartment department = procedureDepartmentDao.get(ProcedureDepartment.class, id);
		procedureDepartmentDao.delete(department);
	}

}
