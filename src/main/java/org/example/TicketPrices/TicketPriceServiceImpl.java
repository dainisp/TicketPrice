package org.example.TicketPrices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Math.round;

@Component
public class TicketPriceServiceImpl  implements ITicketPrices {



    @Autowired(required = false)
    private IBasePrice basePrice=null;
    @Autowired(required = false)
    private ITaxRates taxRates =null;



    @Autowired
    private Config config=null;


    public Config getConfig() {
        return config;
    }

public TicketPricesInfo getTicketPrices(BagInfo bagInfo)
{

    TicketPricesInfo ticketPricesInfo = new TicketPricesInfo();

    if(bagInfo == null)
    {
        ticketPricesInfo.setErrorCode(-4);
        ticketPricesInfo.setErrorText("Input is empty!");
        return  ticketPricesInfo;

    }

    if(  (  bagInfo.getAdultBags() == null || bagInfo.getAdultBags().size() == 0  )  && ( bagInfo.getInfantBags() == null || bagInfo.getInfantBags().size() == 0))
    {
        ticketPricesInfo.setErrorCode(-3);
        ticketPricesInfo.setErrorText("No ticket is needed without passengers");
        return  ticketPricesInfo;

    }


    String busTerminalName = "Vilnius, Lithuania";
    float currentBasePrice = config.getDefaultBasePrice();
    float taxRate = config.getDefaultTaxRate();

  if(config.getServicesNeeded() == 1) {
      if (basePrice == null || taxRates == null) {

          if (basePrice == null) {
              ticketPricesInfo.setErrorCode(-1);
              ticketPricesInfo.setErrorText("Base price service must be present");
          } else {
              ticketPricesInfo.setErrorCode(-2);
              ticketPricesInfo.setErrorText("Tax rates service must be present");
          }
          return ticketPricesInfo;
      }
  }
if(basePrice != null && taxRates != null ) {
    currentBasePrice = basePrice.getBasePrice(busTerminalName);
    //TODO check current price validity
    Map<String, Float> currentTaxRates = taxRates.getTaxRate(Calendar.getInstance().getTime());
    if (!currentTaxRates.containsKey(busTerminalName)) {
        ticketPricesInfo.setErrorCode(-3);
        ticketPricesInfo.setErrorText("Tax rate for this bus terminal not found!");

        return ticketPricesInfo;


    }
    taxRate = currentTaxRates.get(busTerminalName);
}

    calculatePrices(bagInfo,ticketPricesInfo,currentBasePrice,taxRate);

    return  ticketPricesInfo;
}

private void calculatePrices( BagInfo bagInfo, TicketPricesInfo ticketPricesInfo, float currentBasePrice,float taxRate )  {

    float bagPercent = config.getBagPercent();
    float infantPercent = config.getInfantPercent();
    float totalPrice = 0;
  if(bagInfo.getAdultBags() != null && bagInfo.getAdultBags().size() > 0 ) {
      for (Integer bagCount :
              bagInfo.getAdultBags()) {
          PricesInfo pricesInfo = new PricesInfo();
          pricesInfo.setBagCount(bagCount);
          pricesInfo.setBagPercent(bagPercent);
          pricesInfo.setPassengerPercent(100);
          pricesInfo.setPassengerType(PricesInfo.PassengerType.PASSENGER_TYPE_ADULT);
          float adultPrice = (float) round(  currentBasePrice * (100 + taxRate ))/100;
          totalPrice += adultPrice;
          pricesInfo.setPassengerPrice(adultPrice);
          adultPrice = (float) round(currentBasePrice * bagPercent  * bagCount * (1.0 + taxRate / 100))/100;
          pricesInfo.setBagPrice(adultPrice);
          totalPrice += adultPrice;
          ticketPricesInfo.appendAdultPricesInfo(pricesInfo);
      }
  }

    if(bagInfo.getInfantBags() != null && bagInfo.getInfantBags().size() > 0 )

        for (Integer bagCount:
            bagInfo.getInfantBags()) {
        PricesInfo pricesInfo = new PricesInfo();
        pricesInfo.setBagCount(bagCount);
        pricesInfo.setBagPercent(bagPercent);
        pricesInfo.setPassengerPercent(infantPercent);
        pricesInfo.setPassengerType(PricesInfo.PassengerType.PASSENGER_TYPE_INFANT);
        float infantPrice = ((float) round(currentBasePrice * infantPercent * (1.0 + taxRate/100)))/100;
        totalPrice += infantPrice;
        pricesInfo.setPassengerPrice(infantPrice);
        infantPrice = ((float) round(currentBasePrice * bagPercent * bagCount *  (1.0 + taxRate/100)))/100;
        pricesInfo.setBagPrice(infantPrice);
        totalPrice += infantPrice;
        ticketPricesInfo.appendInfantPricesInfo(pricesInfo);
    }


    ticketPricesInfo.setTotalPrice(((float) round(totalPrice*100))/100);
}


}
