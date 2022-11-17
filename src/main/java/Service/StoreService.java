package Service;

import com.example.homework211.Component.Basket;
import model.Item;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final Map<Integer, Item> items = new HashMap<>();

    private final Basket basket;

    public StoreService(Basket basket) {
        this.basket = basket;
    }

    @PostConstruct
    public void init() {
        items.put(1, new Item(1, "Смартфон", 70_000));
        items.put(2, new Item(2, "Стекло", 1_000));
        items.put(3, new Item(3, "Чехол", 2_000));
        items.put(4, new Item(4, "Гарнитура", 5_000));
    }



    public List<Item> get() {
        return basket.get();
    }

    public void add (List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(items::get)
                        .collect(Collectors.toList())
        );
    }
}
