<%@ page trimDirectiveWhitespaces="true" %> 
<%@page import="com.alibaba.fastjson.JSONObject"%>
<%-- <%@page import="com.frogs.system.util.RecordStatusEnum"%>
<%@page import="com.frogs.system.util.DataShowTypeEnum"%>
<%@page import="com.frogs.system.util.DataTypeInfoEnum"%>
<%@page import="com.frogs.system.util.DataTypeLevelEnum"%>
<%@page import="com.frogs.system.util.MeasureDataTypeEnum"%> --%>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="com.frogs.framework.web.filter.SpringWebContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.*,java.io.*,java.text.*,java.net.*,com.frogs.system.util.*" %>
<%@ page import="com.frogs.framework.web.*,com.frogs.framework.util.* , com.frogs.framework.exception.*,com.frogs.framework.component.cache.*,com.frogs.system.util.*" %>
<%@ page import="com.frogs.framework.util.StringUtil"%>
<%@ page import="com.frogs.framework.util.PageTurn" %>
<%@ page import="com.frogs.datacenter.util.*"%>
<%@ page import="com.frogs.datacenter.entity._enum.*"%>
<%@ page import="com.frogs.datacenter.service.impl.scheduledTasks.*"%>
<%@ page import="com.frogs.api.wechat.util.*"%>
<%@ page import="com.frogs.datacenter.util.*" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hdc" uri="https://w.frogshealth.com/el" %>
<%@ page isELIgnored="false" %>
<%
	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
	String path = request.getContextPath();
	//String serverDomain = "https://w.frogshealth.com";
	
	String serverDomain =  SystemBaseConstants.domainName;
	String defaultImages = "https://static.frogshealth.com/static/images/img_pic10.jpg";
	request.setAttribute("EQUIPMENT_OWNER_MINE", EquipmentOwnerEnum.MINE.getId());
	request.setAttribute("EQUIPMENT_OWNER_OTHER", EquipmentOwnerEnum.OTHER.getId());
	request.setAttribute("CONFIG_OWNER_MINE", ConfigOwnerEnum.MINE.getId());
	request.setAttribute("CONFIG_OWNER_OTHER", ConfigOwnerEnum.OTHER.getId());
	request.setAttribute("timeStamp",Long.toString(System.currentTimeMillis() / 1000));
	request.setAttribute("noncestr",UUID.randomUUID().toString());
	request.setAttribute("appsecret",BaseWechatUtil.APPSECRET);
	request.setAttribute("appId",BaseWechatUtil.APPID);
	request.setAttribute("time",new Date().getTime());
	request.setAttribute("bpRemark", BloodPressureLevelEnum.listAllRemarks());
	request.setAttribute("bpLevelMap", BloodPressureLevelEnum.listAllTypes());
	request.setAttribute("crowdTypeMap", CrowdTypeEnum.listAllTypes());
	request.setAttribute("testMomentMap", TestMomentEnum.listAllTypes());
	request.setAttribute("bgLevelMap", BloodGlucoseLevelEnum.listAllTypes());
	request.setAttribute("bgRemarkMap", BloodGlucoseLevelEnum.listAllRemarks());
	request.setAttribute("ALERTCONFIG_TEST", HdcAlertTypeEnum.MESSAGE_ALERT_TYPE_FAMILY_TEST.getId());
	request.setAttribute("ALERTCONFIG_UNEQUIPMENT", HdcAlertTypeEnum.MESSAGE_ALERT_TYPE_UNEQUIPMENT_EXCEPTION.getId());
	request.setAttribute("ALERTCONFIG_EXCEPTION", HdcAlertTypeEnum.MESSAGE_ALERT_TYPE_FAMILY_EXCEPTION.getId());
	request.setAttribute("taskCompleteStatusMap", JSONObject.toJSON(FormSelectLoader.getTaskCompleteStatusMap()));
	request.setAttribute("ALLTIME", DataShowTypeEnum.ALLTIME.getId());
	request.setAttribute("DAYTIME", DataShowTypeEnum.DAYTIME.getId());
	request.setAttribute("NIGHT", DataShowTypeEnum.NIGHT.getId());
	request.setAttribute("weightLevelMap", WeightLevelEnum.listAllTypes());
	
	request.setAttribute("CLOUD_SERVICE", RecordModeEnum.CLOUD_SERVICE.getId());
	
	request.setAttribute("BLOOD_GLUCOSE", MeasureDataTypeEnum.BLOOD_GLUCOSE.getId());
	request.setAttribute("BLOOD_PRESSURE", MeasureDataTypeEnum.BLOOD_PRESSURE.getId());
	request.setAttribute("DATATYPEMAP", DataTypeInfoEnum.listAllTypes());
	request.setAttribute("DATATYPEMAPSTR", JSONObject.toJSONString(DataTypeInfoEnum.listAllTypes()));
	request.setAttribute("BLOOD_PRESSURE_TYPE", DataTypeInfoEnum.BLOOD_PRESSURE.getId());
	request.setAttribute("BLOOD_GLUCOSE_TYPE", DataTypeInfoEnum.BLOOD_GLUCOSE.getId());
	request.setAttribute("WEIGHT_TYPE", DataTypeInfoEnum.WEIGHT.getId());
	
	request.setAttribute("TYPE_1_DIABETES", CrowdTypeEnum.TYPE_1_DIABETES.getId());
	request.setAttribute("TYPE_2_DIABETES", CrowdTypeEnum.TYPE_2_DIABETES.getId());
	request.setAttribute("GESTATIONAL_DIABETES", CrowdTypeEnum.GESTATIONAL_DIABETES.getId());
	request.setAttribute("NON_DIABETES", CrowdTypeEnum.NON_DIABETES.getId());
	
	request.setAttribute("LIMOSIS", TestMomentEnum.LIMOSIS.getId());
	request.setAttribute("BEFORE_DINING", TestMomentEnum.BEFORE_DINING.getId());
	request.setAttribute("AFTER_MEAL_TWO_HOUR", TestMomentEnum.AFTER_MEAL_TWO_HOUR.getId());
	request.setAttribute("BEFORE_SLEEP", TestMomentEnum.BEFORE_SLEEP.getId());
	request.setAttribute("RANDOM", TestMomentEnum.RANDOM.getId());
	
	request.setAttribute("FINISH", TaskCompleteStatusEnum.FINISH.getId());
	request.setAttribute("COMPLETED", TaskCompleteStatusEnum.COMPLETED.getId());
	
	request.setAttribute("ATTENTION_FOLLOWED_LIST", HdcAttentionListTypeEnum.ATTENTION_FOLLOWED_LIST.getId());
	request.setAttribute("ATTENTION_FOLLOWED_AND_REQUEST_LIST", HdcAttentionListTypeEnum.ATTENTION_FOLLOWED_AND_REQUEST_LIST.getId());
	request.setAttribute("ATTENTION_FOLLOW_AND_RECOMMEND_LIST", HdcAttentionListTypeEnum.ATTENTION_FOLLOW_AND_RECOMMEND_LIST.getId());
	
	request.setAttribute("ATTENTION_STATUS_AGREED", AttentionStateEnum.ATTENTION_STATUS_AGREED.getId()); 
	request.setAttribute("ATTENTION_STATUS_REFUSED", AttentionStateEnum.ATTENTION_STATUS_REFUSED.getId());
	
	request.setAttribute("REGISTER_HOSPITAL_LEVEL", JSONObject.toJSONString(RegisterHospitalEnum.listAllRegisterHospital())); 
	request.setAttribute("REGISTER_DOC_LEVEL", JSONObject.toJSONString(RegisterDocLevelEnum.listAllRegisterDocLevel())); 
	request.setAttribute("REGISTER_YY_STATUS", JSONObject.toJSONString(RegisterYYStatusEnum.listAllRegisterYYstatus()));

	
	request.setAttribute("PAYTYPE_MEINIAN", WxPayTypeEnum.MEINIAN.getId()); 
	request.setAttribute("PAYTYPE_JIUYI160", WxPayTypeEnum.JIUYI160.getId());
	request.setAttribute("PAYTYPE_WEIXINRED", WxPayTypeEnum.WEIXINRED.getId());
	request.setAttribute("PAYTYPE_SEEDUSER", WxPayTypeEnum.SEED_USER.getId());
	request.setAttribute("PAYTYPE_WAMING", WxPayTypeEnum.WAMING.getId());

	
	request.setAttribute("BLOOD_GLUCOSE_STATUS_MAP", DataTypeLevelEnum.listBloodGlucoseStatus());
	request.setAttribute("BLOOD_PRESSURE_STATUS_MAP", DataTypeLevelEnum.listBloodPressureStatus());
	request.setAttribute("PARTNER_ORDER_STATUS_MAP_JSON", JSONObject.toJSONString(PartnerOrderStatusEnum.listAllTypes()));
	
	request.setAttribute("CHANNEL_CODE_MASS", OperationLogEnum.CHANNEL_CODE_MASS.getType());
	request.setAttribute("CHANNEL_CODE_SINGLE", OperationLogEnum.CHANNEL_CODE_SINGLE.getType() );
	request.setAttribute("MESSAGE_TYPE_INVENT", MessageTypeEnum.MESSAGE_TYPE_INVITE.getType());
	
	request.setAttribute("ACTION_TYPE_SHAER", OperationActionTypeEnum.ACTION_TYPE_SHAER.getType());
	request.setAttribute("MESSAGE_TYPE_SHAER", MessageTypeEnum.MESSAGE_TYPE_SHAER.getType());
	request.setAttribute("OPERATION_CHANNEL_WAMING", OperationChannelEnum.OPERATION_CHANNEL_WAMING.getType());
	request.setAttribute("URL_TYPE_MESSAGE", OperationUrlTypeEnum.URL_TYPE_MESSAGE.getType());
