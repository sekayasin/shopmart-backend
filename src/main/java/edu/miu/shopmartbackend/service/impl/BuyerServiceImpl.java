package edu.miu.shopmartbackend.service.impl;

import edu.miu.shopmartbackend.model.*;
import edu.miu.shopmartbackend.repo.ShoppingCartRepo;
import edu.miu.shopmartbackend.repo.UserRepo;
import edu.miu.shopmartbackend.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private ShoppingCartRepo shoppingCartRepo;


    @Override
    public boolean unFollowSeller(long buyer_id, long seller_id) {
        User buyer = userRepo.getUserById(buyer_id);
        System.out.println("before........." + buyer.isFollowing());

        List<Follow> following = buyer.getFollowings();

        if (following == null) {
            return false;

        }
        for (Follow f : following) {
            if (f.getBuyer().getId() == buyer_id && f.getSeller().getId() == seller_id) {
                System.out.println("inside if....." + buyer.isFollowing());
                following.remove(f);
                buyer.setFollowing(false);

                buyer.setFollowings(following);
                System.out.println("inside if.....2....." + buyer.isFollowing());
                userRepo.save(buyer);
            }
            return false;

        }


        return true;//following.stream().collect(Collectors.toList());


    }


        @Override
        public Boolean isFollowing ( long buyer_id, long seller_id){
            User buyer = userRepo.getUserById(buyer_id);
            System.out.println("inside if.....isFollowing" + buyer.isFollowing());

            if(buyer == null )
                return null;

            List<Follow> followings = buyer.getFollowings();
            if(followings == null){
                return false;
            }

            for(Follow f : followings){
                if(f.getBuyer().getId() == buyer_id && f.getSeller().getId()==seller_id){
                    buyer.setFollowing(true);
                    return true;
                }
                System.out.println("inside if..2...isFollowing" + buyer.isFollowing());

            }

            return false;
        }


    @Override
    public List<Follow> followSeller(long buyer_id, long seller_id) {
        User buyer = userRepo.getUserById(buyer_id);
        User seller = userRepo.getUserById(seller_id);

        if(buyer == null || seller==null)
            throw new RuntimeException("seller or buyer is null");

        List<Follow> followings = buyer.getFollowings();
        if(followings == null){
            followings = new ArrayList<>();
        }
        for(Follow f : followings){
            if(f.getBuyer().getId() == buyer_id && f.getSeller().getId()==seller_id){
                throw new RuntimeException("already following");

            }
        }
        Follow newFollow = new Follow(null, buyer, seller);
        followings.add(newFollow);
        buyer.setFollowing(true);

        userRepo.save(buyer);
        return followings.stream().collect(Collectors.toList());
        //return followings;

    }
}
