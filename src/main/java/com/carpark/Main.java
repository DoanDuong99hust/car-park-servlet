package com.carpark;

import com.carpark.dao.impl.AbstractDAO;

import javax.inject.Inject;

public class Main {
    public static void main(String[] args) {
        AbstractDAO abstractDAO = new AbstractDAO<>();
        abstractDAO.getConnection();
    }
}
