package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private Long id;

    private String username;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }
}
