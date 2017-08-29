package MyRest.apis;

public enum Plan{
	POC ("poc"),
	TEST ("predix-test"),
	PROD ("predix-prod");
	
	private String plan_id;
	
	Plan(String plan_id){
		
		this.plan_id = plan_id;
	}
	
	public String getPlanId(){
		
		return this.plan_id;
	}
}
