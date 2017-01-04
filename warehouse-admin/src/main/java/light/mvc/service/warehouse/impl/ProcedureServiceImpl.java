package light.mvc.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.service.warehouse.ProcedureService;
@Service
public class ProcedureServiceImpl implements ProcedureService {
	@Autowired
	private BaseDaoI<Procedure> procedureDao;
	@Autowired
	private BaseDaoI<BaseGoodsInfo> baseGoodsInfo;

	@Override
	public List<Procedure> getProcedures(int companyId) {
		return procedureDao.find("from Procedure where companyId = "+companyId);
	}

	@Override
	public List<BaseGoodsInfo> getGoodsInfo(int companyId) {
		return baseGoodsInfo.find("from BaseGoodsInfo where companyId = "+companyId);
	}
}
