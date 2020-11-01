package org.example.TicketPrices;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TicketPriceItems {
private  static  final int MIN_ROUTE_NAME_LENGTH = 3;
private List<Integer> adultBags;
private  List<Integer> infantBags;
private String routeName;
private  float basePrice=10;
private  int taxRate=25;
public static TicketPriceItems priceItemsFromJson(String priceItems) throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();

  /*
    Map<String, ArrayList<Integer>> jsonPriceItems = mapper.readValue(priceItems, new TypeReference<Map<String,ArrayList<Integer>>>() { });
    if(!jsonPriceItems.containsKey("AdultBags") &&  !jsonPriceItems.containsKey("InfantBags") )
        return  null;
List<Integer> adultBags = jsonPriceItems.get("AdultBags");
    List<Integer> infantBags = jsonPriceItems.get("InfantBags");
if( (adultBags == null || adultBags.size() ==0 ) &&  (infantBags == null || infantBags.size() ==0 )  )
    return  null;
    TicketPriceItems    priceItemsInstance = new TicketPriceItems();
    priceItemsInstance.adultBags = adultBags;
    priceItemsInstance.infantBags = infantBags;
 Map<String,String> jsonNamedStrings = mapper.readValue(priceItems,Map.class);
 if(jsonNamedStrings != null && jsonNamedStrings.containsKey("RouteName")   )
 {
    String jsonRouteName = jsonNamedStrings.get("RouteName");
     if(jsonRouteName != null   )
         priceItemsInstance.routeName = jsonRouteName;

 }
*/
    String jsonRouteName = null;
    List<Integer>    adultBagArray = null;
    List<Integer>    infantBagArray = null;
    Map<String,Object> jsonNamedObjects = mapper.readValue(priceItems,new TypeReference<Map<String,Object>>() { });
    for (Map.Entry<String,Object> entry: jsonNamedObjects.entrySet()
    ) {
       if(entry.getKey().equals("RouteName"))
           jsonRouteName = (String) entry.getValue();
       else if(entry.getKey().equals("AdultBags"))
       {

           adultBagArray = (List<Integer>) entry.getValue();
       }
       else{

           infantBagArray = (List<Integer>) entry.getValue();

       }

    }

   if((infantBagArray == null || infantBagArray.size() ==0 ) && (adultBagArray == null || adultBagArray.size() ==0 ) )
       return  null;

    TicketPriceItems ticketPriceItems =  new TicketPriceItems();
  ticketPriceItems.routeName = jsonRouteName;
  ticketPriceItems.infantBags = infantBagArray;
  ticketPriceItems.adultBags = adultBagArray;
    return ticketPriceItems;
}

public void setBasePrice(float basePrice)
{
this.basePrice = basePrice;
}

public String getRouteName()
{

    return routeName;
}


    public List<Integer> getAdultBags() {
        return adultBags;
    }

    public List<Integer> getInfantBags() {
        return infantBags;
    }
}
