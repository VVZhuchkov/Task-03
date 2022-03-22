package com.github.vvzhuchkov.task03.main;

import com.github.vvzhuchkov.task03.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        // you may add your own code here
        if (appliances.size() == 0) {
            System.out.println("Sorry, we don't have any item with such criteria!");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // you may add your own code here

}
