package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeQuizzData;

@Repository
public interface EmployeeQuizzDataRepository extends MongoRepository<EmployeeQuizzData, String> {

	EmployeeQuizzData findByEmpId(int empId);
	List<EmployeeQuizzData> findByDept(String dept, Pageable pageable);
	EmployeeQuizzData deleteByEmpId(int empId);
	List<EmployeeQuizzData> findByDept(String dept);
}
