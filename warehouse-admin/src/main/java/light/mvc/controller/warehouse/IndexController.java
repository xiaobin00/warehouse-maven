package light.mvc.controller.warehouse;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import light.mvc.framework.web.BaseController;
import light.mvc.request.LoginRequest;

@Controller
public class IndexController extends BaseController {
	
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		try {
			LoginRequest loginRequest = new LoginRequest();
			loginRequest.parse(request);
			
		} catch (Exception e) {
			log.error("func[{}] params[{}] exception[{} - {}] desc[fail]",
					new Object[] { Thread.currentThread().getStackTrace()[1].getMethodName(), request, e.getMessage(),
							Arrays.deepToString(e.getStackTrace()) });
			model.addAttribute("tip", "数据有误");
			return "login";
		}
		return "redirect:/index";
	}
}
