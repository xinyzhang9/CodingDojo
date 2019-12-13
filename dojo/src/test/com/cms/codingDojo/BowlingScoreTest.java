package com.cms.codingDojo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingScoreTest {
  private BowlingGame bowlingGame = new BowlingGame();
  @Test
  public void missAll() {
    String input = "-- -- -- -- -- -- -- -- -- --";
    assertEquals(0, bowlingGame.score(input));
  }

  @Test
  public void NineTimesTen() {
    String input = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";
    assertEquals(90, bowlingGame.score(input));
  }

  @Test
  public void allOne(){
    String input  = "1- 1- 1- 1- 1- 1- 1- 1- 1- 1-";
    assertEquals(10, bowlingGame.score(input));
  }

  @Test
  public void allOneTwo(){
    String input  = "12 12 12 12 12 12 12 12 12 12";
    assertEquals(30, bowlingGame.score(input));
  }

  @Test
  public void oneSpare(){
    String input  = "5/ -- -- -- -- -- -- -- -- --";
    assertEquals(10, bowlingGame.score(input));
  }

  @Test
  public void oneSpareAnd4(){
    String input  = "5/ 4- -- -- -- -- -- -- -- --";
    assertEquals(18, bowlingGame.score(input));
  }

  @Test
  public void lastSpare() {
    String input  = "-- -- -- -- -- -- -- -- -- 5/1";
    assertEquals(11, bowlingGame.score(input));
  }


  @Test
  public void oneStrike(){
    String input = "X -- -- -- -- -- -- -- -- --";
    assertEquals(10, bowlingGame.score(input));
  }

  @Test
  public void oneStrikeAndOne(){
    String input = "X 1- -- -- -- -- -- -- -- --";
    assertEquals(12, bowlingGame.score(input));
  }
}
