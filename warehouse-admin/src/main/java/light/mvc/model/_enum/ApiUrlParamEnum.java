package light.mvc.model._enum;

public enum ApiUrlParamEnum {
	name("name"),
	password("password")
	;
	
	private String paramName;
	
	ApiUrlParamEnum(String name){
        this.paramName = name;
    }

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	@Override
	public String toString() {
		return this.paramName;
	}
}
