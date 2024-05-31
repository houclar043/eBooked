package com.ebook.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yuhan
 * @since 2022-09-28
 */
@Data
public class QueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String keyword;

    private int page;

    private int limit;

    private Long sectionId;

    private boolean getUserList;

}
