package jp.kobe_u.cs.daikibo.HIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

import jp.kobe_u.cs.daikibo.HIS.service.YoyakuService;


@Controller
public class YayakuController {
    @Autowired
    YoyakuService ts;

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/front")
    String showyoyakuList() {
        ArrayList<Tsubuyaki> list = new ArrayList<>();

        list = ts.getAllYoyaku();
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
