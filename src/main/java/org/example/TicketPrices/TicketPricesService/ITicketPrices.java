package org.example.TicketPrices.TicketPricesService;

import org.springframework.stereotype.Service;

@Service
public interface ITicketPrices {
    TicketPricesInfo getTicketPrices(BagInfo bagInfo);
}
