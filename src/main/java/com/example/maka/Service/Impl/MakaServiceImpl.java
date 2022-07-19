package com.example.maka.Service.Impl;

import com.example.maka.Service.MakaService;
import com.example.maka.Service.Ticket;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class MakaServiceImpl implements MakaService {

    private int num;
    Ticket ticket = new Ticket();
    @Override
    public void safeTest() {
        ticket.sale();
    }

}
