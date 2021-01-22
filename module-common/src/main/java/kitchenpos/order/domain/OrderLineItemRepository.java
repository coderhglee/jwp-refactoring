package kitchenpos.order.domain;

import kitchenpos.domain.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {
}
