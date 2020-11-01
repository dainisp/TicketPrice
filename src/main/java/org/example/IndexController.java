package org.example;

import org.example.TicketPrices.BagInfo;
import org.example.TicketPrices.TicketPriceServiceImpl;
import org.example.TicketPrices.TicketPricesInfo;
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
