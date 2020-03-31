package cn.iocoder.mall.user.biz.dao;

import cn.iocoder.mall.user.biz.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    void insert(UserDO entity);

    int update(UserDO entity);

    UserDO selectByMobile(@Param("mobile") String mobile);

    UserDO selectById(@Param("id") Integer id);

    List<UserDO> selectListByNicknameLike(@Param("nickname") String nickname,
                                          @Param("status") Integer status,
                                          @Param("offset") Integer offset,
                                          @Param("limit") Integer limit);

    Integer selectCountByNicknameLike(@Param("nickname") String nickname,
                                      @Param("status") Integer status);

}
