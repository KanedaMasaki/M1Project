package jp.kobe_u.cs.daikibo.HIS.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.HIS.controller.YoyakuForm;
import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;
import jp.kobe_u.cs.daikibo.HIS.repository.YoyakuRepository;

@Service
public class YoyakuService {
    @Autowired
    YoyakuRepository repo; // レポジトリ

    // //予約登録
    // public Yoyaku postYoyaku(Yoyaku y) {
    // return repo.save(y);
    // }

    // 予約情報変更
    public Yoyaku changeYoyaku(Yoyaku y, LocalDateTime bft, boolean c) {
        Yoyaku changed = y;
        repo.deleteById(y.getId());
        // changed.getBreakfastTime= bft;
        return repo.save(changed);
    }

    // // 予約を日付指定で取得
    // public ArrayList<Yoyaku> getAllYoyaku() {
    // LocalDate date = LocalDate.now();
    // Iterable<Yoyaku> yoyaku = repo.findByDate(date);
    // ArrayList<Yoyaku> list = new ArrayList<>();
    // yoyaku.forEach(list::add);
    // return list;
    // }

    // // 日付別掃除リスト取得
    // public List<Yoyaku> getAllCleanList(int roomNumber) {
    // LocalDate date = LocalDate.now();
    // Iterable<Yoyaku> clean = repo.findByDateAndClean(date, roomNumber);
    // ArrayList<Yoyaku> list = new ArrayList<>();
    // clean.forEach(list::add);
    // return list;
    // }

    // // 日付別朝食食べる人リスト取得
    // public List<Yoyaku> getAllBreakfastList(boolean breakfast) {
    // LocalDate date = LocalDate.now();
    // Iterable<Yoyaku> breakfastList = repo.findByDateAndBreakfast(date,
    // breakfast);
    // ArrayList<Yoyaku> list = new ArrayList<>();
    // breakfastList.forEach(list::add);
    // return list;
    // }

    public Yoyaku createYoyaku(YoyakuForm form) {

        LocalDate checkInDateInput = LocalDate.parse(form.getCheckInDateInput());

        // ユーザをDBに登録し、登録したユーザの情報を戻り値として返す
        return repo.save(new Yoyaku(
                null,
                form.getName(),
                checkInDateInput,
                // form.getStayDays(),
                form.getEmail(),
                form.isBreakfast(),
                null,
                false));
    }

}