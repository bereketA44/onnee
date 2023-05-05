package com.app.onnee.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity(name = "User_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String profilePicture;

    @JsonManagedReference
    @NonNull
    @OneToOne(mappedBy = "profile")
    private User user;
}
