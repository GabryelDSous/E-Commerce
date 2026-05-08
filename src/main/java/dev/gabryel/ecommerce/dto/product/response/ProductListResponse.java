package dev.gabryel.ecommerce.dto.product.response;

import dev.gabryel.ecommerce.model.enums.ProductStatus;

import java.math.BigDecimal;

public record ProductListResponse(String name, BigDecimal price, String sellerName, ProductStatus status) {
}
