package problems.toast.menurecurse;

import java.util.*;

public class MenuSolution {

    public static void main(String[] args) {
        Collection<Menu> menus = initialiseMenus();
        Deque<Double> priceStack = new ArrayDeque<>();
        findPriceForItemInMenus("Eggs", menus, priceStack);
        System.out.println(priceStack);
    }

    public static void findPriceForItemInMenus(String itemName, Collection<Menu> menus, Deque<Double> priceStack){
        for (Menu menu : menus){
            boolean addedValue = false;
            if (menu.getPrice() != null) {
                priceStack.push(menu.getPrice());
                addedValue = true;
            }
            boolean priceFound = findPriceForItemInItemGroups(itemName, menu.getGroups(), priceStack);
            if(priceFound) {
                return;
            } else if(addedValue) {
                priceStack.pop();
            }
        }
    }

    private static boolean findPriceForItemInItemGroups(String itemName, Collection<MenuGroup> groups, Deque<Double> priceStack){
        for (MenuGroup group : groups) {
            boolean addedValue = false;
            if (group.getPrice() != null) {
                priceStack.push(group.getPrice());
                addedValue = true;
            }
            boolean itemFound = findPriceForItemInItems(itemName, group.getItems(), priceStack);
            if (itemFound) {
                return true;
            } else {
                boolean priceFoundInGroup = findPriceForItemInItemGroups(itemName, group.getGroups(), priceStack);
                if(priceFoundInGroup){
                    return true;
                } else if(addedValue) {
                    priceStack.pop();
                }
            }
        }
        return false;
    }

    private static boolean findPriceForItemInItems(String itemName, Collection<MenuItem> items, Deque<Double> priceStack){
            for (MenuItem item : items) {
                if (item.getItemName().equals(itemName)) {
                    if(item.getPrice() != null) {
                        priceStack.push(item.getPrice());
                    }
                    return true;
                }
            }
        return false;
    }

    private static Collection<Menu> initialiseMenus(){
        // Starters
        // Soups
        MenuItem tomatoSoup = new MenuItem("Tomato Soup", null);
        MenuItem vegetableSoup = new MenuItem( "Vegetable Soup", null);
        Collection<MenuItem> soupItems = Arrays.asList(tomatoSoup,vegetableSoup);
        MenuGroup soupGroup = new MenuGroup(Collections.emptyList(), soupItems, 5.00);

        // Salad
        MenuItem caesarSalad = new MenuItem( "Caesar Salad", 8.50);

        // Starters
        Collection<MenuGroup> starterGroups = Arrays.asList(soupGroup);
        MenuGroup starters = new MenuGroup(starterGroups, Arrays.asList(caesarSalad), null);

        // Mains

        // Meats
        MenuItem beefDish = new MenuItem("Beef Dish", null);
        MenuItem lambDish = new MenuItem("Lamb Dish", null);
        Collection<MenuItem> meatItems = Arrays.asList(beefDish, lambDish);
        MenuGroup meatGroup = new MenuGroup(Collections.emptyList(), meatItems, null);

        // Fish
        MenuItem fishDish = new MenuItem("Fish Dish", null);
        Collection<MenuItem> fishItems = Arrays.asList(fishDish);
        MenuGroup fishGroup = new MenuGroup(Collections.emptyList(), fishItems, null);

        // Vegetarian
        MenuItem sweetPotatoDish = new MenuItem("Sweet Potato Dish", 9.50);
        Collection<MenuItem> vegetarianItems = Arrays.asList(sweetPotatoDish);
        MenuGroup vegetarianGroup = new MenuGroup(Collections.emptyList(), vegetarianItems, 9.00);

        Collection<MenuGroup> mainsOptionGroups = Arrays.asList(meatGroup, fishGroup, vegetarianGroup);
        MenuGroup mains = new MenuGroup(mainsOptionGroups, Collections.emptyList(), 13.00);

        Collection<MenuGroup> dinnerGroups = Arrays.asList(starters, mains);
        Menu dinner = new Menu(dinnerGroups, 12.00);

        return Arrays.asList(dinner);
    }

}
