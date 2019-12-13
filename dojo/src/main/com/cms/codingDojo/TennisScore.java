package com.cms.codingDojo;

import java.util.HashMap;
import java.util.Map;

public class TennisScore {

    /**
     *
     * @param benScore
     * @param ritaScore
     * @param advanced
     * @return
     */
    public String getResult(int benScore, int ritaScore, int advanced) {
        Map score = new HashMap<Integer, String>();
        score.put(0, "love");
        score.put(15, "fifteen");
        score.put(30, "thirty");
        score.put(40, "forty");
        if(benScore  == ritaScore){
            if(benScore == 40){
                if(advanced == 1){
                    return "Ben advanced";
                }
                if(advanced == -1){
                    return "Rita advanced";
                }
                if(advanced == -2){
                    return "Rita win";
                }
                if(advanced == 2){
                    return "Ben win";
                }
                return "deuce";
            }
            return score.get(benScore) + " all";
        }else {
            return score.get(benScore) + " " + score.get(ritaScore);
        }
    }
}
