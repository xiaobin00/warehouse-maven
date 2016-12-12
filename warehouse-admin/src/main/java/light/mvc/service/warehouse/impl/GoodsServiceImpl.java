package light.mvc.service.warehouse.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.BaseGoods;
import light.mvc.service.warehouse.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private BaseDaoI<BaseGoods> goodsDao;
	
	@Override
	public List<BaseGoods> getList(int companyId) {
		return goodsDao.find("from BaseGoods where companyId="+companyId);
	}

	@Override
	public void save(BaseGoods goods) {
		goodsDao.save(goods);
		
	}

	@Override
	public BaseGoods getGoodsById(int id) {
		return goodsDao.get("from BaseGoods where id=" + id);
	}

	@Override
	public void updateGoods(BaseGoods goods) {
		goodsDao.update(goods);
	}

	@Override
	public void deleteGoods(int id) {
		goodsDao.executeHql("delete BaseGoods where id = "+id);
	}
	
	
}
