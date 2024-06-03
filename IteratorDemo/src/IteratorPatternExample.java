import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Giao diện Iterator
interface Iterator {
    boolean hasNext();
    Product next();
}

// Lớp triển khai Iterator cho danh sách sản phẩm
class ProductIterator implements Iterator {
    private List<Product> products;
    private int position;

    public ProductIterator(List<Product> products) {
        this.products = products;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public Product next() {
        if (hasNext()) {
            Product product = products.get(position);
            position++;
            return product;
        }
        return null;
    }
}

// Main class để thực hiện ví dụ
public class IteratorPatternExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1"));
        products.add(new Product("Product 2"));
        products.add(new Product("Product 3"));

        Iterator iterator = new ProductIterator(products);

        while (iterator.hasNext()) {
            Product product = iterator.next();
            System.out.println(product.getName());
        }
    }
}