package com.example.maka.Bean;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String name;
    private byte[] bytes = new byte[1024*1024];
}
