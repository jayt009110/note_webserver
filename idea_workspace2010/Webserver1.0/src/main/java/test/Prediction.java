package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Prediction {
    public static void main(String[] args) {
        List<String> team1 = new ArrayList<String>();
        List<String> team2 = new ArrayList<String>();
        team1.add("利物浦");
        team1.add("拜仁慕尼黑");
        team1.add("尤文图斯");
        team1.add("多特蒙德");
        team1.add("巴黎圣日耳曼");
        team1.add("皇家马德里");
        team1.add("曼城");
        team1.add("切尔西");

        team2.add("巴塞罗那");
        team2.add("马德里竞技");
        team2.add("门兴格拉德巴赫");
        team2.add("波尔图");
        team2.add("拉齐奥");
        team2.add("莱比锡");
        team2.add("塞维利亚");
        team2.add("亚特兰大");



        Random rand = new Random();
        int size = team1.size();
        for(int i=0;i<size;i++){
            int num = rand.nextInt(team1.size());
            int num1 = rand.nextInt(team2.size());
            String t1 = team1.get(num);
            String t2 = team2.get(num1);
            System.out.println(t1+" vs "+t2);
            team1.remove(t1);
            team2.remove(t2);
        }


    }
}
