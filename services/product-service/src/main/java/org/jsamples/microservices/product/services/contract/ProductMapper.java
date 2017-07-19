package org.jsamples.microservices.product.services.contract;

import org.jsamples.microservices.product.services.datasource.domain.Product;
import org.jsamples.microservices.product.services.contract.vo.ProductVO;
import org.jsamples.microservices.seedwork.binding.Mapper;
import org.jsamples.microservices.seedwork.binding.MapperFactory;
import org.modelmapper.PropertyMap;

public final class ProductMapper {
    private static final Mapper MAPPER = MapperFactory.getMapper(ProductMapper.class);

    static public Product map(ProductVO source) {
        return MAPPER.map(source, Product.class);
    }

    static public ProductVO map(Product source) {
        return MAPPER.map(source, ProductVO.class);
    }

    static public ProductVO map(Product source, ProductVO target) {
        return MAPPER.map(source, target);
    }

    //<editor-fold desc="Mappings">
    public class Product2ProductVO extends PropertyMap<ProductVO, Product> {

        @Override
        protected void configure() {
            this.skip().setId(0);
        }
    }
    //</editor-fold>
}
