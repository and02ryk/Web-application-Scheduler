package com.example.conference.repositories;

import com.example.conference.models.Schedule;
import com.example.conference.models.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
    // Проверка на доступность времени для доклада в заданной аудитории
    @Query("SELECT False WHERE exists " +
            "(SELECT 1 FROM Schedule s WHERE " +
            "(:startTime between s.startTime AND s.endTime or :endTime between s.startTime AND s.endTime or s.startTime between :startTime AND :endTime) " +
            "AND s.room.id = :roomId AND s.date = :date)")
    boolean checkAvailability(@Param("roomId") long roomId,
                        @Param("startTime") LocalTime startTime,
                        @Param("endTime") LocalTime endTime,
                        @Param("date") LocalDate date);
//    List<Schedule> findAvailableTimes(@Param("roomId") long roomId,
//                                      @Param("startTime") LocalTime startTime,
//                                      @Param("endTime") LocalTime endTime,
//                                      @Param("date") LocalDate date);
}
