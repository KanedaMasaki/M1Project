package jp.kobe_u.cs.daikibo.HIS.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;

@Repository
public interface YoyakuRepository extends CrudRepository<Yoyaku, Long> {
    public Iterable<Yoyaku> findByCheckInDateAndBreakfast(LocalDate checkInDate, boolean breakfast);

    public Iterable<Yoyaku> findByCheckInDateAndClean(LocalDate checkInDate, boolean clean);

    public Iterable<Yoyaku> findByCheckInDateAndBreakfastAndBreakfastTime(LocalDate checkInDate, boolean breakfast,
            LocalDateTime breakfastTime);

}
