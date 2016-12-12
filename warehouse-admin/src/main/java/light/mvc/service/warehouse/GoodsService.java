package light.mvc.service.warehouse;

import java.util.List;
import java.util.Map;

import light.mvc.model.basic.BaseGoods;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;

public interface GoodsService {
	
	public List<BaseGoods> getList(int companyId);

	public void save(BaseGoods goods);

	public BaseGoods getGoodsById(int id);

	public void updateGoods(BaseGoods goods);

	public void deleteGoods(int id);
}
