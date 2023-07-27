package in.ashokit.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.User;

@RestController
public class UserRestController {
	
	private Map<Integer,User> dataMap = new HashMap<>();
	
	//ResponseEntity is user for Customized response
	//how the data is coming is represented by @RequestBody
	@PostMapping(value ="/user", consumes = {"application/json"})
	public ResponseEntity<String> addUser(@RequestBody User user) {
		
		System.out.println(user);
		dataMap.put(user.getId(), user);
		
		return new ResponseEntity<String>("User Saved",HttpStatus.CREATED);
	}
	/*
	@GetMapping("/user")
	public User getUser(@RequestParam("id")Integer id ,@RequestParam("name")String name) {
		
		User user = dataMap.get(id);
		
		return user;
	}
	*/
	@GetMapping(value ="/user/{id}/data", produces ={"application/json"})
	public User getUser(@PathVariable("id")Integer userId) {
		User user = dataMap.get(userId);
		
		return user;
	}

}
