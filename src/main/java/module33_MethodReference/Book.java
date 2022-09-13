package module33_MethodReference;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

class Book {
    private String title;
    private String isbn;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static Book releaseBook(Book book, String isbn) {
        if (Objects.isNull(book.isbn)) {
            book.setIsbn(isbn);
        }
        return book;
    }

    public String getTitleAndIsbnWithSeparator(String separator) {
        return title + separator + isbn;
    }

    public static void main(String[] args) {
        Book book = new Book("12321");
        BiFunction<Book, String, Book> a = (book2, isbn1) -> releaseBook(book2, isbn1);
        Function<String, Book> b = title1 -> new Book(title1);
        Function<Book, String> c = book1 -> book1.getIsbn();
        Function<String, String> d = separator -> book.getTitleAndIsbnWithSeparator(separator);

    }
}