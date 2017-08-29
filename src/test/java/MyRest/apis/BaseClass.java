package MyRest.apis;


import org.json.JSONObject;

public class BaseClass {
	
	JSONObject createJsonObj = new JSONObject();
	private String appd_appname;
	Plan plan;
	
	BaseClass(){
		
		createJsonObj.put("service_id", "predix-appd");
		createJsonObj.put("organization_guid", "predix_nonprod");
		createJsonObj.put("space_guid", "asset");
	}
	
	public JSONObject createCatalogObject() {

		JSONObject jsonObj = new JSONObject();

		String[] tags = { "apm", "instrumentation" };
		String[] requires = { "route_forwarding" };

		jsonObj.put("id", "predix-appd");
		jsonObj.put("name", "predix-appd");
		jsonObj.put("description", "predix apm appd");
		jsonObj.put("tags", tags);
		jsonObj.put("bindable", true);
		jsonObj.put("plan_updateable", true);
		jsonObj.put("requires", requires);

		return jsonObj;
	}

	public JSONObject pocPlanObject() {

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("id", "poc");
		jsonObj.put("name", "poc");
		jsonObj.put(
				"description",
				"For Non prod env's mainly for POC purpose. All features are enabled for trial usage");
		jsonObj.put("account_name", "gedigital");
		jsonObj.put("account_accessKey", "aac2ce8e8042");
		jsonObj.put("cassandaEnabled", true);
		jsonObj.put("host_name", "gedigital.saas.appdynamics.com");
		jsonObj.put("port", 443);
		jsonObj.put("ssl_enabled", true);

		return jsonObj;
	}

	public JSONObject testPlanObject() {

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("id", "predix-test");
		jsonObj.put("name", "predix-test");
		jsonObj.put("description",
				"For Non prod env's like Dev,Sysint,Performance etc");
		jsonObj.put("account_name", "predix-test");
		jsonObj.put("account_accessKey", "kh47hq72uzwp");
		jsonObj.put("cassandaEnabled", true);
		jsonObj.put("host_name", "predixtest.saas.appdynamics.com");
		jsonObj.put("port", 443);
		jsonObj.put("ssl_enabled", true);

		return jsonObj;
	}

	public JSONObject prodPlanObject() {

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("id", "predix-prod");
		jsonObj.put("name", "predix-prod");
		jsonObj.put("description", "For prod env's");
		jsonObj.put("account_name", "predix-prod");
		jsonObj.put("account_accessKey", "0bgofpg7xwhx");
		jsonObj.put("cassandaEnabled", true);
		jsonObj.put("host_name", "predixprod.saas.appdynamics.com");
		jsonObj.put("port", 443);
		jsonObj.put("ssl_enabled", true);

		return jsonObj;
	}

	public JSONObject createServiceObj(String appd_appname, Plan plan) {

		JSONObject paramjsonObj = new JSONObject();
		paramjsonObj.put("appd_appname", appd_appname);
		createJsonObj.put("plan_id", plan.getPlanId());
		createJsonObj.put("parameters", paramjsonObj);
		
		return createJsonObj;
	}
	
	public JSONObject getCreateServiceObj(){
		
		return createJsonObj; 
	}
	
	public JSONObject updateCreateServiceObj(String appd_appname, Plan plan) {

		JSONObject jsonObjOrg = getCreateServiceObj();
		JSONObject jsonObjToUpdate = getCreateServiceObj();
		
		JSONObject paramjsonObjUpdated = new JSONObject();
		paramjsonObjUpdated.put("appd_appname", appd_appname);
		
		jsonObjToUpdate.put("parameters", paramjsonObjUpdated);
		jsonObjToUpdate.put("plan_id", plan.getPlanId());
		
		jsonObjToUpdate.put("previous_values", jsonObjOrg);
		
		return jsonObjToUpdate;
	}
	
	public JSONObject bindServiceObj(String app_guid) {

		JSONObject bindResourcejsonObj = getCreateServiceObj();

		bindResourcejsonObj.remove("appd_appname");
		bindResourcejsonObj.remove("parameters");
		bindResourcejsonObj.put("bind_resource", bindResourcejsonObj);
		bindResourcejsonObj.put("app_guid", app_guid);

		return bindResourcejsonObj;
	}

}
