package com.jihee.biz;

import java.util.List;

public interface EmpService {
    void insertEmp(EmpVO vo);
    void updateEmp(EmpVO vo);
    void deleteEmp(EmpVO vo);
    EmpVO getEmp(int empno);
    List<EmpVO> getEmpList(EmpVO vo);
}
