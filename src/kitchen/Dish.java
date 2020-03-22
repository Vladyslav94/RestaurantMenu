package kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        return String.valueOf(Dish.Fish) + Dish.Steak + Dish.Soup + Dish.Juice + Dish.Water;
    }
}

