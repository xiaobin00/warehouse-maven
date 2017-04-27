package light.mvc.model._enum;

public enum ApiResultEnum {
	SUCCESS(1,"请求成功"),
	FAIL(0,"请求失败"),
	RESULT_EMPTY(2,"查询结果为空"),
	REPETITIVE_OPERATION(3, "重复操作"),
	NO_ACCOUNT(1001,"无此用户"),
	ERROR_PWD(1002,"密码错误");
	
    
	private int id;
    private String name;
    ApiResultEnum(int id,String name){
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
	public static String valueOf(int value){
		for(ApiResultEnum inst : values()){
			if(value == inst.id)
				return inst.getName();
		}
		throw new IllegalArgumentException("不支持的常量：" + value);
	}
}
