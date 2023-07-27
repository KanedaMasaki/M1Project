package jp.kobe_u.cs.daikibo.HIS.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;
import jp.kobe_u.cs.daikibo.HIS.repository.YoyakuRepository;
import jp.kobe_u.cs.daikibo.HIS.service.YoyakuService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YayakuController {
    @Autowired
    YoyakuService ts;
    YoyakuRepository yr;

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/customer")
    String customer(Model model) {
        model.addAttribute(new YoyakuForm());

        return "customer";
    }

    @GetMapping("/customer/confirm")
    public String confirmUserRegistration(
            Model model,
            RedirectAttributes attributes,
            @ModelAttribute @Validated YoyakuForm form,
            BindingResult bindingResult) {

        // Convert checkInDateInput to Stri
        // ユーザ情報をModelに追加する
        model.addAttribute(
                "name",
                form.getName());
        model.addAttribute(
                "checkInDate",
                form.getCheckInDate());
        // model.addAttribute(
        // "stayDays",
        // form.getStayDays());
        model.addAttribute(
                "email",
                form.getEmail());
        model.addAttribute(
                "breakfast",
                form.isBreakfast());
        model.addAttribute(
                "roomNumber",
                form.getRoomNumber());
        // ユーザ登録確認ページ
        return "customerRegistration";
    }

    @PostMapping("/customer/register")
    public String registerUser(
            Model model,
            RedirectAttributes attributes,
            @ModelAttribute @Validated YoyakuForm form,
            BindingResult bindingResult) {
        ts.createYoyaku(form);
        // 体調記録ページ
        return "conguratulation";
    }

    @GetMapping("/front")
    String showyoyakuList(Model model) {
        ArrayList<Yoyaku> list = ts.getBreakfastTime();
        // 確認用
        // for (Yoyaku yoyaku : list) {
        //     System.out.println("名前：" + yoyaku.getName());
        //     System.out.println("チェックイン日：" + yoyaku.getCheckInDate());
        //     System.out.println("メールアドレス：" + yoyaku.getEmail());
        //     System.out.println("朝食の有無：" + yoyaku.isBreakfast());
        //     System.out.println("朝食時間：" + yoyaku.getBreakfastTime());
        //     System.out.println("掃除したかどうか：" + yoyaku.isClean());
        //     System.out.println("-----------------------------------");
        // }
        model.addAttribute("yoyakulist", list);
        return "front";
    }


    @PostMapping("/front/update")
    String updateyoyakuList(
        Model model,
        RedirectAttributes attributes,
        @ModelAttribute @Validated YoyakuForm form,
        BindingResult bindingResult) {
        ts.updateYoyaku(form);
        return "redirect:/front";
    }

    @GetMapping("/cook")
    String showcookList(Model model) {
        ArrayList<Yoyaku> list = ts.getBreakfastTrue();
        model.addAttribute("cookList", list);
        return "cook";
    }

    @GetMapping("/clean")
    String showcleanList(Model model) {
        ArrayList<Yoyaku> list = ts.getCleanFalse();
        model.addAttribute("cleanList", list);
        return "clean";
    }
    
    @PostMapping("/clean/update")
    public String cleaning(
        Model model,
        RedirectAttributes attributes,
        @ModelAttribute @Validated YoyakuForm form,
        BindingResult bindingResult) {

        // DB上のユーザ情報を更新し、新しいユーザ情報を戻り値として返す
        ts.updateYoyaku(form);

        return "redirect:/clean"; // フォームが表示されるindex.htmlにリダイレクト
    }

}
