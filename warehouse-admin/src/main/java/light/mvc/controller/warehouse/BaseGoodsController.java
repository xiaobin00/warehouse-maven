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
import light.mvc.model.basic.BaseGoodsInfo;
import light.mvc.model.basic.Procedure;
import light.mvc.model.basic.ProcedureDepartment;
import light.mvc.service.warehouse.GoodsService;
import light.mvc.service.warehouse.ProcedureService;

@Controller
@RequestMapping("/goods")
public class BaseGoodsController extends BaseController{
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/manager")
	public String getList(HttpServletRequest request,HttpServletResponse response,Model model){
		//request.setAttribute("listData", procedureDepartmentService.getList());
		model.addAttribute("listData", goodsService.getList(1));
		return "goods/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "goods/add";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request){
		String name = request.getParameter("name");
		BaseGoodsInfo baseGoods = new BaseGoodsInfo();
		baseGoods.setName(name);
		baseGoods.setCompanyId(1);
		baseGoods.setCreateTime(new Date());
		baseGoods.setStatus(1);
		goodsService.save(baseGoods);
		return"redirect:/goods/manager";
		
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest request){
		String id= request.getParameter("id");
		BaseGoodsInfo goods = goodsService.getGoodsById(Integer.parseInt(id));
		request.setAttribute("goods", goods);
		return "goods/update";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String id =  request.getParameter("id");
		String name =  request.getParameter("name");
		BaseGoodsInfo goods = goodsService.getGoodsById(Integer.parseInt(id));
		goods.setName(name);
		goodsService.updateGoods(goods);
		return"redirect:/goods/manager";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {

		String id = request.getParameter("id");
		goodsService.deleteGoods(Integer.parseInt(id));
		return "redirect:/goods/manager";
	}
	
}
