package jp.kobe_u.cs.daikibo.HIS.controller;

import java.util.Date;

import lombok.Data;

@Data

public class YoyakuForm {
    String name; // 名前
    Date checkInDateTime; // チェックイン日時
    int stayDays; // 宿泊日数
    String tellNumber; // 電話番号
    boolean breakfast; // 朝食の有無
}
