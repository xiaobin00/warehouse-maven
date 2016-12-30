package light.mvc.service.warehouse.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.GoodsRecordInfo;
import light.mvc.request.GoodsRecordAddRequest;
import light.mvc.request.GoodsRecordGetRequest;
import light.mvc.request.Request;
import light.mvc.service.warehouse.GoodsService;
import light.mvc.utils.StringUtil;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private BaseDaoI<GoodsRecordInfo> goodsDao;
	
	@Autowired
	private BaseDaoI<BaseGoodsInfo> baseGoodsDao;
	
	
	@Override
	public List<BaseGoodsInfo> getBaseGoodsInfos(int companyId) {
		return baseGoodsDao.find("from BaseGoodsInfo where companyId="+companyId);
	}


	@Override
	public void saveGoodsRecordInfos(Request request) throws Exception{
		GoodsRecordAddRequest addRequest = (GoodsRecordAddRequest) request;
		GoodsRecordInfo info = new GoodsRecordInfo();
		info.setCompanyId(addRequest.getCompanyId());
		info.setCount(addRequest.getCount());
		info.setDescribe(addRequest.getDescribe());
		info.setSpecifications(addRequest.getSpecifications());
		info.setStatus(1);
		info.setName(addRequest.getName());
		info.setTatolPrice(addRequest.getTatolPrice());
		info.setPrice(addRequest.getPrice());
		info.setType(addRequest.getType());
		info.setCreateTime(new Date());
		info.setParentId(addRequest.getParentId());
		goodsDao.save(info);
	}


	@Override
	public List<GoodsRecordInfo> getGoodsRecordInfos(Request request) throws Exception {
		GoodsRecordGetRequest getRequest = (GoodsRecordGetRequest) request;
		Map<String, Object> params = new HashMap<String, Object>();
		String query = "";
		if (!StringUtil.isEmpty(getRequest.getName()) || getRequest.getType() > 0) {
			query = " where ";
			if (!StringUtil.isEmpty(getRequest.getName())) {
				params.put("name", getRequest.getName());
				query = query + " name =:name";
			}
			if (getRequest.getType() > 0) {
				if(!StringUtil.isEmpty(getRequest.getName())){
					query = query + " and ";
				}
				params.put("type", getRequest.getType());
				query = query + " type =:type";
			}
		}
		return goodsDao.find("from GoodsRecordInfo" + query, params);
	}
	
}
