package org.example.TicketPrices;

import org.springframework.stereotype.Service;

@Service
public interface ITicketPrices {
    TicketPricesInfo getTicketPrices(BagInfo bagInfo);
}
