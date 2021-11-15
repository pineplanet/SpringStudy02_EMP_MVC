package com.jihee.biz;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapper implements RowMapper<EmpVO> {

    @Override
    public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpExtractor empExtractor = new EmpExtractor();

        return empExtractor.extractData(rs);
    }
}
