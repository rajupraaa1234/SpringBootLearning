package com.SpringBootLearning.SpringLearning.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
    private User user;


//    public VerificationToken(User user,String token,Long id){
//        super();
//        this.token = token;
//        this.id = id;
//        this.user = user;
//        this.expirationTime = calculateExpirationDate(10);
//    }

    public Date calculateExpirationDate(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,i);
        return new Date(calendar.getTime().getTime());
    }

//    public VerificationToken(String token){
//        super();
//        this.token = token;
//        this.expirationTime = calculateExpirationDate(10);
//    }

}
