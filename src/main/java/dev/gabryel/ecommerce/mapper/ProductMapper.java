package dev.gabryel.ecommerce.mapper;

import dev.gabryel.ecommerce.dto.product.request.ProductRegisterRequest;
import dev.gabryel.ecommerce.dto.product.response.ProductRegisterResponse;
import dev.gabryel.ecommerce.model.ProductModel;
import dev.gabryel.ecommerce.model.enums.ProductStatus;

public class ProductMapper {

    public static ProductModel toProductModel(ProductRegisterRequest productRequest) {
        ProductModel productModel = new ProductModel();
        productModel.setName(productRequest.name());
        productModel.setDescription(productRequest.description());
        productModel.setPrice(productRequest.price());
        productModel.setStock(productRequest.stock());
        productModel.setStatus(
                productRequest.stock() > 0 ? ProductStatus.ACTIVE : ProductStatus.OUT_OF_STOCK
        );
        return productModel;
    }

    public static ProductRegisterResponse toProductRegisterResponse(ProductModel productModel) {
        return new ProductRegisterResponse(
                productModel.getName(),
                productModel.getSellerName(),
                productModel.getPrice(),
                productModel.getStock(),
                productModel.getStatus()
        );
    }
}
