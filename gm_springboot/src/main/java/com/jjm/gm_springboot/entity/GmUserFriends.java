package com.jjm.gm_springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 蒋金铭
 * @since 2021-11-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class GmUserFriends implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 标识ID
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 用户ID
     */
      private Long userId;

      /**
     * 好友ID
     */
      private Long userFriendsId;

      /**
     * 好友备注
     */
      private String userNote;

      /**
     * 好友状态
     */
      private String userStatus;


}
