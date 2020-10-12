package com.TeamWork.MainProjct;

import cn.hutool.core.io.file.FileWriter;
import com.TeamWork.Utils.CreatArithmetic;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("1.生成题目： -n 题目数量 -r 题目数字的范围。例如：-n 5 -r 5");
        System.out.println("2.对照答案： -e：练习题的绝对路径 -a： 答案的绝对路径。例如: -e F:exercises.txt -a F:answerfile.txt");
        System.out.println("请输入");
        Scanner scanner = new Scanner(System.in);
        String recomend = scanner.nextLine();
        String[] newargs = recomend.split("\\s+");
        int number= 0,round = 0;
        // 判断参数是否正确
        if (newargs.length < 4) {
            System.out.println("请检查参数是否正确");
        }

        // 获取参数
        for (int i = 0; i < newargs.length; i++) {
            if ("-n".equals(newargs[i])) {
                number = Integer.parseInt(newargs[i + 1]);
                i++;
            } else if ("-r".equals(newargs[i])) {
                round = Integer.parseInt(newargs[i + 1]);
                i++;
            } else {
                break;
            }
        }
        String[] arithmetic = CreatArithmetic.creat(number,round);
        StringBuffer s = new StringBuffer();

        for(String s1 :arithmetic){
            s.append(s1);
        }
        //File file = new File("/resources/Exercises.txt");
        FileWriter writer = new FileWriter("/resources/Exercises.txt");
        writer.write(s.toString());
    }
}
