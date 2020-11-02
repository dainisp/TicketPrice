package org.example.TicketPrices;


import org.example.TicketPrices.TicketPricesService.ITaxRates;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TaxRateServicesImpl implements ITaxRates {

    @Override
    public Map<String, Float> getTaxRate(Date rateDate)
    {
        Map<String, Float> routeTaxRates = new HashMap<String, Float>();
        routeTaxRates.put("Vilnius, Lithuania", (float) 21);
        return routeTaxRates;
    }
}
