package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Series series=new Series();
        int option= Integer.parseInt(JOptionPane.showInputDialog(null,
                """
                        LATEST SERIES-2025
                        ***********************************
                        Enter (1) to launch menu or any other key to exit
                        Please select one of the following menu items:
                        (1) Capture a new series
                        (2) Search for a series
                        (3) Update series\s
                        (4) Delete series
                        (5) Print series report - 2025
                        (6) Exit Application
                        """));

        
        
        while(option==1||option==2||option==3||option==4||option==5||option==6){
            if (option==1){
                series.CaptureSeriesInArray();
            }
            else if(option==2){
                series.searchSeries();
            }
            else if(option==3){
                series.updateSeries();
            }
            else if(option==4){
                series.deleteSeries();
            }
            else if(option==5){
                series.seriesReport();
            }
            else{
                series.exitApp();
                return;}
        }




    }
}





