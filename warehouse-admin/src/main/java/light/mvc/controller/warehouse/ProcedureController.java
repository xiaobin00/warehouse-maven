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
import light.mvc.request.ProcedurePlanGetListRequest;
import light.mvc.request.ProcedurePlanGetRequest;
import light.mvc.request.ProcedurePlanUpdateRequest;
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
		ProcedurePlanGetListRequest getRequest = new ProcedurePlanGetListRequest();
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
		model.addAttribute("procedures", procedures);
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
	
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request, Model model) {
		try {
			ProcedurePlanGetRequest getRequest = new ProcedurePlanGetRequest();
			getRequest.parse(request);
			int companyId = 1;
			ProcedurePlanInfo info = procedureService.getProcedurePlanInfo(getRequest);
			List<Procedure> procedures = procedureService.getProcedures(companyId);
			model.addAttribute("procedures", procedures);
			model.addAttribute("info", info);
		} catch (Exception e) {
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[] { Thread.currentThread().getStackTrace()[1].getMethodName(), request, e.getMessage(),
							Arrays.deepToString(e.getStackTrace()) });
			model.addAttribute("tip", "数据有误");
			return "procedure/update";
		}
		return "procedure/update";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model){
		try {
			ProcedurePlanUpdateRequest planUpdateRequest = new ProcedurePlanUpdateRequest();
			planUpdateRequest.parse(request);
			procedureService.updateProcedurePlanInfo(planUpdateRequest);
		} catch (Exception e) {
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[] { Thread.currentThread().getStackTrace()[1].getMethodName(), request, e.getMessage(),
							Arrays.deepToString(e.getStackTrace()) });
			model.addAttribute("tip", "数据有误");
			return "procedure/update";
		}
		return "redirect:/procedure/manager";
	}
	
	
}
