package jp.kobe_u.cs.daikibo.HIS.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Yoyaku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; //予約エンティティの識別子
    String name;    //名前
    LocalDate checkInDateTime;    //チェックイン日時
    int stayDays;   //宿泊日数
    Date date;    //宿泊日付
    String telNumber;    //電話番号
    boolean breakfast;  //朝食の有無
    LocalDate breakfastTime; //朝食の時間 
    boolean cleaning;   //掃除したかどうか
    int roomNumber; //部屋番号
}


