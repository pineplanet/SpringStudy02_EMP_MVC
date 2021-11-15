package com.jihee.controller;

import com.jihee.biz.EmpService;
import com.jihee.biz.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp/")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("list")
    public String getList(Model model) {

        model.addAttribute("list", empService.getEmpList(new EmpVO()));
        return "emp/empList";

    }

    @RequestMapping("info")
    public String getEmp(Model model, @RequestParam int empno) {
        model.addAttribute("empInfo", empService.getEmp(empno));
        return "emp/empInfo";
    }

    @RequestMapping("insert")
    public String insertEmp(@ModelAttribute EmpVO empVO) {
        if (empVO.getEmpno() == 0) {
            return "emp/inputForm";
        } else {
            empService.insertEmp(empVO);
            return "redirect:/emp/list";
        }
    }

    @RequestMapping("edit")
    public ModelAndView editEmp(@RequestParam int empno,
                                @ModelAttribute EmpVO emp) {
        emp = empService.getEmp(empno);
        return new ModelAndView("/emp/empEdit", "empInfo", emp);
    }

    @RequestMapping("update")
    public String updateEmp(@ModelAttribute EmpVO emp) {
        empService.updateEmp(emp);
        return "redirect:/emp/list";
    }

    @RequestMapping("delete")
    public String deleteEmp(@RequestParam int empno) {
        EmpVO vo = new EmpVO();
        vo.setEmpno(empno);
        empService.deleteEmp(vo);
        return "redirect:/emp/list";
    }

}
