package light.mvc.service.warehouse.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.exception.ServiceOperationException;
import light.mvc.model._enum.ProcedurePlanStatus;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureGoodsRecordInfo;
import light.mvc.model.basic.ProcedurePlanInfo;
import light.mvc.request.ProcedureGoodsAddRequest;
import light.mvc.request.ProcedurePlanAddRequest;
import light.mvc.request.ProcedurePlanGetListRequest;
import light.mvc.request.ProcedurePlanGetRequest;
import light.mvc.request.ProcedurePlanUpdateRequest;
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
	private BaseDaoI<BaseGoodsInfo> baseGoodsInfoDao;
	@Autowired
	private BaseDaoI<ProcedureGoodsRecordInfo> procedureGoodsRecordInfoDao;

	@Override
	public List<Procedure> getProcedures(int companyId) {
		return procedureDao.find("from Procedure where companyId = "+companyId);
	}

	@Override
	public List<BaseGoodsInfo> getGoodsInfo(int companyId) {
		return baseGoodsInfoDao.find("from BaseGoodsInfo where companyId = "+companyId);
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
		ProcedurePlanGetListRequest getRequest = (ProcedurePlanGetListRequest) request;
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
		if (getRequest.getStatus() != -1) {
			hql = hql + " and status = :status ";
			params.put("status", getRequest.getStatus());
		}
		hql = hql + " order by createTime desc";
		return procedurePlanInfoDao.find(hql, params);
	}

	@Override
	public ProcedurePlanInfo getProcedurePlanInfo(Request request) {
		ProcedurePlanGetRequest getRequest = (ProcedurePlanGetRequest) request;
		String hql = "from ProcedurePlanInfo where id = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", getRequest.getPlanId());
		return procedurePlanInfoDao.get(hql, params);
	}

	@Override
	public void updateProcedurePlanInfo(Request request) throws Exception {
		ProcedurePlanUpdateRequest planUpdateRequest = (ProcedurePlanUpdateRequest) request;
		ProcedurePlanInfo info = procedurePlanInfoDao.get(ProcedurePlanInfo.class, planUpdateRequest.getId());
		if (info.getStatus() == ProcedurePlanStatus.PREPARE.getId()) {
			if (!StringUtil.isEmpty(planUpdateRequest.getName())) {
				info.setName(planUpdateRequest.getName());
			}
			if (planUpdateRequest.getProcedureId() != 0) {
				info.setProcedureId(planUpdateRequest.getProcedureId());
			}
			if (planUpdateRequest.getCount() != 0) {
				info.setCount(planUpdateRequest.getCount());
			}
			if (planUpdateRequest.getStartTime() != null) {
				info.setStartTime(planUpdateRequest.getStartTime());
			}
			if (planUpdateRequest.getEndTime() != null) {
				info.setEndTime(planUpdateRequest.getEndTime());
			}
		}
		if (planUpdateRequest.getPercentage() != 0) {
			info.setPercentage(planUpdateRequest.getPercentage());
		}
		if (planUpdateRequest.getActualTime() != null) {
			info.setActualTime(planUpdateRequest.getActualTime());
		}

		if (planUpdateRequest.getStatus() != 0) {
			if (planUpdateRequest.getStatus() == ProcedurePlanStatus.PREPARE.getId()
					&& info.getStatus() != ProcedurePlanStatus.PREPARE.getId()) {
				throw new ServiceOperationException("数据异常");
			}
			info.setStatus(planUpdateRequest.getStatus());
		}
		procedurePlanInfoDao.update(info);
	}

	@Override
	public List<ProcedureGoodsRecordInfo> getProcedureGoods(Request request) throws Exception {
		ProcedurePlanGetRequest getRequest = (ProcedurePlanGetRequest) request;
		String hql = "from ProcedureGoodsRecordInfo where planId = :planId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("planId", getRequest.getPlanId());
		return procedureGoodsRecordInfoDao.find(hql, params);
	}

	@Override
	public void addGoods(Request request,int userId) throws Exception {
		ProcedureGoodsAddRequest getRequest = (ProcedureGoodsAddRequest) request;
		ProcedureGoodsRecordInfo goodsRecordInfo = new ProcedureGoodsRecordInfo();
		goodsRecordInfo.setCount(getRequest.getCount());
		goodsRecordInfo.setGoodsId(getRequest.getId());
		goodsRecordInfo.setName(getRequest.getName());
		goodsRecordInfo.setUserId(userId);
		goodsRecordInfo.setCreateTime(new Date());
		goodsRecordInfo.setPlanId(getRequest.getPlanId());
		goodsRecordInfo.setStatus(1);
		goodsRecordInfo.setUpdateTime(new Date());
		procedureGoodsRecordInfoDao.save(goodsRecordInfo);
	}
}
