package com.example.csj21webappultimateway;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public User(String name, String email, String phone, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
}
