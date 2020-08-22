package com.sz.zhiling.controller;


import com.sz.zhiling.model.ExamItems;
import com.sz.zhiling.model.ExamPaper;
import com.sz.zhiling.model.ExamScoreDetail;
import com.sz.zhiling.model.Myanswer;
import com.sz.zhiling.service.IItems;
import com.sz.zhiling.service.IPaper;
import com.sz.zhiling.service.IScoreDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/scoredetail")
@Controller
public class ScoreDetailController {

    @Autowired
    private IScoreDetail iScoreDetail;

    @Autowired
    private IItems iItems;

    @Autowired
    private IPaper iPaper;


    @RequestMapping("/fh")
    public String fh(){
        return "paper";
    }

    @RequestMapping("/luru")
    public String Sluru(Integer scoreid, Integer paperid, Model model){
        ExamPaper examPaper=iPaper.getPaperById(paperid);
        model.addAttribute("papername",examPaper.getPapername());
        model.addAttribute("remarks",examPaper.getRemarks());
        model.addAttribute("scoreid",scoreid);
        model.addAttribute("paperid",paperid);
        return "end";
    }


    @RequestMapping("/show")
    @ResponseBody
    public List luru(Integer scoreid, Integer paperid, Model model){
        List<ExamScoreDetail> list1= iScoreDetail.selectByScoreid(scoreid);
        List<ExamItems> list2= iItems.selectByPaperid(paperid);
        List list=new ArrayList();
        for (ExamItems ei:list2) {
            for (ExamScoreDetail esd:list1) {
                if(ei.getEid()==esd.getEid()){
                    Myanswer myanswer=new Myanswer(ei.getEid(),ei.getEname(),ei.getEpaperid(),
                            ei.getEscore(),ei.getEtype(),ei.getEdegree(),ei.getEa(),ei.getEb(),ei.getEc(),
                            ei.getEd(),ei.getEe(),ei.getEf(),ei.getEkeys(),ei.getEhints(),esd.getDetailid(),
                            esd.getScoreid(),esd.getUanswer(),esd.getUpoint());
                    list.add(myanswer);
                }
            }
        }
        return list;
    }
}
