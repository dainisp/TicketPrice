package org.example.TicketPrices.TicketPricesService;

import org.springframework.boot.jackson.JsonComponent;

import java.util.ArrayList;
import java.util.List;
@JsonComponent
public class TicketPricesInfo {
    private float totalPrice=0;
  private   List<PricesInfo> adultPrices=new ArrayList<PricesInfo>();
  private   List<PricesInfo> infantPrices=new ArrayList<PricesInfo>();
  private int errorCode=0;
  private String errorText="Ok";

  public void appendAdultPricesInfo(PricesInfo pricesInfo)
  {
      adultPrices.add(pricesInfo);
  }

    public void appendInfantPricesInfo(PricesInfo pricesInfo)
    {
        infantPrices.add(pricesInfo);
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PricesInfo> getAdultPrices() {
        return adultPrices;
    }

    public void setAdultPrices(List<PricesInfo> adultPrices) {
        this.adultPrices = adultPrices;
    }

    public List<PricesInfo> getInfantPrices() {
        return infantPrices;
    }

    public void setInfantPrices(List<PricesInfo> infantPrices) {
        this.infantPrices = infantPrices;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
