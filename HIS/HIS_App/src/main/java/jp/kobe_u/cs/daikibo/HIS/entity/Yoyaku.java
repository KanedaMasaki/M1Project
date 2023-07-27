package jp.kobe_u.cs.daikibo.HIS.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Yoyaku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // 予約エンティティの識別子
    String name; // 名前
    LocalDate checkInDate; // チェックイン日
    String Email; // メールアドレス
    boolean breakfast; // 朝食の有無
    LocalTime breakfastTime; // 朝食の時間
    boolean clean; // 掃除したかどうか
    // int roomNumber; // 部屋番号
}
