package light.mvc.service.warehouse;

import light.mvc.model.basic.ClientUser;
import light.mvc.request.Request;

public interface IndexService {
	
	/**     
	* 校验用户
	* @author：zhenghaibin 
	* @date：2017年1月22日 下午3:19:58 
	* @param request
	* @return
	*/
	public ClientUser login(Request request);
	
}
