package com.jihee.biz.impl;

import com.jihee.biz.EmpService;
import com.jihee.biz.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDAO empDAO;
    public EmpServiceImpl() {
        System.out.println("====> EmpServiceImpl 객체 생성 ");
    }

    @Override
    public void insertEmp(EmpVO vo) {
        this.empDAO.insertEmp(vo);

    }

    @Override
    public void updateEmp(EmpVO vo) {
        this.empDAO.updateEmp(vo);

    }

    @Override
    public void deleteEmp(EmpVO vo) {
        this.empDAO.deleteEmp(vo);
    }

    @Override
    public EmpVO getEmp(int empno) {
        EmpVO vo = new EmpVO();
        vo.setEmpno(empno);
        return this.empDAO.getEmp(vo);
    }

    @Override
    public List<EmpVO> getEmpList(EmpVO vo) {
        return this.empDAO.getEmpList(vo) ;
    }
}
