package org.example.TicketPrices.TicketPricesService;


import org.springframework.stereotype.Service;

@Service
public interface IBasePrice {
    float getBasePrice(String busTerminalName);
}
