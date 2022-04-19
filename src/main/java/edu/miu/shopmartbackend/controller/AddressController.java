package edu.miu.shopmartbackend.controller;


import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @GetMapping()
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @PatchMapping("/{id}")
    public Address updateAddress(@RequestBody Address address, @PathVariable long id){
        return addressService.updateAddress(address,id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") long id){
        addressService.deleteById(id);
    }


}
