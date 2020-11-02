package org.example.TicketPrices;

import org.example.TicketPrices.TicketPricesService.BagInfo;
import org.example.TicketPrices.TicketPricesService.TicketPriceServiceImpl;
import org.example.TicketPrices.TicketPricesService.TicketPricesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private TicketPriceServiceImpl ticketPriceService;

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public TicketPricesInfo create(@RequestBody BagInfo resource) {
      //  Preconditions.checkNotNull(resource);
        return ticketPriceService.getTicketPrices(resource);
    }

    public TicketPriceServiceImpl getService() {
        return ticketPriceService;
    }

    public void setService(TicketPriceServiceImpl service) {
        this.ticketPriceService = service;
    }
}
