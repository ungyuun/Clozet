package com.clozet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class PageInfo {
    private int size;
    private int page;
    private int totalElements;
    private int totalPages;
}
