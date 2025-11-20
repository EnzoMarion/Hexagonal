package com.example.demo.fleet.infrastructure.repositories;

import com.example.demo.fleet.domain.models.entities.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff,Long> {}
