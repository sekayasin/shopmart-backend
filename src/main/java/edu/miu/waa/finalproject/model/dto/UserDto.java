package edu.miu.waa.finalproject.model.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonProperty("password")
    private String password;

    @JsonProperty("points")
    private int points;
}
