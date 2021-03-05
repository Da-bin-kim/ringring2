package com.dessert.ringring.mapper;

import com.dessert.ringring.domain.DTOCart;
import com.dessert.ringring.domain.DTOMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
@Repository
=======

>>>>>>> mina/main
@Mapper
public interface CartMapper {
    int insertCart(DTOCart cart);
    List<DTOCart> listCart(String userId);
    int updateCart(int idx);
    int deleteCart(int idx);
    int sumMoney(String userId);
    int deleteAll(String userId);
    int countCart(String userId);

    


}
