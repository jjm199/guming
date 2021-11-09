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
public class GmLabels implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 标签ID
     */
        @TableId(value = "label_id", type = IdType.AUTO)
      private Long labelId;

      /**
     * 标签名称
     */
      private String labelName;

      /**
     * 标签别名
     */
      private String labelAlias;

      /**
     * 标签描述
     */
      private String labelDescription;


}