%>

<c:set var="CONTEXT_PATH" value="<%=request.getContextPath() %>"/>
<c:set var="DEFAULT_IMG_PATH" value="<%=defaultImages %>"/>
<c:set var="HDC_DOMAIN" value="<%=serverDomain %>" />
<c:set var="STATIC_PATH" value="/static" />
<c:set var="staticRSC" value="<%=UpdateJsTask.getMap()%>"/>
<c:set var="RECORD_NORMAL" value="<%=RecordStatusEnum.NORMAL.getId() %>"/>
<c:set var="RECORD_DELETED" value="<%=RecordStatusEnum.DELETED.getId() %>"/>
<c:set var="sexMap" value="<%=FormSelectLoader.getSexMap()%>"/>
<c:set var="defaultImages" value="<%=defaultImages%>"></c:set>
<c:set var="DEFAULT_GOODS_IMG" value="https://img.frogshealth.com/img/default/img_pic180x180.jpg"></c:set>
<%-- <c:set var="W_DOMAIN" value="//w.frogshealth.com"></c:set> --%>
<c:set var="W_DOMAIN" value="<%=serverDomain %>"></c:set>
<c:set var="IMG_DOMAIN" value="//img.frogshealth.com"></c:set>
<c:set var="STATIC_DOMAIN" value="//static.frogshealth.com"></c:set>