package com.greatlearning.studentregistrationapplication.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.studentregistrationapplication.model.Student;
import com.greatlearning.studentregistrationapplication.repository.StudentRepository;
import com.greatlearning.studentregistrationapplication.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
StudentRepository studentrepo;
	@Override
	public void saveRecord(Student student) {
		// TODO Auto-generated method stub
		studentrepo.save(student);
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}
	
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id).get();
	}
	
	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		studentrepo.deleteById(id);
	}
	
	@Override
	public void saveOrUpdate(Student student) {
		// TODO Auto-generated method stub
		studentrepo.save(student);
	}

}
