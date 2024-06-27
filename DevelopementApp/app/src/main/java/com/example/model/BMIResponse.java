package com.example.model;

public class BMIResponse {
    private String reason;
    private Result result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public Result getResult() {
        return result;
    }

    public int getErrorCode() {
        return error_code;
    }

    public static class Result {
        private double idealWeight;
        private String normalWeight;
        private int level;
        private String levelMsg;
        private String danger;
        private double bmi;
        private String normalBMI;

        public double getIdealWeight() {
            return idealWeight;
        }

        public String getNormalWeight() {
            return normalWeight;
        }

        public int getLevel() {
            return level;
        }

        public String getLevelMsg() {
            return levelMsg;
        }

        public String getDanger() {
            return danger;
        }

        public double getBmi() {
            return bmi;
        }

        public String getNormalBMI() {
            return normalBMI;
        }
    }
}
