package com.example.maka.Bean;

import lombok.Data;

@Data
public abstract class animal {
    private String type;
    private String name;

    /**
     * get
     * @return
     */
    public abstract String getNameAndType();
}
