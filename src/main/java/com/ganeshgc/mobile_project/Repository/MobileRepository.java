package com.ganeshgc.mobile_project.Repository;

import com.ganeshgc.mobile_project.model.MobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<MobileEntity,Integer> {
}
