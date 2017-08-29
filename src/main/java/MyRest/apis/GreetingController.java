package MyRest.apis;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GreetingController {

    @RequestMapping("/message")
    public Greeting greeting(@RequestParam(value="name") String name,@RequestParam(value="age") int age) {
    	
    	
        Greeting mygreeting = new Greeting(age,name);
        return mygreeting;
    }
    
    @RequestMapping(value = "/message",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity greeting(@RequestBody Greeting g) {
    	
        System.out.println(g);
        //greetingRepository.
        return new ResponseEntity(g, HttpStatus.OK);
    }
    
    @RequestMapping("/status")
    public String greet() {
    	
        return "hello";
        
    }
    
    @RequestMapping(value = "/createUser",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity createUser(@RequestBody  Map<String, Object> payload) {
    	
        System.out.println(payload);
        payload.put("name", "xyz");
        String json=null;
		try {
			json = new ObjectMapper().writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(json);
        //greetingRepository.
        return new ResponseEntity(json, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/generateNumber",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity generateNumber() {
    	
        Random rand = new Random();
        Integer value = rand.nextInt(100);
        Map<String,Integer> payload = new HashMap<>();
        payload.put("number",value);

        String json=null;
		try {
			json = new ObjectMapper().writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(json);
        //greetingRepository.
        return new ResponseEntity(json, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/advice",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity advice (@RequestBody Map<String,String> healthcare) {
    	
        System.out.println(healthcare);
        healthcare.put("name", "anisha");
        healthcare.put("provider", "bluecross");
        healthcare.put("plan", "Gold");
        
        String json = null;
        try {
			json = new ObjectMapper().writeValueAsString(healthcare);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(json);
        
        
        //greetingRepository.
        return new ResponseEntity(json, HttpStatus.OK);
    
    }  
    
    
}



