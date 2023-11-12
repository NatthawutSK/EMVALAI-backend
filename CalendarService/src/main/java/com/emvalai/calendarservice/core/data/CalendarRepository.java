package com.emvalai.calendarservice.core.data;

import com.emvalai.calendarservice.core.data.CalendarEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends MongoRepository<CalendarEntity, String> {

    @Query(value="{userId:'?0'}")
    public List<CalendarEntity> findByUserId(String userId);

//    @Query(value="{userId:'?0'}")
//    public List<CalendarEntity> findUserByRole(String userId);
}
