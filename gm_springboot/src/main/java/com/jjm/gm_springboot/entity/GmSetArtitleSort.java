package com.jjm.gm_springboot.entity;

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
public class GmSetArtitleSort implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 文章ID
     */
        private Long articleId;

      /**
     * 分类ID
     */
      private Long sortId;


}
