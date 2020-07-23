package cn.iocoder.mall.user.biz.dao.user;

import cn.iocoder.mall.user.biz.dataobject.user.UsersUserAddressDO;
import cn.iocoder.mall.user.biz.enums.user.UserAddressHasDefaultEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 地址
 *
 * @author Sin
 * @time 2019-04-06 13:29
 */
@Repository
// TODO done FROM 芋艿 to 小范：替换成 Mybatis Plus
public interface UserAddressMapper extends BaseMapper<UsersUserAddressDO> {

    default List<UsersUserAddressDO> selectByUserId(Integer userId) {
        LambdaQueryWrapper<UsersUserAddressDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UsersUserAddressDO::getUserId, userId);
        return selectList(wrapper);
    }

    default UsersUserAddressDO selectHasDefault(Integer userId) {
        LambdaQueryWrapper<UsersUserAddressDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UsersUserAddressDO::getUserId, userId);
        wrapper.eq(UsersUserAddressDO::getHasDefault, UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue());
        return selectOne(wrapper);
    }
}
