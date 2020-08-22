package com.sz.zhiling.controller;

import com.sz.zhiling.model.*;
import com.sz.zhiling.service.IItems;
import com.sz.zhiling.service.IPaper;
import com.sz.zhiling.service.IScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/myItems")
@Controller
public class MyItems {

    @Autowired
    private IScore iScore;

    @Autowired
    private IPaper iPaper;

    @RequestMapping("/selectItems")
    @ResponseBody
    public List<ExamIII> getMyItems(Integer paperid, HttpSession session){
        ExamUser user= (ExamUser) session.getAttribute("user");
        List<ExamScore> list1=iScore.getMyItems(paperid,user.getUserid());
        List<ExamIII> list=new ArrayList<>();
        ExamPaper examPaper=iPaper.getPaperById(paperid);
        for (ExamScore s:list1) {
            ExamIII examIII=new ExamIII(s.getScoreid(),s.getUserid(),s.getPaperid(),s.getScore(),s.getRights(),s.getErrors(),examPaper.getPapername(),examPaper.getRemarks());
            list.add(examIII);
        }
        return list;
    }
}
