package database.mysql.dao;

import database.mysql.dto.UserActivityDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public interface UserActivitiesDAO {
    ArrayList<UserActivityDTO> loadUserActivitiesByTargetUID(UUID targetUID);
    ArrayList<UserActivityDTO> loadUserActivitiesByExecutorUID(UUID executorUID);
    ArrayList<UserActivityDTO> loadUserActivitiesBetweenDates(Date startDate, Date endDate);
}
