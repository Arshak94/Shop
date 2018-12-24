package am.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String accessToken;
    private String refreshToken;

   /* @OneToOne(fetch = FetchType.LAZY)
    //alter table token add constraint FKkpus1i666n5yuagi4p45s2edw foreign key (token_generator) references user" via JDBC Statement
    @JoinColumn(name = "token_generator",referencedColumnName = "user")
    private User user;*/

}
