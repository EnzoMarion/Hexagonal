package com.example.demo.fleet.api.models.repositories;

import com.example.demo.fleet.api.models.entities.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff,Long> {}
