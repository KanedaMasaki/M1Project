package jp.kobe_u.cs.daikibo.HIS.controller;

import java.util.Date;

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
    String name; // 名前
    String checkInDateInput; // チェックイン日時
    // int stayDays; // 宿泊日数
    String email; // メールアドレス
    boolean breakfast; // 朝食の有無
}
