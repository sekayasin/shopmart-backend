package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.Address;
import java.util.List;


public interface AddressService {
    List<Address> getAll();

    Address updateAddress(Address address, long id);

    void deleteById(long id);
}
