// Package and imports

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "author_book",
        joinColumns = @JoinColumn(name = "author_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id"),
        foreignKey = @ForeignKey(name = "fk_author"),
        inverseForeignKey = @ForeignKey(name = "fk_book")
    )
    @BatchSize(size = 20) // for batch loading
    private Set<Book> books = new HashSet<>();
    
    // helper methods
    public void addBook(Book book) {
        books.add(book);
        book.getAuthors().add(this);
    }
  public void removeBook(Book book) {
        books.remove(book);
        book.getAuthors().remove(this);
    }
    
    // standard getters/setters
}
