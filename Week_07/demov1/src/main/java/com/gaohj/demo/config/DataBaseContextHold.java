package com.gaohj.demo.config;

class DataBaseContextHoldle {

    public enum DataBaseType {
        WRITE, READ1, READ2
    }

    private static final  ThreadLocal<DataBaseType> contextHold = new ThreadLocal<>();

    public static void setDataBaseType(DataBaseType dataBaseType){
        if(dataBaseType == null){
            throw new NullPointerException();
        }
        contextHold.set(dataBaseType);
    }

    public static  DataBaseType getDataBaseType(){
        return contextHold.get() == null ? DataBaseType.WRITE : contextHold.get();
    }

    public static void cleanDataType(){
        contextHold.remove();
    }

}