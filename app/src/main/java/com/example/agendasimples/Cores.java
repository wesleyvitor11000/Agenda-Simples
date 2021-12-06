package com.example.agendasimples;

import android.graphics.Color;

public class Cores {

    private static int cores[] =   {Color.parseColor("#F2505D"),    //red
                                    Color.parseColor("#26BF5C"),    //green
                                    Color.parseColor("#D2369D"),    //pink
                                    Color.parseColor("#B15AEA")};    //purple

    public static int getCor(int colorId){
        if(colorId >= 0 && cores.length > colorId){
            return cores[colorId];
        }

        return Color.WHITE;
    }


}
