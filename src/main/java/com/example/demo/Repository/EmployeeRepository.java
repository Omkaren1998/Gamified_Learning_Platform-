

package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
	//User findByUsername(String empName);
		 @Query("{'empEmail': ?0, 'password': ?1}")
		   Optional<Employee> findByEmpEmailAndPassword(String empEmail, String password);
		Employee findByEmpEmail(String empEmail); 
		Employee findByEmpId(int empId);
		Employee findByEmpIdOrEmpEmail(int empId, String empEmail);
		void deleteByEmpId(int empId);
		
}
