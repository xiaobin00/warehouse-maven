package light.mvc.controller.warehouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.framework.web.BaseController;
@Controller
public class GoodsController extends BaseController{
	
	private static final String root = "/goods";
	@RequestMapping("/manager")
	public String manager(){
		
		return "";
	}
	
	
}
