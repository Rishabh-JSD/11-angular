package com.example.myfirst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class studentController {
@Autowired
	private studentService ds;

	public studentController(studentService ds) {
		this.ds = ds;
	}

	@PostMapping("/addstudent")
	public student addstudent(@RequestBody student student) {
		return ds.savestudent(student);
	}

	@PostMapping("/addstudents")
	public List<student> addstudents(@RequestBody List<student> student) {
		return ds.savestudents(student);
	}

	@GetMapping("/students")
	public List<student> findAllstudents() {
		return ds.getstudents();
	}

	@GetMapping("/studentbyid/{id}")
	public student findstudentById(@PathVariable int id) {
		return ds.getstudentById(id);
	}

	@GetMapping("/studentbyname/{name}")
	public student findstudentByName(@PathVariable String name) {
		return ds.getstudentByName(name);
	}

	@PutMapping("/update")
	public student updatestudent(@RequestBody student student) {
		return ds.updatestudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deletestudent(@PathVariable int id) {
		return ds.deletestudent(id);
	}

}