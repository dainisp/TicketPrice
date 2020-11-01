package org.example.TicketPrices;

//import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "app")
public class Config {
    public Config()
    {
        System.out.println("asdf");

    }

    private float  basePriceMax;
    private float  basePriceMin;
    private  float bagPercent;
    private  float infantPercent;
    private  int servicesNeeded;
    private float defaultTaxRate;
    private float defaultBasePrice;

    public float getDefaultTaxRate() {
        return defaultTaxRate;
    }

    public void setDefaultTaxRate(float defaultTaxRate) {
        this.defaultTaxRate = defaultTaxRate;
    }

    public float getDefaultBasePrice() {
        return defaultBasePrice;
    }

    public void setDefaultBasePrice(float defaultBasePrice) {
        this.defaultBasePrice = defaultBasePrice;
    }

    public int getServicesNeeded() {
        return servicesNeeded;
    }

    public void setServicesNeeded(int servicesNeeded) {
        this.servicesNeeded = servicesNeeded;
    }

    public float getBasePriceMax() {
        return basePriceMax;
    }

    public void setBasePriceMax(float basePriceMax) {
        this.basePriceMax = basePriceMax;
    }

    public float getBasePriceMin() {
        return basePriceMin;
    }

    public void setBasePriceMin(float basePriceMin) {
        this.basePriceMin = basePriceMin;
    }

    public float getBagPercent() {
        return bagPercent;
    }

    public void setBagPercent(float bagPercent) {
        this.bagPercent = bagPercent;
    }

    public float getInfantPercent() {
        return infantPercent;
    }

    public void setInfantPercent(float infantPercent) {
        this.infantPercent = infantPercent;
    }
}
