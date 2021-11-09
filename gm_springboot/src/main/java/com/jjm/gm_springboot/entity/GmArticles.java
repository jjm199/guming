package com.jjm.gm_springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class GmArticles implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 博文ID
     */
        @TableId(value = "article_id", type = IdType.AUTO)
      private Long articleId;

      /**
     * 发表用户ID
     */
      private Long userId;

      /**
     * 博文标题
     */
      private String articleTitle;

      /**
     * 博文内容
     */
      private String articleContent;

      /**
     * 浏览量
     */
      private Long articleViews;

      /**
     * 评论总数
     */
      private Long articleCommentCount;

      /**
     * 发表时间
     */
      private LocalDateTime articleDate;

    private Long articleLikeCount;


}
