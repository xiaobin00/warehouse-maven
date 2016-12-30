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
import light.mvc.model.basic.GoodsRecordInfo;
import light.mvc.request.GoodsRecordAddRequest;
import light.mvc.request.GoodsRecordGetRequest;
import light.mvc.service.warehouse.GoodsService;
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request,Model model){
		GoodsRecordGetRequest getRequest = new GoodsRecordGetRequest();
		getRequest.parse(request);
		try {
			List<GoodsRecordInfo> infos = goodsService.getGoodsRecordInfos(getRequest);
			model.addAttribute("listData", infos);
		} catch (Exception e) {
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[]{Thread.currentThread().getStackTrace()[1].getMethodName(),request,e.getMessage(), Arrays.deepToString(e.getStackTrace())});
			model.addAttribute("tip", "系统异常");
		}
		return "goods/manager";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd(HttpServletRequest request,Model model){
		int companyId = 1;
		List<BaseGoodsInfo> baseGoodsInfos = goodsService.getBaseGoodsInfos(companyId);
		model.addAttribute("baseGoodsInfos", baseGoodsInfos);
		model.addAttribute("parentId",request.getParameter("parentId"));
		return "goods/add";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		int companyId = 1;
		try{
			GoodsRecordAddRequest addRequest = new GoodsRecordAddRequest();
			addRequest.parse(request);
			goodsService.saveGoodsRecordInfos(addRequest);
		}catch(Exception e){
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[]{Thread.currentThread().getStackTrace()[1].getMethodName(),request,e.getMessage(), Arrays.deepToString(e.getStackTrace())});
			model.addAttribute("tip", "添加数据有误");
			List<BaseGoodsInfo> baseGoodsInfos = goodsService.getBaseGoodsInfos(companyId);
			model.addAttribute("baseGoodsInfos", baseGoodsInfos);
			return "goods/add";
		}
		return "redirect:/goods/manager";
	}
	
}
