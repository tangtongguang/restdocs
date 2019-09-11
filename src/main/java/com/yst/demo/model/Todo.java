package com.yst.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
	private long id;
	private String title;
	private boolean status;
}
