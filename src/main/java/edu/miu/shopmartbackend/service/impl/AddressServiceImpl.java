package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.repo.AddressRepo;
import edu.miu.shopmartbackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepo addressRepo;

    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

    @Override
    public Address updateAddress(Address address, long id) {
        Address address1 = addressRepo.findById(id).get();
        address1.setStreet(address.getStreet());
        address1.setCity(address.getCity());
        address1.setState(address.getState());
        address1.setZipCode(address.getZipCode());
         return addressRepo.save(address1);

    }

    @Override
    public void deleteById(long id){

        addressRepo.deleteById(id);
    }


}
