package problems.toast.menurecurse;

import java.util.Collection;

public class MenuGroup {
    private Collection<MenuGroup> groups;
    private Collection<MenuItem> items;
    private Double price;

    public MenuGroup(Collection<MenuGroup> groups, Collection<MenuItem> items, Double price) {
        this.groups = groups;
        this.items = items;
        this.price = price;
    }

    public Collection<MenuGroup> getGroups() {
        return groups;
    }

    public void setGroups(Collection<MenuGroup> groups) {
        this.groups = groups;
    }

    public Collection<MenuItem> getItems() {
        return items;
    }

    public void setItems(Collection<MenuItem> items) {
        this.items = items;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
