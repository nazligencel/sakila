package com.uniyaz.customer;

import com.uniyaz.address.domain.Address;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import com.uniyaz.customer.service.CustomerService;
import com.uniyaz.store.domain.Store;
import org.junit.Test;


import java.util.List;

public class CustomerServiceTest {
    @Test
    public void findAll() {

        CustomerService customerService=new CustomerService();
        List<Customer> customerList= customerService.findAll();
        for (Customer customer:customerList){
            System.out.println(customer);
        }
    }

   @Test
   public void findAllByQueryFilterDtoCriteria(){
       CustomerQueryFilterDto customerQueryFilterDto = new CustomerQueryFilterDto();
       CustomerService customerService = new CustomerService();
       Store store = new Store();
       Address address=new Address();

       store.setId(1L);
       String name="Mary";
       //address.setDistrict("Aaaaa");
       customerQueryFilterDto.setFirstName(name);

       List<Customer> customers = customerService.findAllByQueryFilterDto(customerQueryFilterDto);
       for (Customer customer : customers) {
           System.out.println(customer); }

   }

    @Test
    public void findAllByQueryFilterDto(){
        CustomerQueryFilterDto customerQueryFilterDto = new CustomerQueryFilterDto();
        CustomerService customerService = new CustomerService();
        Store store = new Store();

        store.setId(1L);
        String name="Mary";
        customerQueryFilterDto.setFirstName(name);

        List<Customer> customers = customerService.findAllByQueryFilterDto(customerQueryFilterDto);
        for (Customer customer : customers) {
            System.out.println(customer); }

    }
}
