package kitchenpos.order.domain;

import kitchenpos.generic.Quantity;
import kitchenpos.menu.domain.Menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @JoinColumn(name = "orderId")
    @ManyToOne
    private Order order;

    @JoinColumn(name = "menuId")
    @ManyToOne
    private Menu menu;

    @Column
    private Quantity quantity;

    protected OrderLineItem() {
    }

    public OrderLineItem(Order order, Menu menu, Quantity quantity) {
        this.order = order;
        this.menu = menu;
        this.quantity = quantity;
    }
}
