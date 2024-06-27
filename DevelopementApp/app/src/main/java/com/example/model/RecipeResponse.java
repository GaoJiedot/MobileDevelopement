package com.example.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RecipeResponse {
    @SerializedName("resultcode")
    private String resultCode;

    @SerializedName("reason")
    private String reason;

    @SerializedName("result")
    private List<RecipeResult> result;

    @SerializedName("error_code")
    private int errorCode;

    // Getters and setters

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<RecipeResult> getResult() {
        return result;
    }

    public void setResult(List<RecipeResult> result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", errorCode=" + errorCode +
                '}';
    }
}
