package org.example.TicketPrices;


import org.example.TicketPrices.TicketPricesService.IBasePrice;
import org.springframework.stereotype.Component;

@Component
public class BasePriceServiceImpl implements IBasePrice {
    @Override
    public float getBasePrice(String busTerminalName) {
        return 10;
    }
}
