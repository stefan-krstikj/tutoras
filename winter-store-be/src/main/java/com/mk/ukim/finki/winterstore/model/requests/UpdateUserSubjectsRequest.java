package com.mk.ukim.finki.winterstore.model.requests;

import com.mk.ukim.finki.winterstore.model.response.SubjectResponse;

import java.util.List;

public class UpdateUserSubjectsRequest {
    private String username;
    private List<SubjectResponse> subjects;

    public UpdateUserSubjectsRequest(String username, List<SubjectResponse> subjects) {
        this.username = username;
        this.subjects = subjects;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<SubjectResponse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectResponse> subjects) {
        this.subjects = subjects;
    }
}
