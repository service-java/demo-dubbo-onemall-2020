package cn.iocoder.mall.pay.biz.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TODO 重复支付的交易
 *
 * 可能不靠这个表，而是差错处理。
 */
@Data
@Accessors(chain = true)
@Deprecated
public class PayRepeatTransactionDO {
}
