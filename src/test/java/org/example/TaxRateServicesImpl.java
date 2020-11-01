package org.example;

import org.example.TicketPrices.ITaxRates;
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
        routeTaxRates.put("Vilnius, Lithuania",new Float(21.0));
        return routeTaxRates;
    }
}
