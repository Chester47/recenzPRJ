package com.example.demo.controller.rq;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateReviewRequest {

    private String oldText;

    private String newText;

}
