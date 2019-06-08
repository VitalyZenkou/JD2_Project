package com.itacademy.zenkou.jdb2project.servlet.util;

import com.itacademy.zenkou.jdb2project.entity.db.BaseEntity;
import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

import static com.itacademy.zenkou.jdb2project.servlet.util.ServletParameterConstant.BIRTH_DATE;

@UtilityClass
public class PageUtil {

    private final int year = 1900;
    private final int month = 1;
    private final int day = 1;

    public <T extends BaseEntity> int calculatePageNumber(List<T> list, int recordsPerPage) {
        int nOfPage = list.size() / recordsPerPage;
        return nOfPage % recordsPerPage > 0 ? nOfPage++ : nOfPage;
    }

    public LocalDate resolveDate(HttpServletRequest request) {
        return request.getParameter(BIRTH_DATE).equals("") ? LocalDate.of(year, month, day)
                : LocalDate.parse(request.getParameter(BIRTH_DATE));
    }
}
