package light.mvc.controller.warehouse;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import light.mvc.framework.web.BaseController;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.ProcedureDepartmentService;

@Controller
@RequestMapping("/procedureDepartment")
public class ProcedureDepartmentController extends BaseController{
	
	@Resource
	private ProcedureDepartmentService procedureDepartmentService;
	
	@RequestMapping("/manager")
	public String getList(HttpServletRequest request,HttpServletResponse response,Model model){
		//request.setAttribute("listData", procedureDepartmentService.getList());
		model.addAttribute("listData", procedureDepartmentService.getList());
		return "procedureDepartment/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "procedureDepartment/add";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		String name = request.getParameter("name");
		String charge = request.getParameter("charge");
		ProcedureDepartment department = new ProcedureDepartment();
		department.setCharge(charge);
		department.setName(name);
		department.setCompanyId(1);
		department.setCreateTime(new Date());
		department.setStatus(1);
		procedureDepartmentService.save(department);
		return"redirect:/procedureDepartment/manager";
		
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request){
		String id= request.getParameter("id");
		ProcedureDepartment department = procedureDepartmentService.getProcedureDepartmentById(Integer.parseInt(id));
		request.setAttribute("department", department);
		return "procedureDepartment/update";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String id =  request.getParameter("id");
		String name =  request.getParameter("name");
		String charge =  request.getParameter("charge");
		ProcedureDepartment department = procedureDepartmentService.getProcedureDepartmentById(Integer.parseInt(id));
		department.setName(name);
		department.setCharge(charge);
		procedureDepartmentService.updateProcedureDepartment(department);
		return"redirect:/procedureDepartment/manager";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {

		String id = request.getParameter("id");
		procedureDepartmentService.deleteProcedureDepartment(Integer.parseInt(id));
		return "redirect:/procedureDepartment/manager";
	}
}
