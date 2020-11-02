package org.example.TicketPrices.TicketPricesService;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

@Service
public interface ITaxRates {
    Map<String,Float> getTaxRate(Date rateDate);
}
