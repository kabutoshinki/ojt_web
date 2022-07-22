package com.swp.swp.repositories;

import com.swp.swp.model.Company;
import com.swp.swp.model.Student;
import com.swp.swp.model.StudentApplyJob;
import org.springframework.data.jpa.repository.JpaRepository;

import com.swp.swp.model.OjtProcess;

public interface OjtProcessRepositories extends JpaRepository<OjtProcess, Integer> {
    OjtProcess findById(int id);

    Iterable <OjtProcess> findByStudent(Student student);
    //Iterable <OjtProcess> findByCompany(Company company);
    OjtProcess findByApplication(StudentApplyJob application);
}
