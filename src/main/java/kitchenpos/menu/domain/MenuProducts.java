package kitchenpos.menu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class MenuProducts {
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<MenuProduct> products = new ArrayList<>();

    protected MenuProducts() {
    }

    public List<MenuProduct> getProducts() {
        return products;
    }

    public void addAll(List<MenuProduct> menuProducts) {
        this.products.addAll(menuProducts);
    }

}
