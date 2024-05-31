package com.ebook.common.To;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * user view object
 * </p>
 *
 * @author yuhan
 * @since 2022-09-13
 */
@Data
public class UserTo implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * username
     */
    private String username;

    /**
     * nickname
     */
    private String nickname;

    /**
     * jwtToken involve user's password
     */
    private String jwtToken;

    /**
     * avatar
     */
    private String avatar;
}
