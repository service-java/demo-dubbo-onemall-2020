import request from "../config/request";

export function GetFavoritePage(pageNo,pageSize){
  return request({
    url: '/user-api/users/favorite/page',
    method: 'get',
    params: { pageNo,pageSize }
  })
}

export function DelFavorite(spuId){
  return request({
    url: '/user-api/users/favorite/remove',
    method: 'DELETE',
    params: { spuId }
  })
}

export function hasUserSpuFavorite(spuId){
  return request({
    url: '/user-api/users/favorite/hasUserFavorite',
    method: 'get',
    params: {spuId}
  })
}


export function GetCoupon(data){
  return request({
    url: '/User/GetCoupon',
    method: 'Post',
    params: { data }
  })
}

export function ExchangeCoupon(code){
  return request({
    url: '/User/ExchangeCoupon',
    method: 'Post',
    params: { code:code }
  })
}

export function getUserInfo() {
  return request({
    url: '/user-api/users/user/info',
    method: 'get',
  });
}

export function doUserUpdateNickname(nickname) {
  return request({
    url: '/user-api/users/user/update_nickname',
    method: 'post',
    params: {
      nickname,
    }
  });
}

export function doPassportMobileRegister(mobile, code) {
  return request({
    url: '/user-api/users/passport/mobile/register',
    method: 'post',
    params: {
      mobile,
      code,
    }
  });
}

export function doPassportMobileSendRegisterCode(mobile) {
  return request({
    url: '/user-api/users/passport/mobile/send_register_code',
    method: 'post',
    params: {
      mobile,
    }
  });
}



// -------------------------- address

export function GetAddressList(){
  return request({
    url: '/user-api/users/address/list',
    method: 'get',
  })
}

export function GetAddressById(id){
  return request({
    url: '/user-api/users/address/address',
    method: 'get',
    params: { id }
  })
}

export function GetDefaultAddress(){
  return request({
    url: '/user-api/users/address/default_address',
    method: 'get',
  })
}

export function UpdateAddress(data){
  return request({
    url: '/user-api/users/address/update',
    method: 'PUT',
    params: data
  })
}

export function SaveAddress(data){
  return request({
    url: '/user-api/users/address/add',
    method: 'POST',
    params: data
  })
}

export function DelAddress(data){
  return request({
    url: '/user-api/users/address/remove',
    method: 'DELETE',
    params: data
  })
}
