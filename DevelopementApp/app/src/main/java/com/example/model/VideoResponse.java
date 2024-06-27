package com.example.model;

import java.util.List;

public class VideoResponse {
    private String reason;
    private List<Video> result;
    private int error_code;

    public VideoResponse(String reason, List<Video> result, int error_code) {
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Video> getResult() {
        return result;
    }

    public void setResult(List<Video> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
// Getters and Setters
}
