package light.mvc.service.warehouse.impl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import light.mvc.request.ProcedurePlanUpdateRequest;




/**
* 流程执行aop
* @author zhenghaibin
* @date 2017年1月12日 下午5:25:01
*/
@Aspect
@Service("procedureAopImpl")
public class ProcedureAopImpl {
	private static final Logger log = LoggerFactory.getLogger(ProcedureAopImpl.class);
	
	@Async
	@AfterReturning(pointcut="execution(* light.mvc.service.warehouse.impl.ProcedureServiceImpl.updateProcedurePlanInfo(..))")
	public void doAfterSendNotice(JoinPoint jp){
		ProcedurePlanUpdateRequest planUpdateRequest = (ProcedurePlanUpdateRequest)jp.getArgs()[0];//切入点方法入参

	}
}
