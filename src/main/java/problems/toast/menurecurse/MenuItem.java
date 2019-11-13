package problems.toast.menurecurse;

public class MenuItem {
    private String itemName;
    private Double price;

    public MenuItem(String itemName, Double price) {

        this.itemName = itemName;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
