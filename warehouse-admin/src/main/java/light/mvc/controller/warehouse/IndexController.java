package light.mvc.controller.warehouse;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.Response.DefaultResponse;
import light.mvc.Response.Response;
import light.mvc.framework.web.BaseController;
import light.mvc.request.LoginRequest;
import light.mvc.service.warehouse.IndexService;

@Controller
@RequestMapping("/warehouse")
public class IndexController extends BaseController {
	
	@Autowired
	private IndexService indexService;
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/login")
	public Response login(HttpServletRequest request, Model model,HttpSession session){
		Response response = Response.getSeccess();
		try {
			LoginRequest loginRequest = new LoginRequest();
			loginRequest.parse(request);
			response =  indexService.login(loginRequest);
		} catch (Exception e) {
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[] { Thread.currentThread().getStackTrace()[1].getMethodName(), request, e.getMessage(),
							Arrays.deepToString(e.getStackTrace()) });
			model.addAttribute("tip", "数据有误");
			return response.getError();
		}
		return response;
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model,HttpSession session){
		return "/index";
	}
}
