package light.mvc.service.warehouse;

import java.util.List;
import java.util.Map;

import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;

public interface GoodsService {
	
	public List<BaseGoodsInfo> getList(int companyId);

	public void save(BaseGoodsInfo goods);

	public BaseGoodsInfo getGoodsById(int id);

	public void updateGoods(BaseGoodsInfo goods);

	public void deleteGoods(int id);
}
