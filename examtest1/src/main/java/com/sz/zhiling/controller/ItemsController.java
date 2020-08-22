package com.sz.zhiling.controller;



import com.sz.zhiling.model.ExamItems;
import com.sz.zhiling.model.ExamScore;
import com.sz.zhiling.model.ExamScoreDetail;
import com.sz.zhiling.model.ExamUser;
import com.sz.zhiling.service.IItems;
import com.sz.zhiling.service.IScore;
import com.sz.zhiling.service.IScoreDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@RequestMapping("/items")
@Controller
public class ItemsController {

    @Autowired
    private IItems iItems;

    @Autowired
    private IScore iScore;

    @Autowired
    private IScoreDetail iScoreDetail;



    @RequestMapping("/select")
    @ResponseBody
    public List<ExamItems> selectItems(int paperid){
        List<ExamItems> list= iItems.selectByPaperid(paperid);
        Collections.shuffle(list);
        return list;
    }

    @RequestMapping("/submit")
    @ResponseBody
    public Integer submit(@RequestBody Map<String,Object> map, HttpSession session){
        System.out.println(map);
        Integer score=0;
        Integer rights=0;
        Integer errors=7;
        Set<String> s=  map.keySet();
        String dx="";
        String px="";
        for (String ss:s) {
            ExamItems examItems=iItems.getKeys(Integer.parseInt(ss));
            Object sps=map.get(ss);
            if(sps instanceof List){
                for(int i=0;i<((List<String>) sps).size();i++){
//                    String str =examItems.getEkeys();
//                    if(str.indexOf(((List<String>) sps).get(i))==-1){
//
//                    }
                    dx+=((List) sps).get(i);
                }
                if(examItems.getEkeys().equals(dx)){
                    errors=errors-1;
                    rights=rights+1;
                    score=score+40;
                }
            }else {
                if(examItems.getEkeys().equals(sps)){
                    errors=errors-1;
                    rights=rights+1;
                    score=score+10;
                }
            }
        }
        ExamUser user= (ExamUser) session.getAttribute("user");
        Integer paperid= (Integer) session.getAttribute("paperid");
        ExamScore examScore=new ExamScore(user.getUserid(),paperid,score,rights,errors);
        iScore.insertByExamScore(examScore);
        for (String ss:s) {
            ExamItems examItems=iItems.getKeys(Integer.parseInt(ss));
            Object sps=map.get(ss);
            if(sps instanceof List){
                for(int i=0;i<((List<String>) sps).size();i++){
                    px+=((List) sps).get(i);
                }
                if(examItems.getEkeys().equals(px)){
                    ExamScoreDetail examScoreDetail=new ExamScoreDetail(examScore.getScoreid(),Integer.parseInt(ss),px,40);
                    iScoreDetail.insertByexamScore(examScoreDetail);
                }else {
                    ExamScoreDetail examScoreDetail=new ExamScoreDetail(examScore.getScoreid(),Integer.parseInt(ss),px,0);
                    iScoreDetail.insertByexamScore(examScoreDetail);
                }
            }else {
                if(examItems.getEkeys().equals(sps)){
                    ExamScoreDetail examScoreDetail=new ExamScoreDetail(examScore.getScoreid(),Integer.parseInt(ss),(String)sps,10);
                    iScoreDetail.insertByexamScore(examScoreDetail);
                }else {
                    ExamScoreDetail examScoreDetail=new ExamScoreDetail(examScore.getScoreid(),Integer.parseInt(ss),(String)sps,0);
                    iScoreDetail.insertByexamScore(examScoreDetail);
                }

            }
        }
        return score;
    }

}
