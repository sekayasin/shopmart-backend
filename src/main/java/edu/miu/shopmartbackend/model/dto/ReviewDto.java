package edu.miu.shopmartbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDto {
    @JsonProperty("review_id")
    private long reviewId;

    @JsonProperty("review_content")
    private String content;

}
