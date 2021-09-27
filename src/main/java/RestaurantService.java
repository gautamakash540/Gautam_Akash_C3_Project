import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName)throws restaurantNotFoundException{

        Restaurant restaurant = restaurants.stream()
                .filter(x -> restaurantName.equals(x.getName()) )
                .findAny()
                .orElse(null);
        if(restaurant==null){
            throw new restaurantNotFoundException("Restaurant does't exist!");
        }
        return restaurant;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if(restaurantToBeRemoved!=null) {
            restaurants.remove(restaurantToBeRemoved);
        }else
        {
            throw  new restaurantNotFoundException("Restaurannts does't exist!");
        }
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
