package com.bootJpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienController {

	//commented by np
	@Autowired
	private TestService testService;

	List<String> test = new ArrayList<String>();

	/*
	 * @Autowired TestService testService;
	 */

	@RequestMapping("/")
	public String home() {

		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	// @ResponseBody
	public String getAlien() {
		test.add("test1");
		test.add("test2");

		StringBuffer sb = new StringBuffer();

		for (String s : test) {
			sb.append(s);
			sb.append(" ");
		}
		String str = sb.toString();
		System.out.println(str);

		System.out.println("hello");
		return str;
		// return Arrays.asList( new Alien(1,"Admin")).toString();

		// return "home.jsp";

	}

	@RequestMapping("/allAlien")
	// @ResponseBody
	public List<Test> getAllAlien() {

		return Arrays.asList(new Test("1", "Admin"));

		// return "home.jsp";

	}
	
	@RequestMapping("/allTest")
	public List<Test> getAllTest(){
		
		return testService.getAllTest();
	}

	@RequestMapping(method=RequestMethod.POST,value = "/addTest")
	public void getAddTest(@RequestBody Test test){
		
		testService.addTest(test);
	}
	
	@RequestMapping("/getTest/{id}")
	public Test getTest(@PathVariable String id) {
		
		return testService.getTest(id);
	}
	

}
