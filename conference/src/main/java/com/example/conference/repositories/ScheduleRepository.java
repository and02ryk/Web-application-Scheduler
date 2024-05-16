package com.example.conference.repositories;

import com.example.conference.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // Получение расписания докладов в одной аудитории по id
    @Query("select s from Schedule s where s.room.id = :roomId")
    List<Schedule> findByRoomId(@Param("roomId") long roomId);
}
