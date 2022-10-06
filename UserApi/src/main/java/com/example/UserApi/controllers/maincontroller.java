package com.example.UserApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserApi.entities.User;
import com.example.UserApi.repositories.userrepository;
import com.example.UserApi.services.userservice;

@RestController
public class maincontroller {
	
	@Autowired
	userrepository userRepository;
	@Autowired
	private userservice userService;

	@GetMapping(value="/createaccount")
    public String showCreateAccountPage(ModelMap model){
		return "<html>\n"
		 		+ "<head>\n"
		 		+ "</head>\n"
		 		+ "<body>\n"
		 		+ "	<div>\n"
		 		+ "		<h1>User Create Account Page</h1>\n"
		 		+ "		\n"
		 		+ "		<h2>Welcome</h2>\n"
		 		+ "		\n"
		 		+ "		<br><br>\n"
		 		+ "		<h2\">Login to account</h2>\n"
		 		+ "		</form>"
				+ "     <form method=\"post\" action=\"logi\">\n"
				+ "     <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Name\" required>\n"
				+ "     <input type=\"text\" id=\"password\" name=\"password\" placeholder=\"Password\" required>\n"	
				+ "     <input type=\"submit\" value=\"Enter\" />\n"
			    + "     </form>"
		 		
		 		+ "		<br><br>\n"
				+ "     <form method=\"get\" action=\"login\">\n"
				+ "			<br><h3>Login below:</h3>\n"
				+ "			<input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Name\" required>\n"
				+ "			<input type=\"text\" id=\"email\" name=\"email\" placeholder=\"Email\" required>\n"
				+ "			<input type=\"text\" id=\"password\" name=\"password\" placeholder=\"Password\" required>	\n"
				+ "			<input type=\"submit\" value=\"Enter\" />\n"
				+ "		</form>"
		 		+ "	</div>\n"
		 		+ "</body>\n"
		 		+ "</html>";
		}
	@GetMapping(value="/login")
	public String showLogin(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, ModelMap map) {
        User u = new User(name,email,password);
        userRepository.save(u); 
        
        return "<html>\n"
 		+ "<head>\n"
 		+ "</head>\n"
 		+ "<body>\n"
 		+ "	<div>\n"
 		+ "		<h1>Account created successfully</h1>\n"
 		+ "		\n"
 		
 		+ "		<h2\">Login to account</h2>\n"
 		+ "		</form>"
		+ "     <form method=\"post\" action=\"logi\">\n"
		+ "     <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Name\" required>\n"
		+ "     <input type=\"text\" id=\"password\" name=\"password\" placeholder=\"Password\" required>\n"	
		+ "     <input type=\"submit\" value=\"Enter\" />\n"
	    + "     </form>"
 		+ "	</div>\n"
 		+ "</body>\n"
 		+ "</html>";
    }
	@PostMapping("/logi")
    public String submitLogin(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap modelMap){

    	try {
			 User u = userService.GetUserByName(name);
			 if(u.getName().equals(name) && u.getPassword().equals(password))
		     {
			     return "<html>\n"
			    	 		+ "<head>\n"
			    	 		+ "</head>\n"
			    	 		+ "<body\">\n"
			    	 		+ "	<div\">\n"
			    	 		+ "		<h1>Logged In</h1>\n"
			    	 		+ "		\n"
			    	 		+ "		<h2\">Successfully loggedin</h2>\n"
			    	 		+ "		<a href=\"http://localhost:8081/products\">quiz</a>\n"
			    	 		+ "	</div>\n"
			    	 		+ "</body>\n"
			    	 		+ "</html>";
			 }
			 else 
			 {
				 return "<html>\n"
			    	 		+ "<head>\n"
			    	 		+ "</head>\n"
			    	 		+ "<body\">\n"
			    	 		+ "	<div\">\n"
			    	 		+ "		<h1>Logged In</h1>\n"
			    	 		+ "		\n"
			    	 		+ "		<h2\">wrong name or password</h2>\n"
			    	 		+ "	</div>\n"
			    	 		+ "</body>\n"
			    	 		+ "</html>";
			 }
		 }
		 catch(NullPointerException e) {
			 return "<html>\n"
		    	 		+ "<head>\n"
		    	 		+ "</head>\n"
		    	 		+ "<body\">\n"
		    	 		+ "	<div\">\n"
		    	 		+ "		<h1>Logged In</h1>\n"
		    	 		+ "		\n"
		    	 		+ "		<h2\">wrong exception</h2>\n"
		    	 		+ "	</div>\n"
		    	 		+ "</body>\n"
		    	 		+ "</html>";
		 }
	 



    }

}
