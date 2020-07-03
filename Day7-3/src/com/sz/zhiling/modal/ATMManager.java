package com.sz.zhiling.modal;

import java.util.Scanner;

public class ATMManager {
    Scanner s = new Scanner(System.in);
    public void Start() {
        while(true) {
            System.out.println("======欢迎使用ATM系统！======");
            System.out.println("请输入银行卡号：");
            int mno=0;
            int mpwd=0;
            try {
                mno = s.nextInt();
                System.out.println("请输入密码：");
                mpwd = s.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("输入格式不正确！请输入正确格式！！！");
                s.next();
                continue;
            }
            User f=Link_oracle.panduan(mno, mpwd);
            Link_oracle.close();
            if(f != null) {
                System.out.println(f.getName()+"登录成功");
                while(true) {
                    int a=0;
                    System.out.println("1.查看余额   2.修改密码    3.存款    4.取款     5.转账     6.返回上一级    7.退出");
                    System.out.println("请输入要选择的功能：");
                    int choice = 0;
                    try {
                        choice = s.nextInt();
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("输入格式不正确！请输入正确格式！！！");
                        s.next();
                        continue;
                    }
                    switch(choice){
                        case 1:
                            Link_oracle.Show(f);
                            Link_oracle.close();
                            break;
                        case 2:
                            Link_oracle.xiugai(f);
                            Link_oracle.close();
                            break;
                        case 3:
                            Link_oracle.cunkuan(f);
                            Link_oracle.close();
                            break;
                        case 4:
                            Link_oracle.qukuan(f);
                            Link_oracle.close();
                            break;
                        case 5:
                            Link_oracle.zhuanzhang(f);
                            Link_oracle.close();
                            break;
                        case 6:
                            a=1;
                            break;
                        case 7:
                            System.out.println("退出成功！！！！");
                            System.exit(0);
                        default:
                            System.out.println("输入数字必须在1-7！");
                    }
                    if(a==1)break;
                }
            }else {
                System.out.println("银行卡号或密码错误！！！");
            }
        }
    }


}
