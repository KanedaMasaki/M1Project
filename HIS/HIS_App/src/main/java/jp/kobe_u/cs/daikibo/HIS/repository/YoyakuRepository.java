package jp.kobe_u.cs.daikibo.HIS.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;

@Repository
public interface YoyakuRepository extends CrudRepository<Yoyaku, Long> {
    // public Iterable<Yoyaku> findByDate(LocalDate date);
    // public Iterable<Yoyaku> findByDateAndBreakfast(LocalDate date, boolean
    // breakfast);
    // public Iterable<Yoyaku> findByDateAndClean(LocalDate date, int roomNumber);

}
