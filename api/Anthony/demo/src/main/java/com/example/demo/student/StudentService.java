package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo1.Student;
import com.example.demo1.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private Long studentId;
	private String name;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {

		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {

		Boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("student with id" + studentId + "does not exists");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email)

	{
		this.studentId = studentId;
		this.name = name;

		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("student with id" + studentId + "does not exists"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

			Optional<Student> studuentOptional = studentRepository.findStudentByEmail(email);

			
			if (studuentOptional.isPresent()) { 
				 throw new IllegalStateException("email taken");
			}			 
			student.setEmail(email);
		}
	}
}
