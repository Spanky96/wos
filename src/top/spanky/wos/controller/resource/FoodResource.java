package top.spanky.wos.controller.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import top.spanky.wos.model.Food;
import top.spanky.wos.model.FoodType;

public class FoodResource {

    private List<FoodGroup> foods = new ArrayList<FoodGroup>();

    public List<FoodGroup> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodGroup> foods) {
        this.foods = foods;
    }

    public class FoodGroup {
        private int index;
        private String name;
        private List foods;

        public FoodGroup(FoodType type) {
            this.index = type.getIndex();
            this.name = type.getName();
            this.foods = new ArrayList<Food>();
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List getFoods() {
            return foods;
        }

        public void setFoods(List foods) {
            this.foods = foods;
        }

    }

    public FoodResource(List<Food> foodList) {
        HashMap<FoodType, List<Food>> foodMap = new HashMap<FoodType, List<Food>>();
        for (Food food : foodList) {
            FoodType foodType = food.getFoodType();
            List<Food> list = foodMap.get(foodType);
            if (list == null) {
                list = new ArrayList<>();
                list.add(food);
                foodMap.put(foodType, list);
            } else {
                list.add(food);
            }
        }

        for (FoodType foodType : foodMap.keySet()) {
            FoodGroup group = new FoodGroup(foodType);
            group.setFoods(foodMap.get(foodType));
            foods.add(group);
        }
    }
}
