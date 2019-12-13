package com.cms.codingDojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisScoreTest {

        String result ="";
        TennisScore tennisScore = new TennisScore();
        @Test
        public void testLove_All(){
                result = tennisScore.getResult(0,0, 0);
                assertEquals("love all", result);

        }
        @Test
        public void testFifteen_Love(){
                result = tennisScore.getResult(15,0, 0);
                assertEquals("fifteen love", result);
        }
        @Test
        public void testFifteen_all(){
                result = tennisScore.getResult(15,15, 0);
                assertEquals("fifteen all", result);
        }
        @Test
        public void testThirty_love(){
                result = tennisScore.getResult(30,0,0);
                assertEquals("thirty love", result);
        }
        @Test
        public void testForty_love(){
                result = tennisScore.getResult(40,0, 0);
                assertEquals("forty love", result);
        }
        @Test
        public void testDeuce(){
                result = tennisScore.getResult(40,40, 0);
                assertEquals("deuce", result);
        }
        @Test
        public void benAdvanced(){
                result = tennisScore.getResult(40,40, 1);
                assertEquals("Ben advanced", result);
        }

        @Test
        public void ritaWin(){
                result = tennisScore.getResult(40,40, -2);
                assertEquals("Rita win", result);
        }

        @Test
        public void ritaAdvanced(){
                result = tennisScore.getResult(40,40, -1);
                assertEquals("Rita advanced", result);
        }

        @Test
        public void benWin(){
                result = tennisScore.getResult(40,40, 2);
                assertEquals("Ben win", result);
        }
}