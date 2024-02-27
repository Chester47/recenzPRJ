package com.example.demo.controller.rq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
public class CreateReviewRequest {

    private String text;

    private UUID gameId;
}

