package com.bootJpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	private List<Test> testList = Arrays.asList(
			new Test("1","Nishanha"),
			new Test("2","Pradeep")
			);
	
	public List<Test> getAllTest(){
		
		List<Test> test = new ArrayList<>();
		testRepository.findAll()
		.forEach(test::add);
		return test;
	}
	
	public void addTest(Test test) {
		
		testRepository.save(test);
	}
	
	public Test getTest(String id) {
		
			return testList.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	}
}
