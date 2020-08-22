package com.sz.zhiling.controller;


import com.sz.zhiling.model.ExamPaper;
import com.sz.zhiling.service.IPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/paper")
@Controller
public class PaperController {

    @Autowired
    private IPaper iPaper;

    @RequestMapping("/selectpaper")
    @ResponseBody
    public List selectPaper(String papername){
        return iPaper.getPaperByName(papername);
    }

    @RequestMapping("/exam")
    public String exam(ExamPaper examPaper, Model model, HttpSession session){
        model.addAttribute("papername",examPaper.getPapername());
        model.addAttribute("remarks",examPaper.getRemarks());
        model.addAttribute("paperid",examPaper.getPaperid());
        session.setAttribute("paperid",examPaper.getPaperid());
        return "exam";
    }
}
