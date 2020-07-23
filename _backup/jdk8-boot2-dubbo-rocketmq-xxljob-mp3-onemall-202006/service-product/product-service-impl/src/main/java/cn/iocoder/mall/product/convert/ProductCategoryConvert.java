package cn.iocoder.mall.product.convert;

import cn.iocoder.mall.product.api.bo.ProductCategoryBO;
import cn.iocoder.mall.product.api.dto.ProductCategoryAddDTO;
import cn.iocoder.mall.product.api.dto.ProductCategoryUpdateDTO;
import cn.iocoder.mall.product.dataobject.ProductCategoryDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductCategoryConvert {

    ProductCategoryConvert INSTANCE = Mappers.getMapper(ProductCategoryConvert.class);

    @Mappings({})
    ProductCategoryBO convertToBO(ProductCategoryDO category);

    @Mappings({})
    List<ProductCategoryBO> convertToBO(List<ProductCategoryDO> categoryList);

    @Mappings({})
    ProductCategoryDO convert(ProductCategoryAddDTO productCategoryAddDTO);

    @Mappings({})
    ProductCategoryDO convert(ProductCategoryUpdateDTO productCategoryUpdateDTO);

}