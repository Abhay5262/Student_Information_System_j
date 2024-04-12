package com.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entities.Administartor;

@Repository
public interface AdministartorRepo extends JpaRepository<Administartor, Long> {


}
