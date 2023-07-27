package jp.kobe_u.cs.daikibo.HIS.controller;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YoyakuForm {
    Long id; // id
    String name; // 名前
    String checkInDate; // チェックイン日時
    String email; // メールアドレス
    boolean breakfast; // 朝食の有無
    LocalTime breakfastTime; // 朝食の時間
    boolean clean; // 掃除したかどうか
    int roomNumber; // 部屋番号
}
