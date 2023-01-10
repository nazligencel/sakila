package com.uniyaz.address;

import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.address.service.AddressService;
import com.uniyaz.city.domain.City;
import org.junit.Test;

import java.util.List;

public class AddressServiceTest {
    @Test
    public void findAllTest() {

        AddressService addressService=new AddressService();
        List<Address> addressList = addressService.findAll();
        for (Address address : addressList) {
            System.out.println(address);
        }
    }

    @Test
    public void findAllByQueryFilterDto(){
        AddressQueryFilterDto addressQueryFilterDto = new AddressQueryFilterDto();
        AddressService addressService = new AddressService();
        City city = new City();
        city.setCity("Abha");

        addressQueryFilterDto.setCity(city);
        List<Address> addresses = addressService.findAllByQueryFilterDto(addressQueryFilterDto);
        for (Address address : addresses) {
            System.out.println(address);
        }
    }
}
