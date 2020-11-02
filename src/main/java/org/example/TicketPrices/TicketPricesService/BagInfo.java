package org.example.TicketPrices.TicketPricesService;

import java.util.List;

public class BagInfo {
    private List<Integer> adultBags;
    private List<Integer> infantBags;

    public List<Integer> getAdultBags() {
        return adultBags;
    }

    public void setAdultBags(List<Integer> adultBags) {
        this.adultBags = adultBags;
    }

    public List<Integer> getInfantBags() {
        return infantBags;
    }

    public void setInfantBags(List<Integer> infantBags) {
        this.infantBags = infantBags;
    }
}
