package org.jsamples.microservices.product.services.vo;

import org.jsamples.microservices.product.services.datasource.domain.Product;
import org.jsamples.microservices.product.services.vo.map.ProductListVO;
import org.jsamples.microservices.product.services.vo.map.ProductVO;
import org.jsamples.microservices.seedwork.map.Mapper;
import org.jsamples.microservices.seedwork.map.MapperFactory;
import org.modelmapper.PropertyMap;

public final class ProductMapper {
    private static final Mapper MAPPER = MapperFactory.getMapper(ProductMapper.class);

    static public Product map(ProductVO source) {
        return MAPPER.map(source, Product.class);
    }

    static public ProductVO map(Product source) {
        return MAPPER.map(source, ProductVO.class);
    }

    static public ProductListVO mapList(Product source) {
        return MAPPER.map(source, ProductListVO.class);
    }

    //<editor-fold desc="Mappings">
    public class Product2ProdutVO extends PropertyMap<ProductVO, Product> {

        public Product2ProdutVO() {}

        @Override
        protected void configure() {
            this.map().setId(0);
        }
    }
    //</editor-fold>
}
