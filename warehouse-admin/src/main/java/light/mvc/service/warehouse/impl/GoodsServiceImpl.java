package light.mvc.service.warehouse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.GoodsRecordInfo;
import light.mvc.service.warehouse.GoodsService;
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
	
}
