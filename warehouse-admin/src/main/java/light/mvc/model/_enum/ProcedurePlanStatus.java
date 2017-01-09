package light.mvc.model._enum;

import java.util.HashMap;
import java.util.Map;

/**
* 生产计划状态
* @author zhenghaibin
* @date 2017年1月5日 下午5:14:26
*/
public enum ProcedurePlanStatus {
	
	PREPARE(0, "待进行"),
	CONDUCT(1, "进行"),
	COMPLETE(2, "完成"),
	OVER(3, "结束"),
	;
	int id;
    String name;
    
    ProcedurePlanStatus(int id,String name){
        this.id = id;
        this.name = name;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static Map<Integer,String> listAllTypes() {
		Map<Integer, String> typesMap = new HashMap<Integer, String>();
		ProcedurePlanStatus[] enums = values();
		for(ProcedurePlanStatus object : enums) {
			typesMap.put(object.getId(), object.getName());
		}
		return typesMap;
	}
}
