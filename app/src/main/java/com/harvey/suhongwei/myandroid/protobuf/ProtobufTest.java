package com.harvey.suhongwei.myandroid.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.harvey.suhongwei.myandroid.PersonHelper;

public class ProtobufTest {
    public static void test(){
        byte[] array = new byte[800];
        try {

            PersonHelper.Person person = PersonHelper.Person.parseFrom(array);
            person.toByteArray();

        } catch (InvalidProtocolBufferException e) {

        }
    }
}
