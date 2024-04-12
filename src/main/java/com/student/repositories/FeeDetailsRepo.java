package com.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entities.FeeDetails;

@Repository
public interface FeeDetailsRepo extends JpaRepository<FeeDetails, Long> {

}
