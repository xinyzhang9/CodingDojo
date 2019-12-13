package com.cms.codingDojo;

public class BowlingGame {
  public int score(String input) {
    input = input.replaceAll("-", "0");
    String[] inputArray = input.split(" ");
    int result = 0;
    for(int i = 0; i< inputArray.length; i++){
      String oneFrameScore = inputArray[i].trim();
      if(oneFrameScore.contains("/")){


        String nextScore = i < 9 ? inputArray[i+1].trim() : inputArray[i].substring(inputArray[i].length()-1);

        result = result + 10 + Integer.parseInt(nextScore.substring(0,1));

      }
      else if (oneFrameScore.contains("X")){
        String nextFrameScore = inputArray[i+1].trim();
        String nextScore = nextFrameScore.substring(0,1);
        String nextNextScore = nextFrameScore.substring(1);
        result = result + 10 + Integer.parseInt(nextScore) + Integer.parseInt(nextNextScore);
      }
      else{
        result = result + Integer.parseInt(oneFrameScore.substring(0,1)) + Integer.parseInt(oneFrameScore.substring(1));
      }



    }
    return result;
  }
}
