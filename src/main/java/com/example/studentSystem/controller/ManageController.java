package com.example.studentSystem.controller;

import com.example.studentSystem.Entity.Student;
import com.example.studentSystem.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManageController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/")
    public String Welcome(){
        return "index";
    }

    @GetMapping("/display")
    public String display(Model model){
        List<Student> stu_list=studentMapper.findAll();
        model.addAttribute("list",stu_list);
        return "student_list";
    }
    @GetMapping("/search")
    public String searchStudent(Model model) {
        model.addAttribute("attr", "");
        return "search";
    }

    @PostMapping("/search")
    public String processSearch(@RequestParam("val") String val,@RequestParam("attr") String attr,Model model) {
        List<Student> stu_list=studentMapper.searchStudentByAttr(val,attr);
        model.addAttribute("list",stu_list);
        return "student_list";
    }

    @GetMapping("/add")
    public String add_student(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("createorupdate", true);
        return "add";
    }

    @PostMapping("/add")
    public String add_student(@ModelAttribute Student student){
        Student s=studentMapper.getStudentByNumber(student.getNumber());
        if(s==null){
            studentMapper.saveStudentInfo(student);
        }
        return "redirect:/display";
    }

    @GetMapping("/display/{id}")
    public ModelAndView showStudent(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("studentDetail");
        Student student=studentMapper.getStudentById(id);
        mav.addObject(student);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentMapper.deleteStudentInfo(id);
        return "redirect:/display";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id,Model model){
        Student student=studentMapper.getStudentById(id);
        model.addAttribute("student",student);
        model.addAttribute("createorupdate", false);
        return "add";
    }

    @PostMapping("/edit/{id}")
    public String finishEditStudent(@ModelAttribute Student student,@PathVariable("id") int id){
        Student s=studentMapper.getStudentByNumber(student.getNumber());
        if(s!=null && !s.getId().equals(id)){
            return "redirect:/display";
        }
        student.setId(id);
        studentMapper.updateStudentInfo(student);
        return "redirect:/display/{id}";
    }
}
