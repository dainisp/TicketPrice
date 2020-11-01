package org.example.TicketPrices;


import org.springframework.stereotype.Service;

@Service
public interface IBasePrice {
    float getBasePrice(String busTerminalName);
}
