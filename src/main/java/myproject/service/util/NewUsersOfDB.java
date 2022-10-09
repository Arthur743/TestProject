package myproject.service.util;

import myproject.models.Role;
import myproject.models.Student;
import myproject.models.User;
import myproject.service.abstracts.RoleService;
import myproject.service.abstracts.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import myproject.service.abstracts.UserService;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class NewUsersOfDB {

    private final UserService userService;

    private final RoleService roleService;

    private final StudentService studentService;

    @Autowired
    public NewUsersOfDB(UserService userService, RoleService roleService, StudentService studentService) {
        this.userService = userService;
        this.roleService = roleService;
        this.studentService = studentService;
    }

    @PostConstruct
    public void createUsersWithRoles() {
        roleService.setRole(new Role("ADMIN"));
        roleService.setRole(new Role("USER"));

        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleService.getRole("ADMIN"));
        roles1.add(roleService.getRole("USER"));
        userService.setUser(new User("Faina", "Amandosova", "1","11", roles1));

        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleService.getRole("USER"));
        userService.setUser(new User("Diana", "Aktuganova", "2", "22", roles2));

        studentService.setStudent(new Student("Диплом", "program1", "УМ/2507/2", "Фамилия Имя Отчество 1","КО/001", "781800428203", new Date(11112001), new Date(11112011), "Д", 144, "Уровень образования1", "Решение комиссии 1", "Место работы 1", "Должность 1"));
        studentService.setStudent(new Student("КЦН", "program2", "УМ/1403/09/1", "Фамилия Имя Отчество 2","ТА/001", "781800428204", new Date(12112002), new Date(11112012), "А", 72, "Уровень образования2", "Решение комиссии 2", "Место работы 2", "Должность 2"));
        studentService.setStudent(new Student("Охрана труда", "program3", "ПЮ/3691/1", "Фамилия Имя Отчество 3","ТА/006", "781800428205", new Date(13112003), new Date(11112013), "С", 520, "Уровень образования3", "Решение комиссии 3", "Место работы 3", "Должность 3"));
        studentService.setStudent(new Student("Удостоверение", "program4", "ПЮ/3755/1", "Фамилия Имя Отчество 4","ТА/006", "781800428206", new Date(14112004), new Date(11112014), "А", 144, "Уровень образования4", "Решение комиссии 4", "Место работы 4", "Должность 4"));
        studentService.setStudent(new Student("Диплом", "program5", "ПЮ/3691/1", "Фамилия Имя Отчество 5","ТА/005", "781800428207", new Date(15112005), new Date(11112015), "В", 300, "Уровень образования5", "Решение комиссии 5", "Место работы 5", "Должность 5"));
        studentService.setStudent(new Student("tod6", "program6", "ПЮ/3765/1", "Фамилия Имя Отчество 6","ТА/001", "781800428208", new Date(16112006), new Date(11112016), "А", 520, "Уровень образования6", "Решение комиссии 6", "Место работы 6", "Должность 6"));
        studentService.setStudent(new Student("Свидетельство", "program7", "ШГ/3477/1", "Фамилия Имя Отчество 7","ТА/001", "781800428209", new Date(17112007), new Date(11112017), "Д", 144, "Уровень образования7", "Решение комиссии 7", "Место работы 7", "Должность 7"));
        studentService.setStudent(new Student("Фигня какаято", "program8", "УМ/1641/1", "Фамилия Имя Отчество 8","ТА/001", "781800428211", new Date(18112008), new Date(11112018), "Г", 72, "Уровень образования8", "Решение комиссии 8", "Место работы 8", "Должность 8"));
        studentService.setStudent(new Student("КЦН", "program9", "ПЮ/3691/1", "Фамилия Имя Отчество 9","КО/001", "781800428212", new Date(19112009), new Date(11112019), "А", 144, "Уровень образования9", "Решение комиссии 9", "Место работы 9", "Должность 9"));
    }
}
