package com.github.vvzhuchkov.task03.main;

import static com.github.vvzhuchkov.task03.entity.criteria.SearchCriteria.*;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;
import com.github.vvzhuchkov.task03.service.ApplianceService;
import com.github.vvzhuchkov.task03.service.ServiceFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(Oven.CAPACITY.toString(), 3);

        appliances = service.find(criteriaOven);

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 200);
        criteriaOven.add(Oven.DEPTH.toString(), 300);

        appliances = service.find(criteriaOven);

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.add(TabletPC.COLOR.toString(), "blue");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 15);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4000);

        appliances = service.find(criteriaTabletPC);// find(Object...obj)

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaRefrigerator = new Criteria(Refrigerator.class.getSimpleName());
        criteriaRefrigerator.add(Refrigerator.BRAND.toString(), "Samsung");

        appliances = service.find(criteriaRefrigerator);// find(Object...obj)

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        criteriaRefrigerator = new Criteria(Refrigerator.class.getSimpleName());
        criteriaRefrigerator.add(Refrigerator.FREEZER_CAPACITY.toString(), "25");

        appliances = service.find(criteriaRefrigerator);// find(Object...obj)

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaSpeakers = new Criteria(Speakers.class.getSimpleName());
        criteriaSpeakers.add(Speakers.NUMBER_OF_SPEAKERS.toString(), "4");
        criteriaSpeakers.add(Speakers.MODEL.toString(), "Kuopio");
        criteriaSpeakers.add(Speakers.BRAND.toString(), "Koss");
        criteriaSpeakers.add(Speakers.PRICE.toString(), "51");
        criteriaSpeakers.add(Speakers.POWER_CONSUMPTION.toString(), "17");
        criteriaSpeakers.add(Speakers.FREQUENCY_RANGE.toString(), "2-3.5");
        criteriaSpeakers.add(Speakers.CORD_LENGTH.toString(), "4");

        appliances = service.find(criteriaSpeakers);// find(Object...obj)

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaVacuumCleaner = new Criteria(VacuumCleaner.class.getSimpleName());
        criteriaVacuumCleaner.add(VacuumCleaner.WAND_TYPE.toString(), "all-in-one");

        appliances = service.find(criteriaVacuumCleaner);// find(Object...obj)

        PrintApplianceInfo.print(appliances);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
        criteriaLaptop.add(Laptop.SYSTEM_MEMORY.toString(), "1000");

        appliances = service.find(criteriaLaptop);// find(Object...obj)

        PrintApplianceInfo.print(appliances);
    }
}