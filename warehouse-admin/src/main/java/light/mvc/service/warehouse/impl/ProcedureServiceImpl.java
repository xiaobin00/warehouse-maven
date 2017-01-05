package light.mvc.service.warehouse.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model._enum.ProcedurePlanStatus;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedurePlanInfo;
import light.mvc.request.ProcedurePlanAddRequest;
import light.mvc.request.ProcedurePlanGetRequest;
import light.mvc.request.Request;
import light.mvc.service.warehouse.ProcedureService;
import light.mvc.utils.StringUtil;
@Service
public class ProcedureServiceImpl implements ProcedureService {
	@Autowired
	private BaseDaoI<Procedure> procedureDao;
	@Autowired
	private BaseDaoI<ProcedurePlanInfo> procedurePlanInfoDao;
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

	@Override
	public void saveProcedurePlanInfo(Request request, int companyId,int userId) {
		ProcedurePlanAddRequest addRequest = (ProcedurePlanAddRequest) request;
		ProcedurePlanInfo info = new ProcedurePlanInfo();
		info.setCompanyId(companyId);
		info.setUserId(userId);
		info.setName(addRequest.getName());
		info.setCount(addRequest.getCount());
		info.setPercentage(addRequest.getPercentage());
		info.setStartTime(addRequest.getStartTime());
		info.setEndTime(addRequest.getEndTime());
		info.setStatus(ProcedurePlanStatus.PREPARE.getId());
		info.setProcedureId(addRequest.getProcedureId());
		info.setCreateTime(new Date());
		procedurePlanInfoDao.save(info);
	}

	@Override
	public List<ProcedurePlanInfo> getProcedurePlanInfos(Request request, int companyId) {
		ProcedurePlanGetRequest getRequest = (ProcedurePlanGetRequest) request;
		String hql = "from ProcedurePlanInfo where companyId = :companyId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		if (!StringUtil.isEmpty(getRequest.getName())) {
			hql = hql + " and name = :name ";
			params.put("name", getRequest.getName());
		}
		if (getRequest.getProcedureId() != 0) {
			hql = hql + " and procedureId = :procedureId ";
			params.put("procedureId", getRequest.getProcedureId());
		}
		if (getRequest.getStatus() != 0) {
			hql = hql + " and status = :status ";
			params.put("status", getRequest.getStatus());
		}
		hql = hql + " order by createTime desc";
		return procedurePlanInfoDao.find(hql, params);
	}
}
