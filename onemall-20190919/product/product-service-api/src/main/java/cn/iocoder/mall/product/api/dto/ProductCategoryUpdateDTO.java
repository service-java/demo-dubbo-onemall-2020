package cn.iocoder.mall.product.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 商品分类更新 DTO
 */
@Data
@Accessors(chain = true)
public class ProductCategoryUpdateDTO {

    /**
     * 编号
     */
    @NotNull(message = "编号不能为空")
    private Integer id;
    /**
     * 父分类编号
     */
    @NotNull(message = "父分类编号不能为空")
    private Integer pid;
    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    private String name;
    /**
     * 描述
     */
    @NotNull(message = "描述不能为空")
    private String description;
    /**
     * 分类图片
     */
//    @NotNull(message = "分类图片不能为空")
    private String picUrl;
    /**
     * 排序值
     */
    @NotNull(message = "排序值不能为空")
    private Integer sort;

}
