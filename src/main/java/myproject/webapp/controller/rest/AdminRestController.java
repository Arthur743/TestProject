package myproject.webapp.controller.rest;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import myproject.models.Role;
import myproject.models.User;
import myproject.service.abstracts.RoleService;
import myproject.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    @Operation(summary = "Get all users", responses = {
            @ApiResponse(responseCode = "200", description = "Users received"),
            @ApiResponse(responseCode = "400", description = "Error on the client side")})
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(
                userService.getUsers(),
                HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Get user", responses = {
            @ApiResponse(responseCode = "200", description = "User received"),
            @ApiResponse(responseCode = "400", description = "Error on the client side")})
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return new ResponseEntity<>(
                userService.getUser(id),
                HttpStatus.OK);
    }

    @GetMapping("/roles/all")
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(
                roleService.getRoles(),
                HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Integer id) {
        return new ResponseEntity<>(
                roleService.getSpecificRoles(id),
                HttpStatus.OK);
    }

    @GetMapping("/users/me")
    public ResponseEntity<User> getActiveUser(Principal principal) {
        return new ResponseEntity<>(
                userService.getSpecificUser(principal.getName()),
                HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> setUser(@RequestBody User user) {
        userService.setUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles/ofUser/{id}")
    public ResponseEntity<String> getRolesOfUser(@PathVariable Integer id) {
        return new ResponseEntity<>(
                userService.getUser(id).toStringRoles(),
                HttpStatus.OK);
    }

}
