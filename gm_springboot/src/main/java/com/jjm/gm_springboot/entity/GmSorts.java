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
public class GmSorts implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 分类ID
     */
        private Long sortId;

      /**
     * 分类名称
     */
      private String sortName;

      /**
     * 分类别名
     */
      private String sortAlias;

      /**
     * 分类描述
     */
      private String sortDescription;

      /**
     * 父分类ID
     */
      private Long parentSortId;


}
