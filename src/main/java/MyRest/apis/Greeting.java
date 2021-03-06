package MyRest.apis;


//@Entity
public class Greeting {

    private  long id;
    private  String content;
    
    
    public Greeting() {
        System.out.println("calling constructor");
    }
    
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
        
    }
    
    public void setId(long id){
    	this.id = id;
    	
    	System.out.println("calling setter");
    }
    
    public void setContent(String content){
    	this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", content=" + content + "]";
	}
    
    
}

