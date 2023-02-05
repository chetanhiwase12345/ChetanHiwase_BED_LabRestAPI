package com.greatlearning.studentregistrationapplication.service;

import java.util.List;
import com.greatlearning.studentregistrationapplication.model.Student;

public interface StudentService {
	
	//Insert new records into the table.
	public void saveRecord(Student student);
	
	//Update existing records into the table.
	//Delete existing records from the table.
	
	//Print all records from the table.
	public List<Student> getAllStudent();
	//Add a security layer where there will be two roles USER, ADMIN.
	//Admin will have the privilege of performing all the operations.
	//User can view/save the details.
	public Student getStudentById(int id);
	public void deleteStudentById(int id);
	public void saveOrUpdate(Student student);

}
