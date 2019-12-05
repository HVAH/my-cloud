package com.vah.reptile.service;


import com.vah.reptile.dto.AuthUser;
import com.vah.reptile.dto.response.RespComboToken;

import java.util.Optional;

public interface JwtService {

    Optional<RespComboToken> generateComboToken(AuthUser authUser);

    Optional<RespComboToken> renewComboToken(String rawRefreshToken);
}