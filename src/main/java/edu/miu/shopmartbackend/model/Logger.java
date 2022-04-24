package edu.miu.shopmartbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Logger {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private LocalDate date;
    private long time;
    private String principle;
    //@OneToOne
    //private User user;
    private String operation;
}
