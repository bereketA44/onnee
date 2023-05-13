package com.app.onnee.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String description;


    @JsonBackReference
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="profile_id")
    private Profile profile;

    @PrePersist
    public void logNewUserAttempt() {
        System.out.println("Attempting to add new user with username: ");
    }
    }
