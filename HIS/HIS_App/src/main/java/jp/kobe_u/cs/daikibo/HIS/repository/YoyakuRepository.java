package jp.kobe_u.cs.daikibo.HIS.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;

@Repository
public interface YoyakuRepository extends CrudRepository<Yoyaku, Long>{  
    public List<Yoyaku> findByDate(Date date);
    public Iterable<Yoyaku> findByDateAndBreakfast(LocalDate date, boolean breakfast);
    public Iterable<Yoyaku> findByDateAndClean(LocalDate date, int roomNumber);




}
