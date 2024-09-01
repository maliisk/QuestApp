package com.example.questApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) //Bir userin birden çok postu olabilir. Fetch işlemi ise ; örneğin post objesni çektiğimde ilgili useri getirmene gerek yok
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde tüm postları silinsin!
    @JsonIgnore // serialization kısmında problem çıkmasın diye bu alanı ignore ediyoruz.
    User user;

    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
