package edu.miu.shopmartbackend.service;

import edu.miu.shopmartbackend.model.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BuyerService {

    boolean unFollowSeller(long buyer_id, long seller_id);

    Boolean isFollowing(long buyer_id, long seller_id);

    List<Follow> followSeller( long buyer_id, long seller_id);
}
