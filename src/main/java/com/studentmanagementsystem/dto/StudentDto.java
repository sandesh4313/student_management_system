package com.studentmanagementsystem.dto;

import com.studentmanagementsystem.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private Status status;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
