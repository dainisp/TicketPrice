package org.example;

import org.example.TicketPrices.IBasePrice;
import org.springframework.stereotype.Component;

@Component
public class BasePriceServiceImpl implements IBasePrice {
    @Override
    public float getBasePrice(String busTerminalName) {
        return 10;
    }
}
