package problems.toast.menurecurse;

import java.util.Collection;

public class Menu {
    private Collection<MenuGroup> groups;
    private Double price;

    public Menu(Collection<MenuGroup> groups, Double price) {
        this.groups = groups;
        this.price = price;
    }

    public Collection<MenuGroup> getGroups() {
        return groups;
    }

    public void setGroups(Collection<MenuGroup> groups) {
        this.groups = groups;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
