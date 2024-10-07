package database.mysql.dto;

import struct.PostActivityType;

import java.util.Date;
import java.util.UUID;

public class PostActivityDTO {
    private int id;
    private UUID postUID;
    private UUID executorUID;
    private PostActivityType postActivityType;
    private String activityType;
    private Date activityDate;
}
