package jp.kobe_u.cs.daikibo.HIS.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;
import jp.kobe_u.cs.daikibo.HIS.service.YoyakuService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class YayakuController {
    @Autowired
    YoyakuService ts;

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
                "checkInDateInput",
                form.getCheckInDateInput());
        // model.addAttribute(
        // "stayDays",
        // form.getStayDays());
        model.addAttribute(
                "email",
                form.getEmail());
        model.addAttribute(
                "breakfast",
                form.isBreakfast());
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
        model.addAttribute("yoyakulist", list);
        return "front";
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

}
