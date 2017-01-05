package light.mvc.controller.warehouse;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.framework.web.BaseController;
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedurePlanInfo;
import light.mvc.request.ProcedurePlanAddRequest;
import light.mvc.request.ProcedurePlanGetRequest;
import light.mvc.service.warehouse.ProcedureService;


@Controller
@RequestMapping("/procedure")
public class ProcedureController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(ProcedureController.class);

	@Resource
	private ProcedureService procedureService;
	
	@RequestMapping("/manager")
	public String manage(HttpServletRequest request,Model model){
		int companyId = 1;
		ProcedurePlanGetRequest getRequest = new ProcedurePlanGetRequest();
		getRequest.parse(request);
		List<Procedure> procedures = procedureService.getProcedures(companyId);
		List<ProcedurePlanInfo> procedurePlanInfos = procedureService.getProcedurePlanInfos(getRequest, companyId);
		model.addAttribute("procedures", procedures);
		model.addAttribute("procedurePlanInfos", procedurePlanInfos);
		return "/procedure/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request,Model model){
		int companyId = 1;
		List<Procedure> procedures = procedureService.getProcedures(companyId);
		List<BaseGoodsInfo> goodsInfos = procedureService.getGoodsInfo(companyId);
		model.addAttribute("procedures", procedures);
		model.addAttribute("goodsInfos", goodsInfos);
		return "procedure/add";
	} 
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model){
		int companyId = 1;
		int userId = 1;
		try{
			ProcedurePlanAddRequest addRequest = new ProcedurePlanAddRequest();
			addRequest.parse(request);
			procedureService.saveProcedurePlanInfo(addRequest, companyId, userId);
		
		}catch(Exception e){
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[]{Thread.currentThread().getStackTrace()[1].getMethodName(),request,e.getMessage(), Arrays.deepToString(e.getStackTrace())});
			model.addAttribute("tip", "添加数据有误");
			List<Procedure> procedures = procedureService.getProcedures(companyId);
			List<BaseGoodsInfo> goodsInfos = procedureService.getGoodsInfo(companyId);
			model.addAttribute("procedures", procedures);
			model.addAttribute("goodsInfos", goodsInfos);
			return "procedure/add";
		}
		return "redirect:/procedure/manager";
	}
	
	
	
}
