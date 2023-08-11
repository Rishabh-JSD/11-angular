package com.example.myfirst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
	
	@Autowired
	 private  studentRepo strepo;
	 
	 
	    public student savestudent(student student) {
	        return strepo.save(student);
	    }

	    public List<student> savestudents(List<student> students) {
	        return strepo.saveAll(students);
	    }

	    public List<student> getstudents(){
	        return strepo.findAll();
	    }

	    public student getstudentById(int id){
	        return strepo.findById(id).orElse(null);
	    }

	    public student getstudentByName(String name ){
	        return strepo.findByName(name);
	    }

	    public String deletestudent(int id){
	        strepo.deleteById(id);
	        return "Product Deleted || "+id;
	    }

	    public student updatestudent(student student ){
	        student existingstudent=strepo.findById(student.getId()).orElse(null);
	        existingstudent.setName(student.getName());
	        existingstudent.setEmail(student.getEmail());
	        existingstudent.setPassword(student.getPassword());
	        return strepo.save(existingstudent);

	    }

		
	}
