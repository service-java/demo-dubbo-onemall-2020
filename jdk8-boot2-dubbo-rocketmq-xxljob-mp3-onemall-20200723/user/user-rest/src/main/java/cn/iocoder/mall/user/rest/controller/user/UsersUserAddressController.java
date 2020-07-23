package cn.iocoder.mall.user.rest.controller.user;

import cn.iocoder.common.framework.vo.CommonResult;
import cn.iocoder.mall.security.core.context.UserSecurityContextHolder;
import cn.iocoder.mall.user.biz.dto.user.UserAddressAddDTO;
import cn.iocoder.mall.user.biz.dto.user.UserAddressUpdateDTO;
import cn.iocoder.mall.user.biz.service.user.UserAddressService;
import cn.iocoder.mall.user.rest.convert.UserAddressConvert;
import cn.iocoder.mall.user.rest.request.user.UserAddressAddRequest;
import cn.iocoder.mall.user.rest.request.user.UserAddressUpdateRequest;
import cn.iocoder.mall.user.rest.response.user.UserAddressResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户地址(user API)
 *
 * author: sin
 * time: 2020/5/8 9:50
 */
@RestController
@Api(tags = "用户地址(user API)") // TODO FROM 芋艿 to 小范："管理员 - 管理员 API" 按照类似酱紫的格式哈。= = 虽然我也没想太好格式。
@RequestMapping("/users/user-address")
public class UsersUserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("list-address")
    @ApiOperation("获取 - 地址列表(all)")
    public CommonResult<List<UserAddressResponse>> listAddress() {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        return CommonResult.success(UserAddressConvert.INSTANCE.convert(userAddressService.listAddress(userId)));
    }

    @GetMapping("{addressId}")
    @ApiOperation("获取 - 根据id获取")
    public CommonResult<UserAddressResponse> getAddress(@PathVariable("addressId") Integer addressId) {
        return CommonResult.success(UserAddressConvert.INSTANCE.convert(userAddressService.getAddress(addressId)));
    }

    @GetMapping("default")
    @ApiOperation("获取 - 获取默认地址")
    public CommonResult<UserAddressResponse> getDefaultAddress() {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        return CommonResult.success(UserAddressConvert.INSTANCE.convert(userAddressService.getDefaultAddress(userId)));
    }

    @DeleteMapping("/{addressId}/remove")
    @ApiOperation("删除 - 根据id删除")
    public CommonResult getDefaultAddress(@PathVariable("addressId") Integer addressId) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        userAddressService.removeAddress(userId, addressId);
        return CommonResult.success(null);
    }

    @PostMapping("/add-address")
    @ApiOperation("添加地址")
    public CommonResult addAddress(@RequestBody @Valid UserAddressAddRequest userAddressAddRequest) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        UserAddressAddDTO userAddressAddDTO = UserAddressConvert.INSTANCE.convert(userAddressAddRequest);
        userAddressAddDTO.setUserId(userId);
        userAddressService.addAddress(userAddressAddDTO);
        return CommonResult.success(null);
    }

    @PutMapping("/update-address")
    @ApiOperation("更新地址")
    public CommonResult updateAddress(@RequestBody @Valid UserAddressUpdateRequest userAddressAddRequest) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        UserAddressUpdateDTO userAddressAddDTO = UserAddressConvert.INSTANCE.convert(userAddressAddRequest);
        userAddressAddDTO.setUserId(userId);
        userAddressService.updateAddress(userAddressAddDTO);
        return CommonResult.success(null);
    }
}
