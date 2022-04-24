package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.Product;
import edu.miu.shopmartbackend.model.Role;
import edu.miu.shopmartbackend.model.User;
import edu.miu.shopmartbackend.model.dto.UserDto;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerServiceImpl implements SellerService {
    @Override
    public List<Product> findProducts(long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product, long id) {
        return null;
    }
}
