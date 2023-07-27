package jp.kobe_u.cs.daikibo.HIS.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    
    // 当日の飲食を取っていてなおかつ朝食の時間が確定しているリスト取得
    public ArrayList<Yoyaku> getBreakfastTrue() {
        LocalDate date = LocalDate.now();
        Iterable<Yoyaku> breakfastList = repo.findByCheckInDateAndBreakfast(date, true);
        ArrayList<Yoyaku> list = new ArrayList<>();
        breakfastList.forEach(list::add);
        return list;
    }

    // 当日の掃除をしていない人のリストを取ってくる
    public ArrayList<Yoyaku> getCleanFalse() {
        LocalDate date = LocalDate.now();
        Iterable<Yoyaku> cleanList = repo.findByCheckInDateAndClean(date, false);
        ArrayList<Yoyaku> list = new ArrayList<>();
        cleanList.forEach(list::add);
        return list;
    }

    // 当日の朝食をとっていてなおかつ朝食の時間が未定ののリストを取ってくる
    public ArrayList<Yoyaku> getBreakfastTime() {
        LocalDate date = LocalDate.now();
        Iterable<Yoyaku> breakfastList = repo.findByCheckInDateAndBreakfastAndBreakfastTime(date, true, null);
        ArrayList<Yoyaku> list = new ArrayList<>();
        breakfastList.forEach(list::add);
        return list;
    }
    
    // 朝食の時間を追加した際のYoyakuの更新
    public Yoyaku updateYoyaku(YoyakuForm form) {
        // DB上のYoyaku情報を更新し、新しいユーザ情報を戻り値として返す
        Yoyaku yoyaku = new Yoyaku(
            form.getId(), 
            form.getName(),
            LocalDate.parse(form.getCheckInDate()), // StringからLocalDateに変換
            form.getEmail(),
            form.isBreakfast(),
            form.getBreakfastTime(), // breakfastTimeはnullを指定
            false // cleanはfalseを指定（デフォルト値）
        );
        // // 確認用
        // System.out.println("id:" + yoyaku.getId());
        // System.out.println("名前：" + yoyaku.getName());
        // System.out.println("チェックイン日：" + yoyaku.getCheckInDate());
        // System.out.println("メールアドレス：" + yoyaku.getEmail());
        // System.out.println("朝食の有無：" + yoyaku.isBreakfast());
        // System.out.println("朝食時間：" + yoyaku.getBreakfastTime());
        // System.out.println("掃除したかどうか：" + yoyaku.isClean());
        // System.out.println("-----------------------------------");
        repo.deleteById(yoyaku.getId());
        
        return repo.save(yoyaku);
        
    }
      /**
   * ユーザの情報を更新する
   *
   * @param form UserForm
   * @return 更新したユーザの情報
   */





    public Yoyaku createYoyaku(YoyakuForm form) {
        LocalDate checkInDate = LocalDate.parse(form.getCheckInDate());
        // ユーザをDBに登録し、登録したユーザの情報を戻り値として返す
        return repo.save(new Yoyaku(
                null,
                form.getName(),
                checkInDate,
                // form.getStayDays(),
                form.getEmail(),
                form.isBreakfast(),
                null,
                false));
    }

}