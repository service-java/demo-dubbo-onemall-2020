import request from "../config/request";

export function getProductCategoryList(pid) {
  return request({
    url: '/product-api/users/category/list',
    method: 'get',
    params: {
      pid
    }
  });
}

export function getProductSpuPage(cid, pageNo, pageSize) {
  return request({
    url: '/product-api/users/spu/page',
    method: 'get',
    params: {
      cid,
      pageNo: pageNo || 1,
      pageSize: pageSize || 10,
    }
  });
}

export function getProductSpuInfo(id) {
  return request({
    url: '/product-api/users/spu/info',
    method: 'get',
    params: {
      id,
    }
  });
}

export function collectionSpu(spuId,hasCollectionType) {
  return request({
    url: '/product-api/users/spu/collection/'+spuId+'/' + hasCollectionType,
    method: 'post'
  });
}
