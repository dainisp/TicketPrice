package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.TicketPrices.BagInfo;
import org.example.TicketPrices.Config;
import org.example.TicketPrices.TicketPriceServiceImpl;
import org.example.TicketPrices.TicketPricesInfo;
import org.junit.jupiter.api.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TicketPriceServiceImplTest {


private static final String  RIGHT_OUTPUT_JSON_STRING = "{\"totalPrice\":29.04,\"adultPrices\":[{\"passengerType\":\"PASSENGER_TYPE_ADULT\",\"bagPercent\":30.0,\"passengerPercent\":100.0,\"passengerPrice\":12.1,\"bagPrice\":3.63,\"bagCount\":1}],\"infantPrices\":[{\"passengerType\":\"PASSENGER_TYPE_INFANT\",\"bagPercent\":30.0,\"passengerPercent\":50.0,\"passengerPrice\":6.05,\"bagPrice\":7.26,\"bagCount\":2}],\"errorCode\":0,\"errorText\":\"Ok\"}";
@Autowired
private TicketPriceServiceImpl ticketPriceService;

    @Autowired
    private ApplicationContext appContext;


    public TicketPriceServiceImpl getTicketPriceService() {
        return ticketPriceService;
    }

    public void setTicketPriceService(TicketPriceServiceImpl ticketPriceService) {
        this.ticketPriceService = ticketPriceService;
    }

   

    @BeforeEach
    void setUp() {
        //assertEquals(1,1);
    }



    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("Null input check")
    void getTicketPrices_NullInput_ErrorCode4()
    {
        ticketPriceService = appContext.getBean(TicketPriceServiceImpl.class);
        TicketPricesInfo ticketPricesInfo = ticketPriceService.getTicketPrices(null);
        assertEquals(-4,ticketPricesInfo.getErrorCode());
    }



    @Test
    @DisplayName("Base service check")
   void getTicketPrices_NoBasePriceService_ErrorCode1()
    {
        ticketPriceService = appContext.getBean(TicketPriceServiceImpl.class);
        ticketPriceService.getConfig().setServicesNeeded(1);
        
        BagInfo bagInfo = new BagInfo();
        TicketPricesInfo ticketPricesInfo = ticketPriceService.getTicketPrices(bagInfo);
        assertEquals(-1,ticketPricesInfo.getErrorCode());
    }


    @Test
    @DisplayName("Tax rate service check")
    void getTicketPrices_NoTaxRateService_ErrorCode2()
    {
        ticketPriceService = appContext.getBean(TicketPriceServiceImpl.class);
        BagInfo bagInfo = new BagInfo();
        TicketPricesInfo ticketPricesInfo = ticketPriceService.getTicketPrices(bagInfo);
        assertEquals(-2,ticketPricesInfo.getErrorCode());
    }


    @Test
    @DisplayName("Input without passengers check")
    void getTicketPrices_InputWithoutPassengers_ErrorCode3()
    {
        ticketPriceService = appContext.getBean(TicketPriceServiceImpl.class);
        BagInfo bagInfo = new BagInfo();
        TicketPricesInfo ticketPricesInfo = ticketPriceService.getTicketPrices(bagInfo);
        assertEquals(-3,ticketPricesInfo.getErrorCode());
    }



    @Test
    @DisplayName("Right input should give right output")
    void getTicketPrices_AllOk_ShouldBe() {
        ticketPriceService = appContext.getBean(TicketPriceServiceImpl.class);
        BagInfo bagInfo = new BagInfo();
        List<Integer> adultBags=new ArrayList<>();
        adultBags.add(1);
        bagInfo.setAdultBags(adultBags);
        List<Integer> infantBags = new ArrayList<>();
        infantBags.add(2);
        bagInfo.setInfantBags(infantBags);
        TicketPricesInfo ticketPricesInfo = ticketPriceService.getTicketPrices(bagInfo);
        String json = "";
        try {
            json =  new ObjectMapper().writeValueAsString(ticketPricesInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assertEquals(json,RIGHT_OUTPUT_JSON_STRING);

        System.out.println("Output:"+json);

    }



}