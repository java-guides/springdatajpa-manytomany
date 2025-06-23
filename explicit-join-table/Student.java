// PAckage and exports
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourses = new HashSet<>();
    
    // constructors, getters, setters
}
