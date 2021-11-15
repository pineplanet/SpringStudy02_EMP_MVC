package com.jihee.biz;

import com.jihee.biz.impl.EmpServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class EmpServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        EmpService EmpService = (EmpService)container.getBean("empService");

        // 1. Emp 등록 테스트
        EmpVO vo = new EmpVO();
        vo.setEmpno(1015);
        vo.setEname("박보검");
        vo.setJob("부장");
        vo.setMgr(1009);
        vo.setHiredate("2021-11-05");
        vo.setSal(2000);
        vo.setComm(100);
        vo.setDeptno(40);
        EmpService.insertEmp(vo);

        //2. Emp 수정 테스트
        vo.setHiredate("2000-11-05");
        EmpService.updateEmp(vo);

        //3. Emp 삭제 테스트
        EmpService.deleteEmp(vo);

        //4.Emp 검색 테스트
        vo.setEmpno(1001);
        EmpVO getVo = EmpService.getEmp(vo.getEmpno());
        System.out.println(getVo);

        //5. 전체 사원 목록 출력
        List<EmpVO> empVOS = EmpService.getEmpList(vo);
        int cnt = 0;
        for (EmpVO empVO:
           empVOS  ) {
            System.out.println(cnt  + ": " + empVO);
            cnt ++ ;
        }
    }
}