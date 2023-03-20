package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Maintain;
import com.virtue.pojo.Maintainwx;

import java.util.List;

public interface MaintainwxService {

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param maintainwx
     * @return
     */
    IPage<Maintainwx> getPage(int currenPage, int pageSize, Maintainwx maintainwx );

}
