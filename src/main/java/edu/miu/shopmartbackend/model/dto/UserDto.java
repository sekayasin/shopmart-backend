package edu.miu.shopmartbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.miu.shopmartbackend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    @JsonProperty("user_id")
    private long id;

    @JsonProperty("f_name")
    private String fName;

    @JsonProperty("l_name")
    private String lName;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("points")
    private int points;
    private boolean isAproved;

}
