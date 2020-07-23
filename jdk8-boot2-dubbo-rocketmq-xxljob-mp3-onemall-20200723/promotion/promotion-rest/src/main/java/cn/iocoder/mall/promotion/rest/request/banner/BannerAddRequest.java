package cn.iocoder.mall.promotion.rest.request.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * banner：更新 banner
 *
 * author: sin
 * time: 2020/5/14 15:44
 */
@Data
@Accessors(chain = true)
public class BannerAddRequest implements Serializable {

    @NotNull // TODO FROM 芋艿 to 小范：提示要加下，哈哈哈
    @ApiModelProperty("跳转链接")
    private Integer url;

    @NotNull
    @ApiModelProperty("图片链接")
    private Integer picUrl;

    @NotNull
    @ApiModelProperty("排序")
    private Integer sort;

    @NotNull
    @ApiModelProperty("备注")
    private Integer memo;
}
