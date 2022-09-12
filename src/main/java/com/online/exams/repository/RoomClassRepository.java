package com.online.exams.repository;

import com.online.exams.entity.RoomClass;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomClassRepository extends PagingAndSortingRepository<RoomClass, String>, JpaSpecificationExecutor<RoomClass> {
}
