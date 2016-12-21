package light.mvc.model._enum;

import java.util.HashMap;
import java.util.Map;

public enum GoodsDealType {
	PURCHASE(1, "购买入库"),
	USE(2, "使用出库"),
	SURPLUS(3, "剩余回库"),
	PRODUCT_IN(4, "成品入库"),
	PRODUCT_OUT(5, "成品出库"),
	;
	int id;
    String name;
    
    GoodsDealType(int id,String name){
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
		GoodsDealType[] enums = values();
		for(GoodsDealType object : enums) {
			typesMap.put(object.getId(), object.getName());
		}
		return typesMap;
	}
}
