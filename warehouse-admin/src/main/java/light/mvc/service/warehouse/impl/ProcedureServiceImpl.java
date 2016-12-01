package light.mvc.service.warehouse.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureByDepartment;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.ProcedureService;
@Service
public class ProcedureServiceImpl implements ProcedureService {
	
	@Autowired
	private BaseDaoI<Procedure> procedureDao;
	@Autowired
	private BaseDaoI<ProcedureDepartment> procedureDepartmentDao;
	@Autowired
	private BaseDaoI<ProcedureByDepartment> prodedureByDepartmentDao;
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
		return procedureDepartmentDao.find("from ProcedureDepartment where companyId="+companyId);
	}

	@Override
	public void saveProcedureDetail(Map<String, String[]> map,int procedureId) {
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			if(!entry.getKey().matches("[0-9]+")){
				continue;
			}
			int pDepartmenetId = Integer.parseInt(entry.getKey());
			int sort = Integer.parseInt( entry.getValue()[0]);
			ProcedureByDepartment byDepartment = new ProcedureByDepartment();
			byDepartment.setCreateTime(new Date());
			byDepartment.setPDepartmentId(pDepartmenetId);
			byDepartment.setProcedureId(procedureId);
			byDepartment.setSort(sort);
			byDepartment.setStatus(1);
			prodedureByDepartmentDao.save(byDepartment);
		}
	}

	@Override
	public List<ProcedureDepartment> getProcedureDepartmentByProcedureId(int procedureId) {
		List<ProcedureByDepartment> prodedureByDepartments = prodedureByDepartmentDao
				.find(" from ProcedureByDepartment p where p.procedureId = " + procedureId + " order by p.sort asc");;
		List<ProcedureDepartment> procedureDepartments = new ArrayList<ProcedureDepartment>();
		for (ProcedureByDepartment procedureByDepartment : prodedureByDepartments) {
			procedureDepartments.add(procedureDepartmentDao
					.find(" from ProcedureDepartment where id = " + procedureByDepartment.getPDepartmentId()).get(0));
		}
		return procedureDepartments;
	}

	

}
