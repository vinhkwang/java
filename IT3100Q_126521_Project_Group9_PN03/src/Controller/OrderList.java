package Controller;

import java.util.List;
import java.util.ArrayList;


import Model.Billboard;
import Model.Customer;
import Model.Order;



public class OrderList {
     List<Order> orderList;
     CustomerList customerList;
     BillboardList billboardList;
     public OrderList(CustomerList customerList, BillboardList billboardList) {
          this.orderList = new ArrayList<>();
          this.customerList = customerList;
          this.billboardList = billboardList;
     }

     public List<Order> searchOrderByCustomerName(String name) {
          List<Order> searchResult = new ArrayList<>();
          for (Order order: orderList) {
               if (order.getNameOfCustomer().equals(name)) {
                    searchResult.add(order);
               }
          }
          return searchResult;
     }

     public List<Order> searchOrderByCustomerAddress(String address) {
          List<Order> searchResult = new ArrayList<>();
          for (Customer customer: customerList.customerList) {
               if (customer.getAddress().equals(address)) {
                    int id = customer.getId();
                    for (Order order: orderList) {
                         if (order.getCustomerId() == id) {
                              searchResult.add(order);
                         }
                    }
               }
          }
          return searchResult;
     }

     public List<Order> searchOrderByShapeOfBillboard(String shape) {
          List<Order> searchResult = new ArrayList<>();
          for (Billboard billboard: billboardList.billboardList) {
               if (billboard.getShape().equals(shape)) {
                    int id = billboard.getId();
                    for (Order order: orderList) {
                         if (order.getBillboardId() == id) {
                              searchResult.add(order);
                         }
                    }
               }
          }
          return searchResult;
     }

     public List<Order> searchOrderByPrice(double price) {
          List<Order> searchResult = new ArrayList<>();
          for (Order order: orderList) {
               if (order.getTotalPrice() == price) {
                    searchResult.add(order);
               }
          }
          return searchResult;
     }
}
