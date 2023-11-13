package com.emvalai.leaveservice.repository;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveInfoRepository extends JpaRepository<LeaveInfoModel, Integer> {

}
