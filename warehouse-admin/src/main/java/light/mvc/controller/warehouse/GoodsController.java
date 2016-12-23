package light.mvc.controller.warehouse;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.framework.web.BaseController;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.service.warehouse.GoodsService;
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/manager")
	public String manager(){
		
		return "goods/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request,Model model){
		int companyId = 1;
		List<BaseGoodsInfo> baseGoodsInfos = goodsService.getBaseGoodsInfos(companyId);
		model.addAttribute("baseGoodsInfos", baseGoodsInfos);
		return "goods/add";
	}
	
	
}
