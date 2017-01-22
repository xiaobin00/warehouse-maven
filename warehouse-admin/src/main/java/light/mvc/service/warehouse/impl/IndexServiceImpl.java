package light.mvc.service.warehouse.impl;

import java.util.HashMap;
import java.util.Map;

import light.mvc.dao.BaseDaoI;
import light.mvc.model.basic.ClientUser;
import light.mvc.request.LoginRequest;
import light.mvc.request.Request;
import light.mvc.service.warehouse.IndexService;

public class IndexServiceImpl implements IndexService {
	
	private BaseDaoI<ClientUser> clientUserDao;
	
	@Override
	public ClientUser login(Request request) {
		LoginRequest loginRequest = (LoginRequest) request;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", loginRequest.getName());
		ClientUser clientUser = clientUserDao.get("from ClientUser where name = :name", params);
		return null;
	}
	
	
}
