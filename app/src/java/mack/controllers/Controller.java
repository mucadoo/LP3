package mack.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    public enum ReturnType {
        FORWARD, REDIRECT, PRINT
    }

    public void execute();

    public void init(HttpServletRequest request, HttpServletResponse response);

    public String getReturnPage();

    public ReturnType getReturnType();
}
