@Embeddable
public class StudentCourseKey implements Serializable {
    private Long studentId;
    private Long courseId;
    
    // constructors, equals, hashCode
}

@Entity
public class StudentCourse {
    @EmbeddedId
    private StudentCourseKey id;
    
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
    
    // additional fields
    
    // constructors, getters, setters
}
