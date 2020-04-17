package com.example.antennarotorcontrol.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    private String satName;
    private static final String satLineOneLineNumber = "1";
    private String satLineOneNumber;
    private static final String satLineOneClass = "U";
    private String satLineOneLaunchyr;
    private String satLineOneLaunchnr;
    private String satLineOneLaunchpc;
    private String satLineOneEpochyr;
    private String satLineOneFtdmm;
    private String satLineOneEpochday;
    private String satLineOneStdmm;
    private String satLineOneDrag;
    private String satLineOneEph;
    private String satLineOneEle;
    private String satLineOneChksum1;

    private static final String satLineTwoLineNumber = "2";
    private String satLineTwoNumber;
    private String satLineTwoIncl;
    private String satLineTwoRa;
    private String satLineTwoEcc;
    private String satLineTwoPeri;
    private String satLineTwoMa;
    private String satLineTwoMm;
    private String satLineTwoRevnr;
    private String satLineTwoChksum2;
    private final static String satLineTwoNotes = "Notes";
    private final static String satLineTwoActive = "1";

    private String lineOne;
    private String lineTwo;

    public void setSatName(String satName) {
        this.satName = satName.trim();
    }

    private void setSatLineOneNumber() {
        this.satLineOneNumber = lineOne.split(" ")[1].split("U")[0];
    }

    private void setSatLineOneLaunchyr() {
        this.satLineOneLaunchyr = lineOne.split(" ")[2].substring(0, 2);
    }

    private void setSatLineOneLaunchnr() {
        this.satLineOneLaunchnr = lineOne.split(" ")[2].substring(2, 5);
    }

    private void setSatLineOneLaunchpc() {
        this.satLineOneLaunchpc = lineOne.split(" ")[2].substring(5, 6);
    }

    private void setSatLineOneEpochyr() {
        this.satLineOneEpochyr = lineOne.split(" ")[3].substring(0, 2);
    }

    private void setSatLineOneFtdmm() {
        this.satLineOneFtdmm = lineOne.split(" ")[4];
    }

    private void setSatLineOneEpochday() {
        this.satLineOneEpochday = lineOne.split(" ")[3].substring(2);
    }

    private void setSatLineOneStdmm() {
        this.satLineOneStdmm = "satLineOneStdmm anpassen";
    }

    private void setSatLineOneDrag() {
        this.satLineOneDrag = "satLineOneDrag anpassen";
    }

    private void setSatLineOneEph() {
        this.satLineOneEph = "satLineOneEph anpassen";
    }

    private void setSatLineOneEle() {
        this.satLineOneEle = "satLineOneEle anpassen";
    }

    private void setSatLineOneChksum1() {
        this.satLineOneChksum1 = "satLineOneChksum1 anpassen";
    }

    private void setSatLineTwoNumber() {
        this.satLineTwoNumber = lineTwo.split(" ")[1];
    }

    private void setSatLineTwoIncl() {
        this.satLineTwoIncl = lineTwo.split(" ")[2];
    }

    private void setSatLineTwoRa() {
        this.satLineTwoRa = lineTwo.split(" ")[3];
                //"satLineTwoRa anpassen";
    }

    private void setSatLineTwoEcc() {
        this.satLineTwoEcc = lineTwo.split(" ")[4];
                //"satLineTwoEcc anpassen";
    }

    private void setSatLineTwoPeri() {
        this.satLineTwoPeri = lineTwo.split(" ")[5];
    //"satLineTwoPeri anpassen";
    }

    private void setSatLineTwoMa() {
        this.satLineTwoMa = lineTwo.split(" ")[6];
    //"satLineTwoMa anpassen";
    }

    private void setSatLineTwoMm() {
        this.satLineTwoMm = lineTwo.split(" ")[7];
    //"satLineTwoMm anpassen";
    }

    private void setSatLineTwoRevnr() {
        try {
            this.satLineTwoRevnr = lineTwo.split(" ")[8];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.satLineTwoRevnr = lineTwo.split(" ")[7].substring(11);
        }

    //"satLineTwoRevnr anpassen";
    }

    private void setSatLineTwoChksum2() {
        this.satLineTwoChksum2 = "satLineTwoChksum2 anpassen";
    }

    public String getSatName() {
        return satName;
    }

    public String getSatLineOneLineNumber() {
        return satLineOneLineNumber;
    }

    public String getSatLineOneNumber() {
        setSatLineOneNumber();
        return satLineOneNumber;
    }

    public String getSatLineOneClass() {
        return satLineOneClass;
    }

    public String getSatLineOneLaunchyr() {
        setSatLineOneLaunchyr();
        return satLineOneLaunchyr;
    }

    public String getSatLineOneLaunchnr() {
        setSatLineOneLaunchnr();
        return satLineOneLaunchnr;
    }

    public String getSatLineOneLaunchpc() {
        setSatLineOneLaunchpc();
        return satLineOneLaunchpc;
    }

    public String getSatLineOneEpochyr() {
        setSatLineOneEpochyr();
        return satLineOneEpochyr;
    }

    public String getSatLineOneFtdmm() {
        setSatLineOneFtdmm();
        return satLineOneFtdmm;
    }

    public String getSatLineOneEpochday() {
        setSatLineOneEpochday();
        return satLineOneEpochday;
    }

    public String getSatLineOneStdmm() {
        setSatLineOneStdmm();
        return satLineOneStdmm;
    }

    public String getSatLineOneDrag() {
        setSatLineOneDrag();
        return satLineOneDrag;
    }

    public String getSatLineOneEph() {
        setSatLineOneEph();
        return satLineOneEph;
    }

    public String getSatLineOneEle() {
        setSatLineOneEle();
        return satLineOneEle;
    }

    public String getSatLineOneChksum1() {
        setSatLineOneChksum1();
        return satLineOneChksum1;
    }

    public String getSatLineTwoLineNumber() {
        return satLineTwoLineNumber;
    }

    public String getSatLineTwoNumber() {
        setSatLineTwoNumber();
        return satLineTwoNumber;
    }

    public String getSatLineTwoIncl() {
        setSatLineTwoIncl();
        return satLineTwoIncl;
    }

    public String getSatLineTwoRa() {
        setSatLineTwoRa();
        return satLineTwoRa;
    }

    public String getSatLineTwoEcc() {
        setSatLineTwoEcc();
        return satLineTwoEcc;
    }

    public String getSatLineTwoPeri() {
        setSatLineTwoPeri();
        return satLineTwoPeri;
    }

    public String getSatLineTwoMa() {
        setSatLineTwoMa();
        return satLineTwoMa;
    }

    public String getSatLineTwoMm() {
        setSatLineTwoMm();
        return satLineTwoMm;
    }

    public String getSatLineTwoRevnr() {
        setSatLineTwoRevnr();
        return satLineTwoRevnr;
    }

    public String getSatLineTwoChksum2() {
        setSatLineTwoChksum2();
        return satLineTwoChksum2;
    }

    public String getSatLineTwoNotes() {
        return satLineTwoNotes;
    }

    public String getSatLineTwoActive() {
        return satLineTwoActive;
    }

    //
    // Lines
    //
    public String getLineZero() {
        return getSatName();
    }

    public void setLineZero(String lineZero) {
        this.satName = lineZero.trim();
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        List<String> list = new ArrayList<>(Arrays.asList(lineOne.trim().split(" ", -1)));
        list.removeAll(Arrays.asList("", null));
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ");
        }
        this.lineOne = sb.toString();
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        List<String> list = new ArrayList<>(Arrays.asList(lineTwo.trim().split(" ", -1)));
        list.removeAll(Arrays.asList("", null));
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ");
        }
        this.lineTwo = sb.toString();
    }

    public String getLines() {
        return (satName.trim() + "\n" + lineOne + "\n" + lineTwo);
    }
}


