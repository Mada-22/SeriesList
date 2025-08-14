package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Series extends SeriesModel{
    int option;
    ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public void CaptureSeriesInArray() {
        SeriesModel seriesModel = new SeriesModel();
        JOptionPane.showMessageDialog(null, "Capture a new series \n" +
                                         "*************************************");

        seriesID = JOptionPane.showInputDialog(null,"Enter the series id:");
        seriesModel.setSeriesID(seriesID);
        seriesName = JOptionPane.showInputDialog(null,"Enter the series name: ");
        seriesModel.setSeriesName(seriesName);
        seriesAge = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the series age restrictions: "));
        seriesModel.setSeriesAge(seriesAge);
        while (getSeriesAge() < 2 || getSeriesAge() >18 ) {
            JOptionPane.showMessageDialog(null, "You have entered the incorrect age!!" + "\n" +
                    "Please re-enter the series age>>");
            seriesAge = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the series age restrictions: "));
        }
        seriesModel.seriesNumberOfEpisode = JOptionPane.showInputDialog(null,"Enter the number of episodes for " + getSeriesName() + ":");
        setSeriesNumberOfEpisode(seriesNumberOfEpisode);
        seriesList.add(seriesModel);
        JOptionPane.showMessageDialog(null, "Series successfully captured!!!");
        option = Integer.parseInt(JOptionPane.showInputDialog(null, "(1)To enter the menu or any key to exit"));

        if (option == 1) {
            menu();
        } else {
            exitApp();
        }
    }

    public void searchSeries() {
        seriesID = JOptionPane.showInputDialog(null, "Please enter the ID to search");

        for (SeriesModel seriesModel : seriesList) {

            if (seriesModel.getSeriesID() != null && seriesModel.getSeriesID().equals(seriesID)) {
                JOptionPane.showMessageDialog(null, "******************************************\n" +
                        "Series ID: " + seriesModel.getSeriesID() + "\n" +
                        "Series Name: " + seriesModel.getSeriesName() + "\n" +
                        "Series age restriction: " + seriesModel.getSeriesAge() + "\n" +
                        "Number of episodes:" + seriesModel.getSeriesNumberOfEpisode());


            } else{
                JOptionPane.showMessageDialog(null, "Error series was not found");

            }
            option=Integer.parseInt(JOptionPane.showInputDialog(null, "(1)To enter the menu or any key to exit"));

            if(option==1){
                menu();
            }
            else{
                exitApp();
            }
        }

    }

    public void updateSeries() {
        for (SeriesModel seriesModel : seriesList) {

            seriesID = JOptionPane.showInputDialog(null,"Please enter your ID to update your series:");
            seriesModel.setSeriesID(seriesID);
            JOptionPane.showMessageDialog(null, "Please enter your series name:");
            seriesName = JOptionPane.showInputDialog(null);
            seriesModel.setSeriesName(seriesName);
            JOptionPane.showMessageDialog(null, "Please enter the age restriction:");
            seriesAge = Integer.parseInt(JOptionPane.showInputDialog(null));
            while (getSeriesAge() < 2 || getSeriesAge() >18 ) {
                JOptionPane.showMessageDialog(null, "You have entered the incorrect age!!" + "\n" +
                        "Please re-enter the series age>>");
                seriesAge = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the series age restrictions: "));
            }
            seriesModel.setSeriesAge(seriesAge);
            JOptionPane.showMessageDialog(null, "Please enter the number of episode: ");
            seriesNumberOfEpisode = JOptionPane.showInputDialog(null);
            seriesModel.setSeriesNumberOfEpisode(seriesNumberOfEpisode);

            JOptionPane.showMessageDialog(null, "Series is updated!!");
            option=Integer.parseInt(JOptionPane.showInputDialog(null, "(1)To enter the menu or any key to exit"));

            if(option==1){
                menu();
            }
            else{
                exitApp();
            }
        }
    }



    public void deleteSeries() {
        String answer;
        seriesID = JOptionPane.showInputDialog(null, "Enter your ID to delete");
        answer = JOptionPane.showInputDialog(null, "Are you sure (Yes/No)");
        if (answer.equals("yes")) {
            if(seriesID.matches(seriesID)){

                seriesList.clear();

            }
            JOptionPane.showMessageDialog(null, "-------------------------------------\n" +
                    "Series with Series ID:" + getSeriesID() + "\tWAS deleted!\n" +
                    "------------------------------------------------");
            option=Integer.parseInt(JOptionPane.showInputDialog(null, "(1)To enter the menu or any key to exit"));

            if(option==1){
                menu();
            }
            else{
                exitApp();

            }
        }



    }

    public void seriesReport() {
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel seriesModel = seriesList.get(i);
            JOptionPane.showMessageDialog(null, "******************************************\n" +
                    "Series ID: " + seriesModel.getSeriesID() + "\n" +
                    "Series Name: " + seriesModel.getSeriesName() + "\n" +
                    "Series age restriction: " + seriesModel.getSeriesAge() + "\n" +
                    "Number of episodes:" + seriesModel.getSeriesNumberOfEpisode() + "\n");
        }
        option = Integer.parseInt(JOptionPane.showInputDialog(null, "(1)To enter the menu or any key to exit"));

        if (option == 1) {
            menu();
        } else {
            exitApp();
        }
    }

    public void exitApp() {
        JOptionPane.showMessageDialog(null, "Thank you for using the Application");

    }

    public void menu() {
        int option = Integer.parseInt(JOptionPane.showInputDialog(null,
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
        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6) {
            if (option == 1) {
                CaptureSeriesInArray();
            } else if (option == 2) {
                searchSeries();
            } else if (option == 3) {
                updateSeries();
            } else if (option == 4) {
                deleteSeries();
            } else if (option == 5) {
                seriesReport();
            } else {
                exitApp();
               return;
            }
        }
    }
}


