package com.emvalai.leaveservice.repository;

import com.emvalai.leaveservice.model.LeaveInfoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends MongoRepository<LeaveInfoModel, String> {
    @Query(value="{leave_id:'?0'}")
    public LeaveInfoModel findByLeaveId(int leave_id);
}
