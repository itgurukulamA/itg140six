package com.example.demo.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jdbcTemplateController {
	@Autowired
	jdbcTemplateService jts;
	
	@PostMapping("/table")
	public String insert1(@RequestBody Jdbc jt) {
		int i=jts.insert(jt);
		if(i>0)
		{
		return ("data set succesfully");
	}
		else {
			return("data not set succefully");
		}
	

}
	
}