package com.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entities.EducationDetails;

@Repository
public interface EducationDetailsRepo extends JpaRepository<EducationDetails, Long> {

}
