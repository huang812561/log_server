package com.ykc.entity.common;

import lombok.Data;

/**
 * @ClassName Header
 * @Description TODO
 * @Author hgq
 * @Date 2020/3/19 17:40
 * @Version 1.0
 */
@Data
public class Header {
    /**
     *  令牌
     */
    public String token;
    /**
     * 业务标识
     */
    public String businessID;

}
