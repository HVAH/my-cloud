package com.vah.reptile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {

    private Long userId;

    private String endpoint;

    private String mobile;

    private String password;

    private Map<String, List<Long>> authorities;
}
