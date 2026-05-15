package dev.gabryel.ecommerce.dto.product.response;

import dev.gabryel.ecommerce.model.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductListByAttributeResponse(UUID id, String name, String description, BigDecimal price,
                                             ProductStatus status, String sellerName) {
}
