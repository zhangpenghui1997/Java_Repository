import java.math.BigDecimal;

public class Book {
    private String name;
    private Double price;
    private String author;
    private String sn;
    private String other;

    public Book(String name, Double price, String author, String sn, String other) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.sn = sn;
        this.other = other;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", sn='" + sn + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
