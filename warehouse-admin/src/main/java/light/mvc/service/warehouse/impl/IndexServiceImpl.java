package light.mvc.service.warehouse.impl;

import java.util.HashMap;
import java.util.Map;

import light.mvc.Response.DefaultResponse;
import light.mvc.Response.Response;
import light.mvc.dao.BaseDaoI;
import light.mvc.model._enum.ApiResultEnum;
import light.mvc.model.basic.UserLoginInfo;
import light.mvc.request.LoginRequest;
import light.mvc.request.Request;
import light.mvc.service.warehouse.IndexService;
import light.mvc.utils.MD5Util;

public class IndexServiceImpl implements IndexService {
	
	private BaseDaoI<UserLoginInfo> userLoginInfoDao;
	
	@Override
	public Response login(Request request) {
		DefaultResponse loginResponse = new DefaultResponse();
		LoginRequest loginRequest = (LoginRequest) request;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", loginRequest.getAccount());
		UserLoginInfo userLoginInfo = userLoginInfoDao.get("from UserLoginInfo where account = :account", params);
		if(userLoginInfo != null){
			String pwdStr = MD5Util.md5(loginRequest.getPassword()+userLoginInfo.getSalt());
			if(pwdStr.equals(userLoginInfo.getPassword())){
				return loginResponse;
			}else{
				loginResponse.setCode(ApiResultEnum.ERROR_PWD.getId());
				loginResponse.setTip(ApiResultEnum.ERROR_PWD.getName());
				return loginResponse;
			}
		}
		loginResponse.setCode(ApiResultEnum.NO_ACCOUNT.getId());
		loginResponse.setTip(ApiResultEnum.NO_ACCOUNT.getName());
		return loginResponse;
	}
	
	
}
