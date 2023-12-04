package com.inclusion.testinclusion.dto;


public class TestInclusionDTO {

    private Integer x;
    private Integer y;
    private Integer n;
    private Integer k;

    public TestInclusionDTO(){}

    public TestInclusionDTO(Integer X, Integer Y, Integer N){
        this.x = X;
        this.y = Y;
        this.n = N;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }
}
