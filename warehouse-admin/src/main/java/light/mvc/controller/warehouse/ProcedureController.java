package light.mvc.controller.warehouse;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.framework.web.BaseController;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.ProcedureService;

@Controller
@RequestMapping("/procedure")
public class ProcedureController extends BaseController{
	@Resource
	private ProcedureService procedureService;
	
	@RequestMapping("/manager")
	public String getList(HttpServletRequest request,HttpServletResponse response,Model model){
		//request.setAttribute("listData", procedureDepartmentService.getList());
		model.addAttribute("listData", procedureService.getList());
		return "procedure/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "procedure/add";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		String name = request.getParameter("name");
		Procedure procedure = new Procedure();
		procedure.setName(name);
		procedure.setCompanyId(1);
		procedure.setCreateTime(new Date());
		procedure.setStatus(1);
		procedureService.save(procedure);
		return"redirect:/procedure/manager";
		
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request){
		String id= request.getParameter("id");
		Procedure procedure = procedureService.getProcedureById(Integer.parseInt(id));
		request.setAttribute("procedure", procedure);
		return "procedure/update";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String id =  request.getParameter("id");
		String name =  request.getParameter("name");
		Procedure procedure = procedureService.getProcedureById(Integer.parseInt(id));
		procedure.setName(name);
		procedureService.updateProcedure(procedure);
		return"redirect:/procedure/manager";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {

		String id = request.getParameter("id");
		procedureService.deleteProcedure(Integer.parseInt(id));
		return "redirect:/procedure/manager";
	}
	
	@RequestMapping("/toDetail")
	public String toDetail(HttpServletRequest request){
		List<ProcedureDepartment> procedureDepartments =procedureService.getProcedureDepartmentList(1);
		request.setAttribute("procedureDepartments", procedureDepartments);
		return "/procedure/detail";
	}
	@RequestMapping("/toDetail")
	public String updateDetai(HttpServletRequest request){
		
		return "redirect:/procedure/toDetail";
	}
}
