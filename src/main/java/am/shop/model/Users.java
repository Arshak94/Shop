package am.shop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String gender;
    private Date dob;
    private String state;
    private String city;
    private String zipCode;
    private String serialNumber;
    private String registerType;
   /* @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Token token;*/
}

