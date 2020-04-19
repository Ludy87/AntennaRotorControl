package com.example.antennarotorcontrol.helper;

import com.example.antennarotorcontrol.HamMenuEntries;

import java.util.Comparator;

public class SortById implements Comparable<HamMenuEntries>, Comparator<HamMenuEntries> {

    @Override
    public int compareTo(HamMenuEntries o) {
        return 0;
    }

    @Override
    public int compare(HamMenuEntries o1, HamMenuEntries o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
