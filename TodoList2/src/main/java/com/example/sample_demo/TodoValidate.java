package com.example.sample_demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TodoValidate {
	
	@NotEmpty(message = "タスク名を入力してください")
    private String taskName;
	
	@NotEmpty(message = "タスクを内容を入力してください")
    private String taskDescription;
	
	@NotEmpty(message = "担当者名を入力してください")
    private String assignPersonName;
	
	@NotNull(message = "見積時間は必須です")
    private Double estimateHour;
}
