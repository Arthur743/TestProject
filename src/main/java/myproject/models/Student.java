package myproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="students")
@Component("products")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "type_of_document")
    private String typeOfDocument;

    @Column(name = "program")
    private String program;

    @Column(name = "manager")
    private String manager;

    @Column(name = "full_name_student")
    private String fullNameStudent;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "form")
    private String form;

    @Column(name = "enrollment_date")
    private Date enrollmentDate;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "number_of_hours")
    private int numberOfHours;

    @Column(name = "the_level_of_education")
    private String theLevelOfEducation;

    @Column(name = "commission_decision")
    private String commissionDecision;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "job_title")
    private String jobTitle;

    public Student(String typeOfDocument, String program, String manager, String fullNameStudent, String registrationNumber, String form, Date enrollmentDate, Date releaseDate, String nameGroup, int numberOfHours, String theLevelOfEducation, String commissionDecision, String placeOfWork, String jobTitle) {
        this.typeOfDocument = typeOfDocument;
        this.program = program;
        this.manager = manager;
        this.fullNameStudent = fullNameStudent;
        this.registrationNumber = registrationNumber;
        this.form = form;
        this.enrollmentDate = enrollmentDate;
        this.releaseDate = releaseDate;
        this.nameGroup = nameGroup;
        this.numberOfHours = numberOfHours;
        this.theLevelOfEducation = theLevelOfEducation;
        this.commissionDecision = commissionDecision;
        this.placeOfWork = placeOfWork;
        this.jobTitle = jobTitle;
    }


}
