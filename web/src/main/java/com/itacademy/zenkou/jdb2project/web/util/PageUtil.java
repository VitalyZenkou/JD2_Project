package com.itacademy.zenkou.jdb2project.web.util;

import com.itacademy.zenkou.jdb2project.database.entity.db.BaseEntity;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class PageUtil {

    public <T extends BaseEntity> int calculatePageNumber(List<T> list, int recordsPerPage) {
        int nOfPage = list.size() / recordsPerPage;
        return nOfPage % recordsPerPage > 0 ? nOfPage + 1 : nOfPage;
    }
}
