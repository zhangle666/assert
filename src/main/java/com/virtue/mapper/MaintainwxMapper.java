package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Maintain;
import com.virtue.pojo.Maintainwx;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaintainwxMapper extends BaseMapper<Maintainwx> {
@Select("SELECT g.genrecode,w.waname ,m.ref,m.repr from maintainwx m INNER JOIN warehous w ON  m.waid=w.waid INNER JOIN genre g ON w.gid=g.gid")
    IPage<Maintainwx> findByPage(IPage<Maintainwx> page, @Param(Constants.WRAPPER) QueryWrapper<Maintainwx> wrapper);

@Select("SELECT g.genrecode,w.waname ,m.ref,m.repr from maintainwx m INNER JOIN warehous w ON  m.waid=w.waid INNER JOIN genre g ON w.gid=g.gid WHERE w.waid=#{waid}")
    Maintain  selectByWaname(Integer waid);
        @Insert("insert into maintainwx(waid,ref,repr) values(#{waid},#{ref},#{repr})")
      int  insertAll(Maintainwx maintainwx);

    @Update("update maintainwx set ref=ref+1,repr=repr+#{repr} where waid=#{waid}  ")
    Integer    updateByWaid(Maintainwx maintainwx);
}
