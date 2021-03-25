package com.example.studentSystem.Mapper;

import org.apache.ibatis.annotations.*;
import com.example.studentSystem.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper {

    @Select("select * from Student")
    List<Student> findAll();

    @Select("select * from Student where Id = #{id}")
    Student getStudentById(int id);

    @Select("select * from Student where Number = #{number}")
    Student getStudentByNumber(String number);

    @Insert({"insert into Student(Name,Gender,Birthdate,NativePlace,Department,Number) values(#{Name}, #{Gender},#{Birthdate},#{NativePlace},#{Department},#{Number})" })
    void saveStudentInfo(Student student);

//    @Delete("delete from Student where Number = #{number}")
//    void deleteStudentInfo(String number);

    @Delete("delete from Student where Id = #{id}")
    void deleteStudentInfo(int id);

    @Update( "update student set Name = #{Name},Gender = #{Gender},Birthdate = #{Birthdate},NativePlace = #{NativePlace},Department = #{Department},Number = #{Number} where Id = #{Id}" )
    void updateStudentInfo(Student student);

    @Select("select * from student where ${attr} Like '${val}%'")
    List<Student> searchStudentByAttr(@Param("val")String val,@Param("attr")String attr);
}
