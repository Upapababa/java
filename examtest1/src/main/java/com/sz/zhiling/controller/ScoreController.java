package com.sz.zhiling.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/score")
@Controller
public class ScoreController {

    @RequestMapping("/great")
    public String getGreat(Integer score, Model model){
        model.addAttribute("score",score);
        return "great";
    }

    @RequestMapping("/back")
    public String back(){
        return "paper";
    }

    @RequestMapping("/jop")
    public String toJop(Integer paperid,Model model){
        model.addAttribute("paperid",paperid);
        return "paperBySomeOne";
    }
}
