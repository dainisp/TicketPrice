package org.example.TicketPrices;

public class PricesInfo {

    public float getPassengerPrice() {
        return passengerPrice;
    }

    public void setPassengerPrice(float passengerPrice) {
        this.passengerPrice = passengerPrice;
    }

    public float getBagPrice() {
        return bagPrice;
    }

    public void setBagPrice(float bagPrice) {
        this.bagPrice = bagPrice;
    }

    public    enum PassengerType
    {
        PASSENGER_TYPE_ADULT,
        PASSENGER_TYPE_INFANT
    }

    private  PassengerType passengerType;
    private float bagPercent;
    private float passengerPercent;
    private float passengerPrice;
    private float bagPrice;
    private int bagCount;

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public float getBagPercent() {
        return bagPercent;
    }

    public void setBagPercent(float bagPercent) {
        this.bagPercent = bagPercent;
    }

    public float getPassengerPercent() {
        return passengerPercent;
    }

    public void setPassengerPercent(float passengerPercent) {
        this.passengerPercent = passengerPercent;
    }


    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }
}
