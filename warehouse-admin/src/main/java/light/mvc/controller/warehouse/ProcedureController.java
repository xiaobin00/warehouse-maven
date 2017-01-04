package light.mvc.controller.warehouse;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.framework.web.BaseController;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.service.warehouse.ProcedureService;


@Controller
@RequestMapping("/procedure")
public class ProcedureController extends BaseController{
	
	@Resource
	private ProcedureService procedureService;
	
	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request,Model model){
		int companyId = 1;
		List<Procedure> procedures = procedureService.getProcedures(companyId);
		List<BaseGoodsInfo> goodsInfos = procedureService.getGoodsInfo(companyId);
		model.addAttribute("procedures", procedures);
		model.addAttribute("goodsInfos", goodsInfos);
		return "procedure/add";
	} 
	
	
	
	
}
