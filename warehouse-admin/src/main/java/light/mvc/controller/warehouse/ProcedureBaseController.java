package light.mvc.controller.warehouse;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import light.mvc.framework.web.BaseController;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.ProcedureService;

@Controller
@RequestMapping("/procedureBase")
public class ProcedureBaseController extends BaseController{
	@Resource
	private ProcedureService procedureService;
	
	@RequestMapping("/manager")
	public String getList(HttpServletRequest request,HttpServletResponse response,Model model){
		//request.setAttribute("listData", procedureDepartmentService.getList());
		model.addAttribute("listData", procedureService.getList());
		return "procedureBase/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "procedureBase/add";
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
		return"redirect:/procedureBase/manager";
		
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request){
		String id= request.getParameter("id");
		Procedure procedure = procedureService.getProcedureById(Integer.parseInt(id));
		request.setAttribute("procedure", procedure);
		return "procedureBase/update";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String id =  request.getParameter("id");
		String name =  request.getParameter("name");
		Procedure procedure = procedureService.getProcedureById(Integer.parseInt(id));
		procedure.setName(name);
		procedureService.updateProcedure(procedure);
		return"redirect:/procedureBase/manager";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		procedureService.deleteProcedure(Integer.parseInt(id));
		return "redirect:/procedureBase/manager";
	}
	
	@RequestMapping("/toDetail")
	public String toDetail(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		List<ProcedureDepartment> procedureDepartments =procedureService.getProcedureDepartmentList(1);
		List<ProcedureDepartment> sorts = procedureService.getProcedureDepartmentByProcedureId(id);
		request.setAttribute("procedureDepartments", procedureDepartments);
		request.setAttribute("sorts", sorts);
		request.setAttribute("id", id);
		return "/procedureBase/detail";
	}
	
	@RequestMapping("/updateDetail")
	public String updateDetai(HttpServletRequest request){
		Map<String,String[]> map = request.getParameterMap();
		int procedureId = Integer.parseInt(request.getParameter("procedureId"));
		procedureService.deleteProcedureDepartmentByProcedureId(procedureId);
		procedureService.saveProcedureDetail(map, procedureId);
		return "redirect:/procedureBase/toDetail?id="+procedureId;
	}
}
