package com.ethan.test.mapper;

import com.ethan.test.domain.TApplyInfo;
import com.ethan.test.domain.TApplyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TApplyInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    int countByExample(TApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    int deleteByExample(TApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    @Delete({
        "delete from `t_apply_info`",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    @Insert({
        "insert into `t_apply_info` (`id`, `user_name`, ",
        "`user_code`, `age`, `create_at`, ",
        "`update_at`)",
        "values (#{id,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{userCode,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP}, ",
        "#{updateAt,jdbcType=TIMESTAMP})"
    })
    int insert(TApplyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    int insertSelective(TApplyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    List<TApplyInfo> selectByExample(TApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "`id`, `user_name`, `user_code`, `age`, `create_at`, `update_at`",
        "from `t_apply_info`",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    TApplyInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TApplyInfo record, @Param("example") TApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TApplyInfo record, @Param("example") TApplyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TApplyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_apply_info
     *
     * @mbggenerated
     */
    @Update({
        "update `t_apply_info`",
        "set `user_name` = #{userName,jdbcType=VARCHAR},",
          "`user_code` = #{userCode,jdbcType=VARCHAR},",
          "`age` = #{age,jdbcType=INTEGER},",
          "`create_at` = #{createAt,jdbcType=TIMESTAMP},",
          "`update_at` = #{updateAt,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TApplyInfo record);
}