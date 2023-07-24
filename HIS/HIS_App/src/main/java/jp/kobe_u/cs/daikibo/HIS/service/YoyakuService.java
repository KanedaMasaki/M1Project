package jp.kobe_u.cs.daikibo.HIS.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;
import jp.kobe_u.cs.daikibo.HIS.repository.YoyakuRepository;

@Service
public class YoyakuService{
    @Autowired 
    YoyakuRepository repo; // レポジトリ

    //予約登録
    public Yoyaku postYoyaku(Yoyaku y) {
        return repo.save(y);
    }

    //予約変更
    public Yoyaku changeYoyaku(Yoyaku y, boolean breakfast, boolean clean){
        Yoyaku change = find(y);
    }

    // 予約を日付指定で取得
    public List<Yoyaku> getAllYoyaku()
    {   
        Date date = new Date();
        Iterable<Yoyaku> yoyaku = repo.findByDate(date);
        ArrayList<Yoyaku> list = new ArrayList<>();
        yoyaku.forEach(list::add);
        return list;
    }

    //日付別掃除リスト取得
    public List<Yoyaku> getAllCleanList(LocalDate date, int roomNumber){
        Iterable<Yoyaku> clean = repo.findByDateAndClean(date, roomNumber);
        ArrayList<Yoyaku> list = new ArrayList<>();
        clean.forEach(list::add);
        return list;
    }

    //日付別朝食食べる人リスト取得
    public List<Yoyaku> getAllBreakfastList(LocalDate date, boolean breakfast){
        Iterable<Yoyaku> breakfastList = repo.findByDateAndBreakfast(date, breakfast);
        ArrayList<Yoyaku> list = new ArrayList<>();
        breakfastList.forEach(list::add);
        return list;
    }


}