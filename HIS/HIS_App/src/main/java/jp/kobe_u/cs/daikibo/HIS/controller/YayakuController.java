package jp.kobe_u.cs.daikibo.HIS.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.kobe_u.cs.daikibo.HIS.entity.Yoyaku;
import jp.kobe_u.cs.daikibo.HIS.service.YoyakuService;

@Controller
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

    @GetMapping("/front")
    String showyoyakuList(Model model) {
        ArrayList<Yoyaku> list = new ArrayList<>();
        list = ts.getAllYoyaku();
        model.addAttribute("Yoyakulist", list);
        return "front";
    }

    @GetMapping("/cook")
    String showcookList() {
        return "cook";
    }

    @GetMapping("/clean")
    String showcleanList() {
        return "clean";
    }

}
