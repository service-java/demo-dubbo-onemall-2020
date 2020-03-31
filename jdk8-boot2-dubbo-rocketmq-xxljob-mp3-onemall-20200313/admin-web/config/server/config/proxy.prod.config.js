// production 配置文件

module.exports = {
  '/admin-api/': {
    target: 'http://api.shop.iocoder.cn:18099',
    changeOrigin: true,
    pathRewrite: {},
  },
  '/product-api/': {
    target: 'http://api.shop.iocoder.cn:18099',
    changeOrigin: true,
    pathRewrite: {},
  },
  '/order-api/': {
    target: 'http://api.shop.iocoder.cn:18099',
    changeOrigin: true,
    pathRewrite: {},
  },
  '/promotion-api/': {
    target: 'http://api.shop.iocoder.cn:18099',
    changeOrigin: true,
    pathRewrite: {},
  },
  '/pay-api/': {
    target: 'http://api.shop.iocoder.cn:18099',
    changeOrigin: true,
    pathRewrite: {},
  },
  '/user-api/': {
    target: 'http://api.shop.iocoder.cn:18099',
    changeOrigin: true,
    pathRewrite: {},
  },
  '/server/api/': {
    target: 'https://preview.pro.ant.design/',
    changeOrigin: true,
    pathRewrite: { '^/server': '' },
  },
};
