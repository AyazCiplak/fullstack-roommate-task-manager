package com.ayaz.roommatesystemapi.repository;

import com.ayaz.roommatesystemapi.entity.RoommateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoommateRepository extends JpaRepository<RoommateEntity, Long> {

}
