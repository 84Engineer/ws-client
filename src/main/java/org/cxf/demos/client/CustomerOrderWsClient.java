package org.cxf.demos.client;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import org.cxf.demos.wsdlfirst.CustomerOrderWsImplService;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author olysenko
 */
public class CustomerOrderWsClient {

   public static void main(String[] args) throws MalformedURLException {

      CustomerOrderWsImplService service = new CustomerOrderWsImplService(
            new URL("http://localhost:8080/wsdlFirstWs/customerOrdersService?wsdl"));
      CustomerOrdersPortType customerOrderWsImplPort = service.getCustomerOrderWsImplPort();

      GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
      getOrdersRequest.setCustomerId(BigInteger.valueOf(1));

      GetOrdersResponse ordersResponse = customerOrderWsImplPort.getOrders(getOrdersRequest);
      List<Order> order = ordersResponse.getOrder();
      System.out.println(order.size());

   }

}
